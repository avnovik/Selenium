package ru.tests.exercise2.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.tests.exercise2.managers.DriverManager;

import java.time.Duration;

import static org.openqa.selenium.support.PageFactory.initElements;

public class BasePage {

    @FindBy(xpath = "//div[@class='loader-mask shown']")
    private WebElement loadingIcon;

    protected static WebDriver driver = DriverManager.getWebDriver();
    protected WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10), Duration.ofSeconds(2));

    public BasePage() {
        initElements(driver, this);
    }

    public void waitingForLoading() {
        wait.until(ExpectedConditions.invisibilityOf(loadingIcon));
    }
}
