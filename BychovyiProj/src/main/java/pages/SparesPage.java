package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    EditSparePage editSparePage;

    @FindBy (xpath = ".//*[@data-original-title='Add]")
    private WebElement buttonPlus;

    public SparesPage(WebDriver webDriver) {

        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }

    public void deletingAllSparesWithName(String nameOfSpare) {
        while (isSpareInList(nameOfSpare)) {
            clicOnSpare(nameOfSpare);
            editSparePage.clickButtonDelete();
            logger.info("Spare withe name " + nameOfSpare + " was deleted");

        }

    }

    private void clicOnSpare(String nameOfSpare) {
        actionsWithOurElements.clickOnElement( nameOfSpare);
    }

    private boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElements.isElementInList(".//*[text()='" + nameOfSpare + "']");
    }

    public void clickOnButtonPlus() {
        actionsWithOurElements.clickOnElement(buttonPlus);
    }
}