package Actions.Elements;

import Actions.Common.BasePage;
import Interface.Elements.RadioButtonInterface;
import org.openqa.selenium.WebDriver;

import static Interface.Elements.RadioButtonInterface.OUTPUT_TEXT;
import static Interface.Elements.RadioButtonInterface.Radio_NO;

public class RadioButtonAction extends BasePage  {
    private WebDriver driver;

    public RadioButtonAction(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isNoRadioDisabled() {
        // Lấy giá trị thuộc tính "disabled" của radio button "No"
        String isDisabled = getElementAttributeValue(driver, Radio_NO, "disabled");
        return isDisabled != null; // Nếu có attribute disabled -> true
    }

    public String getResult() {
        waitForElementIsVisible(driver, OUTPUT_TEXT);
        String outputResult = getTextElement(driver, OUTPUT_TEXT);
        return outputResult.trim();
    }
}
