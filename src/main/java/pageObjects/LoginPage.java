package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebDriver driver;

    private final By email = By.xpath("//input[@id='user_email']");
    private final By password = By.xpath("//input[@id='user_password']");
    private final By submit = By.cssSelector("[type='submit']");

    public WebElement getEmail() {
        return driver.findElement(email);
    }

    public WebElement getPassword() {
        return driver.findElement(password);
    }

    public WebElement getSubmit() {
        return driver.findElement(submit);
    }
}


