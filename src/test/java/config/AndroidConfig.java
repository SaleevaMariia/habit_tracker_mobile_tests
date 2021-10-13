package config;

import org.aeonbits.owner.Config;

@Config.Sources({
        "classpath:${deviceHost}.properties"
})
public interface AndroidConfig extends Config {
    @Key("platformName")
    String getPlatformName();

    @Key("deviceName")
    String getDeviceName();

    @Key("version")
    String getVersionName();

    @Key("appPackage")
    String getAppPackage();

    @Key("appActivity")
    String getAppActivity();

    @Key("app")
    String getApp();
}
