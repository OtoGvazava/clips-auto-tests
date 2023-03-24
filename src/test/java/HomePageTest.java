import messages.AssertMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends BaseTest {
    @BeforeMethod
    public void beforeMethod() {
        pHome.openByUri();
    }

    @Test(description = "Check logo navigation")
    public void logoNavigation() {
        pHome.navigateToClips().clickLogo();
        Assert.assertEquals(driver.getCurrentUrl(), pHome.getPageUri(), AssertMessages.INCORRECT_URL);
    }
}
