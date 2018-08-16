package pages;

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
    private WebElement buttonSubmit;

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
        homePage = new HomePage(webDriver);
    }

    public void openPage() {
        try {
            webDriver.get(baseUrl + "/login");
            checkCurrentUrl();
            logger.info("login page was opened");
        } catch (Exception e) {
            logger.error("Can't open login page");
            Assert.fail("Can't open login page");
        }
    }

    public boolean isSubmitButtonPresent() {
        return actionsWithOurElements.isElementDisplay(buttonSubmit);
    }

    public void enterLogin(String login) {
        actionsWithOurElements.enterTextToElement(userNameInput, login);
    }

    public void enterPass(String pass) {
        actionsWithOurElements.enterTextToElement(passwordInput, pass);
    }

    public void clickOnSubmitButton() {
        actionsWithOurElements.clickOnElement(buttonSubmit);
    }

    /**
     * Method valid login
     * @param login (only valid login)
     * @param password (only valid password)
     */
    public void userValidLogin(String login, String password) {
        openPage();
        enterLogin(login);
        enterPass(password);
        clickOnSubmitButton();
        homePage.checkCurrentUrl();
        homePage.isAvatarPresent();
    }
}
