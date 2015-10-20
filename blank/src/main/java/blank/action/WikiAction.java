package blank.action;

import java.io.File;
import java.util.ResourceBundle;

import org.apache.log4j.Logger;
import org.seasar.struts.annotation.Execute;

import blank.util.FileUtil;
import blank.util.exception.AppException;

public class WikiAction {

    private ResourceBundle bundle = ResourceBundle.getBundle("wiki");

    public String path;
    public String result;

    private Logger logger = Logger.getLogger(this.getClass());

    @Execute(validator = false, urlPattern = "view/{path}")
    public String index() throws AppException {
        logger.info("path=" + path);
        if(path == null || path.length() == 0) {
            path = "index";
        }
        result = FileUtil.getFileText(
                bundle.getString("wiki.root.dir") + File.separator + path + ".md",
                "\r\n", "UTF-8");

        return "index.jsp";
    }
}
