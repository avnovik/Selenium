package ru.tests.exercise2.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LoginPage extends BasePage {

    @FindBy(xpath = "//form[@id='login-form']")
    private WebElement loginForm;

    @FindBy(xpath = "//input[@id='prependedInput']")
    private WebElement inputLogin;

    @FindBy(xpath = "//input[@id='prependedInput2']")
    private WebElement inputPassword;

    @FindBy(xpath = "//button[@type='submit']")
    private WebElement submitButton;

    @FindBy(xpath = "//h1[@class ='oro-subtitle']")
    private WebElement subTitle;
    String subTitleText = "Панель быстрого запуска";

    public void inputLoginAndPassword(String login, String password) {
        wait.until(ExpectedConditions.visibilityOf(loginForm));
        inputLogin.sendKeys(login);
        inputPassword.sendKeys(password);
    }

    public void submitLoginFormAndCheckTitle() {
        submitButton.submit();
        wait.until(ExpectedConditions.visibilityOf(subTitle));
        assertEquals(subTitleText, subTitle.getText(), "Текст отличается от ожидаемого");
    }
}
