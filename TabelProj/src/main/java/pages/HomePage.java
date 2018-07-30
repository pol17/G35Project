package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends ParentPage{
    public HomePage(WebDriver webDriver) {
        super(webDriver, "/");
    }
    /**
     * Научить проверять наличие Аватар
     */
    public boolean isAvatarPresent() {
        try {
            return webDriver.findElement(
                    By.xpath(".//*[@class='pull-left image']//img[@class='img-circle']"))
                    .isDisplayed();   //есть ли аватар (показан)
        } catch (Exception e) {
            return false;
        }
    }
}
