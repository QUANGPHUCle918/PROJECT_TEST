package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.DynamicPropertiesInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DynamicPropertiesAction extends BasePage {
    private WebDriver driver;

    public DynamicPropertiesAction(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isButtonInitiallyDisabled() {
        Log.info("Kiểm tra trạng thái ban đầu của nút 'Will enable 5 seconds'");
        // true nếu element hiển thị nhưng không enabled
        return !isElementEnabled(driver, DynamicPropertiesInterface.ENABLE_AFTER_BUTTON);
    }


    public boolean waitForButtonToBeEnabled(int timeoutSeconds) {
        Log.info("Chờ nút 'Will enable 5 seconds' chuyển sang trạng thái enabled sau " + timeoutSeconds + "s");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutSeconds));
        try {
            wait.until(ExpectedConditions.elementToBeClickable(By.xpath(DynamicPropertiesInterface.ENABLE_AFTER_BUTTON)));
            return isElementEnabled(driver, DynamicPropertiesInterface.ENABLE_AFTER_BUTTON);
        } catch (Exception e) {
            Log.error(" Timeout: Nút không được enable sau " + timeoutSeconds + "s");
            return false;
        }
    }
}