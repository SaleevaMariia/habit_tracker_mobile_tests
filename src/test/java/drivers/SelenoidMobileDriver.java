package drivers;

import com.codeborne.selenide.WebDriverProvider;
import config.AndroidConfig;
import io.appium.java_client.android.AndroidDriver;
import org.aeonbits.owner.ConfigFactory;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class SelenoidMobileDriver implements WebDriverProvider {
    public static AndroidConfig config = ConfigFactory.create(AndroidConfig.class);

    public static URL getSelenoidUrl() {
        try {
            return new URL("https://user1:1234@selenoid.autotests.cloud/wd/hub");
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public WebDriver createDriver(DesiredCapabilities desiredCapabilities) {

        desiredCapabilities.setCapability("platformName", config.getPlatformName());
        desiredCapabilities.setCapability("deviceName", config.getDeviceName());
        desiredCapabilities.setCapability("version", config.getVersionName());
        desiredCapabilities.setCapability("appPackage", config.getAppPackage());
        desiredCapabilities.setCapability("locale", "en");
        desiredCapabilities.setCapability("language", "en");
        desiredCapabilities.setCapability("appActivity", config.getAppActivity());
        desiredCapabilities.setCapability("app", apkUrl());
        desiredCapabilities.setCapability("enableVNC", true);
        desiredCapabilities.setCapability("enableVideo", true);

        return new AndroidDriver(getSelenoidUrl(), desiredCapabilities);
    }

    private URL apkUrl() {
        try {
            return new URL("https://github.com/iSoron/uhabits" +
                    "/releases/download/v2.0.3/loop-2.0.3-release.apk");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        return null;
    }
}

