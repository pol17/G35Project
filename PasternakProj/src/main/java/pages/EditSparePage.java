package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EditSparePage extends ParentPage{

    @FindBy(name = "delete")
    private WebElement buttonDelete;

    public EditSparePage(WebDriver webdriver) {
        super(webdriver, "/dictionary/spares/edit");
    }

    public void clickButtonDelete() {
        actionsWithOurElements.clickOnElement(buttonDelete);
    }
}
