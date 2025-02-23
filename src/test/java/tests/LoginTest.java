//Test for login functionality using the LoginPage class
//This test class uses the LoginPage class to test the login functionality of the application. It sets up the WebDriver instance, interacts with the login page elements, and performs assertions to validate the login process.
//The testValidLogin method tests the login functionality by entering valid credentials and clicking the login button. You can add assertions to verify the successful login process.
//The tearDownTest method closes the WebDriver instance after the test execution is completed.
//To run this test, execute the LoginTest class as a TestNG test.
//You can also create additional test methods to test other scenarios, such as invalid login credentials or empty fields.
//For mobile tests, change the setup parameter to "android" or "ios" to test on different mobile platforms.
//You can also create separate test classes for mobile tests using the AppiumDriver instance.
//This test class demonstrates how to use the Page Object Model (POM) pattern to create reusable page objects for testing web and mobile applications.
package tests;

import base.BaseTest;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import java.net.MalformedURLException;

public class LoginTest extends BaseTest {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        setup("web");  // Change to "android" or "ios" for mobile
        loginPage = new LoginPage(webDriver);
    }

    @Test
    public void testValidLogin() {
        loginPage.enterUsername("testuser");
        loginPage.enterPassword("password123");
        loginPage.clickLogin();
        // Add assertions here
    }

    @AfterMethod
    public void tearDownTest() {
        tearDown();
    }
}
