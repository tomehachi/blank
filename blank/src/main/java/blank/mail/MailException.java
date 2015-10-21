package blank.mail;

public class MailException extends Exception {

    public String appMessage;

    public MailException(String appMessage, Throwable e) {
        initCause(e);
        this.appMessage = appMessage;
    }
}
