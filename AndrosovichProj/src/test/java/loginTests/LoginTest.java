package loginTests;

import org.junit.Test;
import parentTest.ParentTest;

public class LoginTest extends ParentTest {
    @Test
    public void validLogIn(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();

        checkAC("Avatar is not present"
                , homePage.isAvatarPresent()
                , true);
        }

    @Test
    public void unValidLogIn(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("906090");
        loginPage.clickOnSubmitButton();

        loginPage.checkCurrentUrl();

        checkAC("Avatar is present"
                , !homePage.isAvatarPresent()
                , true);
        checkAC("Button Submit is not present"
                , loginPage.isButtonSubmitPresent()
                , true);
    }
}
