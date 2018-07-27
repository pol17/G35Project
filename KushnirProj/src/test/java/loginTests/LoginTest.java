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


}
