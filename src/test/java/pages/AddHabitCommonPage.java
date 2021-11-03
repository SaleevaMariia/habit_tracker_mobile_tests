package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class AddHabitCommonPage {

    public final String appPack = "org.isoron.uhabits";

    private final String nameFieldId = ":id/nameInput",
            questionFieldId = ":id/questionInput",
            colorButtonId = ":id/colorButton",
            notesFieldId = ":id/notesInput",
            saveButtonId = ":id/buttonSave",
            backButtonContDesc = "Navigate up",
            reminderPickerId = ":id/reminderTimePicker",
            reminderDoneButtonId = ":id/done_button",
            colorContDesc = "Color";

    private SelenideElement nameField = $(MobileBy.id(appPack + nameFieldId)),
            questionField = $(MobileBy.id(appPack + questionFieldId)),
            colorButton = $(MobileBy.id(appPack + colorButtonId)),
            notesField = $(MobileBy.id(appPack + notesFieldId)),
            saveButton = $(MobileBy.id(appPack + saveButtonId)),
            backButton = $(MobileBy.AccessibilityId(backButtonContDesc)),
            reminderPicker = $(MobileBy.id(appPack + reminderPickerId)),
            reminderDoneButton = $(MobileBy.id(appPack + reminderDoneButtonId));

    public void insertName(String name) {
        nameField.val(name);
    }

    public void insertQuestion(String question) {
        questionField.val(question);
    }

    public void chooseColor(int color) {
        if (color > 20 || color < 1)
            throw new RuntimeException("Color should be between 1 and 20");
        colorButton.click();
        $(MobileBy.AccessibilityId(colorContDesc + " " + color)).click();
    }

    public void enableReminder(){
        reminderPicker.click();
        reminderDoneButton.click();
    }

    public void insertNotes(String notes){
        notesField.val(notes);
    }

    public ListOfHabitsPage saveHabit(){
        saveButton.click();
        return new ListOfHabitsPage();
    }

    public ListOfHabitsPage returnToListOfHabits(){
        backButton.click();
        return new ListOfHabitsPage();
    }

    public void checkNameField(String name){
        nameField.shouldHave(Condition.text(name));
    }
}
