package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.RadioButtonInterface;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static Interface.Elements.RadioButtonInterface.OUTPUT_TEXT;
import static Interface.Elements.RadioButtonInterface.RADIO_NO;

public class RadioButtonAction extends BasePage {
    private WebDriver driver;

    public RadioButtonAction(WebDriver driver) {
        this.driver = driver;
    }
    public void openButtonsPage() {
        Log.info("Mở menu Elements > Buttons");
//        homePage.clickOnMenu("Elements");
//        menuLeft.clickOnMenuLeft("Buttons");
    }


    public boolean isNoRadioDisabled() {

        Log.info("Check button No co bat khong!");
        waitForElementPresent(driver, RADIO_NO);
        WebElement input = driver.findElement(getXpath(RADIO_NO));

        String disabledAttr = input.getAttribute("disabled");
        boolean enabled = input.isEnabled();

        boolean isDisabled = (disabledAttr != null) || !enabled;
        Log.info("'No' disabled = " + isDisabled);
        return isDisabled;

    }
    public String getResult() {
        Log.info("Lấy kết quả hiển thị sau khi chọn radio button...");
        waitForElementPresent(driver, OUTPUT_TEXT);
        WebElement resultElement = driver.findElement(getXpath(OUTPUT_TEXT));

        if (resultElement.isDisplayed()) {
            String result = resultElement.getText().trim();
            Log.info("Kết quả: " + result);
            return result;
        } else {
            Log.info("Không có kết quả hiển thị!");
            return "";
        }
    }
}
