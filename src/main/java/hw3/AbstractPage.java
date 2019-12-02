package hw3;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected WebDriver driver;

    protected HeaderMenu headerMenu;

    protected LeftSection leftSection;

    protected Footer footer;

    @FindBy(id="epam_logo")
    protected WebElement logo;

    protected AbstractPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        headerMenu = new HeaderMenu(driver);
        leftSection = new LeftSection(driver);
        footer = new Footer(driver);
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public HeaderMenu getHeaderMenu() {
        return headerMenu;
    }

    public WebElement getLogo() {
        return logo;
    }

    public LeftSection getLeftSection() {
        return leftSection;
    }

    public Footer getFooter() {
        return footer;
    }

    public void closeBrowser() {
        driver.close();
    }

}
