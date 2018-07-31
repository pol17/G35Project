package loginTests;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    @Test
    public void validLogin () {
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present", homePage.isAvatarPresent(),true );

    }

    @Test
    public void invalidLogin () {
        loginPage.openPage();
        loginPage.enterLogin("Stydent");
        loginPage.enterPass("909099");
        loginPage.clickOnSubmitButton();
       // Assert.assertTrue("Login Page was opened", loginPage.checkCurrentUrl()); //"Login Page was opened"
        checkAC("Button is present", loginPage.isButtonPresent(),true); //try add button verification
        checkAC("Avatar is not present", homePage.isAvatarPresent(),false );
        checkAC("Login Page is displayed", loginPage.isLoginPageDisplayed(),true);



    }


}
