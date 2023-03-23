package data;

import util.ConfigReader;

public class ConfigData {
    public static String BASE_URI = ConfigReader.getInstance().read("base.uri");
    public static int IMPLICITLY_WAIT = Integer.parseInt(ConfigReader.getInstance().read("implicitly.wait"));
    public static String EMAIL = ConfigReader.getInstance().read("email");
    public static String PASSWORD = ConfigReader.getInstance().read("password");
    public static String USERNAME = ConfigReader.getInstance().read("username");
}
