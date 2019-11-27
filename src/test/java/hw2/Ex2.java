package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class Ex2 extends firstAndFinalCommonSteps {

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
        List<WebElement> dropdownListInHeader = driver.findElements(By.cssSelector("nav ul.dropdown-menu li"));
        for (int i = 0; i < dropdownListInHeader.size(); i++) {
            switch (i) {
                case 0:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"SUPPORT");
                    break;
                case 1:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"DATES");
                    break;
                case 2:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"SEARCH");
                    break;
                case 3:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"COMPLEX TABLE");
                    break;
                case 4:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"SIMPLE TABLE");
                    break;
                case 5:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"USER TABLE");
                    break;
                case 6:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"TABLE WITH PAGES");
                    break;
                case 7:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"DIFFERENT ELEMENTS");
                    break;
                case 8:
                    softAssert.assertEquals(dropdownListInHeader.get(i).getText(),"PERFORMANCE");
                    break;
            }
        }
        softAssert.assertAll();

        //6. Click on Service subcategory in the left section and check that drop down contains options
        driver.findElement(By.cssSelector("li.menu-title")).click();
        List<WebElement> dropdownListInLeftSection = driver.findElements(By.cssSelector(".menu-title[index='3'] .sub span"));
        for (int i = 0; i < dropdownListInLeftSection.size(); i++) {
            switch (i) {
                case 0:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"Support");
                    break;
                case 1:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"Dates");
                    break;
                case 2:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"Complex Table");
                    break;
                case 3:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"Simple Table");
                    break;
                case 4:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"Search");
                    break;
                case 5:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"User Table");
                    break;
                case 6:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"Table with pages");
                    break;
                case 7:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"Different elements");
                    break;
                case 8:
                    softAssert.assertEquals(dropdownListInLeftSection.get(i).getText(),"Performance");
                    break;
            }
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
        WebElement ParentElementOfCheckboxWater = checkboxWater.findElement(By.xpath(".."));
        WebElement ParentElementOfCheckboxWind = checkboxWind.findElement(By.xpath(".."));
        softAssert.assertEquals(ParentElementOfCheckboxWater.getText(), "Water");
        softAssert.assertEquals(ParentElementOfCheckboxWind.getText(), "Wind");
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
        WebElement ParentElementOfRadioSelen = radioSelen.findElement(By.xpath(".."));
        softAssert.assertEquals(ParentElementOfRadioSelen.getText(), "Selen");
        radioSelen.click();
        softAssert.assertTrue(radioSelen.isEnabled());
        softAssert.assertAll();

        //14.Assert that for radiobutton there is a log row and value is corresponded
        // to the status of radiobutton.
        WebElement radioLog = driver.findElement(By.xpath("//li[contains(text(),'metal')]"));
        softAssert.assertTrue(radioLog.getText().contains("Selen"));
        softAssert.assertAll();

        //15. Select in dropdown
        WebElement DropDownListYellow = driver.findElement(By.xpath("//option[contains(text(),'Yellow')]"));
        DropDownListYellow.click();
        softAssert.assertTrue(DropDownListYellow.isSelected());
        softAssert.assertTrue(DropDownListYellow.isDisplayed());
        softAssert.assertAll();

        //16. Assert that for dropdown there is a log row and value is corresponded to the selected value.
        WebElement colorsLogRow = driver.findElement(By.xpath("//li[contains(text(),'Colors')]"));
        softAssert.assertTrue(colorsLogRow.getText().contains(DropDownListYellow.getText()));
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
