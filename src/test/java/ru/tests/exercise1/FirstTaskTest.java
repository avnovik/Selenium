package ru.tests.exercise1;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.*;

public class FirstTaskTest {

    private WebDriver driver;
    private WebDriverWait wait;

    @BeforeEach
    public void before() {
        String baseUrl = "http://training.appline.ru/user/login";
        System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get(baseUrl);
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)); //time when findEl

        wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));
    }

    @AfterEach
    public void after() {
        driver.quit();
    }

    public void waitingForLoading() {
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(By.xpath("//div[@class='loader-mask shown']"))));
    }

    @Test
    public void firstAT() {
        String login = "Taraskina Valeriya";
        String password = "testing";
        //Пройти авторизацию
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@id='prependedInput']")).sendKeys(login);
        driver.findElement(By.xpath("//input[@id='prependedInput2']")).sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        //Проверить наличие на странице заголовка Панель быстрого запуска
        String titleText = "Панель быстрого запуска";
        var titleElement = driver.findElement(By.xpath("//h1[@class ='oro-subtitle']"));

        wait.until(ExpectedConditions.visibilityOf(titleElement));
        assertEquals(titleText, titleElement.getText(), "Текст отличается от ожидаемого");

        //В выплывающем окне раздела Расходы нажать на Командировки
        WebElement costsList = driver.findElement(By.xpath("//ul[contains(@class, 'main-menu')]/li/a//span[text()='Расходы']"));
        costsList.click();

        wait.until(ExpectedConditions.visibilityOf(costsList.findElement(By.xpath("./ancestor::li//ul[@class='dropdown-menu menu_level_1']"))));
        driver.findElement(By.xpath("//li[@data-route='crm_business_trip_index']")).click();
        waitingForLoading();

        //Нажать на  Создать командировку
        driver.findElement(By.xpath("//div[contains(@class, 'pull-right')]/div[@class='btn-group']")).click();
        waitingForLoading();

        //Проверить наличие на странице заголовка "Создать командировку"
        String subTitleText = "Создать командировку";
        var subTitleElement = driver.findElement(By.xpath("//h1[@class='user-name']"));
        assertEquals(subTitleText, subTitleElement.getText(), "Заголовок должен содержать текст 'Создать командировку'");

        //На странице создания командировки заполнить или выбрать поля:
        //— Подразделение - выбрать Отдел внутренней разработки
        driver.findElement(By.xpath("//select[@data-name='field__business-unit']")).click();
        driver.findElement(By.xpath("//option[@value='7']")).click();

        //— Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
        driver.findElement(By.xpath("//a[@id='company-selector-show']")).click();
        driver.findElement(By.xpath("//div[contains(@class, 'select2-container')]")).click();

        var organizationWebElement = driver.findElement(By.xpath("//div[contains(text(), 'Хром')]"));
        wait.until(ExpectedConditions.visibilityOf(organizationWebElement));
        organizationWebElement.click();

        //— В задачах поставить чекбокс на "Заказ билетов"
        driver.findElement(By.xpath("//div[@class='oro-clearfix']/input[@data-name='field__1']")).click();

        //— Указать города выбытия и прибытия
        var departureCityWebElement = driver.findElement(By.xpath("//input[contains(@id, 'departureCity')]"));
        departureCityWebElement.clear();
        departureCityWebElement.sendKeys("Ярославль");

        var arrivalCityWebElement = driver.findElement(By.xpath("//input[contains(@id, 'arrivalCity')]"));
        arrivalCityWebElement.sendKeys("Омск");

        //—Указать даты выезда и возвращения
        driver.findElement(By.xpath("//div[contains(@class,'controls')]/input[contains(@id, 'departureDatePlan')]")).click();
        var calendarWebElement = driver.findElement(By.xpath("//div[@id='ui-datepicker-div']"));
        wait.until(ExpectedConditions.visibilityOf(calendarWebElement));

        calendarWebElement.findElement(By.xpath("./div/button[contains(@class, 'current')]")).click();
        driver.findElement(By.xpath("//div[contains(@class,'controls')]/input[contains(@id, 'returnDatePlan')]")).click();
        wait.until(ExpectedConditions.visibilityOf(calendarWebElement));

        calendarWebElement.findElement(By.xpath("./div/div/select[contains(@class, 'month')]")).click();
        driver.findElement(By.xpath(".//option[text()='июнь']")).click();
        calendarWebElement.findElement(By.xpath("./table/tbody//tr//a[text()='12']")).click();

        //—  !! Раздел Командированные сотрудники не заполнять
        //Проверить, что все поля заполнены правильно
        var validationErrorWebElementLocator = By.xpath("//span[@class='validation-failed']");
        assertFalse(driver.findElement(validationErrorWebElementLocator).isDisplayed());

        var durationDaysWebElement = driver.findElement(By.xpath("//span[@id='duration-plan']"));
        assertTrue(Integer.parseInt(durationDaysWebElement.getText()) > 0, "Срок командировки  должен быть больше 0 дней, фактический срок = " + durationDaysWebElement.getText());


        //Нажать "Сохранить и закрыть"
        driver.findElement(By.xpath("//div[@class='pull-right']//button[not(contains(@class, 'main-group'))]")).click();
        waitingForLoading();

        //Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"
        String errorMsg = "Список командируемых сотрудников не может быть пустым";
        assertTrue(driver.findElement(validationErrorWebElementLocator).isDisplayed());
        assertEquals(errorMsg, driver.findElement(validationErrorWebElementLocator).getText());
    }
}
