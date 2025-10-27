package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.UploadDownloadInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class UploadDownloadAction extends BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public UploadDownloadAction(WebDriver driver) {
        this.driver = driver;
    }

    public void uploadFile(String filePath) {
        Log.info("Upload file từ đường dẫn: " + filePath);
        waitForElementIsVisible(driver, UploadDownloadInterface.UPLOAD_INPUT);
        sendKeysToElement(driver, UploadDownloadInterface.UPLOAD_INPUT, filePath);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id(UploadDownloadInterface.UPLOAD_RESULT), "C:\\temp\\logo.png"
        ));
    }


    public String getUploadedFileText() {
        waitForElementIsVisible(driver, UploadDownloadInterface.UPLOAD_RESULT);
        highlightElement(driver, UploadDownloadInterface.UPLOAD_RESULT);
        return getTextElement(driver, UploadDownloadInterface.UPLOAD_RESULT).trim();
    }

    public boolean isFileUploadedSuccessfully(String fileName) {
        String text = getUploadedFileText();
        Log.info("Text hiển thị sau upload: " + text);
        return text.endsWith(fileName);
    }
}
