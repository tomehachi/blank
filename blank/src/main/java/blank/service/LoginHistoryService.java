package blank.service;

import blank.entity.LoginHistory;
import java.util.List;
import javax.annotation.Generated;

import static blank.entity.LoginHistoryNames.*;
import static org.seasar.extension.jdbc.operation.Operations.*;

/**
 * {@link LoginHistory}のサービスクラスです。
 * 
 */
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.ServiceModelFactoryImpl"}, date = "2015/08/06 13:35:05")
public class LoginHistoryService extends AbstractService<LoginHistory> {

    /**
     * 識別子でエンティティを検索します。
     * 
     * @param loginHistoryId
     *            識別子
     * @return エンティティ
     */
    public LoginHistory findById(Integer loginHistoryId) {
        return select().id(loginHistoryId).getSingleResult();
    }

    /**
     * 識別子の昇順ですべてのエンティティを検索します。
     * 
     * @return エンティティのリスト
     */
    public List<LoginHistory> findAllOrderById() {
        return select().orderBy(asc(loginHistoryId())).getResultList();
    }
}