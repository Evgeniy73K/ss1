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

public class SearchTest extends BaseTest{

    @Test
    public void searchByfName(){
        String nameSearch = "Ron";
        Boolean result = true;
        bankingProjectPage.clickCustomersButton();
        listPage.searchUser(nameSearch);
        List<String> values = new ArrayList<>();
        for (int i = 1; i < listPage.getfNameList().size(); i++){
            values.add(listPage.getfNameList().get(i).getText());
        }
        for (int i = 0; i<values.size(); i++){
            if(!Objects.equals(values.get(i), nameSearch)){
                result = false;
            }
        }
        Assert.assertTrue(result, "Объект не найден");
    }

    @Test
    public void searchBylName(){
        String lNameSearch = "Weasly";
        Boolean result = true;
        bankingProjectPage.clickCustomersButton();
        listPage.searchUser(lNameSearch);
        List<String> values = new ArrayList<>();
        for (int i = 1; i < listPage.getlNameList().size(); i++){
            values.add(listPage.getlNameList().get(i).getText());
        }
        for (int i = 0; i<values.size(); i++){
            if(!Objects.equals(values.get(i), lNameSearch)){
                result = false;
            }
        }
        Assert.assertTrue(result, "Объект не найден");
    }

    @Test
    public void searchByAccTest(){
        String accValue = "1007 1008 1009";
        Boolean result = true;
        bankingProjectPage.clickCustomersButton();
        listPage.searchUser(accValue);
        List<String> values = new ArrayList<>();
        for (int i = 1; i < listPage.getAccList().size(); i++){
            values.add(listPage.getAccList().get(i).getText());
        }
        int i = 0;
        do {
            if (!values.get(i).equals(accValue)) {
                result = false;
            }
            i++;}
            while (i < values.size());
        Assert.assertTrue(result, "Объект не найден");
    }

}
