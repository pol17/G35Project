package loginTests;

import libs.SpreadsheetData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)  //этот класс нужно запустить с разными параметрами

/*
 * Тест с разными параметрами
 */
public class UnValidLoginWithParamsWithExcel extends ParentTest {
    String login, pass;

    public UnValidLoginWithParamsWithExcel(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    /**
     * блок который будет генерить разные параметры
     */
    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() throws IOException {
//        return Arrays.asList(new Object[][]{   //Набор данных
//                {"Login", "909090"},
//                {"Student", "906090"}
//        });

        InputStream spreadsheet
                = new FileInputStream(configProperties.DATA_FILE_PATH() + "testDataSuit.xls");  // поиск пути к файлу ч/з пропертис
        return new SpreadsheetData(spreadsheet,"InvalidLogOn").getData();   //spreadsheet  - имя файла, InvalidLogOn - имя листа  и getData получи все данные
    }

    @Test
    public void inValidLogin() {
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();

        checkAC("Avatar wasn't expected", homePage.isAvatarPresent(), false);

    }
}
