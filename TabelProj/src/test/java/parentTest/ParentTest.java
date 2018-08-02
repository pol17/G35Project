package parentTest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.SparesPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

/**
 * ParentTest
 * Общее для всех Тестов
 */
public class ParentTest {
    WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparesPage;

    @Before  //анатация. метод/данные , junit
    public void setUp() {
        File file = new File("./src/drivers/chromedriver.exe");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();  // драйвер сделай окошко максимальтым
        webDriver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);  //implicitlyWait - неявное ожидание  / 30 - секунд
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparesPage = new SparesPage(webDriver); // добавили страницу которую можем использовать в тестах

    }

    @After  //выполняется в любом случаи, не зависит от +/- результата.
    public void tearDown() {
        webDriver.quit(); //закрывает полность брайзер, close - закрывает только вкладку

    }

    protected void checkAC(String message, boolean actual, boolean expected){  //передадим что аватарка есть
        if (actual !=expected){
            logger.error("AC fail: " + message);
        }
        Assert.assertEquals(message,expected,actual);

    }
}
