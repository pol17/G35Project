package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage  extends  ParentPage{
    @FindBy(xpath = ".//*[@class='pull-left image']//img[@class='img-circle']")
    private WebElement avatar;

    @FindBy(xpath = ".//*[@id='dictionary']/a")
    private WebElement menuDictionary;

    @FindBy(id = "spares")
    private WebElement subMenuSpare;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementDisplay(avatar);
    }
    public boolean isSubmitButtonPresent(){
        try{
            return webDriver.findElement(By.xpath(".//button[@type='submit']")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public void clickOnMenuDictionary() {
        actionsWithOurElements.clickOnElement(menuDictionary);
    }
    public void clickOnSubMenuSpares(){
        actionsWithOurElements.clickOnElement(subMenuSpare);
    }
}
