package blank.entity;

import java.io.Serializable;
import java.util.List;
import javax.annotation.Generated;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * UserAuthエンティティクラス
 * 
 */
@Entity
@Generated(value = {"S2JDBC-Gen 2.4.46", "org.seasar.extension.jdbc.gen.internal.model.EntityModelFactoryImpl"}, date = "2015/08/06 13:34:57")
public class UserAuth implements Serializable {

    private static final long serialVersionUID = 1L;

    /** userIdプロパティ */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(precision = 10, nullable = false, unique = true)
    public Integer userId;

    /** mailAddrプロパティ */
    @Column(length = 128, nullable = false, unique = true)
    public String mailAddr;

    /** passwordプロパティ */
    @Column(length = 256, nullable = false, unique = false)
    public String password;

    /** delFlagプロパティ */
    @Column(nullable = false, unique = false)
    public Boolean delFlag;

    /** loginHistoryList関連プロパティ */
    @OneToMany(mappedBy = "userAuth")
    public List<LoginHistory> loginHistoryList;

    /** onetimeKey関連プロパティ */
    @OneToOne(mappedBy = "userAuth")
    public OnetimeKey onetimeKey;

    /** userAuthSec関連プロパティ */
    @OneToOne(mappedBy = "userAuth")
    public UserAuthSec userAuthSec;

    /** userRoleList関連プロパティ */
    @OneToMany(mappedBy = "userAuth")
    public List<UserRole> userRoleList;
}