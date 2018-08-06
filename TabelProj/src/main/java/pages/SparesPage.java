package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    EditSparePage editSparePage;

    @FindBy(xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);
    }

    public void deletingAllSparesWithName(String nameOfSpare) {
        while (isSpereInList(nameOfSpare)) {
            clickOnSpare(nameOfSpare);
            editSparePage.clickButtonDelete();
            logger.info("Spare with name " + nameOfSpare + " was deleted");
        }
    }

    private void clickOnSpare(String nameOfSpare) {
        actionWithOurElement.clickOnElement(".//*[text()='" + nameOfSpare + "']");
    }

    private boolean isSpereInList(String nameOfSpare) {
        return actionWithOurElement.isElementInList(".//*[text()='" + nameOfSpare + "']");
    }

    public void clickOnButtonPlus() {
        actionWithOurElement.clickOnElement(buttonPlus);
    }
}
