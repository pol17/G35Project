package loginTests;

import net.bytebuddy.implementation.bind.ParameterLengthResolver;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import parenttest.Parenttest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(Parameterized.class)

public class UnValidLoginWithParams extends Parenttest {
    String login, pass;

    public UnValidLoginWithParams (String login, String pass) {
        this.login = login;
        this.pass=pass;
    }
    @Parameterized.Parameters (name="Parameters are {0} and {1}")
    public static Collection testData() {
        return Arrays.asList(new Object[] [] {
                {"Lonig", "909090"},
                {"Student", "906090"},
        });
    }

    @Test
    public void inValidLoginWithParams () {
        loginPage.openPage();
        loginPage.enterLogin(login);
        loginPage.enterPass(pass);
        loginPage.clickOnSubmitButton();
        checkAC("Avatar wasn't expected", homePage.isAvatarPresent(),false);
    }
}
