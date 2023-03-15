package ru.tests.exercise2.pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavMenu extends BasePage {

    @FindBy(xpath = "//ul[contains(@class, 'main-menu')]/li/a//span[text()='Расходы']")
    private WebElement costsList;

    @FindBy(xpath = "//span[text()='Расходы']/ancestor::li/ul[@class='dropdown-menu menu_level_1']")
    private WebElement dropDownMenu;

    @FindBy(xpath = "//li[@data-route='crm_business_trip_index']")
    private WebElement businessTrip;

    @Step
    public void findCostList() {
        costsList.click();
        wait.until(ExpectedConditions.visibilityOf(dropDownMenu));
    }

    @Step
    public void clickBusinessTrip() {
        businessTrip.click();
        waitingForLoading();
    }
}
