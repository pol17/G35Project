package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    EditSparePage editSparePage;

    @FindBy(css = ".btn.btn-info.btn-sm")
    private WebElement buttonPlus;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }

    public void deleteAllSpairsWithName(String nameOfSpare) {
        while (isSpareInList(nameOfSpare)){
            clickOnSpare(nameOfSpare);
            editSparePage.clickButtonDelete();
            logger.info("Spare with name " + nameOfSpare +" was deleted");
        }
    }

    private void clickOnSpare(String nameOfSpare) {
        actionWithOurElements.clickOnElement(".//*[text()='" + nameOfSpare + "']");
    }

    private boolean isSpareInList(String nameOfSpare) {
        return actionWithOurElements.isElementInList(".//*[text()='" + nameOfSpare + "']");
    }

    public void clickOnButtonPlus() {
        actionWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isNewSpareAdded(String nameOfSpare) {
        //TODO ADD validation that only 1 element in list
//        if (webDriver.findElements(By))
        try {
            return this.isSpareInList(nameOfSpare);
        } catch (Exception e) {
            logger.error("New spare " + nameOfSpare + " was NOT added");
            return false;
        }

    }
}
