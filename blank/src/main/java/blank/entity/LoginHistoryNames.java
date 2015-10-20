package blank.entity;

import blank.entity.UserAuthNames._UserAuthNames;
import java.sql.Timestamp;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link LoginHistory}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/08/06 13:35:01")
public class LoginHistoryNames {

    /**
     * loginHistoryIdのプロパティ名を返します。
     * 
     * @return loginHistoryIdのプロパティ名
     */
    public static PropertyName<Integer> loginHistoryId() {
        return new PropertyName<Integer>("loginHistoryId");
    }

    /**
     * tryDateのプロパティ名を返します。
     * 
     * @return tryDateのプロパティ名
     */
    public static PropertyName<Timestamp> tryDate() {
        return new PropertyName<Timestamp>("tryDate");
    }

    /**
     * userIdのプロパティ名を返します。
     * 
     * @return userIdのプロパティ名
     */
    public static PropertyName<Integer> userId() {
        return new PropertyName<Integer>("userId");
    }

    /**
     * inputMailAddrのプロパティ名を返します。
     * 
     * @return inputMailAddrのプロパティ名
     */
    public static PropertyName<String> inputMailAddr() {
        return new PropertyName<String>("inputMailAddr");
    }

    /**
     * ipAddrのプロパティ名を返します。
     * 
     * @return ipAddrのプロパティ名
     */
    public static PropertyName<String> ipAddr() {
        return new PropertyName<String>("ipAddr");
    }

    /**
     * loginSuccessのプロパティ名を返します。
     * 
     * @return loginSuccessのプロパティ名
     */
    public static PropertyName<Boolean> loginSuccess() {
        return new PropertyName<Boolean>("loginSuccess");
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
    public static class _LoginHistoryNames extends PropertyName<LoginHistory> {

        /**
         * インスタンスを構築します。
         */
        public _LoginHistoryNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _LoginHistoryNames(final String name) {
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
        public _LoginHistoryNames(final PropertyName<?> parent, final String name) {
            super(parent, name);
        }

        /**
         * loginHistoryIdのプロパティ名を返します。
         *
         * @return loginHistoryIdのプロパティ名
         */
        public PropertyName<Integer> loginHistoryId() {
            return new PropertyName<Integer>(this, "loginHistoryId");
        }

        /**
         * tryDateのプロパティ名を返します。
         *
         * @return tryDateのプロパティ名
         */
        public PropertyName<Timestamp> tryDate() {
            return new PropertyName<Timestamp>(this, "tryDate");
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
         * inputMailAddrのプロパティ名を返します。
         *
         * @return inputMailAddrのプロパティ名
         */
        public PropertyName<String> inputMailAddr() {
            return new PropertyName<String>(this, "inputMailAddr");
        }

        /**
         * ipAddrのプロパティ名を返します。
         *
         * @return ipAddrのプロパティ名
         */
        public PropertyName<String> ipAddr() {
            return new PropertyName<String>(this, "ipAddr");
        }

        /**
         * loginSuccessのプロパティ名を返します。
         *
         * @return loginSuccessのプロパティ名
         */
        public PropertyName<Boolean> loginSuccess() {
            return new PropertyName<Boolean>(this, "loginSuccess");
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