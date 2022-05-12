package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {

    public LandingPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;

    private final By popup = By.xpath("//button[text()='NO THANKS']");
    private final By title = By.cssSelector(".text-center>h2");
    private final By signIn = By.cssSelector("a[href*='sign_in']");

    public WebElement getPopup() {
        return driver.findElement(popup);
    }

    public WebElement getTitle() {
        return driver.findElement(title);
    }

    public WebElement getLogin() {
        return driver.findElement(signIn);
    }

}
