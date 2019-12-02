package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RightSection {

    private WebDriver driver;

    @FindBy(name = "navigation-sidebar")
    private WebElement navigationRightSideBar;

    @FindBy(xpath = "//li[contains(text(),'Water')]")
    private WebElement logRowWater;

    @FindBy(xpath = "//li[contains(text(),'Wind')]")
    private WebElement logRowWind;

    @FindBy(xpath = "//li[contains(text(),'metal')]")
    private WebElement radioLog;

    @FindBy(xpath = "//li[contains(text(),'Colors')]")
    private WebElement colorsLogRow;

    @FindBy(xpath = "//li[contains(text(),'Water')][1]")
    private WebElement logRowWaterFinalText;

    @FindBy(xpath = "//li[contains(text(),'Wind')][1]")
    private WebElement logRowWindFinalText;

    public RightSection(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getNavigationRightSideBar() {
        return navigationRightSideBar;
    }

    public WebElement getLogRowWater() {
        return logRowWater;
    }

    public WebElement getLogRowWind() {
        return logRowWind;
    }

    public WebElement getRadioLog() {
        return radioLog;
    }

    public WebElement getColorsLogRow() {
        return colorsLogRow;
    }

    public WebElement getLogRowWaterFinalText() {
        return logRowWaterFinalText;
    }

    public WebElement getLogRowWindFinalText() {
        return logRowWindFinalText;
    }
}
