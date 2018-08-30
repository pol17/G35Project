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

public class ActionWithOurElement {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriverWait webDriverWait20;   // ожидание  20cек
    WebDriverWait webDriverWait40;


    public ActionWithOurElement(WebDriver webDriver) {
        this.webDriver = webDriver;
        webDriverWait20 = new WebDriverWait(webDriver, 20);  //в каком драйвере будет работать и сколько ждать 20 сек
        webDriverWait40 = new WebDriverWait(webDriver, 40);
    }

    public void enterTextToElement(WebElement webElement, String text) {
        try {
            webDriverWait40.until(ExpectedConditions.visibilityOf(webElement));  //  ждать загрузки импута
            webElement.clear();
            webElement.sendKeys(text);
            logger.info(text + " was inputted into element");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }

    public void clickOnElement(WebElement webElement) {
        try {
            webDriverWait20.until(ExpectedConditions.elementToBeClickable(webElement));  //метод until-( подожди пока)/ExpectedConditions - проверка состояние єл

//            webDriverWait20.until(ExpectedConditions.not
//                    (ExpectedConditions.elementToBeClickable(webElement)))//метод который инвертирует состояние (!=)  // кнопка станет не активной

            webElement.click();
            logger.info("Element was clicked ");
        } catch (Exception e) {
            printErrorAndStopTest(e);
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

    public boolean isElementDisplay(WebElement webElement) {
        try {
            boolean state = webElement.isDisplayed();
            logger.info("Element is display - > " + state);
            return state;
        } catch (Exception e) {
            logger.info("Element is display - >  false");
            return false;
        }
    }

    public void setNeededStateToCheckBox(WebElement webElement, String neededState){
        if("check".equals(neededState) || "unceck".equals(neededState)){
            if(webElement.isSelected()&& "check".equals(neededState)){
                logger.info("CheckBox is already checked");

            }else if (webElement.isSelected()&&"unceck".equals(neededState)){
                clickOnElement(webElement);
                logger.info("CheckBox was unchecked");
            }
        }else{
            logger.error(String.format("%s - is not expected  state" , neededState));
            Assert.fail(String.format("%s - is not expected  state" , neededState));
        }
    }


    private void printErrorAndStopTest(Exception e) {
        logger.error("Connot work with element " + e);
        Assert.fail("Connot work with element " + e);
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

    public void selectValueInDD(WebElement dropDownElement, String value) {
        try {
            Select select = new Select(dropDownElement);
            select.selectByValue(value);  //он сразу выберит нужный элемент
            logger.info(value + " was select in DD");
        } catch (Exception e) {
            printErrorAndStopTest(e);
        }
    }




}
