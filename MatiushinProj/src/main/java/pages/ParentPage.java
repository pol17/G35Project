package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "http://v3.test.itpmgroup.com";


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = baseUrl + expectedUrl;

    }

    public String getCurrentUrl() {
        return webDriver.getCurrentUrl();

    }

    public void checkCurrentPageUrl() {
        try {
            Assert.assertEquals("Url is not expected", expectedUrl, getCurrentUrl());

        }catch (Exception e){
            logger.error("Cennot work with Url");
            Assert.fail("Cennot work with Url");
        }
    }

}
