package pages;

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

    public void enterLogin(String login){
        actionWithOurElements.enterTextToElement(userNameInput,login);
    }

    public void enterPass(String pass){
        actionWithOurElements.enterTextToElement(passwordInput,pass);
    }

    public void clickOnSubmitButton(){
        actionWithOurElements.clickOnElement(submitButton);
    }

    /**
     * Method for valid Login
     * @param login (only valid login)
     * @param password (only valid password)
     */
    public void userValidLogIn(String login, String password) {
        openPage();
        enterLogin(login);
        enterPass(password);
        clickOnSubmitButton();
        homePage.checkCurrentUrl();
        homePage.isAvatarPresent();
    }
}
