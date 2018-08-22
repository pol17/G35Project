package loginTests;

import libs.ExcelDriver;
import org.junit.Test;
import parentTest.ParentTest;

import java.io.IOException;
import java.util.Map;

public class LoginTestWithExcell extends ParentTest {

    @Test
    public void validLogin() throws IOException {
        ExcelDriver excelDriver = new ExcelDriver();
        Map dataForValidLogin = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogin.get("login").toString());
        loginPage.enterPass(dataForValidLogin.get("pass").toString());
        loginPage.clickOnSubmitButton();
        homePage.isAvatarPresent();

        checkAC("Avatar is not present"
                , homePage.isAvatarPresent()
                , true);
    }

    @Test
    public void invalidLogin() {
        loginPage.openPage();
        loginPage.enterLogin("invalidLogin");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();
        checkAC("Avatar is present", homePage.isAvatarPresent(), false);
        checkAC("Submit button is present", true, loginPage.isSubmitButtonPresent());
    }
}
