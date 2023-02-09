import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Double.parseDouble;
import static java.lang.Math.log;
import static java.lang.Math.sin;
import static java.lang.Thread.sleep;

public class RobotCorrect {
    static ChromeDriver driver;

    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://suninjuly.github.io/math.html";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    public double funcCalc (double x){
        return log(Math.abs(12*sin(x)));

    }

    @Test
    public void calculationTest() throws InterruptedException {
        WebElement x = driver.findElement(By.id("input_value"));
        double result= funcCalc(parseDouble(x.getText()));
        WebElement answerInputField = driver.findElement(By.id("answer"));
        answerInputField.sendKeys(String.valueOf(result));
        sleep (10000);
    }




   /* @After
    public void tearDown() {
        driver.quit();
    }*/
}
