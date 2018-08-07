package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    @Test
    public void  validLogin(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();

        checkAC("Avatar is not present" , homePage.isAvatarPresent(), true);

    }
    @Test
    public void  inValidLogin(){
        loginPage.openPage();
        loginPage.enterLogin("Invalidlogin");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();
        loginPage.checkCurrentUrl();


        checkAC("Avatar is not present" , homePage.isAvatarPresent(), false);
        checkAC("Submit button is not present", homePage.isSubmitButtonPresent(), true);

    }

}
