package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class HomePage extends AbstractPage {

    private static final String URL = "https://epam.github.io/JDI/";

    @FindBy(id = "user-icon")
    private WebElement userIcon;

    @FindBy(id = "name")
    private WebElement usernameTextField;

    @FindBy(id = "password")
    private WebElement passwordTextField;

    @FindBy(id = "login-button")
    private WebElement loginButton;

    @FindBy(id = "user-name")
    private WebElement usernameLabel;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> images;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textUnderImages;

    @FindBy(id = "iframe")
    private WebElement iframe;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void openURL() {
        driver.get(URL);
    }
    public void login(String name, String password) {
        userIcon.click();
        usernameTextField.sendKeys(name);
        passwordTextField.sendKeys(password);
        loginButton.click();
    }
    public String getUserName() {
        return usernameLabel.getText();
    }

    public List<WebElement> getImages() {
        return images;
    }

    public List<WebElement> getTextUnderImages() {
        return textUnderImages;
    }

    public WebElement getIframe() {
        return iframe;
    }

    public void switchToIframe() {
        driver.switchTo().frame(iframe);
    }

    public void switсhToOriginalWindow() {
        driver.switchTo().window(driver.getWindowHandle());
    }

}
