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

    @FindBy(id="password")
    private WebElement passwordInput;

    @FindBy(tagName = "button")
    private WebElement submitButton;

    public LoginPage(WebDriver webdriver) {
        super(webdriver, "/login");
        homePage = new HomePage(webDriver);
    }

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

    public void enterLogin(String login){
        actionsWithOurElements.enterTextToElement(userNameInput, login);
 /*       try {
//            WebElement webElement = webDriver.findElement(By.name("_username"));
//            webElement.clear();
//            webElement.sendKeys(login);
            userNameInput.clear();
            userNameInput.sendKeys(login);
            logger.info(login + " was input into input login");

        } catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }*/

    }

    public void enterPass(String pass){
        actionsWithOurElements.enterTextToElement(passwordInput, pass);
/*        try {
    //        WebElement webElement = webDriver.findElement(By.id("password"));
    //        webElement.clear();
    //        webElement.sendKeys(pass);
            passwordInput.clear();
            passwordInput.sendKeys(pass);
            logger.info(pass + " was input into input password");

        } catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }*/

    }

    public void clickOnSubmitButton(){
        actionsWithOurElements.clickOnElement(submitButton);
/*        try {
        //    WebElement webElement = webDriver.findElement(By.tagName("button"));
        //    webElement.click();
            submitButton.click();
            logger.info("Submit button was clicked");
        } catch (Exception e){
            logger.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }*/
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
    public void userValidLogIn(String login, String password) {
        openPage();
        enterLogin(login);
        enterPass(password);
        clickOnSubmitButton();
        homePage.checkCurrentUrl();
        homePage.isAvatarPresent();

    }
}
