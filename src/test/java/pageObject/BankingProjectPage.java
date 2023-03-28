package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager
public class BankingProjectPage {
    @FindBy(xpath = "//button[@ng-class=\"btnClass1\"]")
    private WebElement addCustomerButton;

    @FindBy(xpath = "//button[@ng-class=\"btnClass2\"]")
    private WebElement openAccountButton;

    @FindBy(xpath = "//button[@ng-class=\"btnClass3\"]")
    private WebElement customersButton;

    @Step("Клик по кнопке Open Account")
    public void clickOpenAccountButton(){
        openAccountButton.click();
    }
    @Step("Клик по кнопке Add Customer")
    public void clickAddCustomerButton(){
        addCustomerButton.click();
    }
    @Step("Клик по кнопке Customers")
    public void clickCustomersButton(){
        customersButton.click();
    }

    public BankingProjectPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
