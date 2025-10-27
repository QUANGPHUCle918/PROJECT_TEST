package Interface.Elements;

public class DataPickerInterface {
    public static final String DATE_INPUT = "//input[@id='datePickerMonthYearInput']";
    public static final String DATE_DROPDOWN_MONTH = "//select[@class='react-datepicker__month-select']";
    public static final String DATE_DROPDOWN_YEAR = "//select[@class='react-datepicker__year-select']";
    public static final String DATE_DAY_TEMPLATE = "//div[contains(@class,'react-datepicker__day') and text()='%s']";
}
