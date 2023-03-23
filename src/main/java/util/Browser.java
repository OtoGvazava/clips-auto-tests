package util;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Browser {
    private static Browser _instance;
    private final ChromeDriver driver;

    private Browser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    public static Browser getInstance() {
        if (_instance == null) {
            _instance = new Browser();
        }
        return _instance;
    }

    public ChromeDriver getDriver() {
        return driver;
    }
}
