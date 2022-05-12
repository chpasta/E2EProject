package academy;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pageObjects.LandingPage;

import java.io.IOException;

public class ValidateTitle extends Base {
    public WebDriver driver;

    @BeforeTest
    public void initializer() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
    }

    @Test()
    public void basePageNavigation() throws IOException, InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        String actualResult = landingPage.getTitle().getText();
        String expectedResult = "FEATURED COURSES";
        Assert.assertEquals(actualResult, expectedResult);
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }
}
