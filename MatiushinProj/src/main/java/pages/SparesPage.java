package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SparesPage extends ParentPage {
    EditSparePage editSparePage;
    @FindBy (xpath =".//*[@data-original-title='Add']" )
    private WebElement buttonPlus;

    public SparesPage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares");
        editSparePage = new EditSparePage(webDriver);



    }

    public void delatingAllSparesWithName(String nameOfSpear) {
        while (isSpearInList(nameOfSpear)){
            clickOnSpare(nameOfSpear);
            editSparePage.clickButtonDelete();
            logger.info("Spare with name " +nameOfSpear + "was deleted");




        }

    }

    private void clickOnSpare(String nameOfSpear) {
        actionsWithElements.clickOnElement(".//*[text()='" + nameOfSpear + "']");
    }

    private boolean isSpearInList(String nameOfSpear) {
        return actionsWithElements.isElementInList(".//*[text()='" + nameOfSpear + "']");
    }

    public void clickOnButtonPlus() {
        actionsWithElements.clickOnElement(buttonPlus);

    }

 //   public boolean isNewSpareAdded(String nameOfSpear) {


//    }

}
