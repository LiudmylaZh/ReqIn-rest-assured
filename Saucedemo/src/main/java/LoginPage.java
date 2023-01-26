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

    @FindBy(css = "[data-test=\"error\"]")
    WebElement errorLockedUser;

    @FindBy (css = "[data-test=\"error\"]")
    WebElement errorMessage;

    public LoginPage (WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void login(User user){
        userName.sendKeys(user.getName());
        password.sendKeys(user.getPassword());
        loginButton.click();


    }

}
