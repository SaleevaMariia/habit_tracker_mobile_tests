package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class WelcomePage {
    public final String appPack = "org.isoron.uhabits";
    private final String idNext = ":id/next",
            idDone = ":id/done";

    private SelenideElement continueButton = $(MobileBy.id(appPack + idNext));
    private SelenideElement doneButton = $(MobileBy.id(appPack + idDone));

    public WelcomePage clickNext() {
        continueButton.click();
        return new WelcomePage();
    }

    public ListOfHabitsPage clickDone() {
        doneButton.click();
        return new ListOfHabitsPage();
    }
}
