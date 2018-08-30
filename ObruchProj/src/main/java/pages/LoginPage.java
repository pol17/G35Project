package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends ParentPage {

    HomePage homePage;

    @FindBy(name = "_username")
    WebElement userNameInput;

    @FindBy(id = "password")
    WebElement passwordInput;

    @FindBy(tagName = "button")
    WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
        homePage = new HomePage(webDriver);
    }

    @Step
    public void openPage(){
        try{
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            logger.info("Login Page was opened");
        } catch (Exception e){
            logger.error("Can not open LoginPage");
            Assert.fail("Can not open LoginPage");
        }
    }

    @Step
    public void enterLogin(String login){
        actionWithOurElements.enterTextToElement(userNameInput,login);
    }

    @Step
    public void enterPass(String pass){
        actionWithOurElements.enterTextToElement(passwordInput,pass);
    }

    @Step
    public void clickOnSubmitButton(){
        actionWithOurElements.clickOnElement(submitButton);
    }

    /**
     * Method for valid Login
     * @param login (only valid login)
     * @param password (only valid password)
     */
    @Step
    public void userValidLogIn(String login, String password) {
        openPage();
        enterLogin(login);
        enterPass(password);
        clickOnSubmitButton();
        homePage.checkCurrentUrl();
        homePage.isAvatarPresent();
    }
}
