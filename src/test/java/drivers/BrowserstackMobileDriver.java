package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.BrowserstackConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserstackMobileDriver implements WebDriverProvider {
    public static BrowserstackConfig config = ConfigFactory.create(BrowserstackConfig.class);

    public static URL getBrowserstackUrl() {
        try {
            return new URL("http://hub.browserstack.com/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        // Set your access credentials
        desiredCapabilities.setCapability("browserstack.user", config.getUser());
        desiredCapabilities.setCapability("browserstack.key", config.getPassword());

        // Set URL of the application under test
        desiredCapabilities.setCapability("app", config.getApp());

        // Specify device and os_version for testing
        desiredCapabilities.setCapability("device", config.getDevice());
        desiredCapabilities.setCapability("os_version", config.getOsVersion());

        // Set other BrowserStack capabilities
        desiredCapabilities.setCapability("project", config.getProject());
        desiredCapabilities.setCapability("build", config.getBuild());
        desiredCapabilities.setCapability("name", config.getName());

        return new AndroidDriver(getBrowserstackUrl(), desiredCapabilities);
    }
}

