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

//all methods with actions with elements
public class ActionsWithOurElements {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;
    WebDriverWait webDriverWait40;

    public ActionsWithOurElements(WebDriver webDriver) {

        this.webDriver = webDriver;
        webDriverWait20 = new WebDriverWait(webDriver, 20);
        webDriverWait40 = new WebDriverWait(webDriver,40);
    }

    public void enterTextToElement(WebElement webElement, String text) {
        try {
            webDriverWait40.until(ExpectedConditions.visibilityOf(webElement));
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was entered into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));
            //example of using not in ExpectedConditions
            // webDriverWait20.until(ExpectedConditions.not(ExpectedConditions.elementToBeClickable(webElement)));
            webElement.click();
            logger.info("Element was clicked");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public boolean isElementDisplay(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is display - > " + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is display - > false");
            return false;
        }
    }

    private void printErrorAndStopTest(Exception e) {
        logger.error("Cannot work with element " + e);
        Assert.fail("Cannot work with element " + e);
    }

    //check if element exists
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

    //check if element exists and only one
    public boolean isElementInListOnlyOne(String xPathLocator) {
        try {
            List<WebElement> webElementList = webDriver.findElements(By.xpath(xPathLocator));
            if (webElementList.size() == 1) {
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

    public void selectValueInDD(WebElement dropDownElement, String value) {
        try {
            Select select = new Select(dropDownElement);
            select.selectByValue(value);
            logger.info(value + " was selected in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void setNeededStateToCheckBox(WebElement webElement, String neededState){
        if ("check".equals(neededState) || "uncheck".equals(neededState)){
            if (webElement.isSelected() && "check".equals(neededState)) {
                logger.info("checkbox is already checked");
            } else if (webElement.isSelected() && "uncheck".equals(neededState)) {
                clickOnElement(webElement);
                logger.info("checkbox was unchecked");
            } else if (!webElement.isSelected() && "uncheck".equals(neededState)){
                logger.info("checkbox is already unchecked");
            } else if (!webElement.isSelected() && "check".equals(neededState)) {
                clickOnElement(webElement);
                logger.info("checkbox was unchecked");
            }
        } else {
            logger.error(String.format("%s - is not expected state", neededState));
            Assert.fail(String.format("%s - is not expected state", neededState));
        }
    }

    public void clickValueInDD(WebElement dropDownList, WebElement dropDownElement) {
        clickOnElement(dropDownList);
        clickOnElement(dropDownElement);
    }

    /**
     * Method set CheckBox State
     *
     * @param checkBox
     * @param checkBoxState - "check" or "uncheck"
     */
    public void setCheckBoxState(WebElement checkBox, String checkBoxState) {
        try {
            if (checkBoxState == "check") {
                if (checkBox.isSelected() != true) {
                    clickOnElement(checkBox);
                }
            } else if (checkBoxState == "uncheck") {
                if (checkBox.isSelected() == true) {
                    clickOnElement(checkBox);
                }
            } else {
                logger.error("CheckBox state can be only check or uncheck, cannot set CheckBox state");
                Assert.fail("CheckBox state can be only check or uncheck, cannot set CheckBox state");
            }
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }
}
