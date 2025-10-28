package Actions.Elements;

import Actions.Common.BasePage;
import Common.Log;
import Interface.Elements.WebTablesInterface;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import java.util.ArrayList;
import java.util.List;

public class WebTablesAction extends BasePage {
    WebDriver driver;

    public WebTablesAction(WebDriver driver) {
        this.driver = driver;
    }

    // 1Lấy email theo First Name
    public String getEmailByFirstName(String firstName) {
        List<WebElement> rows = driver.findElements(By.xpath(WebTablesInterface.TABLE_ROW));
        Log.info("Tổng số hàng tìm được: " + rows.size());

        for (int i = 1; i <= rows.size(); i++) {
            String name = getTextElement(driver, WebTablesInterface.CELL_BY_ROW_AND_COL, String.valueOf(i), "1");
            if (name.equalsIgnoreCase(firstName)) {
                String email = getTextElement(driver, WebTablesInterface.CELL_BY_ROW_AND_COL, String.valueOf(i), "4");
                highlightElement(driver, WebTablesInterface.CELL_BY_ROW_AND_COL, String.valueOf(i), "4");
                Log.info("Tìm thấy email của '" + firstName + "': " + email);
                return email;
            }
        }
        Log.error("Không tìm thấy First Name: " + firstName);
        return null;
    }

    // 2 Click nút Edit theo Last Name
    public void clickEditByLastName(String lastName) {
        Log.info("Tìm hàng có Last Name = '" + lastName + "'");
        waitForElementIsVisible(driver, WebTablesInterface.LAST_NAME_CELL, lastName);
        highlightElement(driver, WebTablesInterface.LAST_NAME_CELL, lastName);

        scrollIntoView(driver, WebTablesInterface.EDIT_BUTTON_BY_LASTNAME, lastName);
        clickToElement(driver, WebTablesInterface.EDIT_BUTTON_BY_LASTNAME, lastName);

        waitForElementIsVisible(driver, WebTablesInterface.EDIT_FORM);
        Log.info("Đã mở form Edit cho Last Name: " + lastName);
    }
    public boolean isEditFormDisplayed() {
        return isElementDisplayed(driver, WebTablesInterface.EDIT_FORM);
    }



    // 3. Lấy danh sách hàng sau hàng có Age = xx
    public List<String> getRowsAfterAge(String ageValue) {
        Log.info("Tìm các hàng sau Age = '" + ageValue + "'");

        // Tìm hàng chứa giá trị Age = ageValue
        String baseRowXpath = String.format(
                "//div[@class='rt-td' and normalize-space(text())='%s']/ancestor::div[@class='rt-tr-group']",
                ageValue);

        waitForElementPresence(driver, baseRowXpath); // dùng presence thay vì visible

        // Tìm tất cả các hàng sau hàng đó
        List<WebElement> followingRows = driver.findElements(
                By.xpath(baseRowXpath + "/following-sibling::div[@class='rt-tr-group']"));

        Log.info("Số hàng sau Age=" + ageValue + ": " + followingRows.size());
        List<String> rowDataList = new ArrayList<>();

        for (int i = 0; i < followingRows.size(); i++) {
            String rowText = followingRows.get(i).getText().trim();
            Log.info("Hàng thứ " + (i + 1) + ": " + rowText);
            rowDataList.add(rowText);
        }

        return rowDataList;
    }

}
