package academy;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageObjects.LandingPage;
import pageObjects.LoginPage;


import java.io.IOException;
import java.util.logging.LogManager;
import java.util.logging.Logger;

public class HomePage extends Base {

    public WebDriver driver;

    @BeforeTest
    public void initializer() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();

    }

    @Test(dataProvider = "getData")
    public void basePageNavigation(String username, String password, String text) throws IOException, InterruptedException {

        LandingPage landingPage = new LandingPage(driver);
        landingPage.getPopup().click();
        landingPage.getLogin().click();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.getEmail().sendKeys(username);
        loginPage.getPassword().sendKeys(password);
        loginPage.getSubmit().click();
        System.out.println(text);

        Thread.sleep(5000);
        driver.quit();
    }

    @AfterTest
    public void tearDown() {
        driver.quit();
    }

    @DataProvider
    public Object[][] getData() {

        Object[][] data = new Object[1][3];

        // 0th Row
        data[0][0] = "nonRestrictUser@gmail.com";
        data[0][1] = "123456";
        data[0][2] = "Restrict User";

        return data;
    }
}
