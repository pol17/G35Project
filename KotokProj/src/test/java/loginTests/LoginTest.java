package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {

    @Test
    public void validLogIn() {
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();

        checkAcceptanceCriteria("Avatar is not present", homePage.isAvatarPresent(), true);

    }

    @Test
    public  void invalidLogin() {
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
