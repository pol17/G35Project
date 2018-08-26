package loginTests;

import libs.ConfigProperties;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLoginWithParams extends ParentTest {
    String login, pass;

    public UnValidLoginWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData(){
        return Arrays.asList(new Object[][] {
                {"Login","909090"},
                {"Student","906090"},
                {"Login","906090"},
                {"Login",""},
                {"","909090"}
        });
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
