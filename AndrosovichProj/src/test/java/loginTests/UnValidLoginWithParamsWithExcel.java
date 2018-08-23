package loginTests;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLoginWithParamsWithExcel extends ParentTest {
    String login, pass;

    public UnValidLoginWithParamsWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
//        return Arrays.asList(new Object[][] {
//                {"Login","909090"},
//                {"Student","906090"},
//                {"Login","906090"},
//                {"Login",""},
//                {"","909090"}
//        });
  InputStream spreedSheet = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");
  return new SpreadsheetData(spreedSheet, "InvalidLogOn").getData();
    }

    @Test
    public void inValidLogin(){
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();

        checkAC("Avatar wasn't expected",
                homePage.isAvatarPresent(),
                false);
    }
}
