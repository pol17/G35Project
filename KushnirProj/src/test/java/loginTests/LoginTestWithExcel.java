package loginTests;


import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithExcel extends ParentTest {
    @Test
    public void validLogin () throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present", homePage.isAvatarPresent(),true );

    }

    @Test
    public void invalidLogin () {
        loginPage.openPage();
        loginPage.enterLogin("Stydent");
        loginPage.enterPass("909099");
        loginPage.clickOnSubmitButton();
       // Assert.assertTrue("Login Page was opened", loginPage.checkCurrentUrl()); //"Login Page was opened"
        checkAC("Button is present", loginPage.isButtonPresent(),true); //try add button verification
        checkAC("Avatar is not present", homePage.isAvatarPresent(),false );
        checkAC("Login Page is displayed", loginPage.isLoginPageDisplayed(),true);



    }


}
