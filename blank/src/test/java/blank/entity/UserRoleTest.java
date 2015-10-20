package blank.entity;

import javax.annotation.Generated;
import org.seasar.extension.jdbc.JdbcManager;
import org.seasar.extension.unit.S2TestCase;

import static blank.entity.UserRoleNames.*;

/**
 * {@link UserRole}のテストクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityTestModelFactoryImpl"}, date = "2015/08/06 13:35:07")
public class UserRoleTest extends S2TestCase {

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
        jdbcManager.from(UserRole.class).id(1, "aaa").getSingleResult();
    }

    /**
     * userAuthとの外部結合をテストします。
     * 
     * @throws Exception
     */
    public void testLeftOuterJoin_userAuth() throws Exception {
        jdbcManager.from(UserRole.class).leftOuterJoin(userAuth()).id(1, "aaa").getSingleResult();
    }
}