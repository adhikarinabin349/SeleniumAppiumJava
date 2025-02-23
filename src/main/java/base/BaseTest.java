//This class initializes WebDriver (for web tests) and AppiumDriver (for mobile tests). It also provides a method to close the driver after the test execution is completed.
package base;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

public class BaseTest {
    protected WebDriver webDriver;
    protected AppiumDriver mobileDriver;

    public void setup(String platform) throws MalformedURLException {
        if (platform.equalsIgnoreCase("web")) {
            System.setProperty("webdriver.chrome.driver", "path/to/chromedriver");
            WebDriverManager.chromedriver().setup();
            WebDriver webDriver = new ChromeDriver();
            webDriver.get("https://atroverse.com");
            webDriver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
            webDriver.manage().window().maximize();
        } else if (platform.equalsIgnoreCase("android")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "Android");
            caps.setCapability("deviceName", "Android Emulator");
            caps.setCapability("app", "path/to/android-app.apk");
            mobileDriver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        } else if (platform.equalsIgnoreCase("ios")) {
            DesiredCapabilities caps = new DesiredCapabilities();
            caps.setCapability("platformName", "iOS");
            caps.setCapability("deviceName", "iPhone Simulator");
            caps.setCapability("app", "path/to/ios-app.app");
            mobileDriver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        }
    }

    public void tearDown() {
        if (webDriver != null) webDriver.quit();
        if (mobileDriver != null) mobileDriver.quit();
    }
}