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
    private WebElement userNameImput;

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
        try {
            webDriver.get(baseUrl + "/login");
            cheekCurrentUrl();
            logger.info("Login Page was opened");

        } catch (Exception e) {
            logger.error("Can not open LoginPage" + " " + e);
            Assert.fail("Can not open LoginPage");
        }
    }
    @Step
    public void enterLogin(String login) {
        actionWithOurElement.enterTextToElement(userNameImput, login);  // тот же результат что и нижеее!!!!!
//        try {
//         //   WebElement webElement = webDriver.findElement(By.name("_username"));  //в переменную WebElement будет записан webElement
//            userNameImput.clear();
//            userNameImput.sendKeys(login);
//            logger.info(login + " was input into input Login ");
//        } catch (Exception e) {
//            logger.error("Can not work with element login ");
//            Assert.fail("Can not work with element login ");
//        }
    }
    @Step
    public void enterPass(String pass) {
        actionWithOurElement.enterTextToElement(passwordImput, pass);
//        try {
//           // WebElement webElement = webDriver.findElement(By.id("password"));
//            passwordImput.clear();
//            passwordImput.sendKeys(Pass);
//            logger.info(Pass + " was input into input Pass ");
//
//        } catch (Exception e) {
//            logger.error("Can not work with element Pass ");
//            Assert.fail("Can not work with element Pass ");
//        }
    }
    @Step
    public void clickOnSubmitButton() {
        actionWithOurElement.clickOnElement(submitButton);
//        try {
//  //  WebElement webElement = webDriver.findElement(By.tagName("button"));
//    submitButton.click();
//    logger.info(" button Submit was Click");
//        } catch (Exception e) {
//            logger.error("Can not work with  button Submit ");
//            Assert.fail("Can not work with  button Submit ");
//        }
    }
    @Step
    public boolean isLoginBoxMsg() {
        try {
            return webDriver.findElement(
                    By.xpath(".//p[@class='login-box-msg']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * Metod valid Login
     * @param login  (ONLY Valid Login)
     * @param passWord   (ONLY Valid Pass)
     */
    @Step
    public void userValidLogIn(String login, String passWord) {
        openPage();
        enterLogin(login);
        enterPass(passWord);
        clickOnSubmitButton();
        homePage.cheekCurrentUrl();
        homePage.isAvatarPresent();

    }
}
