
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SauceDemoTest {
    ChromeDriver driver;
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "/Users/liudmyla/Desktop/Tel-ran/QA/chromedriver");
        driver = new ChromeDriver();
        String BASE_URL = "https://www.saucedemo.com/";
        driver.get(BASE_URL);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
    }

    @Test
    public void logingWithValidData () {
        WebElement userName = driver.findElement(By.id("user-name"));
        userName.sendKeys("standard_user");


        WebElement password = driver.findElement(By.id("password"));
        password.sendKeys("secret_sauce");

        WebElement loginButton = driver.findElement(By.id("login-button"));
        loginButton.click();

        WebElement inventoryList = driver.findElement(By.className("inventory_container"));
        assertTrue("Inventory list is NOT displayed", inventoryList.isDisplayed());


        assertTrue(driver.getCurrentUrl().contains("inventory"));
        assertTrue(driver.getTitle().contains("Swag Labs"));
    }



    @After //выполнение после каждого теса//
    public void tearDown() {
        driver.quit();
    }
}
