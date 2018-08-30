package pages;

import io.qameta.allure.Step;
import org.junit.Assert;
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
    private WebElement submitButton;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
        homePage = new HomePage(webDriver);
    }
        @Step
        public void openPage() {
            try {
                webDriver.get(baseUrl + "/login");
                checkCurrentUrl();
                logger.info("Login Page was opened");
            } catch (Exception e) {
                logger.error("Cannot open LoginPage");
                Assert.fail("Cannot open LoginPage");
            }
        }

        @Step
        public void enterLogin (String login){
            actionsWithOurElements.enterTextToElement(userNameInput, login);
        }
        @Step
        public void enterPass (String pass){
            actionsWithOurElements.enterTextToElement(passwordInput, pass);
        }
        @Step
        public void clickOnSubmitButton (){
            actionsWithOurElements.clickOnElement(submitButton);
        }

        /**
         * Method valid Login
         * @param login (ONLY Valid Login)
         * @param passWord (ONLY Valid Pass)
         */
        @Step
        public void userValidLogIn (String login, String passWord){
            openPage();
            enterLogin(login);
            enterPass(passWord);
            clickOnSubmitButton();
            homePage.checkCurrentUrl();
            homePage.isAvatarPresent();
        }
    }

