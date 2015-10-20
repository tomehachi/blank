package blank.util.exception;

public class AppException extends Exception {

    public String appMessage;
    public AppException(String appMessage, Throwable e) {
        initCause(e);
        this.appMessage = appMessage;
    }
}
