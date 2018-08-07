package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    @FindBy (xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
    }
    EditSparePage editSparePage= new EditSparePage(webDriver);

    public void deletingAllSparesWithName(String nameOfSpare) {
        while (isSpareInList (nameOfSpare)) {
            clickOnSpare (nameOfSpare) ;
            editSparePage.clickButtonDelete();
            logger.info("Spare with name" + nameOfSpare + " was deleted");
        }
    }

    private void clickOnSpare(String nameOfSpare) {
        actionsWithOurElements.clickOnElement(".//*[text()='" + nameOfSpare + "']");
    }

    private boolean isSpareInList(String nameOfSpare) {
        return actionsWithOurElements.isElementInList (".//*[text()='" + nameOfSpare + "']");
    }

    public void clickOnButtonPlus() {
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    //public boolean isNewSpareAdded(String nameOfSpare) {
        //return
    }
