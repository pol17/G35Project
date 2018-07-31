package loginTests;


import org.junit.Test;
import parentTest.ParentTest;

public class LoginPage  extends ParentTest{
    @Test
    public void validLogin(){
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();



        homePage.isAvatarPresent();

        checkAcceptanceCriteria("Avatar is not present ",
                homePage.isAvatarPresent(),
                true);

    }


    @Test
    public void invalidLogin(){

        loginPage.openPage();
        loginPage.enterLogin("Student");//valid login
        loginPage.enterPass("wrongPass");
        loginPage.clickOnSubmitButton();

        checkAcceptanceCriteria("Something goes wrong, avatar present, but should not",
                homePage.isAvatarPresent(),
                false);
        checkAcceptanceCriteria("Submit button is not present",
                loginPage.isSubmitButtonPresent(),true);


    }
}

