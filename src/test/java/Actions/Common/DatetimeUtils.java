package Actions.Common;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DatetimeUtils {

    // Lấy ngày hiện tại (yyyy-MM-dd)
    public static String getCurrentDate() {
        return LocalDate.now().toString();
    }

    // Lấy giờ hiện tại (HH:mm:ss)
    public static String getCurrentTime() {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern("HH:mm:ss"));
    }

    // Lấy ngày giờ theo định dạng tự chọn
    public static String getCurrentDateTime(String pattern) {
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern));
    }

    // Lấy timestamp hiện tại (millisecond)
    public static long getCurrentTimestamp() {
        return System.currentTimeMillis();
    }

    // Parse chuỗi thành LocalDateTime theo pattern
    public static LocalDateTime parseDateTime(String dateTime, String pattern) {
        return LocalDateTime.parse(dateTime, DateTimeFormatter.ofPattern(pattern));
    }

    // Cộng thêm số ngày vào ngày hiện tại
    public static String addDays(String date, String pattern, long days) {
        LocalDate localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern(pattern));
        return localDate.plusDays(days).format(DateTimeFormatter.ofPattern(pattern));
    }

    // Cộng thêm giờ vào thời gian hiện tại
    public static String addHours(String dateTime, String pattern, long hours) {
        LocalDateTime localDateTime = parseDateTime(dateTime, pattern);
        return localDateTime.plusHours(hours).format(DateTimeFormatter.ofPattern(pattern));
    }

    // Kiểm tra chuỗi có phải định dạng ngày giờ hợp lệ không
    public static boolean isValidDateTime(String dateTime, String pattern) {
        try {
            parseDateTime(dateTime, pattern);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}

