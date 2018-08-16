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
//    @FindBy(xpath = ".//select/option[@value=4]") //Не понял как передать сюда номер строки селекта :(
    private WebElement typeOfSpareValue;

    public EditSparePage(WebDriver webDriver) {
        super(webDriver, "/dictionary/spares/edit");
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

    public void selectSpareTypeByClick(String value) {
        actionsWithOurElements.clickOnElement(typeOfSparesDD);
//        actionsWithOurElements.clickOnElement(".//select/option[@value='" + value + "']");
        actionsWithOurElements.clickOnElement(typeOfSpareValue.findElement(
                By.xpath(String.format(".//select/option[@value=%s]", value))));
    }
}
