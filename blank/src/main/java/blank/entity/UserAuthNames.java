package blank.entity;

import blank.entity.LoginHistoryNames._LoginHistoryNames;
import blank.entity.OnetimeKeyNames._OnetimeKeyNames;
import blank.entity.UserAuthSecNames._UserAuthSecNames;
import blank.entity.UserRoleNames._UserRoleNames;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link UserAuth}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/08/06 13:35:01")
public class UserAuthNames {

    /**
     * userIdのプロパティ名を返します。
     * 
     * @return userIdのプロパティ名
     */
    public static PropertyName<Integer> userId() {
        return new PropertyName<Integer>("userId");
    }

    /**
     * mailAddrのプロパティ名を返します。
     * 
     * @return mailAddrのプロパティ名
     */
    public static PropertyName<String> mailAddr() {
        return new PropertyName<String>("mailAddr");
    }

    /**
     * passwordのプロパティ名を返します。
     * 
     * @return passwordのプロパティ名
     */
    public static PropertyName<String> password() {
        return new PropertyName<String>("password");
    }

    /**
     * delFlagのプロパティ名を返します。
     * 
     * @return delFlagのプロパティ名
     */
    public static PropertyName<Boolean> delFlag() {
        return new PropertyName<Boolean>("delFlag");
    }

    /**
     * loginHistoryListのプロパティ名を返します。
     * 
     * @return loginHistoryListのプロパティ名
     */
    public static _LoginHistoryNames loginHistoryList() {
        return new _LoginHistoryNames("loginHistoryList");
    }

    /**
     * onetimeKeyのプロパティ名を返します。
     * 
     * @return onetimeKeyのプロパティ名
     */
    public static _OnetimeKeyNames onetimeKey() {
        return new _OnetimeKeyNames("onetimeKey");
    }

    /**
     * userAuthSecのプロパティ名を返します。
     * 
     * @return userAuthSecのプロパティ名
     */
    public static _UserAuthSecNames userAuthSec() {
        return new _UserAuthSecNames("userAuthSec");
    }

    /**
     * userRoleListのプロパティ名を返します。
     * 
     * @return userRoleListのプロパティ名
     */
    public static _UserRoleNames userRoleList() {
        return new _UserRoleNames("userRoleList");
    }

    /**
     * @author S2JDBC-Gen
     */
    public static class _UserAuthNames extends PropertyName<UserAuth> {

        /**
         * インスタンスを構築します。
         */
        public _UserAuthNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _UserAuthNames(final String name) {
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
        public _UserAuthNames(final PropertyName<?> parent, final String name) {
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
         * mailAddrのプロパティ名を返します。
         *
         * @return mailAddrのプロパティ名
         */
        public PropertyName<String> mailAddr() {
            return new PropertyName<String>(this, "mailAddr");
        }

        /**
         * passwordのプロパティ名を返します。
         *
         * @return passwordのプロパティ名
         */
        public PropertyName<String> password() {
            return new PropertyName<String>(this, "password");
        }

        /**
         * delFlagのプロパティ名を返します。
         *
         * @return delFlagのプロパティ名
         */
        public PropertyName<Boolean> delFlag() {
            return new PropertyName<Boolean>(this, "delFlag");
        }

        /**
         * loginHistoryListのプロパティ名を返します。
         * 
         * @return loginHistoryListのプロパティ名
         */
        public _LoginHistoryNames loginHistoryList() {
            return new _LoginHistoryNames(this, "loginHistoryList");
        }

        /**
         * onetimeKeyのプロパティ名を返します。
         * 
         * @return onetimeKeyのプロパティ名
         */
        public _OnetimeKeyNames onetimeKey() {
            return new _OnetimeKeyNames(this, "onetimeKey");
        }

        /**
         * userAuthSecのプロパティ名を返します。
         * 
         * @return userAuthSecのプロパティ名
         */
        public _UserAuthSecNames userAuthSec() {
            return new _UserAuthSecNames(this, "userAuthSec");
        }

        /**
         * userRoleListのプロパティ名を返します。
         * 
         * @return userRoleListのプロパティ名
         */
        public _UserRoleNames userRoleList() {
            return new _UserRoleNames(this, "userRoleList");
        }
    }
}