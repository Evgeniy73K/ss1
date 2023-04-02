package tests;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ListTests extends BaseTest {
    @Test
    public void sortByNameDescTestTK9_1() {
        Comparator<String> comparator = Collections.reverseOrder();
        bankingProjectPage.clickCustomersButton();
        listPage.fNameSort();
        List<String> test = listPage.getfNameList().stream().skip(1).map(WebElement::getText).collect(Collectors.toList());
        List<String> factList = new ArrayList<>(test);
        Collections.sort(test, comparator);
        Assert.assertTrue(factList.equals(test), "Неверная сортировка");
    }


    @Test
    public void sortByNameAscTestTK10() {
        bankingProjectPage.clickCustomersButton();
        listPage.fNameSort();
        listPage.fNameSort();
        List<String> test = listPage.getfNameList().stream().skip(1).map(WebElement::getText).collect(Collectors.toList());
        List<String> factList = new ArrayList<>(test);
        Collections.sort(test);
        Assert.assertTrue(factList.equals(test), "Неверная сортировка");
    }


}
