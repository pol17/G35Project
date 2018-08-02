package pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage extends ParentPage {

    public LoginPage(WebDriver webDriver) {
        super(webDriver, "/login");
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
        try{
            WebElement webElement = webDriver.findElement(By.name("_username"));
            webElement.clear();
            webElement.sendKeys(login);
            logger.info(login + " was input into input Login ");

        } catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
    public void enterPass(String pass){
        try{
            WebElement webElement = webDriver.findElement(By.id("password"));
            webElement.clear();
            webElement.sendKeys(pass);
            logger.info(pass + " was input into input Pass ");

        } catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }
    public void clickOnSubmitButton(){
        try{
            WebElement webElement = webDriver.findElement(By.tagName("button"));
            webElement.click();
            logger.info("Button submit was clicked");
        }catch (Exception e){
            logger.error("Can not work with element");
            Assert.fail("Can not work with element");
        }
    }

}
