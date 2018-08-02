package spears;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpear extends ParentTest {
    final String nameOfSpear= "joycasino";

    @Test
    public void addNewSpare(){
        loginPage.userValidLogin ("Student", "909090");

        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentPageUrl();





    }








}
