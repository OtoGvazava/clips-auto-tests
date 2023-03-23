/**
 * It reads a key from a properties file and returns the value
 */
package util;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

public class ConfigReader extends Properties {
    private static ConfigReader _instance;

    private ConfigReader() {
        load();
    }

    private void load() {
        try {
            InputStream inputStream = Files.newInputStream(Paths.get("config.properties"));
            load(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * use getProperty instead
     *
     * @return string value of a key
     */

    public String read(String key) {
        return getProperty(key);
    }

    public static ConfigReader getInstance() {
        if (_instance == null) {
            _instance = new ConfigReader();
        }

        return _instance;
    }
}


