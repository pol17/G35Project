package spares;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

import java.sql.Time;

public class AddNewSpare extends ParentTest {
    final String nameOfSpare = "testSpareForTestNEW!!!";

    @Test
    public void addNewSpare() {
        loginPage.userValidLogIn("Student", "909090");
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.checkCurrentUrl();
        sparesPage.deleteAllSpairsWithName(nameOfSpare);
        sparesPage.clickOnButtonPlus();
        editSparePage.checkCurrentUrl();
        editSparePage.enterSpareName(nameOfSpare);
//        editSparePage.selectSpareType("4");
        editSparePage.selectFromDDLikeUser("Прокладка-водитель");
        editSparePage.clickButtonCreate();
        sparesPage.checkCurrentUrl();

        checkAC("New spare wasn't added", sparesPage.isNewSpareAdded(nameOfSpare), true);

    }

//    @After
//    public void deleteNewSpare() {
//        sparesPage.deleteAllSpairsWithName(nameOfSpare);
//    }
}
