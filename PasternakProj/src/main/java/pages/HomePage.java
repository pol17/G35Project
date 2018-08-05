package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends ParentPage {
    @FindBy(xpath = ".//*[@alt='Student'and @class='user-image']")
    private WebElement avatar;

    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }

    public boolean isAvatarPresent() {
        return actionsWithOurElements.isElementDisplay(avatar);
    }

    public boolean isSubmitButtonPresent() {
        try {
            return webDriver.findElement(
                    By.xpath(".//button[@type='submit']"))
                    .isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
}
