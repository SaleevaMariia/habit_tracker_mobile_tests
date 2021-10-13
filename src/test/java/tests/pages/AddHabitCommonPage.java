package tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import static com.codeborne.selenide.Selenide.$;

public class AddHabitCommonPage {

    public final String appPack = "org.isoron.uhabits";
    private final String nameFieldId = ":id/nameInput";
    private final String questionFieldId = ":id/questionInput";
    private final String colorButtonId = ":id/colorButton";
    private final String notesFieldId = ":id/notesInput";
    private final String saveButtonId = ":id/buttonSave";
    private final String backButtonContDesc = "Navigate up";
    private final String reminderPickerId = ":id/reminderTimePicker";
    private final String reminderDoneButtonId = ":id/done_button";
    private final String colorContDesc = "Color";

    private SelenideElement nameField = $(MobileBy.id(appPack+nameFieldId));
    private SelenideElement questionField = $(MobileBy.id(appPack+questionFieldId));
    private SelenideElement colorButton = $(MobileBy.id(appPack+colorButtonId));
    private SelenideElement notesField = $(MobileBy.id(appPack+notesFieldId));
    private SelenideElement saveButton = $(MobileBy.id(appPack+saveButtonId));
    private SelenideElement backButton = $(MobileBy.AccessibilityId(backButtonContDesc));
    private SelenideElement reminderPicker = $(MobileBy.id(appPack+reminderPickerId));
    private SelenideElement reminderDoneButton = $(MobileBy.id(appPack+reminderDoneButtonId));

    public void insertName(String name){
        nameField.val(name);
    }

    public void insertQuestion(String question){
        questionField.val(question);
    }

    public void chooseColor(int color){
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
