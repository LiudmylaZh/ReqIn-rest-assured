import io.qameta.allure.Attachment;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class TestBaseNew {

    /*@Rule
    public TestWatcher screenshotOnFailure = new TestWatcher() {
        @Override
        protected void failed(Throwable e, Description description) {
            makeScreenshotOnFailure();
        }

        @Attachment("Screenshot on failure")
        public byte[] makeScreenshotOnFailure() {
            return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
        }
    };*/
    WebDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://www.saucedemo.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }


    @After
    public void tearDown() {

        //if (driver != null)
        driver.quit();
    }

    String userName = "standard_user";
    String password = "secret_sauce";
    String lockedOutUserName = "locked_out_user";
    String lockedOutPassword = "secret_sauce";
    String nameInvalid = "locked_out_user";
    String passwordInvalid = "secret_sauce4455";
}
