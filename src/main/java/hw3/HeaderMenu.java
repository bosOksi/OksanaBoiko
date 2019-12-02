package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class HeaderMenu {

    private WebDriver driver;

    @FindBy(linkText = "Home")
    private WebElement homeButton;

    @FindBy(linkText = "Contact form")
    private WebElement contactFormButton;

    @FindBy(linkText = "Service")
    private WebElement serviceButton;

    @FindBy(linkText = "Metals & Colors")
    private WebElement metalsAndColorsButton;

    @FindBy(name = "main-title")
    private WebElement mainHeaderText;

    @FindBy(linkText = "JDI GITHUB")
    WebElement subHeaderText;

    @FindBy(name = "jdi-text")
    private WebElement lowerMainHeaderText;

    private final String ATTRIBUTEOFSUBHEADERTEXT = "href";

    @FindBy(css = "li.dropdown")
    private WebElement serviceBtnInHeader;

    @FindBy(css = "nav ul.dropdown-menu li")
    private List<WebElement> dropdownListInHeader;

    @FindBy(linkText = "SERVICE")
    private WebElement serviceHeaderBtn;

    @FindBy(linkText = "DIFFERENT ELEMENTS")
    private WebElement differentElementBtnInDropdownHeaderMenu;

    private List<WebElement> listOfMenuButton = Arrays.asList(homeButton, contactFormButton, serviceButton, metalsAndColorsButton);

    public HeaderMenu(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public WebElement getHomeButton() {
        return homeButton;
    }

    public WebElement getContactFormButton() {
        return contactFormButton;
    }

    public WebElement getServiceButton() {
        return serviceButton;
    }

    public WebElement getMetalsAndColorsButton() {
        return metalsAndColorsButton;
    }

    public List<WebElement> getListOfMenuButton() {
        return listOfMenuButton;
    }

    public List<String> getHeaderMenuTextOfButtons() {
        List<String> headerMenuTextOfItems = new ArrayList<>();
        for (WebElement menuHeaderItem : listOfMenuButton) {
            headerMenuTextOfItems.add(menuHeaderItem.getText());
        }
        return headerMenuTextOfItems;
    }

    public WebElement getMainHeaderText() {
        return mainHeaderText;
    }

    public WebElement getLowerMainHeaderText() {
        return lowerMainHeaderText;
    }

    public WebElement getSubHeaderText() {
        return subHeaderText;
    }

    public String getAttributeOfSubHeaderText() {
        return ATTRIBUTEOFSUBHEADERTEXT;
    }

    public WebElement getServiceBtnInHeader() {
        return serviceBtnInHeader;
    }

    public List<WebElement> getDropdownListInHeader() {
        return dropdownListInHeader;
    }

    public WebElement getDifferentElementBtnInDropdownHeaderMenu() {
        return differentElementBtnInDropdownHeaderMenu;
    }

    public WebElement getServiceHeaderBtn() {
        return serviceHeaderBtn;
    }
}
