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
        Map dataForValidLogIn = excelDriver.getData(configProperties.DATA_FILE(), "validLogOn");
        loginPage.openPage();
        loginPage.enterLogin(dataForValidLogIn.get("login").toString());
        loginPage.enterPass(dataForValidLogIn.get("pass").toString());
        loginPage.clickOnSubmitButton();

        checkAC("Avatar is not present"
                , homePage.isAvatarPresent()
                , true);
    }

}