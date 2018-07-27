package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ParentPage {
    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
    }

    public void openPage() {
        try {
            webDriver.get(baseUrl + "/login");
            cheekCurrentUrl();
            logger.info("Login Page was opened");

        } catch (Exception e) {
            logger.error("Can not open LoginPage" + " " +e);
            Assert.fail("Can not open LoginPage");
        }
    }

    public void enterLogin(String login) {
        try {
            WebElement webElement = webDriver.findElement(By.name("_username"));  //в переменную WebElement будет записан webElement
            webElement.clear();
            webElement.sendKeys(login);
            logger.info(login + " was input into input Login ");

        } catch (Exception e) {
            logger.error("Can not work with element login ");
            Assert.fail("Can not work with element login ");
        }

    }

    public void enterPass(String Pass) {
        try {
            WebElement webElement = webDriver.findElement(By.id("password"));
            webElement.clear();
            webElement.sendKeys(Pass);
            logger.info(Pass + " was input into input Pass ");

        } catch (Exception e) {
            logger.error("Can not work with element Pass ");
            Assert.fail("Can not work with element Pass ");
        }

    }

    public void clickOnSubmitButton() {
        try {
    WebElement webElement = webDriver.findElement(By.tagName("button"));
    webElement.click();
    logger.info(" button Submit was Click");
        } catch (Exception e) {
            logger.error("Can not work with  button Submit ");
            Assert.fail("Can not work with  button Submit ");
        }
    }
}
