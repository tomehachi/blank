package blank.service;

import blank.entity.OnetimeKey;
import java.util.List;
import javax.annotation.Generated;

import static blank.entity.OnetimeKeyNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link OnetimeKey}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/08/06 13:35:05")
public class OnetimeKeyService extends AbstractService<OnetimeKey> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param userId
     *            識別子
     * @return エンティティ
     */
    public OnetimeKey findById(Integer userId) {
        return select().id(userId).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<OnetimeKey> findAllOrderById() {
        return select().orderBy(asc(userId())).getResultList();
    }
}