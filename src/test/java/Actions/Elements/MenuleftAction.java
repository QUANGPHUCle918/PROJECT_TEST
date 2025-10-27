package Actions.Elements;

import Actions.Common.BasePage;
import Interface.HomePageInterface;
import org.openqa.selenium.WebDriver;

public class MenuleftAction extends BasePage {
    WebDriver driver;

    public MenuleftAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMenuLeft(String menu) {
        waitForElementIsVisible(driver,HomePageInterface.ElementsMenu,menu);
        scrollIntoView(driver, HomePageInterface.ElementsMenu, menu);
        highlightElement(driver, HomePageInterface.ElementsMenu, menu);
        clickToElement(driver, HomePageInterface.ElementsMenu, menu);
    }

}
