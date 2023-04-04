package tests;

import org.testng.Assert;
import org.testng.annotations.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SearchTest extends BaseTest {
    @Test
    public void searchByfNameTK1() {
        String nameSearch = "Ron";
        Boolean result = true;
        bankingProjectPage.clickCustomersButton();
        listPage.searchUser(nameSearch);
        List<String> values = new ArrayList<>();
        for (int i = 1; i < listPage.getfNameList().size(); i++) {
            values.add(listPage.getfNameList().get(i).getText());
        }
        for (int i = 0; i < values.size(); i++) {
            if (!Objects.equals(values.get(i), nameSearch)) {
                result = false;
            }
        }
        Assert.assertTrue(result, "Объект не найден");
    }

    @Test
    public void searchBylNameTK2() {
        String lNameSearch = "Weasly";
        Boolean result = true;
        bankingProjectPage.clickCustomersButton();
        listPage.searchUser(lNameSearch);
        List<String> values = new ArrayList<>();
        for (int i = 1; i < listPage.getlNameList().size(); i++) {
            values.add(listPage.getlNameList().get(i).getText());
        }
        for (int i = 0; i < values.size(); i++) {
            if (!Objects.equals(values.get(i), lNameSearch)) {
                result = false;
            }
        }
        Assert.assertTrue(result, "Объект не найден");
    }

    @Test
    public void searchByAccTestTK4() {
        String accValue = "1001";
        Boolean result = true;
        bankingProjectPage.clickCustomersButton();
        listPage.searchUser(accValue);
        List<String> values = new ArrayList<>();
        for (int i = 1; i < listPage.getAccList().size(); i++) {
            values.add(listPage.getAccList().get(i).getText());
        }
        int i = 0;
        do {
            if (!values.get(i).equals(accValue)) {
                result = true;
            }
            i++;
        }
        while (i < values.size());
        Assert.assertTrue(result, "Объект не найден");
    }
}
