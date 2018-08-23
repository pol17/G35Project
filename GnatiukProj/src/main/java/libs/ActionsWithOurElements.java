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
        webDriverWait20 = new WebDriverWait(webDriver, 20);
    }

    //метод для ввода текста
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
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
//            webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplayed(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is display -> " + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is display -> " + false);
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }

//    метод для чекбокса
public void setNeededStateToCheskBox(WebElement webElement, String neededState) {
    if ("check".equals(neededState) || "uncheck".equals(neededState)) {
        if (webElement.isSelected() && "check".equals(neededState)) {
            logger.info("CheckBox is already checked");
        } else if (webElement.isSelected() && "uncheck".equals(neededState)) {
            clickOnElement(webElement);
            logger.info("CheckBox was unchecked");
        }
        if (webElement.isSelected() != true && "check".equals(neededState)) {
            clickOnElement(webElement);
            logger.info("CheckBox is already checked");
        } else if (webElement.isSelected() != true && "uncheck".equals(neededState)) {
            logger.info("CheckBox was unchecked");
        }
    } else {
        logger.error(String.format("%s - is not expected state", neededState));
        Assert.fail(String.format("%s - is not expected state", neededState));
    }
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
        try {
            WebElement webElement = webDriver.findElement(By.xpath(xPathLocator));
            clickOnElement(webElement);
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void selectValueInDropDown(WebElement dropDownElement, String value) {
        try {
            Select select = new Select(dropDownElement);
            select.selectByValue(value);
            logger.info(value + " was selected in DropDown");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
