package loginTests;

import org.junit.Assert;
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

    checkAC("Avatar is not present", homePage.isAvatarPresent(), true);
    }

    @Test
    public void invalidLogin(){
        loginPage.openPage();
        loginPage.enterLogin("invalidLogin");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();
        Assert.assertEquals(
                "Url is not expected","http://v3.test.itpmgroup.com/login",
                webDriver.getCurrentUrl());
        checkAC("Avatar is present", homePage.isAvatarPresent(), false);
        checkAC("Submit button is present", true, homePage.isSubmitButtonPresent());

        //этот тест кликает SubmitButton 15 секунд, из-за implicitlyWait. Как это можно отменить?
    }

}
