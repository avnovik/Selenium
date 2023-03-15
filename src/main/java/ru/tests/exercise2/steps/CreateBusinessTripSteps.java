package ru.tests.exercise2.steps;

import ru.tests.exercise2.pages.BusinessTripPage;
import ru.tests.exercise2.pages.CreateBusinessTripPage;
import ru.tests.exercise2.pages.NavCalendar;

public class CreateBusinessTripSteps {

    public void createBusinessTrip() {
        BusinessTripPage businessTripPage = new BusinessTripPage();

        businessTripPage.createBusinessTrip();
        businessTripPage.checkTitle();
    }

    public void fillTheFieldsExceptEmployeesSection(String departureCity, String arrivalCity, int year, String month, int day) {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();
        NavCalendar navCalendar = new NavCalendar();

        createBusinessTripPage.chooseUnit();
        createBusinessTripPage.chooseHostOrganization();
        createBusinessTripPage.chooseCheckbox();
        createBusinessTripPage.chooseDepartureAndArrivalCity(departureCity, arrivalCity);

        createBusinessTripPage.chooseDepartureDate();
        navCalendar.loading();
        navCalendar.chooseToday();

        createBusinessTripPage.chooseReturnDate();
        navCalendar.loading();
        navCalendar.chooseMonth(month);
        navCalendar.chooseYear(year);
        navCalendar.chooseDay(day);
    }

    public void clickSaveAndClose() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.clickSaveAndClose();
    }

    public void checkNoError() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.checkNoError();
        createBusinessTripPage.checkDurationTrip();
    }

    public void checkError() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.checkError();
    }
}