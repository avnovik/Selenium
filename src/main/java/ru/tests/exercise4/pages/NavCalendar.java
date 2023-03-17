package ru.tests.exercise4.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class NavCalendar extends BasePage {

    @FindBy(xpath = "//div[@id='ui-datepicker-div']")
    private WebElement calendar;

    @FindBy(xpath = "//div[@id='ui-datepicker-div']/div/button[contains(@class, 'current')]")
    private WebElement todayBtn;


    public void loading() {
        wait.until(ExpectedConditions.visibilityOf(calendar));
    }

    public void chooseToday() {
        todayBtn.click();
    }

    public void chooseYear(int year) {
        driver.findElement(By.xpath("//select[@class='ui-datepicker-year']//option[text()='" + year + "']")).click();
    }

    public void chooseMonth(String month) {
        driver.findElement(By.xpath("//select[@class='ui-datepicker-month']//option[text()='" + month + "']")).click();
    }

    public void chooseDay(int day) {
        driver.findElement(By.xpath("//table/tbody//tr//a[text()='" + day + "']")).click();
    }
}
