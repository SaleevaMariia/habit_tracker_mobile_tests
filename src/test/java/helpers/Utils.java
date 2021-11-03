package helpers;

import pages.ListOfHabitsPage;
import pages.WelcomePage;

import static tests.TestBase.onboardingSettingPlaced;

public class Utils {

    public static ListOfHabitsPage goToListOfHabitsPage(ListOfHabitsPage listOfHabitsPage, WelcomePage welcomePage) {
        if (listOfHabitsPage.isOnListOfHabitsPage())
            onboardingSettingPlaced = true;
        if (!onboardingSettingPlaced) {
            welcomePage = welcomePage.clickNext();
            welcomePage = welcomePage.clickNext();
            welcomePage.clickDone();
        }
        return new ListOfHabitsPage();
    }
}
