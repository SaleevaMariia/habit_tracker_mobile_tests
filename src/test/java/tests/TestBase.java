package tests;

import com.codeborne.selenide.Configuration;
import drivers.AndroidMobileDriver;
import drivers.BrowserstackMobileDriver;
import drivers.SelenoidMobileDriver;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import tests.pages.ListOfHabitsPage;
import tests.pages.WelcomePage;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.logevents.SelenideLogger.addListener;
import static helpers.Attach.getSessionId;
import static io.qameta.allure.Allure.step;


public class TestBase {

    public static String deviceHost;
    public static boolean onboardingSettingPlaced = false;
    private WelcomePage welcomePage = new WelcomePage();
    private ListOfHabitsPage listOfHabitsPage = new ListOfHabitsPage();

    @BeforeAll
    public static void setup(){
        addListener("allure", new AllureSelenide());
        Configuration.startMaximized = false;
        Configuration.browserSize = null;
        Configuration.timeout = 10000;
        deviceHost = System.getProperty("deviceHost");
       // deviceHost = "emulator";
        switch (deviceHost){
            case "browserstack": Configuration.browser = BrowserstackMobileDriver.class.getName();
                break;
            case "selenoid": Configuration.browser = SelenoidMobileDriver.class.getName();
                break;
            case "real":
            case "emulator": Configuration.browser = AndroidMobileDriver.class.getName();
                break;
            default: throw new RuntimeException("no such deviceHost" + deviceHost);
        }
    }
    @BeforeEach
    public void startDriver(){
        open();
    }

    @AfterEach
    public void closeDriver(){
        String sessionId = getSessionId();
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();

        closeWebDriver();
        switch (deviceHost){
            case "browserstack": Attach.attachVideo(sessionId);
        }

    }

    protected ListOfHabitsPage goToListOfHabitsPage(){
        if ( listOfHabitsPage.isOnListOfHabitsPage())
                onboardingSettingPlaced = true;
        if(!onboardingSettingPlaced) {
                welcomePage = welcomePage.clickNext();
                welcomePage = welcomePage.clickNext();
                welcomePage.clickDone();
        }
        return new ListOfHabitsPage();
    }
}
