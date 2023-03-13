package ru.tests.exercise2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BusinessTripPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'pull-right')]/div[@class='btn-group']")
    private WebElement createBtn;

    public void createBusinessTrip() {
        createBtn.click();
    }

}
