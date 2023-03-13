package ru.tests.exercise2.extension;

import org.junit.jupiter.api.extension.AfterAllCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import ru.tests.exercise2.managers.DriverManager;

public class DriverExtension implements BeforeAllCallback, AfterAllCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) throws Exception {
        DriverManager.getWebDriver();
    }

    @Override
    public void afterAll(ExtensionContext extensionContext) throws Exception {
        DriverManager.closeDriver();
    }
}
