package blank.service;

import blank.entity.UserAuthSec;
import java.util.List;
import javax.annotation.Generated;

import static blank.entity.UserAuthSecNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link UserAuthSec}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/08/06 13:35:05")
public class UserAuthSecService extends AbstractService<UserAuthSec> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param userId
     *            識別子
     * @return エンティティ
     */
    public UserAuthSec findById(Integer userId) {
        return select().id(userId).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<UserAuthSec> findAllOrderById() {
        return select().orderBy(asc(userId())).getResultList();
    }
}