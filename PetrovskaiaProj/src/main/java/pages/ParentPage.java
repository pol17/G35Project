package pages;

import libs.ActionsWithOurElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "http://v3.test.itpmgroup.com";
    ActionsWithOurElements actionsWithOurElements;


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();
    }

    public void checkCurrentUrl() {
        try {
            Assert.assertEquals("Url is not expected", expectedUrl, getCurrentUrl());
        } catch (Exception e) {
            logger.error("Can't work with Url");
            Assert.fail("Can't work with Url");
        }
    }

    public void CheckBox() {
        WebElement checkBox1;
        WebElement checkBox2;
        checkBox1 = webDriver.findElement(By.xpath(".//somexpath"));
        if (!checkBox1.isSelected()) {
            checkBox1.click();
        }
        checkBox2 = webDriver.findElement(By.xpath("somexpath"));
        if (checkBox2.isSelected()) {
            checkBox2.click();
        }
    }
}
