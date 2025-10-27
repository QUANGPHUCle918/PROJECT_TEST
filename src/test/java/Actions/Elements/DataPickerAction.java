package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.DataPickerInterface;
import org.openqa.selenium.WebDriver;

public class DataPickerAction extends BasePage {
    private WebDriver driver;

    public void DatePickerAction(WebDriver driver) {
        this.driver = driver;
    }

    // Mở Date Picker
    public void openDatePicker() {
        Log.info("Mở Date Picker");
        clickToElement(driver, DataPickerInterface.DATE_INPUT);
        sleepInSecond(1);
    }

    // Chọn tháng và năm
    public void selectMonthAndYear(String month, String year) {
        Log.info("Chọn tháng: " + month + " | Năm: " + year);
        selectItemInDropdown(driver,DataPickerInterface.DATE_DROPDOWN_MONTH, month);
        selectItemInDropdown(driver, DataPickerInterface.DATE_DROPDOWN_YEAR, year);
    }

    // Chọn ngày trong tháng
    public void selectDay(String day) {
        Log.info("Chọn ngày: " + day);
        String dayXpath = String.format(DataPickerInterface.DATE_DAY_TEMPLATE, day);
        clickToElement(driver, dayXpath);
        sleepInSecond(1);
    }

    // Lấy giá trị hiển thị trong ô ngày
    public String getSelectedDateValue() {
        return getElementAttributeValue(driver, DataPickerInterface.DATE_INPUT, "value");
    }
}
