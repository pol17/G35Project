package spares;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    final String nameOfSpare = "pastSpare";

    @Test
    public void addNewSpare(){
        loginPage.userValidLogin("Student", "909090");
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfSpare);
        sparesPage.clickOnButtonPlus();
        editSparePage.checkCurrentUrl();


    }

}
