package parentTest;

import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import libs.ConfigProperties;
import org.aeonbits.owner.ConfigFactory;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import pages.EditSparePage;
import pages.HomePage;
import pages.LoginPage;
import pages.SparesPage;

import java.io.File;
import java.util.concurrent.TimeUnit;

public class ParentTest {

    Logger logger = Logger.getLogger(getClass());

    WebDriver webDriver ;
   protected LoginPage loginPage;
   protected HomePage homePage;
   protected SparesPage sparesPage;
   protected EditSparePage editSparePage;
   String browser = System.getProperty("browser");
   protected static ConfigProperties configProperties = ConfigFactory.create(ConfigProperties.class);



    @Before
    public void setUp(){
        initDriver(browser);
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);


        loginPage= new LoginPage(webDriver);
        homePage = new HomePage(webDriver);
        sparesPage = new SparesPage(webDriver);
        editSparePage = new EditSparePage(webDriver);



    }

    private void initDriver(String browserName) {
        if (browserName == null  || browserName.equals("chrome")) {
            logger.info("Chrome will started");
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info("Chrome is started");
        } else if ("firefox".equals(browserName)) {
            logger.info("FireFox will started");
            File fileFF = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0); // Empty start page
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
            webDriver = new FirefoxDriver();

            logger.info("FireFox is started");
        }
        else if ("ie".equals(browser)){
            logger.info("IE will be started");
            File file1 = new File("./src/drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
            capabilities.setCapability("ignoreZoomSetting", true);
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
            webDriver = new InternetExplorerDriver();
            logger.info(" IE is started");
        }
        else {
            logger.error("Can't init driver");
            Assert.fail("Can't init driver");
        }

    }

    @After
    public void termDown(){
 //       webDriver.quit();

    }

    @Step
    protected void checkAC (String message, boolean actual, boolean expected){
        if (actual!= expected) {
            logger.error("AC failed: " + message);
            Assert.assertEquals(message, expected, actual);

        }
    }


    @Rule
    public TestWatcher watchman = new TestWatcher() {
        String fileName;

        @Override
        protected void failed(Throwable e, Description description) {
            screenshot();
        }

        @Attachment(value = "Page screenshot", type = "image/png")
        public byte[] saveScreenshot(byte[] screenShot) {
            return screenShot;
        }

        public void screenshot() {
            if (webDriver == null) {
                logger.info("Driver for screenshot not found");
                return;
            }

            saveScreenshot(((TakesScreenshot) webDriver).getScreenshotAs(OutputType.BYTES));

        }
        @Override
        protected void finished(Description description) {
            logger.info(String.format("Finished test: %s::%s", description.getClassName(), description.getMethodName()));
            try {
                webDriver.quit();
            } catch (Exception e) {
                logger.error(e);
            }
        }
    };






}
