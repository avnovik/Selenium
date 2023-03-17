package ru.tests.exercise4.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.*;

public class CreateBusinessTripPage extends BasePage {

    @FindBy(xpath = "//select[@data-name='field__business-unit']")
    private WebElement fieldUnit;

    @FindBy(xpath = "//option[@value='7']")
    private WebElement desiredUnit;

    @FindBy(xpath = "//a[@id='company-selector-show']")
    private WebElement companySelector;

    @FindBy(xpath = "//div[contains(@class, 'select2-container')]")
    private WebElement companyList;

    @FindBy(xpath = "//div[contains(text(), 'Хром')]")
    private WebElement companyName;

    @FindBy(xpath = "//div[@class='oro-clearfix']/input[@data-name='field__1']")
    private WebElement ticketBooking;

    @FindBy(xpath = "//input[contains(@id, 'departureCity')]")
    private WebElement departureCity;

    @FindBy(xpath = "//input[contains(@id, 'arrivalCity')]")
    private WebElement arrivalCity;

    @FindBy(xpath = "//div[contains(@class,'controls')]/input[contains(@id, 'departureDatePlan')]")
    private WebElement departureDate;

    @FindBy(xpath = "//div[contains(@class,'controls')]/input[contains(@id, 'returnDatePlan')]")
    private WebElement returnDate;

    @FindBy(xpath = "//span[@class='validation-failed']")
    private WebElement validationFailed;

    @FindBy(xpath = "//span[@id='duration-plan']")
    private WebElement durationTrip;

    @FindBy(xpath = "//div[@class='pull-right']//button[not(contains(@class, 'main-group'))]")
    private WebElement saveAndCloseBtn;


    public void chooseUnit() {
        fieldUnit.click();
        desiredUnit.click();
    }

    public void chooseHostOrganization() {
        companySelector.click();
        companyList.click();
        wait.until(ExpectedConditions.visibilityOf(companyName));
        companyName.click();
    }

    public void chooseCheckbox() {
        ticketBooking.click();
    }

    public void chooseDepartureAndArrivalCity(String departure, String arrival) {
        departureCity.clear();
        departureCity.sendKeys(departure);
        arrivalCity.sendKeys(arrival);
    }

    public void chooseDepartureDate() {
        departureDate.click();
    }

    public void chooseReturnDate() {
        returnDate.click();
    }

    public void checkNoError() {
        assertFalse(validationFailed.isDisplayed());
    }

    public void checkDurationTrip() {
        assertTrue(Integer.parseInt(durationTrip.getText()) > 0,
                "Срок командировки  должен быть больше 0 дней, фактический срок = " + durationTrip.getText());
    }

    public void clickSaveAndClose() {
        saveAndCloseBtn.click();
        waitingForLoading();
    }

    public void checkError() {
        String errorMsg = "Список командируемых сотрудников не может быть пустым";
        assertTrue(validationFailed.isDisplayed());
        assertEquals(errorMsg, validationFailed.getText());
    }
}
