package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {
    @FindBy(name= "delete")
    private WebElement buttonDelete;
    @FindBy( id="spares_spareName")
    private WebElement spareNameInput;
    @FindBy (name ="add")
    private WebElement buttonCreate;
    @FindBy (tagName = "select")
    private WebElement typeOfSparesDropDown;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");

    }


    public void clickButtonDelete() {
        actionsWithElements.clickOnElement(buttonDelete);

    }

    public void enterSpareName(String nameOfSpear) {
        actionsWithElements.enterTextToElement(spareNameInput,nameOfSpear);

    }

    public void clickButtonCreate() {
        actionsWithElements.clickOnElement(buttonCreate);
    }

    public void selectSpareType(String value) {
        actionsWithElements.selectValueDropDown(typeOfSparesDropDown, value);

    }
}
