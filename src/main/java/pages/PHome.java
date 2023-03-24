package pages;

import data.ConfigData;
import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PHome {
    protected final String ENDPOINT = "/";
    protected WebDriver driver;
    @FindBy(xpath = "//nav[@id=\"navigation-header\"]//span[@id=\"login-btn\"]")
    private WebElement buttonLogin;
    @FindBy(xpath = "//nav[@id=\"navigation-header\"]//div[@class=\"react-dropdown-login w-full\"]//input[@name=\"userEmail\"]")
    private WebElement inputEmail;
    @FindBy(xpath = "//nav[@id=\"navigation-header\"]//div[@class=\"react-dropdown-login w-full\"]//input[@name=\"userPassword\"]")
    private WebElement inputPassword;
    @FindBy(xpath = "//nav[@id=\"navigation-header\"]//div[@class=\"react-dropdown-login w-full\"]//p[@class=\"p-2 text-grainyCurrant text-center text-sm\"]")
    private WebElement errorTextNearEmail;
    @FindBy(xpath = "//nav[@id=\"navigation-header\"]//div[@class=\"react-dropdown-login w-full\"]//p[@class=\"pt-1 text-grainyCurrant text-center text-sm\"]")
    private WebElement errorTextNearPassword;
    @FindBy(xpath = "//nav[@id=\"navigation-header\"]//div[@class=\"react-dropdown-login w-full\"]//button[@type=\"submit\"]")
    private WebElement buttonSubmitLogin;
    @FindBy(xpath = "//div[@id=\"logged-in-dropdown\"]/div[1]/div[1]/div[2]/div")
    private WebElement labelUsername;
    @FindBy(xpath = "//nav[@id=\"navigation-header\"]//a[@id=\"logo-direct\"]")
    private WebElement logo;
    @FindBy(xpath = "//ul[@id='main-menu']//a[@href='https://www.clips4sale.com/clips/search']")
    private WebElement navClips;

    public PHome(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @Step("Open home page by url")
    public void openByUri() {
        driver.get(ConfigData.BASE_URI);
    }

    @Step("Click login button")
    public PHome clickLogin() {
        buttonLogin.click();
        return this;
    }

    @Step("Input email")
    public PHome inputEmail(String email) {
        inputEmail.clear();
        inputEmail.sendKeys(email);
        return this;
    }

    @Step("Input password")
    public PHome inputPassword(String password) {
        inputPassword.clear();
        inputPassword.sendKeys(password);
        return this;
    }

    @Step("Log in")
    public PHome submitLogin() {
        buttonSubmitLogin.click();
        return this;
    }

    @Step("Get error text near email field")
    public String getErrorTextNearEmail() {
        return errorTextNearEmail.getText();
    }

    @Step("Get error text near password field")
    public String getErrorTextNearPass() {
        return errorTextNearPassword.getText();
    }

    @Step("Get username")
    public String getUsername() {
        return labelUsername.getText();
    }

    @Step("Click logo")
    public PHome clickLogo() {
        logo.click();
        return this;
    }

    @Step("Navigate to clips page")
    public PHome navigateToClips() {
        navClips.click();
        return this;
    }

    @Step("Get page uri")
    public String getPageUri() {
        return ConfigData.BASE_URI + ENDPOINT;
    }
}
