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
    @FindBy(tagName = "select")
    private WebElement typeOfSpareDD;

    public EditSparePage(WebDriver webDriver){
        super(webDriver, "/dictionary/spares/edit");
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareName(String nameOfSpare) {
        actionsWithOurElements.enterTextToElement(spareNameInput,nameOfSpare);
    }

    public void clickButtonCreate() {
        actionsWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareType(String value) {
        actionsWithOurElements.selectValueInDD(typeOfSpareDD, value);
    }
}
