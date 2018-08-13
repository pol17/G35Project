package pages;

import libs.ActionsWithOurElements;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);
//    final String baseUrl = "http://v3.test.itpmgroup.com";
    String baseUrl;
    ActionsWithOurElements actionsWithOurElements;


    public ParentPage(WebDriver webdriver, String expectedUrl) {
        this.webDriver = webdriver;
        baseUrl = configProperties.base_url();
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver,this); //initialize of all elements in findby
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    //return actual url of opened page
    public  String getCurrentUrl(){
        return webDriver.getCurrentUrl();
    }

    public void checkCurrentUrl(){
        try {
            Assert.assertEquals("Url is not expected", expectedUrl, getCurrentUrl());
        } catch (Exception e){
            logger.error("Cannot work with Url");
            Assert.fail("Cannot work with Url");
        }

    }
}
