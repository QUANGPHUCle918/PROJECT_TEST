package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.ButtonsInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class ButtonsAction extends BasePage {
    private WebDriver driver;

    public ButtonsAction(WebDriver driver) {
        this.driver = driver;
    }

    public void doubleClickButton() {
        Log.info("Thực hiện double click vào nút 'Double Click Me'");
        waitForElementIsVisible(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        WebElement button = getElement(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        highlightElement(driver, ButtonsInterface.DOUBLE_CLICK_BUTTON);
        Actions actions = new Actions(driver);
        actions.doubleClick(button).perform();
        sleepInSecond((long) 1.5);
    }


    public String getDoubleClickMessage() {
        waitForElementIsVisible(driver, ButtonsInterface.DOUBLE_CLICK_MESSAGE);
        highlightElement(driver, ButtonsInterface.DOUBLE_CLICK_MESSAGE);

        return getElement(driver, ButtonsInterface.DOUBLE_CLICK_MESSAGE).getText().trim();
    }
}
