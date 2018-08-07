package spears;

import org.junit.After;
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

        sparesPage.delatingAllSparesWithName(nameOfSpear);
        sparesPage.clickOnButtonPlus();
        editSparePage.checkCurrentPageUrl();
        editSparePage.enterSpareName(nameOfSpear);
        editSparePage.selectSpareType("4");
        editSparePage.clickButtonCreate();
        sparesPage.checkCurrentPageUrl();
        checkAcceptanceCriteria("New spare wasn't added",
                sparesPage.isNewSpareAdded(nameOfSpear),
                true);







    }


@After
    public void deletingNewSpare(){
        sparesPage.delatingAllSparesWithName(nameOfSpear);
    }





}
