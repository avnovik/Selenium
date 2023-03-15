package ru.tests.exercise2.steps;

import io.qameta.allure.Step;
import ru.tests.exercise2.pages.NavMenu;

public class NavMenuSteps {

    @Step("В выплывающем окне раздела Расходы нажаимаем на 'Командировки'")
    public void clickOnBusinessTrips() {
        NavMenu navMenu = new NavMenu();

        navMenu.findCostList();
        navMenu.clickBusinessTrip();
    }
}
