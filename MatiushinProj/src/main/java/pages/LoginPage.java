package pages;


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
    private WebElement submitButton;




    public LoginPage(WebDriver webDriver) {

        super(webDriver, "/login");
        homePage = new HomePage(webDriver);

    }

    public void openPage() {
        try {
            webDriver.get(baseUrl + "/login");
            logger.info("login page was opened");


        } catch (Exception e) {
            logger.error("Can not open login page");
            Assert.fail("Can not open Login Page");

        }
    }

    public void enterLogin(String login) {
       actionsWithElements.enterTextToElement(userNameInput, login);
    }

    public void enterPass(String pass) {
        actionsWithElements.enterTextToElement(passwordInput, pass);
    }

    public void clickOnSubmitButton() {
        actionsWithElements.clickOnElement(submitButton);
    }

    public boolean isSubmitButtonPresent() {
        try {
            return webDriver.findElement(By.tagName("button")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     *  Method valid login
     * @param login (only valid login)
     * @param pass (only valid pass)
     */
    public void userValidLogin(String login, String pass) {

        openPage();
        enterLogin(login);
        enterPass(pass);
        clickOnSubmitButton();
        homePage.checkCurrentPageUrl();
        homePage.isAvatarPresent();





    }
}

