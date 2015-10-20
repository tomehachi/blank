package blank.action.mnt;

import java.util.List;

import javax.annotation.Resource;

import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import blank.annotation.AdminService;
import blank.dto.UserDto;
import blank.entity.UserAuth;
import blank.form.AddUserForm;


public class UserManageAction {

    @Resource
    public UserDto userDto;

    @Resource
    public JdbcManager jdbcManager;

    public List<UserAuth> userAuthList;

    @ActionForm
    public AddUserForm addUserForm;

    /**
     * ユーザ管理トップ画面表示.<br>
     *
     * @return ユーザ管理画面
     */
    @AdminService
    @Execute(validator = false)
    public String index() {
        // ユーザ詳細を取得.
        userAuthList = jdbcManager.from(UserAuth.class)
            .leftOuterJoin("onetimeKey")
            .leftOuterJoin("userAuthSec")
            .leftOuterJoin("userRoleList")
            .getResultList();

        return "index.jsp";
    }

    @AdminService
    @Execute(validator = true, input="index.jsp")
    public String addUserConfirm() {
        return "addUserConfirm.jsp";
    }

    /**
     * 登録.<br>
     *
     * @return 確認画面/完了画面
     */
    @AdminService
    @Execute(validator = false)
    public String addUserCommit() {

        return "addUserCommit.jsp";
    }
}
