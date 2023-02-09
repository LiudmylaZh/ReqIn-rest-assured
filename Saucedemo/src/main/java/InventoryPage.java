import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static org.junit.Assert.*;

public class InventoryPage extends BasePage {


    @FindBy(css = "[class=\"inventory_list\"]")
    private WebElement inventoryList;

    @FindBy (css = "[class=\"inventory_item\"]")
    private List<WebElement> productsCards;

    @FindBy (css = "[class=\"inventory_item_name\"]")
    private List<WebElement> productsName;

    @FindBy (xpath = "//a[@href='https://twitter.com/saucelabs']")
    private WebElement twitterIconLink;

    @FindBy (id = "react-burger-menu-btn")
    private WebElement sideBarOpenIcon;

    @FindBy (id = "inventory_sidebar_link")
    private WebElement allItems;

    @FindBy (id = "about_sidebar_link")
    private WebElement about;

    @FindBy (id = "logout_sidebar_link")
    private WebElement logout;

    @FindBy (id = "reset_sidebar_link")
    private WebElement reset;



    public InventoryPage(WebDriver driver) {
        super(driver);
    }
    public void inventoryListShouldBeDisplyed(){
        assertTrue(inventoryList.isDisplayed());
    }

    public void checkOfProductsAreDisplayed (){
        for (WebElement product:
             productsCards) {
            assertTrue(product.isDisplayed());

        }
    }

    public void checkAmountOfProducts(int expectedAmount){
        assertEquals("Amount of products is not " +expectedAmount, productsCards.size(), expectedAmount);
    }

    public void checkProductsNameIsDisplayed () {
        for (WebElement title:
             productsName) {
            assertTrue(title.isDisplayed());
        }

    }

    public void checkProductsNameIsNoEmpty (){
        for (WebElement title:
                productsName) {
            assertFalse(title.getText().isEmpty());
        }

    }
    public void checkTwitterIconLink (){
        assertTrue(twitterIconLink.isDisplayed());

    }
    public void clickOnTheSideBarOpenIcon () {
        sideBarOpenIcon.click();
    }

    public void allItemsIsDisplayed() {
        assertTrue(allItems.isDisplayed());
    }
    public void aboutIsDisplayed() {
        assertTrue(about.isDisplayed());
    }

    public void logoutIsDisplayed(){
        assertTrue(logout.isDisplayed());
    }
    public void resetIsDisplayed() {
        assertTrue(reset.isDisplayed());
    }





}
