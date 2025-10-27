package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.PracticeFormInterface;
import org.openqa.selenium.WebDriver;

public class PracticeFormAction  extends BasePage {
    private WebDriver driver;

    public PracticeFormAction(WebDriver driver) {
        this.driver = driver;
    }

    public void fillForm(String firstName, String lastName, String email, String mobile) {
        Log.info("Điền First Name");
        sendKeysToElement(driver, PracticeFormInterface.FIRST_NAME_INPUT, firstName);

        Log.info("Điền Last Name");
        sendKeysToElement(driver, PracticeFormInterface.LAST_NAME_INPUT, lastName);

        Log.info("Điền Email");
        sendKeysToElement(driver, PracticeFormInterface.EMAIL_INPUT, email);

        Log.info("Chọn Gender: Male");
        clickToElement(driver, PracticeFormInterface.GENDER_RADIO_MALE);

        Log.info("Điền Mobile");
        sendKeysToElement(driver, PracticeFormInterface.MOBILE_INPUT, mobile);
    }

    public void clickSubmit() {
        Log.info("Click nút Submit");
        scrollIntoView(driver, PracticeFormInterface.SUBMIT_BUTTON);
        clickToElementByJS(driver, PracticeFormInterface.SUBMIT_BUTTON);
        sleepInSecond(2);
    }

    public boolean isModalDisplayed() {
        Log.info("Kiểm tra modal hiển thị sau khi submit");
        return isDisplayElement(driver, PracticeFormInterface.MODAL_TITLE);
    }

    public boolean verifyModalContainsData(String... expectedValues) {
        Log.info("Kiểm tra modal chứa đúng dữ liệu đã nhập");
        String modalText = getTextElement(driver, PracticeFormInterface.MODAL_CONTENT);
        for (String value : expectedValues) {
            if (!modalText.contains(value)) {
                Log.error("Không tìm thấy giá trị: " + value + " trong modal");
                return false;
            }
        }
        return true;
    }
}
