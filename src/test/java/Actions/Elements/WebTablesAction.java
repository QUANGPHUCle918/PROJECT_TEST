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

    public String getEmailByFirstName(String firstName) {
        List<WebElement> rows = driver.findElements(By.xpath(WebTablesInterface.TABLE_ROW));

        for (int i = 1; i <= rows.size(); i++) {
            String name = getTextElement(driver, String.format(WebTablesInterface.CELL_BY_COLUMN, i, 1));
            if (name.equalsIgnoreCase(firstName)) {
                String email = getTextElement(driver, String.format(WebTablesInterface.CELL_BY_COLUMN, i, 4));
                highlightElement(driver, String.format(WebTablesInterface.CELL_BY_COLUMN, i, 4));
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                System.out.println("Email tìm thấy: " + email);
                return email;
            }
        }
        return null;
    }
    public void clickEditByLastName(String lastName) {
        Log.info("Tìm hàng có Last Name = '" + lastName + "'");
        String cellLocator = String.format(WebTablesInterface.LAST_NAME_CELL, lastName);
        waitForElementIsVisible(driver, cellLocator);

        String editButtonLocator = String.format(WebTablesInterface.EDIT_BUTTON_BY_LASTNAME, lastName);
        highlightElement(driver, editButtonLocator);
        clickToElement(driver, editButtonLocator);
        waitForElementIsVisible(driver, WebTablesInterface.EDIT_FORM);

        try {
            Thread.sleep(1500);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        Common.Log.info("Đã mở form Edit cho hàng có Last Name: " + lastName);
    }

    public boolean isElementDisplayed(WebDriver driver, String locator, String... params) {
        String finalXpath = String.format(locator, (Object[]) params);
        try {
            waitForElementIsVisible(driver, finalXpath);
            highlightElement(driver, finalXpath);
            return driver.findElement(getXpath(finalXpath)).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    // case 4
//    public void openWebTablesPage() {
//        driver.get("https://demoqa.com/webtables");
//        Log.info("Đã mở trang Web Tables");
//    }

    //Lấy danh sách hàng sau hàng có Age = 39
    public List<String> getRowsAfterAge(String ageValue) {
        Log.info("Tìm hàng có Age = '" + ageValue + "'");
        String baseRowXpath = String.format("//div[@class='rt-td' and text()='%s']/ancestor::div[@class='rt-tr-group']", ageValue);

        waitForElementIsVisible(driver, baseRowXpath);

        List<WebElement> followingRows = driver.findElements(
                By.xpath(baseRowXpath + "/following-sibling::div[@class='rt-tr-group']")
        );

        Log.info("Tổng số hàng sau Age = " + ageValue + ": " + followingRows.size());

        List<String> rowDataList = new ArrayList<>();

        for (int i = 0; i < followingRows.size(); i++) {
            String rowText = followingRows.get(i).getText().trim();
            Log.info("Hàng thứ " + (i + 1) + " sau Age " + ageValue + ": " + rowText);
            rowDataList.add(rowText);
        }
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }


        return rowDataList;
    }

    }


