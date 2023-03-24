import data.ConfigData;
import fragments.FWarningPopup;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pages.PHome;
import util.Browser;

import java.time.Duration;

public class BaseTest {
    // Declare Utils
    protected static WebDriver driver;

    // Declare Fragments
    protected static FWarningPopup fWarningPopup;

    // Declare Pages
    protected static PHome pHome;

    @BeforeSuite
    public void beforeSuite() {
        // Initialize Project
        driver = Browser.getInstance().getDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ConfigData.IMPLICITLY_WAIT));
        driver.manage().window().maximize();

        // Initialize Fragments
        fWarningPopup = new FWarningPopup(driver);
        // Initialize Pages
        pHome = new PHome(driver);
        // Open Webpage
        pHome.openByUri();
        // Approve age restriction
        fWarningPopup.clickCheckbox().enter();
    }

    @AfterSuite
    public void afterSuite() {
        driver.close();
    }
}
