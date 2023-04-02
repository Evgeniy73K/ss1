package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import pageObject.AddCustPage;
import pageObject.BankingProjectPage;
import pageObject.ListPage;


import java.time.Duration;

public class AddCustomerTests extends BaseTest {

    @Test
    public void validAddCustomerTestTK5() {
        bankingProjectPage.clickAddCustomerButton();
        addCustPage.typeForm("Test",
                "Test",
                "123456");
        addCustPage.sendForm();
        Alert alert = driver.switchTo().alert();
        String alertText = alert.getText();
        Assert.assertTrue(alertText.contains("Customer added successfully with customer id"), "Сообщение не соответствует ожидаемому результату");
        alert.accept();
    }

    @Test
    public void emptyFnameFieldTestTK6() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bankingProjectPage.clickAddCustomerButton();
        addCustPage.typeForm("",
                "Test",
                "123456");
        addCustPage.sendForm();
        boolean alertNotPresent = false;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            alertNotPresent = true;
        }
        Assert.assertTrue(alertNotPresent);
    }

    @Test
    public void emptyLnameFieldTestTK7() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bankingProjectPage.clickAddCustomerButton();
        addCustPage.typeForm("Test",
                "",
                "123456");
        addCustPage.sendForm();
        boolean alertNotPresent = false;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            alertNotPresent = true;
        }
        Assert.assertTrue(alertNotPresent);
    }

    @Test
    public void emptyAllFieldsTestTK8() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        bankingProjectPage.clickAddCustomerButton();
        addCustPage.typeForm("",
                "",
                "");
        addCustPage.sendForm();
        boolean alertNotPresent = false;
        try {
            wait.until(ExpectedConditions.alertIsPresent());
        } catch (TimeoutException e) {
            alertNotPresent = true;
        }
        Assert.assertTrue(alertNotPresent);
    }
}
