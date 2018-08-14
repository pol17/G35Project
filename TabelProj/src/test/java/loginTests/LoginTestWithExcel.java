package loginTests;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;


public class LoginTestWithExcel extends ParentTest {
    @Test
    public void validLogIn() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();//вынести в перент тест
        Map dataForValidLogIn = excelDriver.getData(configProperties.DATA_FILE(),"validLogOn");

        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogIn.get("login").toString());
        loginPage.enterPass(dataForValidLogIn.get("pass").toString());
        loginPage.clickOnSubmitButton();

        checkAC("Avatar is not present"
                , homePage.isAvatarPresent()
                , true);
    }





//    @Test
//    public void unValidLogIn() {
//        loginPage.openPage();
//        loginPage.enterLogin("Student");
//        loginPage.enterPass("906090");
//        loginPage.clickOnSubmitButton();
//
//        checkAC("Login box is not present",
//                loginPage.isLoginBoxMsg(),
//                true);
//        checkAC("Avatar is present",
//                homePage.isAvatarPresent(),
//                false);
//        checkAC("Button is not present",
//                homePage.isSubminButtonPresent(),
//                true);
//        //Assert.assertEquals("Url is not valid", "http://v3.test.itpmgroup.com/login",webDriver.getCurrentUrl());
//
//        checkAC("123", webDriver.getCurrentUrl()=="http://v3.test.itpmgroup.com/login", false);
//
//    }
}
