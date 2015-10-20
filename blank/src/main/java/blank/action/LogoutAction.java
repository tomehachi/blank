package blank.action;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.seasar.struts.annotation.Execute;

import blank.dto.UserDto;

public class LogoutAction {

    @Resource
    public HttpServletRequest request;

    @Execute(validator = false)
    public String index() {
        request.getSession().setAttribute("userDto", new UserDto());
        return "/login?redirect=true";
    }

}
