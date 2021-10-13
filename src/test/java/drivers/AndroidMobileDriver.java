package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AndroidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class AndroidMobileDriver implements WebDriverProvider {
    static AndroidConfig config = ConfigFactory.create(AndroidConfig.class);

    public static URL getAppiumUrl() {
        try {
            return new URL("http://127.0.0.1:4723/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", config.getPlatformName());
        desiredCapabilities.setCapability("deviceName",config.getDeviceName());
        desiredCapabilities.setCapability("version", config.getVersionName());
        desiredCapabilities.setCapability("appPackage", config.getAppPackage());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appActivity", config.getAppActivity());
        desiredCapabilities.setCapability("app", getAbsolutePath(config.getApp()));

        /*desiredCapabilities.setCapability("platformName", "Android");
        desiredCapabilities.setCapability("deviceName","Pixel 4 API 30");
        desiredCapabilities.setCapability("version", "11.0");
        desiredCapabilities.setCapability("appPackage", "org.isoron.uhabits");
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appActivity", "org.isoron.uhabits.MainActivity");
        desiredCapabilities.setCapability("app", getAbsolutePath(config.getApp()));*/

        return new AndroidDriver(getAppiumUrl(), desiredCapabilities);
    }

    private String getAbsolutePath(String filePath) {
        //filePath = "src/test/resources/loop-2.0.3-release.apk";
        File file = new File(filePath);
        assertTrue(file.exists(), filePath + " not found");

        return file.getAbsolutePath();
    }
}

