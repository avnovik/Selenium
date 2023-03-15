package ru.tests.exercise2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import ru.tests.exercise2.extension.DriverExtension;
import ru.tests.exercise2.managers.TestProperties;
import ru.tests.exercise2.pages.BasePage;
import ru.tests.exercise2.steps.CreateBusinessTripSteps;
import ru.tests.exercise2.steps.LoginSteps;
import ru.tests.exercise2.steps.NavMenuSteps;

import java.util.Properties;

@ExtendWith(DriverExtension.class)
class SecondTaskTest extends BasePage {

    private final Properties properties = TestProperties.getInstance().getProperties();
    private final LoginSteps loginSteps = new LoginSteps();
    private final NavMenuSteps navMenu = new NavMenuSteps();
    private final CreateBusinessTripSteps businessTripPage = new CreateBusinessTripSteps();

    @Test
    void secondAT() {

        //Пройти авторизацию
        //Проверить наличие на странице заголовка Панель быстрого запуска
        loginSteps.login(properties.getProperty("LOGIN"), properties.getProperty("PASSWORD"));
        //В выплывающем окне раздела Расходы нажать на Командировки
        navMenu.clickOnBusinessTrips();
        //Нажать на  Создать командировку
        //Проверить наличие на странице заголовка "Создать командировку"
        businessTripPage.createBusinessTrip();
        //На странице создания командировки заполнить или выбрать поля:
        //— Подразделение - выбрать Отдел внутренней разработки
        //— Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
        //— В задачах поставить чекбокс на "Заказ билетов"
        //— Указать города выбытия и прибытия
        //—Указать даты выезда и возвращения
        //—  !! Раздел Командированные сотрудники не заполнять
        //Проверить, что все поля заполнены правильно
        businessTripPage.fillTheFieldsExceptEmployeesSection(
                "Ярославль", "Омск",
                2024, "июнь", 13);
        businessTripPage.checkNoError();
        //Нажать "Сохранить и закрыть"
        businessTripPage.clickSaveAndClose();
        //Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
        businessTripPage.checkError();
    }
}
