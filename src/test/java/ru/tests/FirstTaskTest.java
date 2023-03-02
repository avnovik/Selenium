package ru.tests;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    public void test() {
        String login = "Taraskina Valeriya";
        String password = "testing";
        //Пройти авторизацию
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//form[@id='login-form']"))));
        driver.findElement(By.xpath("//input[@id='prependedInput']"))
                .sendKeys(login);
        driver.findElement(By.xpath("//input[@id='prependedInput2']"))
                .sendKeys(password);
        driver.findElement(By.xpath("//button[@type='submit']")).submit();

        String title = "Панель быстрого запуска";
//        Проверить наличие на странице заголовка Панель быстрого запуска
        wait.until(ExpectedConditions.visibilityOf(
                driver.findElement(By.xpath("//h1[@class ='oro-subtitle']"))));
        var titleElement = driver.findElement(By.xpath("//h1[@class ='oro-subtitle']"));
        assertEquals(title, titleElement.getText(), "Текст отличается от ожидаемого");


//        В выплывающем окне раздела Расходы нажать на Командировки
//        Нажать на  Создать командировку
//        Проверить наличие на странице заголовка "Создать командировку"
//        На странице создания командировки заполнить или выбрать поля:
        //— Подразделение - выбрать Отдел внутренней разработки
        //— Принимающая организация  - нажать "Открыть список" и в поле "Укажите организацию" выбрать любое значение
        //— В задачах поставить чекбокс на "Заказ билетов"
        //— Указать города выбытия и прибытия
        //—Указать даты выезда и возвращения
        //—  !! Раздел Командированные сотрудники не заполнять
//        Проверить, что все поля заполнены правильно
//        Нажать "Сохранить и закрыть"
//        Проверить, что на странице появилось сообщение: "Список командируемых сотрудников не может быть пустым"



    }



}
