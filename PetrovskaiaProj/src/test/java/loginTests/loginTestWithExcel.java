package loginTests;

import libs.ExcelDriver;
import org.junit.Assert;
import org.junit.Test;
import parenttest.Parenttest;

import java.io.IOException;
import java.util.Map;

public class loginTestWithExcel extends Parenttest {
    @Test
    public void validLogin () throws IOException {
        ExcelDriver excelDriver=new ExcelDriver();
        Map dataForValidLogin=excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present",
                homePage.isAvatarPresent(),
                true);
    }
    @Test
    public void invalidLogin () {
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("12345");
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();
        Assert.assertEquals("Url is not expected","http://v3.test.itpmgroup.com/login",webDriver.getCurrentUrl());
    }
}
