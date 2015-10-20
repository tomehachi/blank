package blank.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.unit.S2TestCase;

import static blank.entity.UserAuthNames.*;

/**
 * {@link UserAuth}のテストクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2015/08/06 13:35:07")
public class UserAuthTest extends S2TestCase {

    private JdbcManager jdbcManager;

    /**
     * 事前処理をします。
     * 
     * @throws Exception
     */
    @Override
    protected void setUp() throws Exception {
        super.setUp();
        include("s2jdbc.dicon");
    }

    /**
     * 識別子による取得をテストします。
     * 
     * @throws Exception
     */
    public void testFindById() throws Exception {
        jdbcManager.from(UserAuth.class).id(1).getSingleResult();
    }

    /**
     * loginHistoryListとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_loginHistoryList() throws Exception {
        jdbcManager.from(UserAuth.class).leftOuterJoin(loginHistoryList()).id(1).getSingleResult();
    }

    /**
     * onetimeKeyとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_onetimeKey() throws Exception {
        jdbcManager.from(UserAuth.class).leftOuterJoin(onetimeKey()).id(1).getSingleResult();
    }

    /**
     * userAuthSecとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_userAuthSec() throws Exception {
        jdbcManager.from(UserAuth.class).leftOuterJoin(userAuthSec()).id(1).getSingleResult();
    }

    /**
     * userRoleListとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_userRoleList() throws Exception {
        jdbcManager.from(UserAuth.class).leftOuterJoin(userRoleList()).id(1).getSingleResult();
    }
}