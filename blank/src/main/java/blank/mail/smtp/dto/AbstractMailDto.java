package blank.mail.smtp.dto;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import javax.mail.internet.InternetAddress;

import blank.mail.AddressType;
import blank.mail.MailException;

public class AbstractMailDto {

    /** 差出人アドレス */
    public InternetAddress from;
    public String fromAddress;
    public String fromName;

    /** 宛先アドレス */
    public List<InternetAddress> to = new ArrayList<InternetAddress>();
    public List<InternetAddress> cc = new ArrayList<InternetAddress>();
    public List<InternetAddress> bcc = new ArrayList<InternetAddress>();

    /** 表題 */
    public String subject;

    public List<File> attachedFiles = new ArrayList<File>();

    /** 署名 */
    public String signature;

    public String mailEncode;

    public AbstractMailDto(String mailEncode) {
        this.mailEncode = mailEncode;
    }

    /**
     * 各種アドレス追加.<br>
     *
     * @param email メールアドレス
     * @param name 表示名
     * @param recipientType メールアドレスタイプ(FROM, TO, CC, BCC)
     * @return this
     * @throws MailException エンコード失敗時の例外
     */
    public AbstractMailDto addAddress(AddressType recipientType, String email, String name)
            throws MailException {
        try {
            switch (recipientType) {
            case FROM:
                from = new InternetAddress(email, name, mailEncode);
                fromName = name;
                fromAddress = email;
                break;

            case TO:
                to.add(new InternetAddress(email, name, mailEncode));
                break;

            case CC:
                cc.add(new InternetAddress(email, name, mailEncode));
                break;

            case BCC:
                bcc.add(new InternetAddress(email, name, mailEncode));
                break;

            default:
                throw new MailException("想定外のRecipientTypeが指定されました.", null);
            }
        } catch (UnsupportedEncodingException e) {
            throw new MailException("アドレス設定中にエンコード例外発生.", e);
        }
        return this;
    }
}
