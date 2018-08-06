package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage{
    @FindBy (name = "delete")
    private WebElement buttonDelete;
    @FindBy (name ="add")
    private WebElement buttonCcreate;
    @FindBy (id = "sparse_spareName")
    private WebElement spareNameInput;
    @FindBy (tagName = "select")
    private WebElement typeOfSparesDD;


    public EditSparePage (WebDriver webDriver){
        super(webDriver, "/dictionary/spares/edit");
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareName(String nameOfSpare) {
        actionsWithOurElements.enterTextToElement(spareNameInput, nameOfSpare);
    }

    public void clckButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCcreate);

    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSparesDD, value);
    }
}
