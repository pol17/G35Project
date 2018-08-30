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

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(tagName = "button")
    private WebElement submitButton;

    public LoginPage(WebDriver webdriver) {
        super(webdriver, "/login");
        homePage = new HomePage(webDriver);
    }
 @Step
    public void openPage() {
        try {
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            logger.info("login page was opened");
        } catch (Exception e) {
            logger.error("Cannot open Login page");
            Assert.fail("Cannot open Login page");
        }
    }

    @Step
    public void enterLogin(String login){
        actionsWithOurElements.enterTextToElement(userNameInput, login);
    }

    @Step
    public void enterPass(String pass){
        actionsWithOurElements.enterTextToElement(passwordInput, pass);
    }

    @Step
    public void clickOnSubmitButton(){
        actionsWithOurElements.clickOnElement(submitButton);
    }

    public boolean isButtonLoginPresent () {
        try {
            return webDriver.findElement(By.xpath(".//button[@type='submit']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Method valid login
     * @param login (ONLY Valid login)
     * @param password (ONLY Valid password)
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
