package blank.form;

import java.io.Serializable;

import org.seasar.struts.annotation.Arg;
import org.seasar.struts.annotation.Required;

public class AuthKeyForm implements Serializable {

    @Required(arg0 = @Arg(key = "認証キー", resource = false))
    public String authKey;

}
