package tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class HabitPage {

    private final String toolBarId = ":id/toolbar";
    public final String appPack = "org.isoron.uhabits";
    private final String habitQuestionId = ":id/questionLabel";
    private final String habitFrequencyId = ":id/frequencyLabel";
    private final String habitReminderId = ":id/reminderLabel";
    private final String habitNotesId = ":id/habitNotes";
    private final String habitTargetId = ":id/targetText";

    private SelenideElement habitName = $(MobileBy.xpath("//*[@resource-id = '" + appPack+toolBarId + "']"
            + "/*[@class='android.widget.TextView']"));
    private SelenideElement habitQuestion = $(MobileBy.id(appPack+habitQuestionId));
    private SelenideElement habitFrequency = $(MobileBy.id(appPack+habitFrequencyId));
    private SelenideElement habitReminder = $(MobileBy.id(appPack+habitReminderId));
    private SelenideElement habitNotes = $(MobileBy.id(appPack+habitNotesId));
    private SelenideElement habitTarget = $(MobileBy.id(appPack+habitTargetId));

    public void checkHabitName(String name){
        habitName.shouldHave(Condition.text(name));
    }

    public void checkHabitQuestion(String question){
        habitQuestion.shouldHave(Condition.text(question));
    }

    public void checkHabitNotes(String notes){
        habitNotes.shouldHave(Condition.text(notes));
    }

    public void checkHabitReminder(String reminder){
        System.out.println("habitReminder" + habitReminder.getText());
        habitReminder.shouldHave(Condition.text(reminder));
    }

    public void checkHabitFrequency(String frequency){
        System.out.println("habitFrequency" + habitFrequency.getText());
        habitFrequency.shouldHave(Condition.text(frequency));
    }

    public void checkHabitTarget(int target, String unit){
        habitTarget.shouldHave(Condition.text(target + " " + unit));
    }
}
