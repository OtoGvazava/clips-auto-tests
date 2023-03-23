import data.ConfigData;
import messages.AppMessages;
import messages.AssertMessages;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import util.RandomData;

public class AuthorisationTest extends BaseTest {

    @BeforeMethod
    public void beforeMethod() {
        pHome.openByUri();
    }

    @Test(description = "Make success login")
    public void success() {
        pHome.clickLogin()
                .inputEmail(ConfigData.EMAIL)
                .inputPassword(ConfigData.PASSWORD)
                .submitLogin();
        Assert.assertEquals(pHome.getUsername(), ConfigData.USERNAME, AssertMessages.INCORRECT_USERNAME);
    }

    @Test(description = "Try login with incorrect email")
    public void incorrectEmail() {
        pHome.clickLogin()
                .inputEmail(RandomData.randomIncorrectEmail())
                .inputPassword(ConfigData.PASSWORD)
                .submitLogin();
        Assert.assertEquals(pHome.getErrorTextNearPass(), AppMessages.INCORRECT_CREDENTIALS, AssertMessages.INCORRECT_ERROR_TEXT);
    }

    @Test(description = "Try login with incorrect password")
    public void incorrectPassword() {
        pHome.clickLogin()
                .inputEmail(ConfigData.EMAIL)
                .inputPassword(RandomData.randomIncorrectPassword())
                .submitLogin();
        Assert.assertEquals(pHome.getErrorTextNearPass(), AppMessages.INCORRECT_CREDENTIALS, AssertMessages.INCORRECT_ERROR_TEXT);
    }

    @Test(description = "Try login with incorrect user and password")
    public void incorrectUserPassword() {
        pHome.clickLogin()
                .inputEmail(RandomData.randomIncorrectEmail())
                .inputPassword(RandomData.randomIncorrectPassword())
                .submitLogin();
        Assert.assertEquals(pHome.getErrorTextNearPass(), AppMessages.INCORRECT_CREDENTIALS, AssertMessages.INCORRECT_ERROR_TEXT);
    }


    @Test(description = "Try login with empty email")
    public void emptyEmail() {
        pHome.clickLogin()
                .inputEmail("")
                .inputPassword(RandomData.randomIncorrectPassword())
                .submitLogin();
        Assert.assertEquals(pHome.getErrorTextNearEmail(), AppMessages.EMAIL_REQUIRED, AssertMessages.INCORRECT_ERROR_TEXT);
    }

    @Test(description = "Try login with empty password")
    public void emptyPassword() {
        pHome.clickLogin()
                .inputEmail(RandomData.randomIncorrectEmail())
                .inputPassword("")
                .submitLogin();
        Assert.assertEquals(pHome.getErrorTextNearPass(), AppMessages.PASSWORD_REQUIRED, AssertMessages.INCORRECT_ERROR_TEXT);
    }

    @Test(description = "Try login with empty email & password")
    public void emptyEmailPassword() {
        pHome.clickLogin()
                .inputEmail("")
                .inputPassword("")
                .submitLogin();
        Assert.assertEquals(pHome.getErrorTextNearEmail(), AppMessages.EMAIL_REQUIRED, AssertMessages.INCORRECT_ERROR_TEXT);
        Assert.assertEquals(pHome.getErrorTextNearPass(), AppMessages.PASSWORD_REQUIRED, AssertMessages.INCORRECT_ERROR_TEXT);
    }
}
