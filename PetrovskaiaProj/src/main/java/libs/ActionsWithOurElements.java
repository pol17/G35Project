package libs;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;

    public ActionsWithOurElements(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait20= new WebDriverWait(webDriver, 20);
    }

    public void enterTextToElement(WebElement webElement, String text) {
        try {
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputed into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplay(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is displayed" + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is display" + false);
            return false;
        }
    }
    public void setNeededStateToCheckBox (WebElement webElement, String neededState) {
        if ("checked".equals(neededState) || "uncheck".equals(neededState)) {
            if (webElement.isSelected() && "checked".equals(neededState)) {
                logger.info("CheckBox selected");
            } else if (webElement.isSelected() && "unchecked".equals(neededState)) {
                clickOnElement(webElement);
                logger.info("CheckBox unchecked");
            }
            if (webElement.isSelected() != true && "checked".equals(neededState)) {
                clickOnElement(webElement);
                logger.info("Checkbox checked");
            } else if (webElement.isSelected() != true && "unchecked".equals(neededState)) {
                logger.info("Checkbox unchecked");
            }
        } else {
            logger.error(String.format("&s - is not expected state", neededState));
            Assert.fail(String.format("&s - is not expected state",neededState));
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Can't work with element" + e);
        Assert.fail("Can't work with element" + e);
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            //webDriverWait20.until(ExpectedConditions.not
            //(ExpectedConditions.elementToBeClickable(webElement));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementInList(String xPathLocator) {
        try {
            List<WebElement> webElementList =webDriver.findElements(By.xpath(xPathLocator));
            if (webElementList.size()>0) {
                return true ;
            } else {
                return  false;
            }
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnElement(String xPathLocator) {
        try {
            WebElement webElement= webDriver.findElement(By.xpath(xPathLocator));
            clickOnElement(webElement);
    }catch (Exception e) {
        printErrorAndStopTest(e);
        }
    }

    public void selectValueInDD(WebElement dropDownElement, String value) {
        try {
            Select select= new Select(dropDownElement);
            select.selectByValue(value);
            logger.info(value + " was selected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
