package ru.tests.exercise2.steps;

import ru.tests.exercise2.pages.NavMenu;

public class NavMenuSteps {

    public void clickOnBusinessTrips() {
        NavMenu navMenu = new NavMenu();

        navMenu.findCostList();
        navMenu.clickBusinessTrip();
    }
}
