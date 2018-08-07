package loginTests;

import org.junit.Assert;
import org.junit.Test;
import parenttest.Parenttest;

public class loginTest extends Parenttest {
    @Test
    public void validLogin () {
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("909090");
        loginPage.clickOnSubmitButton();
        checkAC("Avatar is not present",
                homePage.isAvatarPresent(),
                true);
    }
    @Test
    public void invalidLogin () {
        loginPage.openPage();
        loginPage.enterLogin("Student");
        loginPage.enterPass("12345");
        loginPage.clickOnSubmitButton();
loginPage.checkCurrentUrl();
        Assert.assertEquals("Url is not expected","http://v3.test.itpmgroup.com/login",webDriver.getCurrentUrl());
    }
}
