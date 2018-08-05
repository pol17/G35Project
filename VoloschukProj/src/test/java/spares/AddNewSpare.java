package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare  extends ParentTest {
    final String nameOfSpare = "testSpareOVOL";

    @Test
    public void addNewSpare(){
        loginPage.userValidLogIn("Student", "909090");
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfSpare);
        sparesPage.clickOnButtonPlus();
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(nameOfSpare);
        editSparePage.selectSpareType("4");
        editSparePage.clickButtonCreate();
    }

}
