import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    protected WebDriver driver;

    @FindBy(id = "user-name")
    static
    WebElement userName;

    @FindBy(id = "password")
    static
    WebElement password;

    @FindBy(id = "login-button")
    static
    WebElement loginButton;

    public LoginPage (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public static void login(String userNameParams, String passwordParams) {
        userName.sendKeys(userNameParams);
        password.sendKeys(passwordParams);
        loginButton.click();


    }
}
