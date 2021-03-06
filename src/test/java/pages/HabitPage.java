package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class HabitPage {

    public final String appPack = "org.isoron.uhabits";

    private final String toolBarId = ":id/toolbar",
            habitQuestionId = ":id/questionLabel",
            habitFrequencyId = ":id/frequencyLabel",
            habitReminderId = ":id/reminderLabel",
            habitNotesId = ":id/habitNotes",
            habitTargetId = ":id/targetText";

    private SelenideElement habitName = $(MobileBy.xpath("//*[@resource-id = '" + appPack + toolBarId + "']"
            + "/*[@class='android.widget.TextView']")),
            habitQuestion = $(MobileBy.id(appPack + habitQuestionId)),
            habitFrequency = $(MobileBy.id(appPack + habitFrequencyId)),
            habitReminder = $(MobileBy.id(appPack + habitReminderId)),
            habitNotes = $(MobileBy.id(appPack + habitNotesId)),
            habitTarget = $(MobileBy.id(appPack + habitTargetId));

    public void checkHabitName(String name) {
        habitName.shouldHave(Condition.text(name));
    }

    public void checkHabitQuestion(String question) {
        habitQuestion.shouldHave(Condition.text(question));
    }

    public void checkHabitNotes(String notes) {
        habitNotes.shouldHave(Condition.text(notes));
    }

    public void checkHabitReminder(String reminder){
        habitReminder.shouldHave(Condition.text(reminder));
    }

    public void checkHabitFrequency(String frequency){
        habitFrequency.shouldHave(Condition.text(frequency));
    }

    public void checkHabitTarget(int target, String unit){
        habitTarget.shouldHave(Condition.text(target + " " + unit));
    }
}
