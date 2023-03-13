package ru.tests.exercise2.managers;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.Properties;

import static java.lang.System.setProperty;

public class DriverManager {

    private static WebDriver driver;
    private static final Properties properties = TestProperties.getInstance().getProperties();


    public static WebDriver getWebDriver() {
        if (driver == null) {
            initDriver();
        }
        return driver;
    }

    public static void initDriver() {
        driver = new ChromeDriver();
        setProperty(properties.getProperty("WEB_DRIVER"), properties.getProperty("WEB_DRIVER_PATH"));
        driver.get(properties.getProperty("HOST"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public static void closeDriver() {
        driver.quit();
    }
}



