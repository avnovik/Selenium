package ru.tests.exercise4.steps;

import io.cucumber.java.en.And;
import ru.tests.exercise4.pages.NavMenu;

public class NavMenuSteps {

    @And("^В выплывающем окне раздела Расходы нажать на Командировки$")
    public void clickOnBusinessTrips() {
        NavMenu navMenu = new NavMenu();

        navMenu.findCostList();
        navMenu.clickBusinessTrip();
    }
}
