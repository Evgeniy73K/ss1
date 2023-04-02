package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

// page_url = https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/addCust
public class AddCustPage {
    @FindBy(xpath = "//input[@ng-model=\"fName\"]")
    private WebElement fNameField;

    @FindBy(xpath = "//input[@ng-model=\"lName\"]")
    private WebElement lNameField;

    @FindBy(xpath = "//input[@ng-model=\"postCd\"]")
    private WebElement postCodeField;

    @FindBy(xpath = "//button[@ng-class=\"btnClass3\"]")
    private WebElement customersButton;
    @FindBy(css = ".btn.btn-default")
    private WebElement addCustomerFormButton;

    @Step("Заполнение формы")
    public void typeForm(
            String name,
            String lastName,
            String postCode
    ){
        fNameField.sendKeys(name);
        lNameField.sendKeys(lastName);
        postCodeField.sendKeys(postCode);
    }
    @Step("Отправить форму")
    public void sendForm(){
        addCustomerFormButton.click();
    }

    public AddCustPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }


}
