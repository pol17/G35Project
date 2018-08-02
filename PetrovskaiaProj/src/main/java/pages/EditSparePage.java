package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


public class EditSparePage extends ParentPage{
    @FindBy (name= "delete")
    private WebElement buttonDelete;
    @FindBy (id= "spares_name")
    private WebElement spareNameInput;
    @FindBy (name="add")
    private WebElement buttonAdd;
    @FindBy (name="select")
    private WebElement typeOfSpareDD;

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
}
