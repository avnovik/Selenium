package ru.tests.exercise2.steps;

import ru.tests.exercise2.pages.LoginPage;

public class LoginSteps {

    public void login(){
        LoginPage loginPage = new LoginPage();

        loginPage.inputLoginAndPassword();
        loginPage.submitLoginFormAndCheckTitle();
    }
}
