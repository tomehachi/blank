package blank.entity;

import blank.entity.UserAuthNames._UserAuthNames;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link UserRole}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/08/06 13:35:01")
public class UserRoleNames {

    /**
     * userIdのプロパティ名を返します。
     * 
     * @return userIdのプロパティ名
     */
    public static PropertyName<Integer> userId() {
        return new PropertyName<Integer>("userId");
    }

    /**
     * roleのプロパティ名を返します。
     * 
     * @return roleのプロパティ名
     */
    public static PropertyName<String> role() {
        return new PropertyName<String>("role");
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
    public static class _UserRoleNames extends PropertyName<UserRole> {

        /**
         * インスタンスを構築します。
         */
        public _UserRoleNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _UserRoleNames(final String name) {
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
        public _UserRoleNames(final PropertyName<?> parent, final String name) {
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
         * roleのプロパティ名を返します。
         *
         * @return roleのプロパティ名
         */
        public PropertyName<String> role() {
            return new PropertyName<String>(this, "role");
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