package hw3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.Arrays;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex1 extends TestBase{

    private HomePage homePage;

    @BeforeMethod
    @Override
    public void setUp() {
        super.setUp();
        homePage = new HomePage(driver);
    }


    @Test
    public void pageObjectTestEx1() {

        //1. Open test site by URL
        homePage.openURL();

        //2. Assert Browser title
        assertEquals(homePage.getPageTitle(), "Home Page");

        //3. Perform login
        homePage.login("epam", "1234");

        //4. Assert User name in the left-top side of screen that user is loggined
        assertEquals(homePage.getUserName(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        assertEquals(homePage.getPageTitle(), "Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        for (WebElement menuItem : homePage.getHeaderMenu().getListOfMenuButton()) {
            assertTrue(menuItem.isDisplayed());
        }
        List<String> listOfProperTextInHeader = Arrays.asList("Home", "Contact form", "Service", "Metals & Colors");
        for (String linkTextOfHeaderButton : listOfProperTextInHeader) {
            assertEquals(homePage.getHeaderMenu().getHeaderMenuTextOfButtons(),linkTextOfHeaderButton);
        }

        //7. Assert that there are 4 images on the Index Page and they are displayed
        for (WebElement element : homePage.getImages()) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(homePage.getImages().size(), 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        for (WebElement element : homePage.getTextUnderImages()) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(homePage.getTextUnderImages().size(), 4);

        //9. Assert a text of the main headers
        WebElement upperMainHeaderText = driver.findElement(By.name("main-title"));
        assertTrue(homePage.getHeaderMenu().getMainHeaderText().isDisplayed());
        assertEquals(upperMainHeaderText.getText(), "EPAM FRAMEWORK WISHES…");
        assertTrue(homePage.getHeaderMenu().getLowerMainHeaderText().isDisplayed());
        assertEquals(homePage.getHeaderMenu().getLowerMainHeaderText().getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
                "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT " +
                "NULLA PARIATUR.");

        //10. Assert that there is the iframe in the center of page
        assertTrue(homePage.getIframe().isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        homePage.switchToIframe();
        assertTrue(homePage.getLogo().isDisplayed());

        //12. Switch to original window back
        homePage.switсhToOriginalWindow();
        assertEquals(driver.getTitle(), "Home Page");

        //13. Assert a text of the sub header
        assertTrue(homePage.getHeaderMenu().getSubHeaderText().isDisplayed());
        assertEquals(homePage.getHeaderMenu().getSubHeaderText().getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertEquals(homePage.getHeaderMenu().getSubHeaderText().getAttribute(homePage.getHeaderMenu().getAttributeOfSubHeaderText()),
                "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        assertTrue(homePage.getLeftSection().getSideBar().isDisplayed());

        //16. Assert that there is Footer
        assertTrue(homePage.getFooter().getFooterElement().isDisplayed());

        //17. Close Browser
        homePage.closeBrowser();
    }
}
