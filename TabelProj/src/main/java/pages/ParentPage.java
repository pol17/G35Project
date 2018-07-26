package pages;

import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;

public class ParentPage {
    private final WebDriver wedDriver;
    Logger logger = Logger.getLogger(getClass());
    WebDriver webDriver;
    String expectedUrl;
    final String baseUrl = "http://v3.test.itpmgroup.com";

    public ParentPage(WebDriver webDriver, String expectedUrl) {
        this.wedDriver = webDriver;
        this.expectedUrl = baseUrl + expectedUrl;
    }

    public String getCurrentUrl() {   // метод который возвращает Url страницы
        return webDriver.getCurrentUrl();
    }

    public void cheekCurrentUrl() {  //метод который будет сравнивать известный Url с  тем что нужен
        try {
            Assert.assertEquals("Url is not expect ", expectedUrl, getCurrentUrl() );  //сравнене Url-ов, тот ли открылся

        }catch (Exception e){
            logger.error("Cannot work with Url ");
            Assert.fail("Cannot work with Url ");   //закрытие страницы
        }
    }
}
