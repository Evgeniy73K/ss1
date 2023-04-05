package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pageObject.AddCustPage;
import pageObject.BankingProjectPage;
import pageObject.ListPage;

import java.time.Duration;

public class BaseTest {
    protected WebDriver driver;
    protected AddCustPage addCustPage;
    protected BankingProjectPage bankingProjectPage;
    protected ListPage listPage;

    public void setUp() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        String driverPath = System.getProperty("driver") + "/chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
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



