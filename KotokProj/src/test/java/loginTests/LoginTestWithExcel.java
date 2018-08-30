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
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnSubmitButton();

        checkAcceptanceCriteria("Avatar is not present", homePage.isAvatarPresent(), true);

    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();
        loginPage.enterLogin("Email");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();
//        loginPage.isButtonPresent();
//
        checkAcceptanceCriteria("Avatar is present", homePage.isAvatarPresent(), false);
        checkAcceptanceCriteria("Login button is absent", loginPage.isLoginButtonpresent(), true);
    }


}
