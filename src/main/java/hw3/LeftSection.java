package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftSection {

    private WebDriver driver;

    @FindBy(name = "navigation-sidebar")
    private WebElement sideBar;

    @FindBy(css = "li.menu-title")
    private WebElement serviceBtnInLeftSection;

    @FindBy(css = ".menu-title[index='3'] .sub span")
    private List<WebElement> dropdownListInLeftSection;

    @FindBy(name = "log-sidebar")
    private WebElement logSideBarInLeftSection;

    public LeftSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getSideBar() {
        return sideBar;
    }

    public WebElement getServiceBtnInLeftSection() {
        return serviceBtnInLeftSection;
    }

    public List<WebElement> getDropdownListInLeftSection() {
        return dropdownListInLeftSection;
    }

    public WebElement getLogSideBarInLeftSection() {
        return logSideBarInLeftSection;
    }
}
