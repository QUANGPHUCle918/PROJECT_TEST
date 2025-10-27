package Interface.Elements;

public class WebTablesInterface {
    // Table body
    public static final String TABLE_ROW = "//div[@class='rt-tr-group']";
    // tim tên thep cot
    public static final String CELL_BY_COLUMN = "//div[@class='rt-tr-group'][%s]//div[@class='rt-td'][%s]";
    // tim ten theo cot ten
    public static final String LAST_NAME_CELL = "//div[@class='rt-td' and text()='%s']";
    // chinh sua ở nut but chì
    public static final String EDIT_BUTTON_BY_LASTNAME = "//div[@class='rt-td' and text()='%s']//ancestor::div[@class='rt-tr-group']//span[@title='Edit']";
    // chinh ua form
    public static final String EDIT_FORM = "//div[@class='modal-content']";
    public static final String SUBMIT_BUTTON = "//button[text()='Submit']";
}

