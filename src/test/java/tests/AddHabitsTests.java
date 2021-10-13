package tests;

import dictionaries.MeasurableFrequencies;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.pages.AddMeasurableHabitPage;
import tests.pages.AddYesNoHabitPage;
import tests.pages.HabitPage;
import tests.pages.ListOfHabitsPage;

import static io.qameta.allure.Allure.step;

//@Tag("selenide_android")
public class AddHabitsTests extends TestBase{

    private ListOfHabitsPage listOfHabitsPage = new ListOfHabitsPage();
    private AddYesNoHabitPage addYesNoHabitPage = new AddYesNoHabitPage();
    private HabitPage habitPage = new HabitPage();
    private AddMeasurableHabitPage addMeasurableHabitPage = new AddMeasurableHabitPage();

    // @Tag("selenide_android")
    @Test
    void addYesNoHabitWithName(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to add Yes/No habit", () -> {
            addYesNoHabitPage = listOfHabitsPage.clickAddYNHabit();
        });
        step("Enter name of habit and save", () -> {
            addYesNoHabitPage.insertName("Only name");
            listOfHabitsPage = addYesNoHabitPage.saveHabit();
        });
        step("Check last added habit", () -> {
            habitPage = listOfHabitsPage.chooseLastAddedHabit();
            habitPage.checkHabitName("Only name");
            habitPage.checkHabitReminder("off");
            habitPage.checkHabitFrequency("Every day");
        });
    }

    // @Tag("selenide_android")
    @Test
    void addYesNoHabitWithFrequency5TimesPerWeekReminder(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to add Yes/No habit", () -> {
            addYesNoHabitPage = listOfHabitsPage.clickAddYNHabit();
        });
        //todo как можно поставить напоминание на другое время?
        step("Enter name of habit, set reminder, set frequency and save", () -> {
            addYesNoHabitPage.insertName("English");
            addYesNoHabitPage.enableReminder();
            addYesNoHabitPage.chooseXTimesPerWeekFrequency(5);
            listOfHabitsPage = addYesNoHabitPage.saveHabit();
        });
        step("Check last added habit", () -> {
            habitPage = listOfHabitsPage.chooseLastAddedHabit();
            habitPage.checkHabitName("English");
            habitPage.checkHabitReminder("8:00 AM");
            habitPage.checkHabitFrequency("5 times per week");
        });
    }

    // @Tag("selenide_android")
    @Test
    void addYesNoHabitWithFrequencyEvery2DaysReminderAndQuestion(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to add Yes/No habit", () -> {
            addYesNoHabitPage = listOfHabitsPage.clickAddYNHabit();
        });
        step("Enter name of habit, set reminder, set frequency and save", () -> {
            addYesNoHabitPage.insertName("Meditation");
            addYesNoHabitPage.insertQuestion("Did you meditate Today?");
            addYesNoHabitPage.enableReminder();
            addYesNoHabitPage.chooseEveryXDaysFrequency(2);
            listOfHabitsPage = addYesNoHabitPage.saveHabit();
        });
        step("Check last added habit", () -> {
            habitPage = listOfHabitsPage.chooseLastAddedHabit();
            habitPage.checkHabitName("Meditation");
            habitPage.checkHabitReminder("8:00 AM");
            habitPage.checkHabitFrequency("every 2 days");
            habitPage.checkHabitQuestion("Did you meditate Today?");
        });
    }

    // @Tag("selenide_android")
    @Test
    void addYesNoHabitWithFrequencyEveryDaysQuestionNotesColor(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to add Yes/No habit", () -> {
            addYesNoHabitPage = listOfHabitsPage.clickAddYNHabit();
        });
        step("Enter name of habit, set reminder, set frequency and save", () -> {
            addYesNoHabitPage.insertName("Exercise");
            addYesNoHabitPage.insertQuestion("Did you exercise Today?");
            addYesNoHabitPage.chooseEveryDayFrequency();
            addYesNoHabitPage.insertNotes("Keep yourself fit and happy");
            addYesNoHabitPage.chooseColor(3);
            listOfHabitsPage = addYesNoHabitPage.saveHabit();
        });
        // todo можно ли как-то вытащить цвет?
        step("Check last added habit", () -> {
            habitPage = listOfHabitsPage.chooseLastAddedHabit();
            habitPage.checkHabitName("Exercise");
            habitPage.checkHabitReminder("off");
            habitPage.checkHabitFrequency("Every day");
            habitPage.checkHabitQuestion("Did you exercise Today?");
            habitPage.checkHabitNotes("Keep yourself fit and happy");
        });
    }

    // @Tag("selenide_android")
    @Test
    void negAddYesNoHabitWithoutName(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to add Yes/No habit", () -> {
            addYesNoHabitPage = listOfHabitsPage.clickAddYNHabit();
        });
        step("Click save", () -> {
            addYesNoHabitPage.saveHabit();
        });
        //todo Можно ли как-то найти знак ошибки и текст?
        step("Check error", () -> {
            addYesNoHabitPage.checkNameField("e.g. Exercise");
        });
    }

    @Tag("selenide_android")
    @Test
    void addMeasurableHabitWithNameTarget(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to measurable habit", () -> {
            addMeasurableHabitPage = listOfHabitsPage.clickAddMeasurableHabit();
        });
        step("Enter name and target, click save", () -> {
            addMeasurableHabitPage.insertName("2 parameters");
            addMeasurableHabitPage.insertTarget(6);
            addMeasurableHabitPage.saveHabit();
        });

        step("Check last added habit", () -> {
            habitPage = listOfHabitsPage.chooseLastAddedHabit();
            habitPage.checkHabitName("2 parameters");
            habitPage.checkHabitTarget(6, "");
        });
    }

    @Tag("selenide_android")
    @Test
    void addMeasurableHabitWithEveryMonthFrequencyQuestionColorUnitNotes(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to measurable habit", () -> {
            addMeasurableHabitPage = listOfHabitsPage.clickAddMeasurableHabit();
        });
        step("Enter name, question, unit, target, color, notes, frequency and click save", () -> {
            addMeasurableHabitPage.insertName("Run");
            addMeasurableHabitPage.insertQuestion("How many miles did you run today?");
            addMeasurableHabitPage.insertUnit("miles");
            addMeasurableHabitPage.insertTarget(10);
            addMeasurableHabitPage.chooseColor(15);
            addMeasurableHabitPage.insertNotes("you can do it");
            addMeasurableHabitPage.chooseFrequency(MeasurableFrequencies.EVERY_MONTH);
            addMeasurableHabitPage.saveHabit();
        });

        step("Check last added habit", () -> {
            habitPage = listOfHabitsPage.chooseLastAddedHabit();
            habitPage.checkHabitName("Run");
            habitPage.checkHabitQuestion("How many miles did you run today?");
            habitPage.checkHabitTarget(10, "miles");
            habitPage.checkHabitNotes("you can do it");
            habitPage.checkHabitFrequency(MeasurableFrequencies.EVERY_MONTH.getName());
        });
    }

    //@Tag("selenide_android")
    @Test
    void addMeasurableHabitWithEveryDayFrequencyQuestionUnitReminder(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to measurable habit", () -> {
            addMeasurableHabitPage = listOfHabitsPage.clickAddMeasurableHabit();
        });
        step("Enter name, question, unit, target, reminder, frequency and click save", () -> {
            addMeasurableHabitPage.insertName("Water");
            addMeasurableHabitPage.insertQuestion("How many water did you drink today?");
            addMeasurableHabitPage.insertUnit("litre");
            addMeasurableHabitPage.insertTarget(2);
            addMeasurableHabitPage.enableReminder();
            addMeasurableHabitPage.chooseFrequency(MeasurableFrequencies.EVERY_DAY);
            addMeasurableHabitPage.saveHabit();
        });

        step("Check last added habit", () -> {
            habitPage = listOfHabitsPage.chooseLastAddedHabit();
            habitPage.checkHabitName("Water");
            habitPage.checkHabitQuestion("How many water did you drink today?");
            habitPage.checkHabitTarget(2, "litre");
            habitPage.checkHabitFrequency(MeasurableFrequencies.EVERY_DAY.getName());
            habitPage.checkHabitReminder("8:00 AM");
        });
    }

   // @Tag("selenide_android")
    @Test
    void negAddMeasurableHabitWithoutNameTarget(){
        step("Go to the screen with list of habits", () -> {
            listOfHabitsPage = goToListOfHabitsPage();
        });
        step("Click to measurable habit", () -> {
            addMeasurableHabitPage = listOfHabitsPage.clickAddMeasurableHabit();
        });
        step("Click save", () -> {
            addMeasurableHabitPage.saveHabit();
        });
        step("Check error", () -> {
            addMeasurableHabitPage.checkNameField("e.g. Run");
        });
    }
}
