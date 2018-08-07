package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());

    public ActionWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    
    public void enterTextToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into element");
        } catch (Exception e){
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement webElement){
        try {
            webElement.click();
            logger.info(webElement + " was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement webElement){
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is displaed " + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is displaed --> false");
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can not work with element " + e);
        Assert.fail("Can not work with element " + e);
    }


    public boolean isElementInList(String xpathLocator) {
        try {
            List<WebElement> webElementList = webDriver.findElements(By.xpath(xpathLocator));
            if (webElementList.size() > 0) {
                return true;
            } else {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String xpathLocator) {
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xpathLocator));
            clickOnElement(webElement);
        }catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDD(WebElement dropDownElement, String value) {
        try {
            Select select = new Select(dropDownElement);
            select.selectByValue(value);
            logger.info(value + " was selected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectFromDDLikeUser (WebElement ddElement, String value) {
        this.clickOnElement(ddElement);
        List<WebElement> allOptions = ddElement.findElements(By.tagName("option"));
        for (WebElement option : allOptions) {
            if (option.getText().equals(value)) {
                option.click();
            }

        }

    }


}
