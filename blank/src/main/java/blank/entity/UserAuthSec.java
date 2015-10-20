package blank.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 * UserAuthSecエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/08/06 13:34:57")
public class UserAuthSec implements Serializable {

    private static final long serialVersionUID = 1L;

    /** userIdプロパティ */
    @Id
    @Column(precision = 10, nullable = false, unique = true)
    public Integer userId;

    /** lastLoginDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp lastLoginDate;

    /** loginFailureCountプロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer loginFailureCount;

    /** userAuth関連プロパティ */
    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public UserAuth userAuth;
}