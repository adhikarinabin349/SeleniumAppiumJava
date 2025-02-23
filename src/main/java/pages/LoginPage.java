//This class contains reusable locators and methods for logging in. It uses the WebDriver or AppiumDriver instance to interact with the elements on the login page.
package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    private WebDriver webDriver;
    private AppiumDriver mobileDriver;

    // Locators
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.id("login");

    public LoginPage(WebDriver driver) {
        this.webDriver = driver;
    }

    public LoginPage(AppiumDriver driver) {
        this.mobileDriver = driver;
    }

    public void enterUsername(String username) {
        getDriver().findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        getDriver().findElement(passwordField).sendKeys(password);
    }

    public void clickLogin() {
        getDriver().findElement(loginButton).click();
    }

    private WebDriver getDriver() {
        return (webDriver != null) ? webDriver : mobileDriver;
    }
}