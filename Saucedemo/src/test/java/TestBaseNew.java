import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class TestBaseNew {

    @Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
            driver.close();
            driver.quit();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
        @Override
        protected void succeeded(Description description) {
            driver.close();
            driver.quit();
        }
    };


    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        //options.addArguments("--start-maximized");
        //options.addArguments("--window-size=100,200"); //-задает размер экрана
        //options.addArguments("--headless"); //- тесты в фоновом режиме без открытия браузера
        driver = new ChromeDriver(options);
        String BASE_URL = "https://www.saucedemo.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        //driver.manage().window().maximize();
    }

            public void tearDown (){
        driver.quit();
    }

    String userName = "standard_user";
    String password = "secret_sauce";
    String lockedOutUserName = "locked_out_user";
    String lockedOutPassword = "secret_sauce";
    String nameInvalid = "locked_out_user";
    String passwordInvalid = "secret_sauce4455";
}
