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
    private WebElement passwordInput;

    @FindBy(tagName = "button")
    private WebElement sumbitButton;



    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
        homePage = new HomePage(webDriver);
    }

    @Step
    public void openPage () {
        try {
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            logger.info("Login Page was opened");
        } catch (Exception e){
            logger.error("Can't open LoginPage");
            Assert.fail("Can't open LoginPage");

        }
    }
    @Step
    public boolean isLoginPageDisplayed (){
        try {
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            return true;
        } catch (Exception e) {
            return false;

        }

    }
    @Step
    public void enterLogin (String login) {
       actionsWithOurElements.enterTextToElement(userNameInput, login);
    }

    @Step
    public void enterPass (String pass) {
        actionsWithOurElements.enterTextToElement(passwordInput, pass);
    }
    @Step
    public void clickOnSubmitButton (){
       actionsWithOurElements.clickOnElement(sumbitButton);
    }
    @Step
    public boolean isButtonPresent (){
        try {
           return webDriver.findElement(By.tagName("button")).isDisplayed();

        }catch (Exception e){
            return false;
        }

    }

    /**
     * Method valid login
     * @param login (only valid login)
     * @param passWord (only valid Pass)
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
