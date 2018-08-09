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
    String baseUrl;
    ActionsWithOurElements actionsWithOurElements;


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        baseUrl = configProperties.base_url();
        this.expectedUrl = baseUrl + expectedUrl; // ожидаемый урл напр. /login
        PageFactory.initElements(webDriver,this);
        actionsWithOurElements = new ActionsWithOurElements(webDriver);
    }

    //метод, который возвращает урл нашей страницы
    public String getCurrentUrl () {
        return webDriver.getCurrentUrl();
    }

    //метод, который сравнивает известный нам урл с фактическим
    public void checkCurrentUrl () {
        try {
            Assert.assertEquals("Url is not expected", expectedUrl, getCurrentUrl());
        } catch (Exception e) {
            logger.error("Cannot work with Url"); //выведется, если в try будет exception
            Assert.fail("Cannot work with Url");
        }
    }
}
