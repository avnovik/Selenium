package ru.tests.exercise4.steps;

import io.cucumber.java.en.And;
import ru.tests.exercise4.pages.LoginPage;

public class LoginSteps {

    @And("^Страница авторизации: вводим логин \"([^\"]*)\" и пароль \"([^\"]*)\"$")
    public void login(String login, String password){
        LoginPage loginPage = new LoginPage();

        loginPage.inputLoginAndPassword(login, password);
        loginPage.submitLoginFormAndCheckTitle();
    }
}
