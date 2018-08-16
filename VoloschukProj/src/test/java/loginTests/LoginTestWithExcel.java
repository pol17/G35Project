package loginTests;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithExcel extends ParentTest {
    @Test
    public void validLogIn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present", homePage.isAvatarPresent(),true);
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("9090");
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();
        checkAC("Avatar is present, but not expected", homePage.isAvatarPresent(), false);
        checkAC("Login button is not present", loginPage.isButtonLoginPresent(),true);


    }
}
