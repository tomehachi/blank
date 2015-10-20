package blank.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.seasar.framework.log.Logger;

import blank.util.exception.AppException;

public class FileUtil {

    private static Logger logger = Logger.getLogger(FileUtil.class);

    private FileUtil() {}

    /**
     * path で指定されたファイル内のテキストを取得し、返す.<br>
     * このとき、改行コードを br に、文字コードを charset として読み込む.<br>
     *
     * @param path 読み込む対象ファイルパス
     * @param br 改行コード
     * @param charset 文字コード
     * @return ファイル内のテキスト
     * @throws AppException 読み込み例外
     */
    public static String getFileText(String path, String br, String charset) throws AppException {
        File file = new File(path);

        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new InputStreamReader(
                    new FileInputStream(file), Charset.forName(charset)));

            StringBuffer text = new StringBuffer();
            String line = "";
            while((line=reader.readLine())!=null) {
                text.append(line).append(br);
            }
            return text.toString();

        } catch (FileNotFoundException e) {
            throw new AppException("ファイル読み込み中に例外発生.", e);

        } catch (IOException e) {
            throw new AppException("ファイル読み込み中に例外発生.", e);

        } finally {
            if(reader != null) {
                try {
                    reader.close();

                } catch (IOException e) {
                    logger.error("ファイルクローズ中に例外発生.", e);
                }
            }
        }

    }
}
