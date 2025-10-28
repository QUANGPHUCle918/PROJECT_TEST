package TestCase;

import Actions.Common.BaseTest;
import Actions.Elements.*;
import Actions.HomePageAction;
import Common.Log;
import Interface.Elements.DataPickerInterface;
import Interface.Elements.WebTablesInterface;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.util.List;

public class ForToElementsTest extends BaseTest {
    private WebDriver driver;
    private HomePageAction homePage;
    private MenuleftAction menuLeft;
    private RadioButtonAction radiobutton;
    private WebTablesAction webTable;
    private ButtonsAction buttons;
    private LinksAction links;
    private UploadDownloadAction uploadfile;
    private UploadDownloadAction uploadDownload;
    private AlertsAction alertsAction;
     private DataPickerAction picker ;
     private PracticeFormAction form ;

    @BeforeMethod(alwaysRun = true)
    public void init() {
        driver = getBrowserDriver("chrome", "https://demoqa.com/");
        homePage = new HomePageAction(driver);
        menuLeft = new MenuleftAction(driver);
       radiobutton = new RadioButtonAction(driver);
        webTable = new WebTablesAction(driver);
        buttons = new ButtonsAction(driver);
       links = new LinksAction(driver);
       uploadDownload = new UploadDownloadAction(driver);
       uploadfile = new UploadDownloadAction(driver);
       alertsAction = new AlertsAction(getDriver());
       picker =new DataPickerAction();
       form = new PracticeFormAction(getDriver());

    }
    @Test(priority = 1, description = "DQ-RB-002|Elements > Radio Button | NEGATIVE_DISABLED")
    public void DQ_RB_002() {
        Log.info(" Steep 1:  Click vaof dong menu Elements ");
        homePage.clickOnMenu("Elements");
        Log.info(" Steep 2:  Click vao  menu trai   radio button man hinh elements   ");
        menuLeft.clickOnMenuLeft("Radio Button");
        Log.info(" Steep 3:  Click vao radoi butto chon den no vaf ko chon dc  ");
        boolean isNoDisabled = radiobutton.isNoRadioDisabled();
        Assert.assertTrue(isNoDisabled, "'No' radio button should be disabled but it's not!");
        Log.info("Step 4: Verify kết quả hiển thị");
        String actualResult = radiobutton.getResult();
        Assert.assertEquals(actualResult, "", "Expected no result to be shown when 'No' radio is disabled!");

   }
   @Test(groups = {"DQ-WT-001"}, priority = 2, description = "Elements > Web Tables | LOCATOR_FOLLOWING_SIBLING")
public void DQ_WT_001() {
    Log.info("Step 1: Click menu Elements");
    homePage.clickOnMenu("Elements");
    Log.info("Step 2: Click menu trái 'Web Tables'");
    menuLeft.clickOnMenuLeft("Web Tables");
    Log.info("Step 3: Lấy email của người có First Name = 'Cierra'");
    WebTablesAction webTable = new WebTablesAction(driver);
    String actualEmail = webTable.getEmailByFirstName("Cierra");
    Log.info("Step 4: Verify email khớp dữ liệu mong đợi");
    String expectedEmail = "cierra@example.com";
    Assert.assertEquals(actualEmail, expectedEmail,
            "Email của 'Cierra' không khớp với dữ liệu mong đợi!");
}
    @Test(priority = 3, description = "DQ-WT-002 | Web Tables | Verify Edit by Last Name")
    public void DQ_WT_002() {
        Log.info("Step 1: Click menu 'Elements'");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click 'Web Tables' ở menu bên trái");
        menuLeft.clickOnMenuLeft("Web Tables");
        Log.info("Step 3: Click nút Edit của hàng có Last Name = 'Alden'");
        webTable.clickEditByLastName("Alden");
        Log.info("Step 4: Verify form Edit hiển thị đúng");
        Assert.assertTrue(webTable.isEditFormDisplayed(), "Form Edit không hiển thị!");
    }

   @Test(priority = 4, description = "DQ-WT-003 | Web Tables | Verify all rows after Age=39")
public void DQ_WT_003() {
    Log.info("Step 1: Click menu 'Elements'");
    homePage.clickOnMenu("Elements");
    Log.info("Step 2: Click 'Web Tables' ở menu bên trái");
    menuLeft.clickOnMenuLeft("Web Tables");
    Log.info("Step 3: Lấy tất cả các hàng sau hàng có Age = 39");
    List<String> followingRows = webTable.getRowsAfterAge("39");
    Log.info("Step 4: In ra danh sách hàng sau Age=39");
    for (String row : followingRows) {
        System.out.println("-> " + row);
    }

    Log.info("Step 5: Verify danh sách không rỗng");
    Assert.assertTrue(followingRows.size() > 0, "Không tìm thấy hàng nào sau Age = 39!");
}
    @Test(priority = 5, description = "DQ-BTN-001|Buttons|Verify Double Click button")
    public void DQ_BTN_001() {
        Log.info("Step 1: Click menu 'Elements'");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click 'Buttons' ở menu bên trái");
        menuLeft.clickOnMenuLeft("Buttons");
        Log.info("Step 3: Double Click vào nút 'Double Click Me'");
        buttons.doubleClickButton();
        Log.info("Step 4: Verify thông báo xuất hiện");
        String actualMessage = buttons.getDoubleClickMessage();
        Log.info("Thông báo hiển thị: " + actualMessage);
        Assert.assertEquals(actualMessage, "You have done a double click",
                "Thông báo double click không đúng!");
    }
    @Test(priority = 6, description = "DQ-LK-001|LINKS|Verify Double Click button")

