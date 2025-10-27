package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.AlertsInterface;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;

import static Interface.Elements.AlertsInterface.SIMPLE_ALERT_BUTTON;

public class AlertsAction extends BasePage  {
    private WebDriver driver;

    public AlertsAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickSimpleAlert() {
        Log.info("Click 'Click me' để mở alert đơn giản");
        clickToElement(driver, SIMPLE_ALERT_BUTTON);
        sleepInSecond(1);
    }
    public void acceptAlert() {
        try {
            Alert alert = driver.switchTo().alert();
            Log.info("Alert hiển thị với text: " + alert.getText());
            alert.accept();
            Log.info("Đã Accept alert thành công");
        } catch (Exception e) {
            Log.error("Không tìm thấy alert để Accept! " + e.getMessage());
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true; // Nếu switch thành công => alert còn hiển thị
        } catch (Exception e) {
            return false; // Không còn alert nào
        }
    }
}
