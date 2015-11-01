package blank.service;

import static blank.entity.UserAuthNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

import java.util.List;

import javax.annotation.Generated;

import org.seasar.extension.jdbc.where.SimpleWhere;

import blank.entity.UserAuth;

/**
 * {@link UserAuth}のサービスクラスです。
 *
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/08/06 13:35:05")
public class UserAuthService extends AbstractService<UserAuth> {

    /**
     * 識別子でエンティティを検索します。
     *
     * @param userId
     *            識別子
     * @return エンティティ
     */
    public UserAuth findById(Integer userId) {
        return select().id(userId).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     *
     * @return エンティティのリスト
     */
    public List<UserAuth> findAllOrderById() {
        return select().orderBy(asc(userId())).getResultList();
    }

    /**
     * メールアドレスをキーに有効なユーザ情報を取得.<br>
     *
     * @param mailAddr メールアドレス
     * @return ユーザ情報
     */
    public UserAuth findAvailableUserByMailAddr(String mailAddr) {
        return jdbcManager.from(UserAuth.class)
        .where(new SimpleWhere()
            .eq("mailAddr", mailAddr)
            .eq("delFlag", false)
        )
        .getSingleResult();
    }
}
