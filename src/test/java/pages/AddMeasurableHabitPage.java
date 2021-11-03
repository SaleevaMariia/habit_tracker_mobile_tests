package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import dictionaries.MeasurableFrequencies;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class AddMeasurableHabitPage extends AddHabitCommonPage {

    private final String unitFieldId = ":id/unitInput",
            targetFieldId = ":id/targetInput",
            frequencyPikerId = ":id/numericalFrequencyPicker",
            frequencyChooseId = "android:id/text1";

    private SelenideElement unitField = $(MobileBy.id(appPack + unitFieldId)),
            targetField = $(MobileBy.id(appPack + targetFieldId)),
            frequencyPiker = $(MobileBy.id(appPack + frequencyPikerId)),
            everyDay = $$(MobileBy.id(frequencyChooseId)).
                    findBy(Condition.text(MeasurableFrequencies.EVERY_DAY.getName())),
            everyMonth = $$(MobileBy.id(frequencyChooseId)).
                    findBy(Condition.text(MeasurableFrequencies.EVERY_MONTH.getName())),
            everyWeek = $$(MobileBy.id(frequencyChooseId)).
                    findBy(Condition.text(MeasurableFrequencies.EVERY_WEEK.getName()));

    public void insertUnit(String unit) {
        unitField.val(unit);
    }

    public void insertTarget(int target) {
        targetField.val(String.valueOf(target));
    }

    public void chooseFrequency(MeasurableFrequencies frequency) {
        frequencyPiker.click();
        switch (frequency){
            case EVERY_DAY:
                everyDay.click();
                break;
            case EVERY_WEEK:
                everyWeek.click();
                break;
            case EVERY_MONTH:
                everyMonth.click();
                break;
        }
    }
}
