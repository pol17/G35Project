package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditSparePage extends ParentPage{
    @FindBy (name= "delete")
    private WebElement buttonDelete;
    @FindBy (id= "spares_spareName")
    private WebElement spareNameInput;
    @FindBy (name="add")
    private WebElement buttonAdd;
    @FindBy (id="spares_spareType")
    private WebElement typeOfSpareDD;
    @FindBy (xpath = ".//option[@value='4']")
    private WebElement value4;

    public EditSparePage (WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSparename(String nameOfSpare) {
        actionsWithOurElements.enterTextToElement(spareNameInput, nameOfSpare);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonAdd);
    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD (typeOfSpareDD, value);
    }
    public void MyselectSpareType() {
        actionsWithOurElements.clickOnElement(typeOfSpareDD);
        actionsWithOurElements.clickOnElement(value4);
        logger.info("my method element was selected");
}
  
