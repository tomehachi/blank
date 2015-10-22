package blank.requestprocessor;

import java.io.IOException;
import java.lang.annotation.Annotation;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMapping;
import org.seasar.struts.action.S2RequestProcessor;
import org.seasar.struts.util.S2ExecuteConfigUtil;

import blank.annotation.AdminService;
import blank.annotation.PublicService;
import blank.dto.UserDto;
import blank.util.exception.AppException;

public class AppRequestProcessor extends S2RequestProcessor {

    private Logger logger = Logger.getLogger(AppRequestProcessor.class);

    /**
     * 引数で指定された UserDto の指定フィールドに値を代入する.<br>
     *
     * @param userDto
     * @param userId
     * @param requestUrl
     * @param loggedInAt
     * @throws AppException
     */
    private void setUserDtoFields(Object userDto, Integer userId,
            String requestUrl, Timestamp loggedInAt) throws AppException {

        Class<?> clazz = userDto.getClass();
        try {
            if(userId != null) { clazz.getField("userId").set(userDto, userId); }
            if(requestUrl != null) { clazz.getField("requestUrl").set(userDto, requestUrl); }
            if(loggedInAt != null) { clazz.getField("loggedInAt").set(userDto, loggedInAt); }

        } catch (IllegalArgumentException e) {
            throw new AppException("UserDtoに値をinvokeする際に例外発生.", e);

        } catch (SecurityException e) {
            throw new AppException("UserDtoに値をinvokeする際に例外発生.", e);

        } catch (IllegalAccessException e) {
            throw new AppException("UserDtoに値をinvokeする際に例外発生.", e);

        } catch (NoSuchFieldException e) {
            throw new AppException("UserDtoに値をinvokeする際に例外発生.", e);
        }
    }

    private Object getUserDtoField(Object userDto, String fieldName) throws AppException {
        try {
            return userDto.getClass().getField(fieldName).get(userDto);

        } catch (IllegalArgumentException e) {
            throw new AppException("UserDtoから値を取得する際に例外発生.", e);

        } catch (SecurityException e) {
            throw new AppException("UserDtoから値を取得する際に例外発生.", e);

        } catch (IllegalAccessException e) {
            throw new AppException("UserDtoから値を取得する際に例外発生.", e);

        } catch (NoSuchFieldException e) {
            throw new AppException("UserDtoから値を取得する際に例外発生.", e);
        }
    }

    /**
     * 対象メソッドに指定のアノテーションが付いているかどうかを返す.<br>
     *
     * @return 対象メソッドに指定のアノテーションが付いているかどうか(true=yes, false=no)
     */
    private boolean targetHasAnnotation(Class<?> clazz) {
        Annotation[] annotations = S2ExecuteConfigUtil.getExecuteConfig().getMethod().getAnnotations();
        for(Annotation annotation : annotations) {
            if(annotation.annotationType().getName().equals(clazz.getName())) {
                return true;
            }
        }
        return false;
    }

    /**
     * ログインしているかどうかを返す.<br>
     *
     * @param req HttpServletRequest
     * @return ログインしているかどうか(true=yes, false=no)
     */
    private boolean isLoggedIn(Object userDto) {

        if(userDto == null) {
            return false;

        } else {
            Integer userId = null;
            try {
                // ユーザIDの取得.
                userId = (Integer)getUserDtoField(userDto, "userId");

            } catch (AppException e) {
                logger.error(e.appMessage, e);
                return false;
            }

            if(userId == null) {
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private boolean isAdmin(Object userDto) {

        if(userDto == null) {
            return false;
        } else {
            Set<String> roles = null;
            try {
                roles = (HashSet<String>)getUserDtoField(userDto, "role");
            } catch (AppException e) {
                logger.error(e.appMessage, e);
                return false;
            }

            if(roles.contains("admin")) {
                return true;
            } else {
                return false;
            }

        }
    }

    /*
     * (非 Javadoc)
     * @see org.apache.struts.action.RequestProcessor
     * #processPreprocess(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    protected boolean processRoles(HttpServletRequest request, HttpServletResponse response, ActionMapping mapping) {
        // 禁止UA
        if(request.getHeader("user-agent").equals("Mozilla/5.0 (X11; Linux x86_64; rv:10.0) Gecko/20150101 Firefox/20.0 (Chrome)")) {
            return false;
        }

        // 公開エリアへのアクセスならばそのままServlet処理継続.
        if(targetHasAnnotation(PublicService.class)) {
            return true;
        }

        /* -- 認証されているかどうか ---------------------------------------------------------------------- */

        // userDto を取得
        Object userDto = request.getSession().getAttribute("userDto");

        if(isLoggedIn(userDto)) {
            if(targetHasAnnotation(AdminService.class)) {
                return isAdmin(userDto);
            }
            return true;

        } else {
            // ログインしていない場合はURIを保存しておき、ログイン画面にリダイレクト.
            try {
                if(userDto == null) {
                    userDto = new UserDto();
                }
                // URLを保持しておく.
                setUserDtoFields(userDto, null, request.getRequestURL().toString(), null);
                // セッション層に userDto を格納する.
                request.getSession().setAttribute("userDto", userDto);
                // ログイン画面にリダイレクト
                response.sendRedirect(request.getContextPath() + "/login");
                return false;

            } catch (AppException e) {
                logger.error(e.appMessage, e);
                return false;

            } catch (IOException e) {
                logger.error(e);
                return false;
            }
        }
    }

}
