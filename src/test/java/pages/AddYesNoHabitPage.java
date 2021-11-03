package pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class AddYesNoHabitPage extends AddHabitCommonPage {

    private final String frequencyPikerId = ":id/boolean_frequency_picker",
            everyDayRadioButtonId = ":id/everyDayRadioButton",
            everyXDaysRadioButtonId = ":id/everyXDaysRadioButton",
            everyXDaysFieldId = ":id/everyXDaysTextView",
            xTimesPerWeekRadioButtonId = ":id/xTimesPerWeekRadioButton",
            xTimesPerWeekFieldId = ":id/xTimesPerWeekTextView",
            xTimesPerMonthRadioButtonId = ":id/xTimesPerMonthRadioButton",
            xTimesPerMonthFieldId = ":id/xTimesPerMonthTextView",
            saveFrequencyButtonId = "android:id/button1";


    private SelenideElement frequencyPiker = $(MobileBy.id(appPack + frequencyPikerId)),
            everyDayRadioButton = $(MobileBy.id(appPack + everyDayRadioButtonId)),
            everyXDaysRadioButton = $(MobileBy.id(appPack + everyXDaysRadioButtonId)),
            everyXDaysField = $(MobileBy.id(appPack + everyXDaysFieldId)),
            xTimesPerWeekRadioButton = $(MobileBy.id(appPack + xTimesPerWeekRadioButtonId)),
            xTimesPerWeekField = $(MobileBy.id(appPack + xTimesPerWeekFieldId)),
            xTimesPerMonthRadioButton = $(MobileBy.id(appPack + xTimesPerMonthRadioButtonId)),
            xTimesPerMonthField = $(MobileBy.id(appPack + xTimesPerMonthFieldId)),
            saveFrequencyButton = $(MobileBy.id(saveFrequencyButtonId));

    public void chooseEveryDayFrequency() {
        frequencyPiker.click();
        everyDayRadioButton.click();
        saveFrequencyButton.click();
    }

    public void chooseEveryXDaysFrequency(int x) {
        frequencyPiker.click();
        everyXDaysRadioButton.click();
        everyXDaysField.val(String.valueOf(x));
        saveFrequencyButton.click();
    }

    public void chooseXTimesPerWeekFrequency(int x) {
        frequencyPiker.click();
        xTimesPerWeekRadioButton.click();
        xTimesPerWeekField.val(String.valueOf(x));
        saveFrequencyButton.click();
    }

    public void chooseXTimesPerMonthFrequency(int x) {
        frequencyPiker.click();
        xTimesPerMonthRadioButton.click();
        xTimesPerMonthField.val(String.valueOf(x));
        saveFrequencyButton.click();
    }
}
