package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    EditSparePage editSparePage;

    @FindBy (xpath = ".//*[@data-original-title='Add']")
    private WebElement buttonPlus;

    public SparesPage(WebDriver webdriver) {
        super(webdriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webdriver);
    }

    public void deletingAllSparesWithName(String nameOfSpare) {
        while (isSpareInList(nameOfSpare)){
            clickOnSpare(nameOfSpare);
            editSparePage.clickButtonDelete();
            logger.info("Spare with name "+ nameOfSpare+" was deleted");
        }
    }

    private void clickOnSpare(String nameOfSpare) {
      //  actionsWithOurElements.clickOnElement(".//*[text='"+nameOfSpare+"']");
        actionsWithOurElements.clickOnElement(".//td[contains(text(), '"+nameOfSpare+"')]");
    }

    private boolean isSpareInList(String nameOfSpare) {
    //    return actionsWithOurElements.isElementInList(".//*[text='"+nameOfSpare+"']");
        return actionsWithOurElements.isElementInList(".//td[contains(text(), '"+nameOfSpare+"')]");
    }

    public void clickOnButtonPlus() {
        actionsWithOurElements.clickOnElement(buttonPlus);
    }

    public boolean isNewSpareAdded(String nameOfSpare) {
   //     return actionsWithOurElements.isElementInList(".//*[text='"+nameOfSpare+"']");
        return actionsWithOurElements.isElementInListOnlyOne(".//td[contains(text(), '"+nameOfSpare+"')]");
    }
}
