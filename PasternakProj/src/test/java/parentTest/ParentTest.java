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

public class ParentTest {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparesPage;

    @Before
    public void setUp(){
        File file = new File("/home/uniuser/chromedriver_linux64/chromedriver");
        System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
        webDriver = new ChromeDriver();
//        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        loginPage = new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparesPage = new SparesPage(webDriver);
    }

    @After
    public void tearDown(){
        webDriver.quit();
    }
    protected void checkAC(String massage, boolean actual, boolean expexted){
        if (actual != expexted){
            logger.error("AC failed: " + massage);
        } else {
            Assert.assertEquals(massage, expexted, actual);
        }
    }
}
