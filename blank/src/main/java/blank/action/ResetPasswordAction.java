package blank.action;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.struts.annotation.Execute;

import blank.annotation.PublicService;
import blank.entity.UserAuth;

public class ResetPasswordAction {

    public JdbcManager jdbcManager;

    @PublicService
    @Execute(validator=false)
    public String index() {
        return "index.jsp";
    }

    public String mailAddr;

    @PublicService
    @Execute(validator=false)
    public String execute() {
        UserAuth userAuth = jdbcManager
        .from(UserAuth.class)
        .where(new SimpleWhere().eq("mailAddr", mailAddr))
        .getSingleResult();

        if(userAuth != null) {

        }
        return "done.jsp";
    }
}
