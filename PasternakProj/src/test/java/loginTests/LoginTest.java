package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test
    public void validLogin(){
    loginPage.openPage();
    loginPage.enterLogin("Student");
    loginPage.enterPass("909090");
    loginPage.clickOnSubmitButton();
    homePage.isAvatarPresent();

    checkAC("Avatar is not present", homePage.isAvatarPresent(), false);
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.enterLogin("invalidLogin");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();

        loginPage.checkCurrentUrl();
        checkAC("Avatar is present", homePage.isAvatarPresent(), false);
        checkAC("Submit button is present", true, loginPage.isSubmitButtonPresent());
    }

}
