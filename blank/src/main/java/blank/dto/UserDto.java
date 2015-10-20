package blank.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import org.seasar.framework.container.annotation.tiger.Component;
import org.seasar.framework.container.annotation.tiger.InstanceType;

@Component(instance = InstanceType.SESSION)
public class UserDto implements Serializable {
    /** ユーザID */
    public Integer userId;
    /** ロール */
    public Set<String> role;
    /** リクエストURI */
    public String requestUrl;
    /** ログイン日時 */
    public Date loggedInAt;
}
