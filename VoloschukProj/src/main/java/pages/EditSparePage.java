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

    public EditSparePage(WebDriver webdriver) {
        super(webdriver, "/dictionary/spares/edit");
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

    public void clickSpareType(Integer numberOfSpareTypeInDD) {
        actionsWithOurElements.clickValueInDD(typeOfSparesDD,
                webDriver.findElement(By.xpath(".//select[@id='spares_spareType']//option[@value='" + numberOfSpareTypeInDD + "']")));
    }
}
