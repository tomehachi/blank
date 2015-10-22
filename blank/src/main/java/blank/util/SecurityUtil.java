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

    private static String[] CHARS = new String[]{
            "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m",
            "n", "o", "p", "q", "r", "s", "t", "u", "v", "w", "x", "y", "z",
            "A", "B", "C", "D", "E", "F", "G", "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S", "T", "U", "V", "W", "X", "Y", "Z",
            "1", "2", "3", "4", "5", "6", "7", "8", "9", "0"
    };

    public static String randomString(int length) {
        StringBuffer result = new StringBuffer();
        for(int i=0; i<length; i++) {
            result.append(
                    CHARS[(int)Math.round( (double)(Math.random()*(CHARS.length - 1)) )]
            );
        }
        return result.toString();
    }

    public static void main(String...args) {
//        System.out.println(encode("admin"));
        System.out.println(randomString(32));
    }
}
