package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class DifferentElementsPage extends AbstractPage {

    @FindBy(xpath = "//input[@type = 'checkbox']")
    private List<WebElement> checkboxes;

    @FindBy(xpath = "//input[@type = 'checkbox'][1]")
    private WebElement checkboxWater;

    @FindBy(xpath = "//input[@type = 'checkbox'][3]")
    private WebElement checkboxWind;

    @FindBy(xpath = "//input[@type = 'radio']")
    private List<WebElement> radios;

    @FindBy(xpath = "//input[@type = 'radio'][3]")
    private WebElement radioSelen;

    @FindBy(tagName = "select")
    private List<WebElement> dropdownList;

    @FindBy(name = "Default Button")
    private WebElement defaultButton;

    @FindBy(xpath = "//input[@type = 'button']")
    private WebElement button;

    @FindBy(xpath = "//option[contains(text(),'Yellow')]")
    private WebElement dropDownListYellow;

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
    }

    public List<WebElement> getCheckboxes() {
        return checkboxes;
    }

    public List<WebElement> getRadios() {
        return radios;
    }

    public List<WebElement> getDropdownList() {
        return dropdownList;
    }

    public WebElement getDefaultButton() {
        return defaultButton;
    }

    public WebElement getButton() {
        return button;
    }

    public WebElement getTextOfCheckboxWater() {
        return checkboxes.get(0).findElement(By.xpath(".."));
    }

    public WebElement getTextOfCheckboxWind() {
        return checkboxes.get(2).findElement(By.xpath(".."));
    }

    public WebElement getCheckboxWater() {
        return checkboxWater;
    }

    public WebElement getCheckboxWind() {
        return checkboxWind;
    }

    public WebElement getRadioSelen() {
        return radioSelen;
    }

    public WebElement getTextOfRadioSelen() {
        return radioSelen.findElement(By.xpath(".."));
    }

    public WebElement getDropDownListYellow() {
        return dropDownListYellow;
    }
}
