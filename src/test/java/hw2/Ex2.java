package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import java.util.Arrays;
import java.util.List;

public class Ex2 extends FirstAndFinalCommonSteps {

    @Test
    public void SeleniumTestEx2() {
        SoftAssert softAssert = new SoftAssert();

        //2. Assert Browser title
        softAssert.assertEquals(driver.getTitle(), "Home Page");
        softAssert.assertAll();

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        //4. Assert User name in the left-top side of screen that user is loggined
        WebElement loginedUserName = new WebDriverWait(driver,15)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        softAssert.assertEquals(loginedUserName.getText(), "PITER CHAILOVSKII");
        softAssert.assertAll();

        //5. Click on "Service" subcategory in the header and check that drop down contains options
        driver.findElement(By.cssSelector("li.dropdown")).click();
        List<String> textOfDropdownListInHeader = Arrays.asList("Support", "Dates", "Search", "Complex Table",
                "Simple Table", "User Table", "Table with pages", "Different elements", "Performance");
        List<WebElement> dropdownListInHeader = driver.findElements(By.cssSelector("nav ul.dropdown-menu li"));
        for (int i = 0; i < dropdownListInHeader.size(); i++) {
            softAssert.assertEquals(dropdownListInHeader.get(i).getText(), textOfDropdownListInHeader.get(i).toUpperCase());
        }
        softAssert.assertAll();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        driver.findElement(By.cssSelector("li.menu-title")).click();
        List<String> textOfDropdownListInLeftSection = Arrays.asList("Support", "Dates", "Complex Table",
                "Simple Table", "Search", "User Table", "Table with pages", "Different elements", "Performance");
        List<WebElement> dropdownListInLeftSection = driver.findElements(By.cssSelector(".menu-title[index='3'] .sub span"));
        for (int i = 0; i < dropdownListInLeftSection.size(); i++) {
            softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(), textOfDropdownListInLeftSection.get(i));
        }
        softAssert.assertAll();

        //7. Open through the header menu Service -> Different Elements Page
        driver.findElement(By.linkText("SERVICE")).click();
        driver.findElement(By.linkText("DIFFERENT ELEMENTS")).click();

        //8. Check interface on Different elements page, it contains all needed elements
        List<WebElement> checkboxes = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        List<WebElement> radios = driver.findElements(By.xpath("//input[@type = 'radio']"));
        List<WebElement> dropdownList = driver.findElements(By.tagName("select"));
        WebElement defaultButton = driver.findElement(By.name("Default Button"));
        WebElement button = driver.findElement(By.xpath("//input[@type = 'button']"));
        softAssert.assertEquals(checkboxes.size(), 4);
        softAssert.assertEquals(radios.size(), 4);
        softAssert.assertEquals(defaultButton.getAttribute("value"), "Default Button");
        softAssert.assertEquals(button.getAttribute("value"), "Button");
        softAssert.assertEquals(dropdownList.size(), 1);
        softAssert.assertAll();

        //9. Assert that there is Right Section
        softAssert.assertTrue(driver.findElement(By.name("navigation-sidebar")).isDisplayed());
        softAssert.assertAll();

        //10. Assert that there is Left Section
        softAssert.assertTrue(driver.findElement(By.name("log-sidebar")).isDisplayed());
        softAssert.assertAll();

        //11. Select checkboxes
        WebElement checkboxWater = checkboxes.get(0);
        WebElement checkboxWind = checkboxes.get(2);
        WebElement parentElementOfCheckboxWater = checkboxWater.findElement(By.xpath(".."));
        WebElement parentElementOfCheckboxWind = checkboxWind.findElement(By.xpath(".."));
        softAssert.assertEquals(parentElementOfCheckboxWater.getText(), "Water");
        softAssert.assertEquals(parentElementOfCheckboxWind.getText(), "Wind");
        checkboxWater.click();
        checkboxWind.click();
        boolean selectedCheckboxWater = checkboxWater.isSelected();
        boolean selectedCheckboxWind = checkboxWind.isSelected();
        softAssert.assertTrue(selectedCheckboxWater);
        softAssert.assertTrue(selectedCheckboxWind);
        softAssert.assertAll();

        //12. Assert that for each checkbox there is an individual log row and value is corresponded
        // to the status of checkbox.
        WebElement logRowWater = driver.findElement(By.xpath("//li[contains(text(),'Water')]"));
        WebElement logRowWind = driver.findElement(By.xpath("//li[contains(text(),'Wind')]"));
        softAssert.assertTrue(logRowWater.getText().contains("Water: condition changed to true"));
        softAssert.assertTrue(logRowWind.getText().contains("Wind: condition changed to true"));
        softAssert.assertAll();


        //13. Select radio
        WebElement radioSelen = radios.get(3);
        WebElement parentElementOfRadioSelen = radioSelen.findElement(By.xpath(".."));
        softAssert.assertEquals(parentElementOfRadioSelen.getText(), "Selen");
        radioSelen.click();
        softAssert.assertTrue(radioSelen.isEnabled());
        softAssert.assertAll();

        //14.Assert that for radiobutton there is a log row and value is corresponded
        // to the status of radiobutton.
        WebElement radioLog = driver.findElement(By.xpath("//li[contains(text(),'metal')]"));
        softAssert.assertTrue(radioLog.getText().contains("Selen"));
        softAssert.assertAll();

        //15. Select in dropdown
        WebElement dropDownListYellow = driver.findElement(By.xpath("//option[contains(text(),'Yellow')]"));
        dropDownListYellow.click();
        softAssert.assertTrue(dropDownListYellow.isSelected());
        softAssert.assertTrue(dropDownListYellow.isDisplayed());
        softAssert.assertAll();

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        WebElement colorsLogRow = driver.findElement(By.xpath("//li[contains(text(),'Colors')]"));
        softAssert.assertTrue(colorsLogRow.getText().contains(dropDownListYellow.getText()));
        softAssert.assertAll();

        //17. Unselect and assert checkboxes
        checkboxWater.click();
        checkboxWind.click();
        softAssert.assertFalse(checkboxWater.isSelected());
        softAssert.assertFalse(checkboxWind.isSelected());
        softAssert.assertAll();

        //18. Assert that for each checkbox there is an individual log row and value is corresponded to the status of checkbox.
        WebElement logRowWaterFinalText = driver.findElement(By.xpath("//li[contains(text(),'Water')][1]"));
        WebElement logRowWindFinalText = driver.findElement(By.xpath("//li[contains(text(),'Wind')][1]"));

        softAssert.assertTrue(checkboxWind.isSelected()!= selectedCheckboxWind);
        softAssert.assertTrue(logRowWindFinalText.getText().contains(String.valueOf(!selectedCheckboxWind)));
        softAssert.assertTrue(checkboxWater.isSelected() != selectedCheckboxWater);
        softAssert.assertTrue(logRowWaterFinalText.getText().contains(String.valueOf(!selectedCheckboxWater)));
        softAssert.assertAll();
    }

}
