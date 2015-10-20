package blank.entity;

import blank.entity.UserAuthNames._UserAuthNames;
import java.sql.Timestamp;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link UserAuthSec}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/08/06 13:35:01")
public class UserAuthSecNames {

    /**
     * userIdのプロパティ名を返します。
     * 
     * @return userIdのプロパティ名
     */
    public static PropertyName<Integer> userId() {
        return new PropertyName<Integer>("userId");
    }

    /**
     * lastLoginDateのプロパティ名を返します。
     * 
     * @return lastLoginDateのプロパティ名
     */
    public static PropertyName<Timestamp> lastLoginDate() {
        return new PropertyName<Timestamp>("lastLoginDate");
    }

    /**
     * loginFailureCountのプロパティ名を返します。
     * 
     * @return loginFailureCountのプロパティ名
     */
    public static PropertyName<Integer> loginFailureCount() {
        return new PropertyName<Integer>("loginFailureCount");
    }

    /**
     * userAuthのプロパティ名を返します。
     * 
     * @return userAuthのプロパティ名
     */
    public static _UserAuthNames userAuth() {
        return new _UserAuthNames("userAuth");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _UserAuthSecNames extends PropertyName<UserAuthSec> {

        /**
         * インスタンスを構築します。
         */
        public _UserAuthSecNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _UserAuthSecNames(final String name) {
            super(name);
        }

        /**
         * インスタンスを構築します。
         * 
         * @param parent
         *            親
         * @param name
         *            名前
         */
        public _UserAuthSecNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * userIdのプロパティ名を返します。
         *
         * @return userIdのプロパティ名
         */
        public PropertyName<Integer> userId() {
            return new PropertyName<Integer>(this, "userId");
        }

        /**
         * lastLoginDateのプロパティ名を返します。
         *
         * @return lastLoginDateのプロパティ名
         */
        public PropertyName<Timestamp> lastLoginDate() {
            return new PropertyName<Timestamp>(this, "lastLoginDate");
        }

        /**
         * loginFailureCountのプロパティ名を返します。
         *
         * @return loginFailureCountのプロパティ名
         */
        public PropertyName<Integer> loginFailureCount() {
            return new PropertyName<Integer>(this, "loginFailureCount");
        }

        /**
         * userAuthのプロパティ名を返します。
         * 
         * @return userAuthのプロパティ名
         */
        public _UserAuthNames userAuth() {
            return new _UserAuthNames(this, "userAuth");
        }
    }
}