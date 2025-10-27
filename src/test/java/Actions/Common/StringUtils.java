package Actions.Common;


import java.text.Normalizer;

public class StringUtils {

    // Kiểm tra chuỗi rỗng hoặc null
    public static boolean isNullOrEmpty(String text) {
        return text == null || text.trim().isEmpty();
    }

    // Viết hoa chữ cái đầu tiên
    public static String capitalizeFirst(String input) {
        if (isNullOrEmpty(input)) return "";
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

    // Chuyển chuỗi thành chữ thường
    public static String toLower(String input) {
        return isNullOrEmpty(input) ? "" : input.toLowerCase();
    }

    // Chuyển chuỗi thành chữ in hoa
    public static String toUpper(String input) {
        return isNullOrEmpty(input) ? "" : input.toUpperCase();
    }

    // Xóa ký tự đặc biệt
    public static String removeSpecialChars(String input) {
        return isNullOrEmpty(input) ? "" : input.replaceAll("[^a-zA-Z0-9\\s]", "");
    }

    // Bỏ dấu tiếng Việt
    public static String removeVietnameseAccents(String input) {
        if (isNullOrEmpty(input)) return "";
        String temp = Normalizer.normalize(input, Normalizer.Form.NFD);
        return temp.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
    }

    // Chuẩn hóa chuỗi để so sánh (bỏ dấu + chữ thường)
    public static String normalizeKeyword(String input) {
        return toLower(removeVietnameseAccents(input.trim()));
    }

    // Giới hạn độ dài chuỗi
    public static String truncate(String input, int maxLength) {
        if (isNullOrEmpty(input)) return "";
        return input.length() <= maxLength ? input : input.substring(0, maxLength);
    }

    // Kiểm tra chuỗi có chứa số không
    public static boolean containsNumber(String input) {
        return !isNullOrEmpty(input) && input.matches(".*\\d.*");
    }

    // Xóa khoảng trắng thừa
    public static String trimAllSpaces(String input) {
        return isNullOrEmpty(input) ? "" : input.trim().replaceAll("\\s+", " ");
    }
}
