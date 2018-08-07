package spares;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    final String nameOfSpare = "pastSpare";

    @Test
    public void addNewSpare() {
        loginPage.userValidLogin("Student", "909090");
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(20000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deletingAllSparesWithName(nameOfSpare); //TODO не отрабатывает
        sparesPage.clickOnButtonPlus();
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(nameOfSpare);
        editSparePage.selectSpareType("4");
        editSparePage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New spare wasn't added", sparesPage.isNewspareAdded(nameOfSpare), true);
    }
    @After
    public void deletingNewSpare(){
        sparesPage.deletingAllSparesWithName(nameOfSpare);
    }

}