    public void DQ_LK_001() {
        Log.info("Step 1: Click menu 'Elements'");
        homePage.clickOnMenu("Elements");
        Log.info("Step 2: Click 'Links' ở menu bên trái");;
        menuLeft.clickOnMenuLeft("Links");
        Log.info("Step 3: Click link 'Created'");
        links.clickCreatedLink();
        Log.info("Step 4: Verify phản hồi hiển thị status = 201 và text = 'Created'");
        boolean isCorrect = links.isStatus201Displayed();
        Assert.assertTrue(isCorrect, "Phản hồi không chứa status 201 hoặc text 'Created'!");
        Log.info(" Testcase DQ_LK_001 hoàn thành!");
    }
    @Test(priority = 7, description = "DQ-UP-001 | Upload & Download | Verify upload .png file hiển thị đúng tên")
    public void DQ_UP_001() {
        Log.info("Step 1: Click menu 'Elements'");
        homePage.clickOnMenu("Elements");

        Log.info("Step 2: Click 'Upload and Download' ở menu bên trái");
        menuLeft.clickOnMenuLeft("Upload and Download");
        Log.info("Step 3: Upload file 'logo.png' từ resources");
        String shownPath = uploadfile.uploadFromResources("logo.png");

        Log.info("Step 4: Verify kết quả hiển thị có đuôi 'logo.png'");
        Assert.assertTrue(shownPath.endsWith("logo.png"),
                "Kết quả hiển thị không khớp với tên file logo.png");
    }
    @Test(priority = 8, description = "DQ-DY-001 | Verify button 'Will enable 5 seconds' is disabled first and enabled after ~5s")
    public void DQ_DY_001() {
        Log.info("Step 1: Click menu 'Elements'");
        homePage.clickOnMenu("Elements");

        Log.info("Step 2: Click 'Dynamic Properties' ở menu bên trái");
        menuLeft.clickOnMenuLeft("Dynamic Properties");

        DynamicPropertiesAction dynamicPage = new DynamicPropertiesAction(driver);

        Log.info("Step 3: Kiểm tra nút ban đầu bị disabled");
        Assert.assertTrue(dynamicPage.isButtonInitiallyDisabled(),
                " Nút không bị disabled khi vừa load!");

        Log.info("Step 4: Chờ 6s và kiểm tra lại trạng thái enabled");
        boolean isEnabled = dynamicPage.waitForButtonToBeEnabled(6);
        Assert.assertTrue(isEnabled, " Nút không được enabled sau 5-6 giây!");

        Log.info("PASS: Nút ban đầu disabled và được enable sau 5s");
    }
    @Test(priority = 9, description = "DQ-AL-001 | Alerts | Verify simple alert hiển thị và accept thành công")
    public void DQ_AL_001() {


        Log.info("Step 1: Mở menu 'Alerts, Frame & Windows'");
        homePage.clickOnMenu("Alerts, Frame & Windows");

        Log.info("Step 2: Click submenu 'Alerts'");
        menuLeft.clickOnMenuLeft("Alerts");

        Log.info("Step 3: Click 'Click me' để mở alert đơn giản");
        alertsAction.clickSimpleAlert();

        Log.info("Step 4: Accept alert");
        alertsAction.acceptAlert();

        Log.info("Step 5: Verify alert đã biến mất");
        Assert.assertFalse(alertsAction.isAlertPresent(),
                " Alert vẫn còn hiển thị sau khi Accept!");
    }
    @Test(priority = 10, description = "DQ-FM-001 | Điền form hợp lệ và verify modal hiển thị đúng dữ liệu")
    public void DQ_FM_001() {
        Log.info("Step 1: Mở menu Forms > Practice Form");
        homePage.clickOnMenu("Forms");
        menuLeft.clickOnMenuLeft("Practice Form");

        Log.info("Step 2: Điền form hợp lệ");
        form.fillForm("Minh", "Le", "minh@example.com", "0987654321");

        Log.info("Step 3: Submit form");
        form.clickSubmit();

        Log.info("Step 4: Verify modal hiển thị và chứa dữ liệu nhập");
        Assert.assertTrue(form.isModalDisplayed(), " Modal không hiển thị sau khi Submit!");
        Assert.assertTrue(
                form.verifyModalContainsData("Minh", "Le", "minh@example.com", "Male", "0987654321"),
                "Modal không chứa đúng dữ liệu!"
        );
    }
    @Test(priority = 11, description = "DQ-WG-001 | Chọn ngày đầu và cuối tháng trong Date Picker (BVA)")
    public void DQ_DPICK_001() {
        Log.info("Step 1: Mở menu Widgets > Date Picker");
        homePage.clickOnMenu("Widgets");
        menuLeft.clickOnMenuLeft("Date Picker");


        Log.info("Step 2: Mở picker và chọn ngày 1 (đầu tháng)");
        picker.openDatePicker();
        picker.selectMonthAndYear("August", "2025"); // ví dụ tháng có 31 ngày
        picker.selectDay("1");
        String firstDate = picker.getSelectedDateValue();
        Log.info("Ngày được chọn: " + firstDate);

        Assert.assertTrue(firstDate.contains("08/01/2025") || firstDate.startsWith("08/01"),
                "Ngày 1 không được cập nhật đúng!");

        Log.info("Step 3: Mở lại picker và chọn ngày 31 (cuối tháng)");
        picker.openDatePicker();
        picker.selectMonthAndYear("August", "2025");
        picker.selectDay("31");
        String lastDate = picker.getSelectedDateValue();
        Log.info("Ngày được chọn: " + lastDate);

        Assert.assertTrue(lastDate.contains("08/31/2025") || lastDate.startsWith("08/31"),
                " Ngày 31 không được cập nhật đúng!");

        Log.info("Kết quả: Date Picker hoạt động chính xác cho ngày biên 1 và 31");
    }






}



