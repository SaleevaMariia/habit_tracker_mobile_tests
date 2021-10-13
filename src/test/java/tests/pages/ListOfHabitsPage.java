package tests.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import io.appium.java_client.MobileBy;

import java.time.Duration;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class ListOfHabitsPage {

    private final String addHabitButtonId = "Add habit";
    private final String habitsFieldClass = "//*[@class='androidx.recyclerview.widget.RecyclerView']";
    private final String measurableHabitIdButton = ":id/buttonMeasurable";
    private final String yesNoHabitIdButton = ":id/buttonYesNo";
    private final String listOfHabitsXpath = "//*[@class='androidx.recyclerview.widget.RecyclerView']" +
            "/*[@class='android.widget.FrameLayout']/*[@class='android.widget.LinearLayout']" +
            "/*[@class='android.view.View'][1]";
    public final String appPack = "org.isoron.uhabits";

    private ElementsCollection listOfHabits = $$(MobileBy.xpath(listOfHabitsXpath));
    private SelenideElement yesNoButton = $(MobileBy.id(appPack+yesNoHabitIdButton));
    private SelenideElement measurableButton = $(MobileBy.id(appPack+measurableHabitIdButton));
    private SelenideElement addHabitButton =  $(MobileBy.AccessibilityId(addHabitButtonId));
    private SelenideElement habitsField =  $(MobileBy.xpath(habitsFieldClass));

    public int getNumbersOfHabits(){
        return listOfHabits.size();
    }

    public boolean isOnListOfHabitsPage(){
        return addHabitButton.exists();
    }

    public AddYesNoHabitPage clickAddYNHabit(){
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
