package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.Arrays;
import java.util.List;

public class Ex2 extends TestBase {

    private HomePage homePage;
    private HeaderMenu headerMenu;
    private LeftSection leftSection;
    private DifferentElementsPage differentElementsPage;
    private RightSection rightSection;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
        headerMenu = new HeaderMenu(driver);
        leftSection = new LeftSection(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        rightSection = new RightSection(driver);
    }

    @Test
    public void pageObjectComponentsTestEx2() {

        SoftAssert softAssert = new SoftAssert();


        //1. Open test site by URL
        homePage.openURL();

        //2. Assert Browser title
        softAssert.assertEquals(homePage.getPageTitle(), "Home Page");
        softAssert.assertAll();

        //3. Perform login
        homePage.login("epam", "1234");

        //4. Assert User name in the left-top side of screen that user is loggined
        softAssert.assertEquals(homePage.getUserName(), "PITER CHAILOVSKII");
        softAssert.assertAll();

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        headerMenu.getServiceBtnInHeader().click();
        List<String> textOfDropdownListInHeader = Arrays.asList("Support", "Dates", "Search", "Complex Table",
                "Simple Table", "User Table", "Table with pages", "Different elements", "Performance");
        for (int i = 0; i < headerMenu.getDropdownListInHeader().size(); i++) {
            softAssert.assertEquals(headerMenu.getDropdownListInHeader().get(i).getText(),
                    textOfDropdownListInHeader.get(i).toUpperCase());
        }
        softAssert.assertAll();

        //6. Click on Service subcategory in the left section and check that drop down contains options

        leftSection.getServiceBtnInLeftSection().click();
        List<String> textOfDropdownListInLeftSection = Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance");
        for (int i = 0; i < leftSection.getDropdownListInLeftSection().size(); i++) {
            softAssert.assertEquals(leftSection.getDropdownListInLeftSection().get(i).getText(),
                    textOfDropdownListInLeftSection.get(i));
        }
        softAssert.assertAll();

        //7. Open through the header menu Service -> Different Elements Page
        headerMenu.getServiceHeaderBtn().click();
        headerMenu.getDifferentElementBtnInDropdownHeaderMenu().click();

        //8. Check interface on Different elements page, it contains all needed elements
        softAssert.assertEquals(differentElementsPage.getCheckboxes().size(), 4);
        softAssert.assertEquals(differentElementsPage.getRadios().size(), 4);
        softAssert.assertEquals(differentElementsPage.getDefaultButton().getAttribute("value"), "Default Button");
        softAssert.assertEquals(differentElementsPage.getButton().getAttribute("value"), "Button");
        softAssert.assertEquals(differentElementsPage.getDropdownList().size(), 1);
        softAssert.assertAll();

        //9. Assert that there is Right Section
        softAssert.assertTrue(rightSection.getNavigationRightSideBar().isDisplayed());
        softAssert.assertAll();

        //10. Assert that there is Left Section
        softAssert.assertTrue(leftSection.getLogSideBarInLeftSection().isDisplayed());
        softAssert.assertAll();

        //11. Select checkboxes
        softAssert.assertEquals(differentElementsPage.getTextOfCheckboxWater().getText(), "Water");
        softAssert.assertEquals(differentElementsPage.getTextOfCheckboxWind().getText(), "Wind");
        differentElementsPage.getCheckboxWater().click();
        differentElementsPage.getCheckboxWind().click();
        boolean initStateOfCheckboxWater = differentElementsPage.getCheckboxWater().isSelected();
        boolean initStateOfCheckboxWind = differentElementsPage.getCheckboxWind().isSelected();
        softAssert.assertTrue(initStateOfCheckboxWater);
        softAssert.assertTrue(initStateOfCheckboxWind);
        softAssert.assertAll();

        //12. Assert that for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox.
        WebElement logRowWater = driver.findElement(By.xpath("//li[contains(text(),'Water')]"));
        WebElement logRowWind = driver.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        softAssert.assertTrue(rightSection.getLogRowWater().getText().contains("Water: condition changed to true"));
        softAssert.assertTrue(rightSection.getLogRowWind().getText().contains("Wind: condition changed to true"));
        softAssert.assertAll();


        //13. Select radio
        softAssert.assertEquals(differentElementsPage.getTextOfRadioSelen().getText(), "Selen");
        differentElementsPage.getRadioSelen().click();
        softAssert.assertTrue(differentElementsPage.getRadioSelen().isEnabled());
        softAssert.assertAll();

        //14.Assert that for radiobutton there is a log row and value is corresponded
        // to the status of radiobutton.
        softAssert.assertTrue(rightSection.getRadioLog().getText().contains("Selen"));
        softAssert.assertAll();

        //15. Select in dropdown
        differentElementsPage.getDropDownListYellow().click();
        softAssert.assertTrue(differentElementsPage.getDropDownListYellow().isSelected());
        softAssert.assertTrue(differentElementsPage.getDropDownListYellow().isDisplayed());
        softAssert.assertAll();

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        WebElement colorsLogRow = driver.findElement(By.xpath("//li[contains(text(),'Colors')]"));
        softAssert.assertTrue(rightSection.getColorsLogRow().getText().
                contains(differentElementsPage.getDropDownListYellow().getText()));
        softAssert.assertAll();

        //17. Unselect and assert checkboxes
        differentElementsPage.getCheckboxWater().click();
        differentElementsPage.getCheckboxWind().click();
        softAssert.assertFalse(differentElementsPage.getCheckboxWater().isSelected());
        softAssert.assertFalse(differentElementsPage.getCheckboxWind().isSelected());
        softAssert.assertAll();

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        WebElement logRowWaterFinalText = driver.findElement(By.xpath("//li[contains(text(),'Water')][1]"));
        WebElement logRowWindFinalText = driver.findElement(By.xpath("//li[contains(text(),'Wind')][1]"));

        softAssert.assertTrue(differentElementsPage.getCheckboxWind().isSelected()
                != initStateOfCheckboxWind);
        softAssert.assertTrue(rightSection.getLogRowWindFinalText().getText().
                contains(String.valueOf(!initStateOfCheckboxWind)));
        softAssert.assertTrue(differentElementsPage.getCheckboxWater().isSelected() !=
                initStateOfCheckboxWater);
        softAssert.assertTrue(rightSection.getLogRowWaterFinalText().getText().
                contains(String.valueOf(!initStateOfCheckboxWater)));
        softAssert.assertAll();

        //19. Close Browser
        homePage.closeBrowser();
    }

}
