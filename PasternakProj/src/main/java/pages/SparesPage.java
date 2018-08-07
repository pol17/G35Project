package pages;

import org.openqa.selenium.WebDriver;

public class SparesPage extends ParentPage {
    EditSparePage editSparePage;
    public SparesPage(WebDriver webdriver) {
        super(webdriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webdriver);
    }

    public void deletingAllSparesWithName(String nameOfSpare) {
        while (isSpareInList(nameOfSpare)){
            clickOnSpare(nameOfSpare);
            EditSparePage.clickButtonDelete();
            logger.info("Spare with name " + nameOfSpare + " was deleted");

        }
    }

    private void clickOnSpare(String nameOfSpare) {
        actionsWithOurElements.clickOnElement(".//*[text='" + nameOfSpare + "']");
    }

    private boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElements.isElementInList(".//*[text='" + nameOfSpare + "']");
    }
}
