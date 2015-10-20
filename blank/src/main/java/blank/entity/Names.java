package blank.entity;

import blank.entity.LoginHistoryNames._LoginHistoryNames;
import blank.entity.OnetimeKeyNames._OnetimeKeyNames;
import blank.entity.UserAuthNames._UserAuthNames;
import blank.entity.UserAuthSecNames._UserAuthSecNames;
import blank.entity.UserRoleNames._UserRoleNames;
import javax.annotation.Generated;

/**
 * 名前クラスの集約です。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.NamesAggregateModelFactoryImpl"}, date = "2015/08/06 13:35:01")
public class Names {

    /**
     * {@link LoginHistory}の名前クラスを返します。
     * 
     * @return LoginHistoryの名前クラス
     */
    public static _LoginHistoryNames loginHistory() {
        return new _LoginHistoryNames();
    }

    /**
     * {@link OnetimeKey}の名前クラスを返します。
     * 
     * @return OnetimeKeyの名前クラス
     */
    public static _OnetimeKeyNames onetimeKey() {
        return new _OnetimeKeyNames();
    }

    /**
     * {@link UserAuth}の名前クラスを返します。
     * 
     * @return UserAuthの名前クラス
     */
    public static _UserAuthNames userAuth() {
        return new _UserAuthNames();
    }

    /**
     * {@link UserAuthSec}の名前クラスを返します。
     * 
     * @return UserAuthSecの名前クラス
     */
    public static _UserAuthSecNames userAuthSec() {
        return new _UserAuthSecNames();
    }

    /**
     * {@link UserRole}の名前クラスを返します。
     * 
     * @return UserRoleの名前クラス
     */
    public static _UserRoleNames userRole() {
        return new _UserRoleNames();
    }
}