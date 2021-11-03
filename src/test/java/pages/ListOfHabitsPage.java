package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ListOfHabitsPage {

    private final String addHabitButtonId = "Add habit",
            habitsFieldClass = "//*[@class='androidx.recyclerview.widget.RecyclerView']",
            measurableHabitIdButton = ":id/buttonMeasurable",
            yesNoHabitIdButton = ":id/buttonYesNo",
            listOfHabitsXpath = "//*[@class='androidx.recyclerview.widget.RecyclerView']" +
                    "/*[@class='android.widget.FrameLayout']/*[@class='android.widget.LinearLayout']" +
                    "/*[@class='android.view.View'][1]",
            appPack = "org.isoron.uhabits";

    private ElementsCollection listOfHabits = $$(MobileBy.xpath(listOfHabitsXpath));
    private SelenideElement yesNoButton = $(MobileBy.id(appPack + yesNoHabitIdButton)),
            measurableButton = $(MobileBy.id(appPack + measurableHabitIdButton)),
            addHabitButton = $(MobileBy.AccessibilityId(addHabitButtonId)),
            habitsField = $(MobileBy.xpath(habitsFieldClass));

    public int getNumbersOfHabits() {
        return listOfHabits.size();
    }

    public boolean isOnListOfHabitsPage() {
        return addHabitButton.exists();
    }

    public AddYesNoHabitPage clickAddYNHabit() {
        addHabitButton.click();
        yesNoButton.click();
        return new AddYesNoHabitPage();
    }

    public AddMeasurableHabitPage clickAddMeasurableHabit(){
        addHabitButton.click();
        measurableButton.click();
        return new AddMeasurableHabitPage();
    }

    public HabitPage chooseLastAddedHabit() {
        habitsField.shouldBe(Condition.enabled, Duration.ofSeconds(10));
        listOfHabits.get(listOfHabits.size()-1).click();
        return new HabitPage();
    }
}
