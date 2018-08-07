package spares;

import org.junit.After;
import org.junit.Test;
import parenttest.Parenttest;

public class AddNewSpare extends Parenttest {
    final String nameOfSpare = "PetrovskaSpare";

    @Test
    public void addNewSpare() {
        loginPage.userValidLogin("Student", "909090");
        homePage.clickOnMenuDictionary ();
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
        editSparePage.enterSparename (nameOfSpare);
        editSparePage.selectSpareType ("4");
        editSparePage.clickButtonCreate();
        sparesPage.checkCurrentUrl();
        checkAC("New spare wasn't added", sparesPage.isNewSpareAdded(nameOfSpare),true);
        }
        @After
    public void deletingNewSpare () {
        sparesPage.deletingAllSparesWithName(nameOfSpare);
        }
    }