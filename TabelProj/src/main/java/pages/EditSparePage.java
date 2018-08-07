package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage {

    @FindBy(name = "delete")
    private WebElement buttenDelete;
    @FindBy(id = "spares_spareName")
    private WebElement spareNameImput;

    @FindBy(name = "add")
    private WebElement buttenCreate;

    @FindBy(id="spares_spareType")
    private WebElement typeOfSpareDD;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
    }

    public void clickButtonDelete() {
        actionWithOurElement.clickOnElement(buttenDelete);
    }

    public void enterSpareName(String nameOfSpare) {
        actionWithOurElement.enterTextToElement(spareNameImput, nameOfSpare);
    }

    public void clickButtonCreate() {
        actionWithOurElement.clickOnElement(buttenCreate);
    }

    public void selectSpareType(String value) {
        actionWithOurElement.selectValueInDD(typeOfSpareDD, value);
    }

//    public void clickSelect() {
//        actionWithOurElement.clickOnElement(typeOfSpareDD, value);
//    }
}
