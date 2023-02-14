import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public abstract class BasePage {
    WebDriver driver;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterTextToElement(String text, WebElement element) {
        element.click();
        element.clear();
        element.sendKeys(text);

    }
    public boolean allElementsOfCollectionAreDisplay(List<WebElement> collection) {
        for ( WebElement element: collection) {
        if (!element.isDisplayed()) {
            return false;
        }
        }
        return true;
        }
    }

