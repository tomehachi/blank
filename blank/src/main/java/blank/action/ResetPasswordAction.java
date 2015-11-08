package blank.action;

import java.sql.Timestamp;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.jdbc.where.SimpleWhere;
import org.seasar.struts.annotation.ActionForm;
import org.seasar.struts.annotation.Execute;

import blank.annotation.PublicService;
import blank.dto.ResetPasswordConfirmMailDto;
import blank.entity.OnetimeKey;
import blank.entity.UserAuth;
import blank.form.AuthKeyForm;
import blank.mail.AddressType;
import blank.mail.MailException;
import blank.mail.smtp.Smtp;
import blank.service.OnetimeKeyService;
import blank.service.UserAuthService;
import blank.util.SecurityUtil;

public class ResetPasswordAction {

    public JdbcManager jdbcManager;
    public UserAuthService userAuthService;
    public OnetimeKeyService onetimeKeyService;

    public String mailAddr;

    private static long ONE_DAY = (long)1000*60*60*24;

    /**
     * パスワードリセットTOP.<br>
     *
     * @return
     */
    @PublicService
    @Execute(validator=false)
    public String index() {
        return "index.jsp";
    }

    /**
     * パスワードリセット メールアドレス入力.<br>
     *
     * @return
     */
    @PublicService
    @Execute(validator=false)
    public String execute() {

        // メールアドレスから該当ユーザ認証情報を取得.
        UserAuth userAuth = userAuthService.findAvailableUserByMailAddr(mailAddr);

        if(userAuth != null) {
            // ワンタイムパスワードを生成
            String authKey = SecurityUtil.randomString(
                    Integer.parseInt(ResourceBundle.getBundle("application").getString("setting.authKey.length")));

            // ユーザ認証情報のワンタイムレコード取得.
            OnetimeKey onetimeKey = onetimeKeyService.findById(userAuth.userId);

            if(onetimeKey != null) {
                onetimeKey.onetimeKey = authKey;
                onetimeKey.expirationDate = new Timestamp(new Date().getTime() + ONE_DAY);
                onetimeKey.delFlag = false;
                onetimeKeyService.update(onetimeKey);

            } else {
                onetimeKey = new OnetimeKey();
                onetimeKey.userId = userAuth.userId;
                onetimeKey.onetimeKey = authKey;
                onetimeKey.expirationDate = new Timestamp(new Date().getTime() + ONE_DAY);
                onetimeKey.delFlag = false;
                onetimeKeyService.insert(onetimeKey);
            }
            sendConfirmMail(userAuth.mailAddr, authKey);
        }
        return "/resetPassword/confirmSent/?redirect=true";

    }

    /**
     * パスワードリセットのご案内送信完了.<br>
     *
     * @return
     */
    @PublicService
    @Execute(validator=false)
    public String confirmSent() {
        return "confirmSent.jsp";
    }

    private void sendConfirmMail(String mailAddr, String authKey) {
        Smtp smtp = new Smtp("blankmail");
        ResetPasswordConfirmMailDto dto = new ResetPasswordConfirmMailDto(smtp.getMailEncode());
        try {
            dto
            .addAddress(AddressType.FROM, "email@test.com", "blank-mail")
            .addAddress(AddressType.TO, mailAddr, mailAddr);

            dto.authKey = authKey;
            dto.toAddr = mailAddr;
            dto.subject = "blank-mail パスワードリセットの確認";

            smtp.sendMail(dto, "sample");

        } catch (MailException e) {
            e.printStackTrace();
        }
    }

    /**
     * 認証キー入力.<br>
     *
     * @return
     */
    @PublicService
    @Execute(validator=false)
    public String showAuth() {
        return "auth.jsp";
    }

    @ActionForm
    public AuthKeyForm authKeyForm;

    /**
     * 認証キーバリデーション
     *
     * @return エラー
     */
    public ActionMessages validateAuthKey() {
        ActionMessages errors = new ActionMessages();

        /* -- 認証キーの長さチェック -------------------------------------------------------------------------------- */

        int authKeyLength = Integer.parseInt(
                ResourceBundle.getBundle("application").getString("setting.authKey.length"));

        if(authKeyForm.authKey.length() != authKeyLength) {
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.authKeyValidation"));
        }

        /* -- 認証キーの存在チェック -------------------------------------------------------------------------------- */

        UserAuth userAuth = jdbcManager.from(UserAuth.class)
                .leftOuterJoin("onetimeKey")
                .where(new SimpleWhere()
                    .eq("onetimeKey.onetimeKey", authKeyForm.authKey)
                ).getSingleResult();

        if(userAuth == null) {
            errors.add(ActionMessages.GLOBAL_MESSAGE, new ActionMessage("errors.authKeyValidation"));
        }

        return errors;
    }

    @PublicService
    @Execute(validator=true, validate="validateAuthKey", input="auth.jsp")
    public String auth() {
        return "reset.jsp";
    }
}
