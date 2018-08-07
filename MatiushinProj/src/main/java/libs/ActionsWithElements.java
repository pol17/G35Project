package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;


public class ActionsWithElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger((getClass()));


    public ActionsWithElements(WebDriver webDriver) {
        this.webDriver = webDriver;

    }

    public void enterTextToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);


        }

    }

    public void clickOnElement(WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is displayed: " + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is displayed: false");
            return false;
        }

    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element, exception: " + e);
        Assert.fail("Cannot work with element");


    }

    public boolean isElementInList(String xPathLocator) {
        try {
            List<WebElement> webElementList = webDriver.findElements(By.xpath(xPathLocator));
            if (webElementList.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String xPathLocator) {
        try{
            WebElement webElement= webDriver.findElement(By.xpath(xPathLocator));
            clickOnElement(webElement);
        }catch (Exception e){
            printErrorAndStopTest(e);
        }


    }

    public void selectValueDropDown(WebElement dropDownElement, String value) {
        try{
            Select select = new Select(dropDownElement);
            select.deselectByValue(value);
            logger.info(value + "was selected in DD");


        }catch(Exception e){
            printErrorAndStopTest(e);

        }


    }
}
