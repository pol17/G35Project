package pages;

import libs.ActionsWithElements;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "http://v3.test.itpmgroup.com";
    ActionsWithElements actionsWithElements;


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);
        actionsWithElements = new ActionsWithElements(webDriver);

    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();

    }

    public void checkCurrentPageUrl() {
        try {
            Assert.assertEquals("Url is not expected", expectedUrl, getCurrentUrl());

        }catch (Exception e){
            logger.error("Cannot work with Url");
            Assert.fail("Cannot work with Url");
        }
    }



}
