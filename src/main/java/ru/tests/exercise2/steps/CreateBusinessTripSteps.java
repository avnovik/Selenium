package ru.tests.exercise2.steps;

import io.qameta.allure.Step;
import ru.tests.exercise2.pages.BusinessTripPage;
import ru.tests.exercise2.pages.CreateBusinessTripPage;
import ru.tests.exercise2.pages.NavCalendar;

public class CreateBusinessTripSteps {

    @Step("Нажимаем на 'Создать командировку' и проверяем наличие на странице заголовка 'Создать командировку'")
    public void createBusinessTrip() {
        BusinessTripPage businessTripPage = new BusinessTripPage();

        businessTripPage.createBusinessTrip();
        businessTripPage.checkTitle();
    }

    @Step("На странице создания командировки заполняем поля")
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

    @Step("Нажимаем 'Сохранить и закрыть'")
    public void clickSaveAndClose() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.clickSaveAndClose();
    }

    @Step("Проверяем отсутствие ошибок")
    public void checkNoError() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.checkNoError();
        createBusinessTripPage.checkDurationTrip();
    }

    @Step("Проверяем на странице сообщение: 'Список командируемых сотрудников не может быть пустым'")
    public void checkError() {
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();

        createBusinessTripPage.checkError();
    }
}