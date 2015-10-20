package blank.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.MessageFormat;

import org.apache.log4j.Logger;

public class SecurityUtil {

    /** 暗号化前のパスワード */
    private static final String PASSWORD_FORMAT = "caAyDAKiEW{0}VxsSgMYNhQ";

    /** 暗号化アルゴリズム名 */
    private static final String ENCRYPT_ALGORITHMN = "SHA-512";

    /** ロガー */
    private static Logger logger = Logger.getLogger(SecurityUtil.class);


    private SecurityUtil() {}


    public static String encode(String input) {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(ENCRYPT_ALGORITHMN);

        } catch (NoSuchAlgorithmException e) {
            logger.error("文字列を暗号化中に例外が発生しました.", e);
        }
        messageDigest.update(MessageFormat.format(PASSWORD_FORMAT, input).getBytes());
        byte[] bytes = messageDigest.digest();

        StringBuffer result = new StringBuffer();
        for(int b : bytes) {
            result.append(Integer.toHexString(b & 0xff));
        }
        return result.toString();
    }

    public static void main(String...args) {

        System.out.println(encode("admin"));
    }
}
