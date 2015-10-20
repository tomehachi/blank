package blank.entity;

import blank.entity.UserAuthNames._UserAuthNames;
import java.sql.Timestamp;
import javax.annotation.Generated;
import org.seasar.extension.jdbc.name.PropertyName;

/**
 * {@link OnetimeKey}のプロパティ名の集合です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesModelFactoryImpl"}, date = "2015/08/06 13:35:01")
public class OnetimeKeyNames {

    /**
     * userIdのプロパティ名を返します。
     * 
     * @return userIdのプロパティ名
     */
    public static PropertyName<Integer> userId() {
        return new PropertyName<Integer>("userId");
    }

    /**
     * onetimeKeyのプロパティ名を返します。
     * 
     * @return onetimeKeyのプロパティ名
     */
    public static PropertyName<String> onetimeKey() {
        return new PropertyName<String>("onetimeKey");
    }

    /**
     * expirationDateのプロパティ名を返します。
     * 
     * @return expirationDateのプロパティ名
     */
    public static PropertyName<Timestamp> expirationDate() {
        return new PropertyName<Timestamp>("expirationDate");
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
    public static class _OnetimeKeyNames extends PropertyName<OnetimeKey> {

        /**
         * インスタンスを構築します。
         */
        public _OnetimeKeyNames() {
        }

        /**
         * インスタンスを構築します。
         * 
         * @param name
         *            名前
         */
        public _OnetimeKeyNames(final String name) {
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
        public _OnetimeKeyNames(final PropertyName<?> parent, final String name) {
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
         * onetimeKeyのプロパティ名を返します。
         *
         * @return onetimeKeyのプロパティ名
         */
        public PropertyName<String> onetimeKey() {
            return new PropertyName<String>(this, "onetimeKey");
        }

        /**
         * expirationDateのプロパティ名を返します。
         *
         * @return expirationDateのプロパティ名
         */
        public PropertyName<Timestamp> expirationDate() {
            return new PropertyName<Timestamp>(this, "expirationDate");
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
         * userAuthのプロパティ名を返します。
         * 
         * @return userAuthのプロパティ名
         */
        public _UserAuthNames userAuth() {
            return new _UserAuthNames(this, "userAuth");
        }
    }
}