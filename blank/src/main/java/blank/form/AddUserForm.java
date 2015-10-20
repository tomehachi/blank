package blank.form;

import java.io.Serializable;

import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Maxlength;
import org.seasar.struts.annotation.Required;

public class AddUserForm implements Serializable {

    @Required(arg0 = @Arg(key = "メールアドレス", resource = false))
    @Maxlength(maxlength = 128, arg0 = @Arg(key = "メールアドレス", resource = false))
    public String mailAddr;

    @Required(arg0 = @Arg(key = "パスワード", resource = false))
    @Maxlength(maxlength = 128, arg0 = @Arg(key = "パスワード", resource = false))
    public String password;

}
