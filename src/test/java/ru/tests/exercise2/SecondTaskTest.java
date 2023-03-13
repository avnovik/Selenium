package ru.tests.exercise2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.tests.exercise2.extension.DriverExtension;
import ru.tests.exercise2.pages.*;

@ExtendWith(DriverExtension.class)
class SecondTaskTest extends BasePage {

    @Test
    void secondAT() {

        LoginPage loginPage = new LoginPage();
        NavMenu navMenu = new NavMenu();
        BusinessTripPage businessTripPage = new BusinessTripPage();
        CreateBusinessTripPage createBusinessTripPage = new CreateBusinessTripPage();
        NavCalendar navCalendar = new NavCalendar();

        //Пройти авторизацию
        //Проверить наличие на странице заголовка Панель быстрого запуска
        loginPage.inputLoginAndPassword();
        loginPage.submitLoginFormAndCheckTitle();
        //В выплывающем окне раздела Расходы нажать на Командировки
        navMenu.findCostList();
        navMenu.clickBusinessTrip();
        waitingForLoading();
        //Нажать на  Создать командировку
        businessTripPage.createBusinessTrip();
        waitingForLoading();
        //Проверить наличие на странице заголовка "Создать командировку"
        createBusinessTripPage.checkTitle();
        //На странице создания командировки заполнить или выбрать поля:
        //— Подразделение - выбрать Отдел внутренней разработки
        createBusinessTripPage.chooseUnit();
        //— Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
        createBusinessTripPage.chooseHostOrganization();
        //— В задачах поставить чекбокс на "Заказ билетов"
        createBusinessTripPage.chooseCheckbox();
        //— Указать города выбытия и прибытия
        createBusinessTripPage.chooseDepartureAndArrivalCity("Ярославль", "Омск");
        //—Указать даты выезда и возвращения
        createBusinessTripPage.chooseDepartureDate();
        navCalendar.loading();
        navCalendar.chooseToday();
        createBusinessTripPage.chooseReturnDate();
        navCalendar.loading();
        navCalendar.chooseMonth("июнь");
        navCalendar.chooseYear(2024);
        navCalendar.chooseDay(15);
        //—  !! Раздел Командированные сотрудники не заполнять
        //Проверить, что все поля заполнены правильно
        createBusinessTripPage.checkNoError();
        createBusinessTripPage.checkDurationTrip();
        //Нажать "Сохранить и закрыть"
        createBusinessTripPage.clickSaveAndClose();
        waitingForLoading();
        //Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
        createBusinessTripPage.checkError();
    }
}
