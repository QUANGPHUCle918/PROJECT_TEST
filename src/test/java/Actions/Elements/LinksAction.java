package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.LinksInterface;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

public class LinksAction extends BasePage {
    private WebDriver driver;

    public LinksAction(WebDriver driver) {
        this.driver = driver;
    }

    public void clickCreatedLink() {
        Log.info("Click link 'Created' và xử lý quảng cáo che phủ nếu có");

        try {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript(
                    "document.querySelectorAll('iframe, [id^=google_ads_iframe], .adsbygoogle').forEach(e => e.remove());"
            );

            waitForElementIsVisible(driver, LinksInterface.CREATED_LINK);
            highlightElement(driver, LinksInterface.CREATED_LINK);

            //scrollToElement(driver,LinksInterface.CREATED_LINK);
            clickToElementByJS(driver, LinksInterface.CREATED_LINK);

            Log.info(" Click link 'Created' thành công!");

        } catch (Exception e) {
            Log.error("Lỗi khi click link 'Created': " + e.getMessage());
            throw e;
        }
    }

    public String getResponseText() {
        Log.info("Lấy text phản hồi sau khi click link");

        waitForElementIsVisible(driver, LinksInterface.LINK_RESPONSE_BLOCK);
        highlightElement(driver, LinksInterface.LINK_RESPONSE_BLOCK);

        String response = getTextElement(driver, LinksInterface.LINK_RESPONSE_BLOCK).trim();
        Log.info("Phản hồi nhận được: " + response);
        return response;
    }

    public boolean isStatus201Displayed() {
        String response = getResponseText();
        return response.contains("201") && response.contains("Created");
    }
}
