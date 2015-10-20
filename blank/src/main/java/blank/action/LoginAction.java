package blank.action;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;
import org.seasar.struts.util.ResponseUtil;

import blank.annotation.PublicService;
import blank.dto.UserDto;
import blank.entity.LoginHistory;
import blank.entity.UserAuth;
import blank.entity.UserRole;
import blank.form.LoginForm;
import blank.util.SecurityUtil;

public class LoginAction {

    @Resource
    public UserDto userDto;

    @Resource
    public HttpServletRequest request;

    @Resource
    public JdbcManager jdbcManager;

    @ActionForm
    public LoginForm loginForm;

    private Logger logger = Logger.getLogger(this.getClass());

    /**
     * ログイン画面を表示.<br>
     *
     * @return ログイン画面
     */
    @PublicService
    @Execute(validator=false)
    public String index() {
        return "index.jsp";
    }

    /**
     * パスワード忘れ画面を表示.<br>
     *
     * @return パスワード忘れ画面
     */
    @Execute(validator=false)
    public String forgot() {
        return null;
    }

    /**
     * パスワードリセット用の認証キーを送信.<br>
     *
     * @return パスワード忘れ処理完了画面
     */
    @Execute(validator=false)
    public String sendResetCode() {
        return null;
    }

    /**
     * ログイン実行.<br>
     *
     * @return 成功→トップ画面, 失敗→ログイン画面
     */
    @PublicService
    @Execute(validator=true, validate="validateUser", input="index.jsp")
    public String execute() {
        try {
            if(userDto.requestUrl == null) {
                // ログアウト直後など、requestUrlが設定されていない場合はトップにリダイレクト.
                ResponseUtil.getResponse().sendRedirect(request.getContextPath() + "/");

            } else {
                // requestUrlにリダイレクト
                ResponseUtil.getResponse().sendRedirect(userDto.requestUrl);
            }

        } catch (IOException e) {
            logger.error("リダイレクト失敗( "+ userDto.requestUrl +" )", e);
        }
        return null;
    }

    /**
     * ロールをオブジェクトListからStringのSetに変換.<br>
     *
     * @param userRoleList ロールリスト
     * @return
     */
    private Set<String> getRoleStringSet(List<UserRole> userRoleList) {
        Set<String> result = new HashSet<String>();
        for(UserRole userRole : userRoleList) {
            result.add(userRole.role);
        }
        return result;
    }

    /**
     * ユーザ認証.<br>
     *
     * @return
     */
    public ActionMessages validateUser() {

        // DBにmailAddrが一致するレコードを取得.
        UserAuth userAuth = jdbcManager
                .from(UserAuth.class)
                .leftOuterJoin("userAuthSec")
                .leftOuterJoin("userRoleList")
                .leftOuterJoin("onetimeKey")
                .where(new SimpleWhere()
                    .eq("mailAddr", loginForm.mailAddr)
        ).getSingleResult();

        // ログイン試行履歴テーブルのレコードの共通値を格納.
        LoginHistory history = new LoginHistory();
        history.tryDate = new Timestamp(new Date().getTime());
        history.inputMailAddr = loginForm.mailAddr;
        history.ipAddr = request.getRemoteAddr();

        ActionMessages errors = new ActionMessages();
        if(userAuth == null) {
            // 認証失敗(対象ユーザ不明)
            history.userId = null;
            history.loginSuccess = false;
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.authentication"));

        } else {
            // 対象ユーザは特定できた.
            history.userId = userAuth.userId;

            if(SecurityUtil.encode(loginForm.password).equals(userAuth.password)) {
                // パスワード一致(認証成功)
                history.loginSuccess = true;

                // セッション層にユーザ情報を設定
                userDto.userId = userAuth.userId;
                userDto.role = getRoleStringSet(userAuth.userRoleList);
                userDto.loggedInAt = new Date();

                // 認証セキュリティ情報をアップデート
                userAuth.userAuthSec.lastLoginDate = new Timestamp(new Date().getTime());
                userAuth.userAuthSec.loginFailureCount = 0;
                jdbcManager.update(userAuth.userAuthSec).execute();

            } else {
                // パスワード不一致(認証失敗)
                history.loginSuccess = false;

                // 認証セキュリティ情報をアップデート
                userAuth.userAuthSec.loginFailureCount++;
                jdbcManager.update(userAuth.userAuthSec).execute();

                errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.authentication"));
            }
        }
        jdbcManager.insert(history).execute();
        return errors;
    }
}
