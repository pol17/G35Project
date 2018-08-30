package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {
    HomePage homePage;

    @FindBy(name = "_username")
    private WebElement userNameInput;

    @FindBy(id = "password")
    private WebElement passwordImput;

    @FindBy(tagName = "button")
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {

        super(webDriver, "/login");
        homePage = new HomePage(webDriver);
    }


    @Step
    public void openPage() {
        try{
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            logger.info("Login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open Login Page");
            Assert.fail("Cannot open Login Page");
        }
    }

    @Step
    public void enterLogin(String login) {
        actionsWithOurElements.enterTexttoElement(userNameInput, login);

    }

    @Step
    public void enterPass(String pass) {
        actionsWithOurElements.enterTexttoElement(passwordImput, pass);

    }

    @Step
    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(submitButton);

    }

    public boolean isButtonPresent() {
        return  actionsWithOurElements.isElementDisplay(submitButton);
    }

    @Step
    public boolean isLoginButtonpresent() {
        try {
            return webDriver.findElement(
                    By.tagName("button")).isDisplayed();

        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method valid Login
     * @param login (ONLY valid Login)
     * @param passWord (ONLY Valid Pass)
     */

    @Step
    public void userValidLogIn(String login, String passWord) {
        openPage();
        enterLogin(login);
        enterPass(passWord);
        clickOnSubmitButton();
        homePage.checkCurrentUrl();
        homePage.isAvatarPresent();



    }
}
