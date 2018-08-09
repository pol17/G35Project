package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {

    @FindBy(xpath = ".//*[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpares;

    @FindBy(tagName = "button")
    private WebElement subbutton;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    /**
     * Научить проверять наличие Аватар
     */
    public boolean isAvatarPresent() {
        return actionWithOurElement.isElementDisplay(avatar);
//        try {
//            return webDriver.findElement(
//                    By.xpath(".//*[@class='pull-left image']//img[@class='img-circle']"))
//                    .isDisplayed();   //есть ли на страничке аватар (показан)
//        } catch (Exception e) {
//            return false;
//        }
    }

    public boolean isSubminButtonPresent() {
        return actionWithOurElement.isElementDisplay(subbutton);
    }

    public void clickOnMenuDictionary() {
        actionWithOurElement.clickOnElement(menuDictionary);
    }

    public void clickOnSubMenuSpares() {
        actionWithOurElement.clickOnElement(subMenuSpares);
    }
}
