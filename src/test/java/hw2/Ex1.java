package hw2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Ex1 extends firstAndFinalCommonSteps {

    @Test
    public void SeleniumTestEx1() {

        //2. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //3. Perform login
        driver.findElement(By.id("user-icon")).click();
        driver.findElement(By.id("name")).sendKeys("epam");
        driver.findElement(By.id("password")).sendKeys("1234");
        driver.findElement(By.id("login-button")).click();

        //4. Assert User name in the left-top side of screen that user is loggined
        WebElement loginedUserName = new WebDriverWait(driver,15)
                .until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        assertEquals(loginedUserName.getText(), "PITER CHAILOVSKII");

        //5. Assert Browser title
        assertEquals(driver.getTitle(), "Home Page");

        //6. Assert that there are 4 items on the header section are displayed and they have proper texts
        WebElement homeBtn = driver.findElement(By.linkText("Home"));
        WebElement contactFormBtn = driver.findElement(By.linkText("Contact form"));
        WebElement serviceBtn = driver.findElement(By.linkText("Service"));
        WebElement metalsAndColorsBtn = driver.findElement(By.linkText("Metals & Colors"));
        assertTrue(homeBtn.isDisplayed());
        assertTrue(contactFormBtn.isDisplayed());
        assertTrue(serviceBtn.isDisplayed());
        assertTrue(metalsAndColorsBtn.isDisplayed());
        assertEquals(homeBtn.getText(), "Home");
        assertEquals(contactFormBtn.getText(), "Contact form");
        assertEquals(serviceBtn.getText(), "Service");
        assertEquals(metalsAndColorsBtn.getText(), "Metals & Colors");

        //7. Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> images = driver.findElements(By.cssSelector(".benefit-icon"));
        for (WebElement element : images) {
            assertTrue(element.isDisplayed());
        }
        assertEquals(images.size(), 4);

        //8. Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> textUnderImages = driver.findElements(By.cssSelector(".benefit-txt"));
        for (WebElement element : textUnderImages) {
            assertTrue(element.isDisplayed());
        }

        assertEquals(textUnderImages.size(), 4);

        //9. Assert a text of the main headers
        WebElement upperMainHeaderText = driver.findElement(By.name("main-title"));
        assertTrue(upperMainHeaderText.isDisplayed());
        assertEquals(upperMainHeaderText.getText(), "EPAM FRAMEWORK WISHES…");
        WebElement lowerMainHeaderText = driver.findElement(By.name("jdi-text"));
        assertTrue(lowerMainHeaderText.isDisplayed());
        assertEquals(lowerMainHeaderText.getText(), "LOREM IPSUM DOLOR SIT AMET, " +
                "CONSECTETUR ADIPISICING ELIT, SED DO EIUSMOD TEMPOR INCIDIDUNT UT LABORE ET DOLORE MAGNA ALIQUA. " +
                "UT ENIM AD MINIM VENIAM, QUIS NOSTRUD EXERCITATION ULLAMCO LABORIS NISI UT ALIQUIP EX EA COMMODO " +
                "CONSEQUAT DUIS AUTE IRURE DOLOR IN REPREHENDERIT IN VOLUPTATE VELIT ESSE CILLUM DOLORE EU FUGIAT " +
                "NULLA PARIATUR.");

        //10. Assert that there is the iframe in the center of page
        WebElement iframe = driver.findElement(By.id("iframe"));
        assertTrue(iframe.isDisplayed());

        //11. Switch to the iframe and check that there is Epam logo in the left top conner of iframe
        driver.switchTo().frame("iframe");
        WebElement logo = driver.findElement(By.id("epam_logo"));
        assertTrue(logo.isDisplayed());

        //12. Switch to original window back
        driver.switchTo().window(driver.getWindowHandle());
        assertEquals(driver.getTitle(), "Home Page");

        //13. Assert a text of the sub header
        WebElement subHeaderText = driver.findElement(By.linkText("JDI GITHUB"));
        assertTrue(subHeaderText.isDisplayed());
        assertEquals(subHeaderText.getText(), "JDI GITHUB");

        //14. Assert that JDI GITHUB is a link and has a proper URL
        assertTrue(subHeaderText.isDisplayed());
        assertEquals(subHeaderText.getAttribute("href"), "https://github.com/epam/JDI");

        //15. Assert that there is Left Section
        WebElement leftSection = driver.findElement(By.name("navigation-sidebar"));
        assertTrue(leftSection.isDisplayed());

        //16. Assert that there is Footer
        WebElement footer = driver.findElement(By.tagName("footer"));
        assertTrue(footer.isDisplayed());

    }
}
