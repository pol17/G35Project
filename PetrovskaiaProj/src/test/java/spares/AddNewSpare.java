package spares;

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
        }
    }