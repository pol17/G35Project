package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditSparePage extends ParentPage {

    @FindBy(name = "delete")
    private WebElement buttonDelete;
    @FindBy(id = "spares_spareName")
    private WebElement spareNameInput;
    @FindBy(name = "add")
    private WebElement buttonCreate;
    @FindBy(id = "spares_spareType")   // name select
    private WebElement typeOfSparesDD;

    @FindBy(id=".//*[@id='spares_spareType']/option[4]")
    private WebElement selectTypeOfSpares;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit"  );
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareName(String nameOfSpare) {
        actionsWithOurElements.enterTextToElement(spareNameInput, nameOfSpare);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSparesDD, value);

    }

    /**
     *  method selecting spare type from dropdown clicking upon two elements
     */

    public void clickOnMenuSelecSpareType (){
        actionsWithOurElements.clickOnElement(typeOfSparesDD);
    }

    public void clickOnSpareType (){
        actionsWithOurElements.clickOnElement(selectTypeOfSpares);
    }


}


