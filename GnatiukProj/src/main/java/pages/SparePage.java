package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparePage extends ParentPage {
    EditSparePage editSparePage;
    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    public SparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }

    public void deletingAllSparesWithName(String nameOfSpare) {
        while (isSpareInList(nameOfSpare)) {
            clickOnSpare(nameOfSpare);
            editSparePage.clickButtonDelete();
            logger.info("Spare with name " + nameOfSpare + " was deleted");
        }
    }

    private void clickOnSpare(String nameOfSpare) {
        actionsWithOurElements.clickOnElement(".//[text()='" + nameOfSpare + "']");
    }

    private boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElements.isElementInList(".//[text()='" + nameOfSpare + "']");
    }

    public void clickOnButtonPlus() {
        actionsWithOurElements.clickOnElement(buttonPlus);
    }
}
