package ru.tests.exercise4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BusinessTripPage extends BasePage {
    @FindBy(xpath = "//div[contains(@class, 'pull-right')]/div[@class='btn-group']")
    private WebElement createBtn;

    @FindBy(xpath = "//h1[@class='user-name']")
    private WebElement subTitleWebElement;
    String subTitleText = "Создать командировку";

    public void createBusinessTrip() {
        wait.until(ExpectedConditions.visibilityOf(createBtn));
        createBtn.click();
        waitingForLoading();
    }

    public void checkTitle() {
        assertEquals(subTitleText, subTitleWebElement.getText(), "Заголовок должен содержать текст 'Создать командировку'");
    }
}
