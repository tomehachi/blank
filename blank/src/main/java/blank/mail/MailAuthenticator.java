package blank.mail;

import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;

public class MailAuthenticator extends Authenticator {

    private String mailAddr;
    private String password;

    /**
     * メールアドレスとパスワードを設定する.<br>
     *
     * @param mailAddr メールアドレス
     * @param password パスワード
     */
    public MailAuthenticator(String mailAddr, String password) {
        this.mailAddr = mailAddr;
        this.password = password;
    }

    /*
     * (非 Javadoc)
     * @see javax.mail.Authenticator#getPasswordAuthentication()
     */
    @Override
    protected PasswordAuthentication getPasswordAuthentication() {
        return new PasswordAuthentication(this.mailAddr, this.password);
    }

}
