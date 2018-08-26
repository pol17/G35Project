package loginTests;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parentTest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)
public class UnValidLogInWithParams extends ParentTest {
    String login , pass;

    public UnValidLogInWithParams(String login, String pass) {
        this.login = login;
        this.pass = pass;
    }

    @Parameterized.Parameters(name = "Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[] []  {
                {"Login", "909090"},
                {"Student", "906090"}
        } );
    }


    @Test
    public void inValidLogIn(){
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();

        checkAC("Avatar wasn't expected", homePage.isAvatarPresent(), false);

    }
}
