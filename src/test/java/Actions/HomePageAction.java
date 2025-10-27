package Actions;

import Actions.Common.BasePage;
import Actions.Common.BaseTest;
import Interface.HomePageInterface;
import org.openqa.selenium.WebDriver;

public class HomePageAction extends BasePage {
    WebDriver driver;

    public HomePageAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickOnMenu(String menu) {
        scrollIntoView(driver, HomePageInterface.HomePageMenu, menu);
        highlightElement(driver,  HomePageInterface.HomePageMenu, menu);
        SleepInSeconds(3);
        clickToElement(driver,  HomePageInterface.HomePageMenu, menu);
    }

}
