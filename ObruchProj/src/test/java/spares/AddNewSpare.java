package spares;

import org.junit.Test;
import parentTest.ParentTest;

import java.sql.Time;

public class AddNewSpare extends ParentTest {
    final String nameOfSpare = "testSpareForTest";

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
    }
}
