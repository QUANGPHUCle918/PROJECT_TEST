package Interface.Elements;

public class WebTablesInterface {
    // Hàng dữ liệu trong bảng
    public static final String TABLE_ROW = "//div[@class='rt-tr-group']";

    public static final String CELL_BY_ROW_AND_COL = "//div[@class='rt-tr-group'][%s]//div[@class='rt-td'][%s]";
    public static final String LAST_NAME_CELL = "//div[@class='rt-td' and normalize-space(text())='%s']";
    public static final String EDIT_BUTTON_BY_LASTNAME =
            "//div[@class='rt-td' and normalize-space(text())='%s']/ancestor::div[@class='rt-tr-group']//span[@title='Edit']";

    public static final String EDIT_FORM = "//div[contains(@class,'modal-content')]";
    public static final String SUBMIT_BUTTON = "//button[text()='Submit']";
}
