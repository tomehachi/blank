package blank.entity;

import java.io.Serializable;
import java.sql.Timestamp;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * LoginHistoryエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/08/06 13:34:57")
public class LoginHistory implements Serializable {

    private static final long serialVersionUID = 1L;

    /** loginHistoryIdプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 10, nullable = false, unique = true)
    public Integer loginHistoryId;

    /** tryDateプロパティ */
    @Column(nullable = false, unique = false)
    public Timestamp tryDate;

    /** userIdプロパティ */
    @Column(precision = 10, nullable = true, unique = false)
    public Integer userId;

    /** inputMailAddrプロパティ */
    @Column(length = 128, nullable = true, unique = false)
    public String inputMailAddr;

    /** ipAddrプロパティ */
    @Column(length = 64, nullable = false, unique = false)
    public String ipAddr;

    /** loginSuccessプロパティ */
    @Column(nullable = false, unique = false)
    public Boolean loginSuccess;

    /** userAuth関連プロパティ */
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    public UserAuth userAuth;
}