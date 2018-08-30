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

/**
 * ParentTest
 * Общее для всех Тестов
 */
public class ParentTest {
    protected WebDriver webDriver;
    Logger logger = Logger.getLogger(getClass());
    protected LoginPage loginPage;
    protected HomePage homePage;
    protected SparesPage sparesPage;  //объявили
    protected EditSparePage editSparePage;
    String browser = System.getProperty("browser");
    protected  static ConfigProperties configProperties
            = ConfigFactory.create(ConfigProperties.class);


    @Before  //анатация. метод/данные , junit
    public void setUp() {
        initDriver(browser);
        webDriver.manage().window().maximize();  // драйвер сделай окошко максимальтым
        webDriver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);  //implicitlyWait - неявное ожидание  / 30 - секунд
        loginPage = new LoginPage(webDriver);   // Инициализация
        homePage = new HomePage(webDriver);
        sparesPage = new SparesPage(webDriver); // добавили страницу которую можем использовать в тестах
        editSparePage = new EditSparePage(webDriver);

    }

    private void initDriver(String browserName) {
        if (browserName == null || browserName.equals("chrome")) { //сравнивание стринги - equals
            logger.info("chrome will be started");
            File file = new File("./src/drivers/chromedriver.exe");
            System.setProperty("webdriver.chrome.driver", file.getAbsolutePath());
            webDriver = new ChromeDriver();
            logger.info("Chrome is started");
        } else if ("fareFox".equals(browserName)) {
            logger.info("FireFox will be started");

            File fileFF = new File("./src/drivers/geckodriver.exe");
            System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
            /*
             *Настройка браузера
             */
            FirefoxOptions profile = new FirefoxOptions();
            profile.addPreference("browser.startup.page", 0); // Empty start page / что бы открылась 1 пустая страница
            profile.addPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page// закрыть страницу с рекламой
            webDriver = new FirefoxDriver();
            logger.info("FireFox is started");
        } else if ("ie".equals(browser)) {
            logger.info("IE will be started");
            File file1 = new File("./src/drivers/IEDriverServer.exe");
            System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
            DesiredCapabilities capabilities = DesiredCapabilities.internetExplorer();
            capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true); //незашещённый домен (тестовый сервер)
            capabilities.setCapability("ignoreZoomSetting", true);  // маштаб 100%
            capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);  //игнор сертификаты
            webDriver = new InternetExplorerDriver();
            logger.info(" IE is started");

        } else {
            logger.error("Can't init Driver");
            Assert.fail("Can't init Driver");
        }
    }

    @After  //выполняется в любом случаи, не зависит от +/- результата.
    public void tearDown() {
        webDriver.quit(); //закрывает полность брайзер, close - закрывает только вкладку

    }
    @Step
    protected void checkAC(String message, boolean actual, boolean expected) {  //передадим что аватарка есть
        if (actual != expected) {
            logger.error("AC fail: " + message);
        }
        Assert.assertEquals(message, expected, actual);

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
