package tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import tests.pages.ListOfHabitsPage;
import tests.pages.WelcomePage;

import static io.qameta.allure.Allure.step;


public class WelcomePageTest extends TestBase{

    private WelcomePage welcomePage = new WelcomePage();
    private ListOfHabitsPage listOfHabitsPage = new ListOfHabitsPage();

   // @Tag("selenide_android")
    @Test
    public void goThroughWelcomePagePages(){
        step("Determine whether the application is open for the first time or not", () -> {
            if ( listOfHabitsPage.isOnListOfHabitsPage()){
                onboardingSettingPlaced = true;
            }
        });
        if(!onboardingSettingPlaced) {
            step("Click all welcome screens", () -> {
                welcomePage = welcomePage.clickNext();
                welcomePage = welcomePage.clickNext();
                listOfHabitsPage = welcomePage.clickDone();
            });
            step("Check amount of habits", () -> {
                Assertions.assertTrue(listOfHabitsPage.getNumbersOfHabits() == 0);
            });
        }
    }
}
