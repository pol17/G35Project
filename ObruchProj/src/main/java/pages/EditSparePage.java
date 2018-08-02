package pages;

import org.openqa.selenium.By;
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
    private WebElement typeOfSparesDD;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void clickButtonDelete() {
        actionWithOurElements.clickOnElement(buttonDelete);
    }

    public void enterSpareName(String nameOfSpare) {
        actionWithOurElements.enterTextToElement(spareNameInput, nameOfSpare);
    }

    public void clickButtonCreate() {
        actionWithOurElements.clickOnElement(buttonCreate);
    }

    public void selectSpareType(String value) {
        actionWithOurElements.selectValueInDD(typeOfSparesDD, value);
    }
}
