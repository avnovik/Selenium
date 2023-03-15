package ru.tests.exercise2.steps;

import io.qameta.allure.Step;
import ru.tests.exercise2.pages.LoginPage;

public class LoginSteps {

    public void login(String login, String password){
        LoginPage loginPage = new LoginPage();

        loginPage.inputLoginAndPassword(login, password);
        loginPage.submitLoginFormAndCheckTitle();
    }
}
