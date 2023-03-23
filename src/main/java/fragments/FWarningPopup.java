package fragments;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FWarningPopup {
    @FindBy(xpath = "//input[@id=\"iCertifyCheck\"]")
    private WebElement checkbox;
    @FindBy(xpath = "//button[@id=\"enter-agree\"]")
    private WebElement buttonEnter;

    public FWarningPopup(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    @Step("Click age approve checkbox")
    public FWarningPopup clickCheckbox() {
        checkbox.click();
        return this;
    }

    @Step("Enter on the website")
    public FWarningPopup enter() {
        buttonEnter.click();
        return this;
    }
}
