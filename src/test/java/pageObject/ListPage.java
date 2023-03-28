package pageObject;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

// page_url = https://www.globalsqa.com/angularJs-protractor/BankingProject/#/manager/list
public class ListPage {
    @FindBy(xpath = "//input[@ng-model=\"searchCustomer\"]")
    private WebElement searchInput;

    @FindBy(xpath = "//a[@ng-click=\"sortType = 'fName'; sortReverse = !sortReverse\"]")
    private WebElement fNameSort;

    @FindBy(xpath = "//a[@ng-click=\"sortType = 'lName'; sortReverse = !sortReverse\"]")
    private WebElement lNameSort;
    @FindBy(xpath = "//a[@ng-click=\"sortType = ''postCd''; sortReverse = !sortReverse\"]")
    private WebElement postCdSort;
    @FindBy(xpath = "//tr//td[1]")
    private List<WebElement> fNameList;
    @FindBy(xpath = "//tr//td[2]")
    private List<WebElement> lNameList;
    @FindBy(xpath = "//tr//td[3]")
    private List<WebElement> psCodeList;
    @FindBy(xpath = "//tr//td[4]")
    private List<WebElement> accList;

    public List<WebElement> getfNameList() {
        return fNameList;
    }

    public List<WebElement> getlNameList() {
        return lNameList;
    }

    public List<WebElement> getPsCodeList() {
        return psCodeList;
    }

    public List<WebElement> getAccList() {
        return accList;
    }

    public WebElement getlNameSort() {
        return lNameSort;
    }

    @Step("Сортировка по First Name")
    public void fNameSort(){
        fNameSort.click();
    }
    @Step("Сортировка по Last Name")
    public void lNameSort(){
        lNameSort.click();
    }
    @Step("Сортировка по Post Code")
    public void postCodeSort(){
        postCdSort.click();
    }

    public void searchUser(String value){
        searchInput.sendKeys(value);
    }



    public ListPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }
}
