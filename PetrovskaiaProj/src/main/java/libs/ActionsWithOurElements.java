package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger=Logger.getLogger(getClass());
    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver=webDriver;
    }
    public void enterTextToElement (WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into element");
        } catch (Exception e) {
            printErrorAndStopTest(e) ;
        }
    }
    public boolean isElementDisplay (WebElement webElement) {
        try {
            boolean state=webElement.isDisplayed();
            logger.info("Element is displayed" + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is display" + false);
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can't work with element" + e);
        Assert.fail("Can't work with element" + e);
    }

    public void clickOnElement (WebElement webElement) {
        try {
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
