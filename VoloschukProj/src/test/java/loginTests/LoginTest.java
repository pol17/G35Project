package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    @Test
    public void validLogIn(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("90090");
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present", homePage.isAvatarPresent(),true);
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("9090");
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();
        checkAC("Avatar is present, but not expected", homePage.isAvatarPresent(), false);
        checkAC("Login button is not present", loginPage.isButtonLoginPresent(),true);


    }
}
