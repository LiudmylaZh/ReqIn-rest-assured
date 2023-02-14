import io.qameta.allure.Attachment;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static java.lang.Thread.sleep;
import static org.junit.Assert.*;

public class LoginPageTests extends TestBaseNew {


    @Test
    public void loginWithValidData(){
        User user = new User(userName, password);
        new LoginPage(driver).login(user).inventoryListShouldBeDisplyed();

    }

@Test
    public void loginLockedOutUser()  {
        User lockedOutUser = new User(lockedOutUserName, lockedOutPassword);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(lockedOutUser);
        loginPage.login(lockedOutUser);
        assertTrue(loginPage.loginButton.isDisplayed());
        assertTrue(loginPage.errorMessege.getText().contains("Epic sadface: Sorry, this user has been locked out."));

}
    @Test
    public void loginInvalid(){
        User invalidUser = new User(nameInvalid, passwordInvalid);
        LoginPage loginPage = new LoginPage(driver);
        loginPage.login(invalidUser);
        loginPage.loginButtonShouldBeDisplay();
        loginPage.errorMessegeShouldBeDisplay();


}

@Test
    public void allLoginPageElenetsAreDisplayed () {
    LoginPage loginPage = new LoginPage(driver);
    loginPage.logoShouldBeDisplay();
    assertTrue(loginPage.pictureOnLoginPageShoudBeDisplyed());
    loginPage.pictureOnLoginPageShoudBeDisplyed();
    loginPage.userNameFieldShoudBeDisplyed();
    loginPage.passwordFieldShpuldBeDisplayed();
    loginPage.loginButtonShouldBeDisplyed();
    loginPage.acceptedUserNamesShouldBeDisplayed();
    loginPage.passwordForAllUsersShpuldBeDispyed();

}


}
