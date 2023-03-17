package ru.tests.exercise4.steps;

import io.cucumber.java.en.And;
import ru.tests.exercise4.pages.BusinessTripPage;
import ru.tests.exercise4.pages.CreateBusinessTripPage;
import ru.tests.exercise4.pages.NavCalendar;

public class CreateBusinessTripSteps {

    @And("^Нажать на  Создать командировку$")
    public void createBusinessTrip() {
        BusinessTripPage businessTripPage = new BusinessTripPage();

        businessTripPage.createBusinessTrip();
        businessTripPage.checkTitle();
    }

    @And("^На странице создания командировки заполнить или выбрать поля: город отбытия \"([^\"]*)\", город прибытия \"([^\"]*)\", дата возвращения: год \"(\\d+)\", месяц \"(.+)\", день \"(\\d+)\"$")
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

    @And("^Нажать 'Сохранить и закрыть'$")
    public void clickSaveAndClose() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.clickSaveAndClose();
    }

    @And("^Проверить, что все поля заполнены правильно$")
    public void checkNoError() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.checkNoError();
        createBusinessTripPage.checkDurationTrip();
    }

    @And("^Проверить, что на странице появилось сообщение: 'Список командируемых сотрудников не может быть пустым'$")
    public void checkError() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.checkError();
    }
}