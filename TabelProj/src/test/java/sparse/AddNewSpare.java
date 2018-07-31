package sparse;

import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    final  String nameOfSpare = "testTabel153";

    @Test
    public void addNewSpare(){
        loginPage.userValidLogIn("Student","909090");
        homePage.clickOnMenuDictionary();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.cheekCurrentUrl();  //проверка что мы попали на нужную страницу (проверка url)

    }

}
