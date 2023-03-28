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
import java.util.*;

public class BaseTest {
    protected WebDriver driver;
    protected AddCustPage addCustPage;
    protected BankingProjectPage bankingProjectPage;
    protected ListPage listPage;

    @BeforeMethod
    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.get("https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager");

        addCustPage = new AddCustPage(driver);
        bankingProjectPage = new BankingProjectPage(driver);
        listPage = new ListPage(driver);


    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


}



