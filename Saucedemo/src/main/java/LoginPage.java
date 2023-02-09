import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import static org.junit.Assert.assertTrue;

public class LoginPage extends BasePage {

    @FindBy(id = "user-name")
    private
    WebElement userName;

    @FindBy(id = "password")
    private
    WebElement password;


    @FindBy(id = "login-button")
    WebElement loginButton;

    @FindBy(css = "[data-test=\"error\"]")
    private
    WebElement errorLockedUser;

    @FindBy (css = "[data-test=\"error\"]")
    WebElement errorMessege;

    @FindBy (css = "[class=\"login_logo\"]")
    WebElement logoOnLoginPage;

    @FindBy (css = "[class=\"bot_column\"]")
    WebElement pictureOnLoginPage;

    @FindBy(id = "user-name")
    WebElement userNameField;

    @FindBy(id = "password")
    WebElement passwordField;

    @FindBy (id = "login_credentials")
    WebElement acceptedUserNames;

    @FindBy (css = "[class=\"login_password\"]")
    WebElement passwordForAllUsers;




    public LoginPage (WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @Step("Filing in username, password and push the Login button")
    public InventoryPage login(User user){
        enterTextToElement(user.getName(), userName);
        enterTextToElement(user.getPassword(), password);
        loginButton.click();
        return new InventoryPage(driver);


    }
    public void loginButtonShouldBeDisplay(){
        assertTrue(loginButton.isDisplayed());
    }

    public void errorMessegeShouldBeDisplay(){
        assertTrue(errorMessege.isDisplayed());
    }

    public void logoShouldBeDisplay(){
        assertTrue(logoOnLoginPage.isDisplayed());

    }
    public boolean pictureOnLoginPageShoudBeDisplyed(){
        return pictureOnLoginPageShoudBeDisplyed();
    }
    public void userNameFieldShoudBeDisplyed() {
        assertTrue(userNameField.isDisplayed());
    }
    public void passwordFieldShpuldBeDisplayed(){
        assertTrue(passwordField.isDisplayed());
    }
    public void loginButtonShouldBeDisplyed(){
        assertTrue(loginButton.isDisplayed());
    }

    public void acceptedUserNamesShouldBeDisplayed(){
        assertTrue(acceptedUserNames.isDisplayed());
    }
    public void passwordForAllUsersShpuldBeDispyed () {
        assertTrue(passwordForAllUsers.isDisplayed());
    }
}
