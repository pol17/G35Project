package pages;

import libs.ActionWithOurElement;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class ParentPage {
    Logger logger = Logger.getLogger(getClass());  // подставить имя класса в логгер!
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "http://v3.test.itpmgroup.com";
    ActionWithOurElement actionWithOurElement;


    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.webDriver = webDriver;
        this.expectedUrl = baseUrl + expectedUrl;
        PageFactory.initElements(webDriver, this);  // (инициализировать)вызвать вэб  элементы на той  страницы что нужна
        actionWithOurElement = new ActionWithOurElement(webDriver);
    }

    public String getCurrentUrl() {   //  //метод который возвращает адресс страницы

        return webDriver.getCurrentUrl();
    }

    public void cheekCurrentUrl() {  //метод который будет сравнивать известный Url с  тем что нужен
        try {
            Assert.assertEquals("Url is not expect ", expectedUrl, getCurrentUrl());  //сравнене Url-ов, тот ли открылся

        } catch (Exception e) {
            logger.error("Cannot work with Url ");
            Assert.fail("Cannot work with Url ");   //закрытие страницы
        }
    }
}
