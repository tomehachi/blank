package blank.mail.util;

import java.util.Enumeration;
import java.util.HashSet;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

public class MailClientUtil {

    private MailClientUtil() {}

    public static Set<String> getPropertyKeySetByPrefix(String keyPrefix, ResourceBundle bundle) {
        Enumeration<String> e = bundle.getKeys();

        Set<String> keys = new HashSet<String>();
        while(e.hasMoreElements()) {
            String key = e.nextElement();
            if(key.startsWith(keyPrefix)) {
                keys.add(key);
            }
        }
        return keys;
    }

    /**
     * Gather the properties filled with the given prefix from the given ResourceBundle.
     *
     * @param keyPrefix Key prefix to gather the related configuration keys.
     * @param bundle ResourceBundle to find the configurations.
     * @return A property object filled with the given prefix.
     */
    public static Properties loadPropertiesByPrefix(String keyPrefix, ResourceBundle bundle) {
        // Gather the SMTP configuration keys.
        Set<String> keys = getPropertyKeySetByPrefix(keyPrefix, bundle);

        // Fill the properties with the configurations given by the keys.
        Properties props = new Properties();
        for(String key : keys) {
            props.setProperty(key, bundle.getString(key));
        }
        return props;
    }

}
