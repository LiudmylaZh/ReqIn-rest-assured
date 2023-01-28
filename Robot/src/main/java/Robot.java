import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;


import java.time.Duration;
import java.time.Instant;

import static java.lang.Math.*;
import static org.junit.Assert.assertTrue;

public class Robot {
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


   public static void main(String[] args) {
      //WebElement x = driver.findElement(By.id("[id=input_value]"));
      //int propesedNumber = Integer.parseInt (String.valueOf(x));
       int x = 89898;
       int summa = Math.toIntExact((int) abs(12 * sin(x)));
       System.out.println(summa);


    }



    @Test
    public void approveStatusRobot(){

        WebElement InputAnswer = driver.findElement(By.cssSelector("[class='form-control']"));
        InputAnswer.sendKeys("12");

        WebElement appruveButton = driver.findElement(By.cssSelector("[for=\"robotCheckbox\"]"));
        appruveButton.click();

        WebElement submmitButton = driver.findElement(By.cssSelector("[class=\"btn btn-default\"]"));
        submmitButton.click();

        //wait().until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        String text = alert.getText();
        assertTrue(alert.getText().contains("Robots should rule!"));
        alert.accept();



    }


    @After
    public void tearDown() {
        driver.quit();
    }
}



