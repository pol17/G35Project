package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    HomePage homePage;
    @FindBy(name="_username")
    private WebElement userNameInput;
    @FindBy(id="password")
    private WebElement PasswordInput;
    @FindBy(tagName="button")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
        homePage= new HomePage(webDriver);
    }
@Step
    public void openPage() {
        try {
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Can't open Login Page");
            Assert.fail("Can't open Login Page");
        }
    }
@Step
    public void enterLogin(String login) {
     actionsWithOurElements.enterTextToElement(userNameInput, login);
    }
@Step
    public void enterPass(String pass) {
     actionsWithOurElements.enterTextToElement(PasswordInput, pass);
    }
@Step
    public void clickOnSubmitButton() {
   actionsWithOurElements.clickOnElement(submitButton);
    }

    /**
     * Method valid login
     * @param login  (ONLY Valid Login)
     * @param passWord (ONLY Valid pass)
     */
    @Step
    public void userValidLogin(String login, String passWord) {
        openPage();
        enterLogin(login);
        enterPass(passWord);
        clickOnSubmitButton();
        homePage.checkCurrentUrl();
        homePage.isAvatarPresent();
    }
}