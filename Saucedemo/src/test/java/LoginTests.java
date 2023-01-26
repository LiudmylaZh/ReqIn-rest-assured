import org.junit.Test;

import static java.lang.Thread.sleep;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LoginTests extends TestBase{
    @Test
    public void logingWithValidData(){
        User user = new User(userName, password);
        LoginPage loginPage = new LoginPage(driver);
        InventoryPage inventoryPage = new InventoryPage(driver);
        loginPage.login(user);
        assertTrue(inventoryPage.inventoryList.isDisplayed());
    }
@Test
    public void loginOutUser() throws InterruptedException {
        User lockedOutUser = new User(lockedOutUserName, lockedOutPassword);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(lockedOutUser);
        assertTrue(loginPage.errorMessage.isDisplayed());
}

}
