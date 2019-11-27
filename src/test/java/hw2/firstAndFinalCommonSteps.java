package hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class firstAndFinalCommonSteps {

    protected WebDriver driver;

    @BeforeMethod
    //1. Open test site by URL
    public void setUp() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://epam.github.io/JDI/");
    }

    @AfterMethod
    //17. Close Browser
    public void closeBrowser() {
        driver.close();
    }
}
