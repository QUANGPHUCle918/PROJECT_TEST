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

//    public void uploadFile(String filePath) {
//        Log.info("Upload file từ đường dẫn: " + filePath);
//        waitForElementIsVisible(driver, UploadDownloadInterface.UPLOAD_INPUT);
//        sendKeysToElement(driver, UploadDownloadInterface.UPLOAD_INPUT, filePath);
//
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        wait.until(ExpectedConditions.textToBePresentInElementLocated(
//                By.id(UploadDownloadInterface.UPLOAD_RESULT), "C:\\temp\\logo.png"
//        ));
//    }


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
    public String uploadFromResources(String resourcePath) {
        Log.info("Thử load file upload: " + resourcePath);
        java.net.URL url = Thread.currentThread()
                .getContextClassLoader()
                .getResource(resourcePath);

        java.nio.file.Path fileToUpload = null;

        try {
            if (url != null) {
                java.nio.file.Path temp = java.nio.file.Files.createTempFile("upload_", "_" + resourcePath.replace("/", "_"));
                try (java.io.InputStream in = url.openStream()) {
                    java.nio.file.Files.copy(in, temp, java.nio.file.StandardCopyOption.REPLACE_EXISTING);
                }
                fileToUpload = temp;
                Log.info("Đã lấy từ classpath và copy ra file tạm: " + fileToUpload.toAbsolutePath());
            } else {
                throw new RuntimeException("Không tìm thấy file trong classpath: " + resourcePath);
            }
        } catch (Exception e) {
            throw new RuntimeException("Lỗi khi chuẩn bị file upload: " + e.getMessage(), e);
        }

        waitForElementPresent(driver,UploadDownloadInterface.UPLOAD_INPUT);
        driver.findElement(getXpath(UploadDownloadInterface.UPLOAD_INPUT))
                .sendKeys(fileToUpload.toAbsolutePath().toString());

        waitForElementPresent(driver, UploadDownloadInterface.UPLOAD_RESULT);
        String shown = getTextElement(driver, UploadDownloadInterface.UPLOAD_RESULT);
        Log.info("Đường dẫn hiển thị sau upload: " + shown);
        return shown;
    }

}
