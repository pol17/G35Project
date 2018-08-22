package sparse;

import org.junit.After;
import org.junit.Test;
import parentTest.ParentTest;

public class AddNewSpare extends ParentTest {
    final String nameOfSpare = "testTabel153";

    @Test
    public void addNewSpare() {
        loginPage.userValidLogIn("Student", "909090");
        homePage.clickOnMenuDictionary();
        //явное ожидание (Когда появится єлемент в нужном состоянии)

        // задержка   (замерание на указанное время) Thread - поток . метод sleep (2000) 2 сек
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        homePage.clickOnSubMenuSpares();
        sparesPage.cheekCurrentUrl();  //проверка что мы попали на нужную страницу (проверка url)
        sparesPage.deletingAllSparesWithName(nameOfSpare);  //удалили запчасть
        sparesPage.clickOnButtonPlus();
        editSparePage.cheekCurrentUrl();
        editSparePage.enterSpareName(nameOfSpare);
        editSparePage.selectSpareType("4");
        editSparePage.clickButtonCreate();
        sparesPage.cheekCurrentUrl();

        checkAC("New spare wasn't added",
                sparesPage.isNewSpareAdded(nameOfSpare),
                true);
    }

    @After
    public void deletingNewSpare() {
        sparesPage.deletingAllSparesWithName(nameOfSpare);
    }

}


