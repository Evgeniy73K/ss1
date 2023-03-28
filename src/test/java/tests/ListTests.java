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
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListTests extends BaseTest{

    @Test
    public void sortByNameDescTestTK9(){
        Comparator<String> comparator = Collections.reverseOrder();
        bankingProjectPage.clickCustomersButton();
        listPage.fNameSort();
        List<String> test = new ArrayList<>();
        for(int i = 1; i < listPage.getfNameList().size(); i++){
            test.add(listPage.getfNameList().get(i).getText());
        }
        List<String> factList = new ArrayList<>(test);
        Collections.sort(test, comparator);
        Assert.assertTrue(factList.equals(test), "Неверная сортировка");
    }

    @Test
    public void sortByNameAscTestTK10(){
        bankingProjectPage.clickCustomersButton();
        listPage.fNameSort();
        listPage.fNameSort();
        List<String> test = new ArrayList<>();
        for(int i = 1; i < listPage.getfNameList().size(); i++){
            test.add(listPage.getfNameList().get(i).getText());
        }
        List<String> factList = new ArrayList<>(test);
        Collections.sort(test);
        Assert.assertTrue(factList.equals(test), "Неверная сортировка");
    }


}
