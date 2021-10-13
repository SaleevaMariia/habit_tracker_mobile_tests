package tests.pages;

import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class AddYesNoHabitPage extends AddHabitCommonPage{

    private final String frequencyPikerId = ":id/boolean_frequency_picker";
    private final String everyDayRadioButtonId = ":id/everyDayRadioButton";
    private final String everyXDaysRadioButtonId = ":id/everyXDaysRadioButton";
    private final String everyXDaysFieldId = ":id/everyXDaysTextView";
    private final String xTimesPerWeekRadioButtonId = ":id/xTimesPerWeekRadioButton";
    private final String xTimesPerWeekFieldId = ":id/xTimesPerWeekTextView";
    private final String xTimesPerMonthRadioButtonId = ":id/xTimesPerMonthRadioButton";
    private final String xTimesPerMonthFieldId = ":id/xTimesPerMonthTextView";
    private final String saveFrequencyButtonId = "android:id/button1";


    private SelenideElement frequencyPiker = $(MobileBy.id(appPack+frequencyPikerId));
    private SelenideElement everyDayRadioButton = $(MobileBy.id(appPack+everyDayRadioButtonId));
    private SelenideElement everyXDaysRadioButton = $(MobileBy.id(appPack+everyXDaysRadioButtonId));
    private SelenideElement everyXDaysField = $(MobileBy.id(appPack+everyXDaysFieldId));
    private SelenideElement xTimesPerWeekRadioButton = $(MobileBy.id(appPack+xTimesPerWeekRadioButtonId));
    private SelenideElement xTimesPerWeekField = $(MobileBy.id(appPack+xTimesPerWeekFieldId));
    private SelenideElement xTimesPerMonthRadioButton = $(MobileBy.id(appPack+xTimesPerMonthRadioButtonId));
    private SelenideElement xTimesPerMonthField = $(MobileBy.id(appPack+xTimesPerMonthFieldId));
    private SelenideElement saveFrequencyButton = $(MobileBy.id(saveFrequencyButtonId));

    public void chooseEveryDayFrequency(){
        frequencyPiker.click();
        everyDayRadioButton.click();
        saveFrequencyButton.click();
    }

    public void chooseEveryXDaysFrequency(int x){
        frequencyPiker.click();
        everyXDaysRadioButton.click();
        everyXDaysField.val(String.valueOf(x));
        saveFrequencyButton.click();
    }

    public void chooseXTimesPerWeekFrequency(int x){
        frequencyPiker.click();
        xTimesPerWeekRadioButton.click();
        xTimesPerWeekField.val(String.valueOf(x));
        saveFrequencyButton.click();
    }

    public void chooseXTimesPerMonthFrequency(int x){
        frequencyPiker.click();
        xTimesPerMonthRadioButton.click();
        xTimesPerMonthField.val(String.valueOf(x));
        saveFrequencyButton.click();
    }
}
