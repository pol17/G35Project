package loginTests;

import org.junit.Assert;
import org.junit.Test;
import parentTest.ParentTest;
//clean test -Dtest=LoginTest -Dmaven.test.failure.ignore=true allure:serve
//-Dmaven.test.failure.ignore=true   - мавен закрывает глаза на феленые тесты


public class LoginTest extends ParentTest {
    @Test
    public void validLogIn() {
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();

        checkAC("Avatar is not present"
                , homePage.isAvatarPresent()
                , true);
    }

//    @Test
//    public void unValidLogIn() {
//        loginPage.openPage();
//        loginPage.enterLogin("Student");
//        loginPage.enterPass("906090");
//        loginPage.clickOnSubmitButton();
//
//        checkAC("Login box is not present",
//                loginPage.isLoginBoxMsg(),
//                true);
//        checkAC("Avatar is present",
//                homePage.isAvatarPresent(),
//                false);
//        checkAC("Button is not present",
//                homePage.isSubminButtonPresent(),
//                true);
//        //Assert.assertEquals("Url is not valid", "http://v3.test.itpmgroup.com/login",webDriver.getCurrentUrl());
//
//        checkAC("123", webDriver.getCurrentUrl()=="http://v3.test.itpmgroup.com/login", false);
//
//    }
}
