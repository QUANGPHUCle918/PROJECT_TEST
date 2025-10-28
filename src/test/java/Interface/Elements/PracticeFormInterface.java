package Interface.Elements;

public class PracticeFormInterface {
    public static final String FIRST_NAME_INPUT = "//input[@id='firstName']";
    public static final String LAST_NAME_INPUT = "//input[@id='lastName']";
    public static final String EMAIL_INPUT = "//input[@id='userEmail']";
    public static final String GENDER_RADIO_MALE = "//label[@for='gender-radio-1']";
    public static final String MOBILE_INPUT = "//input[@id='userNumber']";
    public static final String SUBMIT_BUTTON = "//button[@id='submit']";
    public static final String MODAL_TITLE = "//div[@id='example-modal-sizes-title-lg']";
    public static final String MODAL_CONTENT = "//div[@class='modal-content']";
    public static final String RESULT_TABLE = "//div[@class='table-responsive']//table";
    public static final String RESULT_CELL_BY_LABEL = RESULT_TABLE + "//td[normalize-space()='%s']/following-sibling::td";
}
