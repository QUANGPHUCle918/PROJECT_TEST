package Actions.Common;

public class Assert {
    //So sánh 2 chuỗi giống nhau tuyệt đối
    public static void assertEquals(String actualResult, String expectedResult, String... message) {
        if (message.length > 0)
            Assert.assertEquals(actualResult, expectedResult, message[0]);
        else
            Assert.assertEquals(actualResult, expectedResult);
    }

    // So sánh 2 chuỗi KHÔNG giống nhau
    public static void assertNotEquals(String actualResult, String expectedResult, String... message) {
        if (message.length > 0)
            Assert.assertNotEquals(actualResult, expectedResult, message[0]);
        else
            Assert.assertNotEquals(actualResult, expectedResult);
    }

    //  So sánh 2 chuỗi bỏ qua hoa/thường (case-insensitive)
    public static void assertEqualsIgnoreCase(String actualResult, String expectedResult, String... message) {
        if (message.length > 0)
            Assert.assertTrue(actualResult.equalsIgnoreCase(expectedResult), message[0]);
        else
            Assert.assertTrue(actualResult.equalsIgnoreCase(expectedResult),
                    "Giá trị mong đợi (bỏ qua hoa/thường): " + expectedResult + " nhưng thực tế là: " + actualResult);
    }

    // Kiểm tra điều kiện đúng (true)
    public static void assertTrue(boolean condition, String... message) {
        if (message.length > 0)
            Assert.assertTrue(condition, message[0]);
        else
            Assert.assertTrue(condition);
    }

    // Kiểm tra điều kiện sai (false)
    public static void assertFalse(boolean condition, String... message) {
        if (message.length > 0)
            Assert.assertFalse(condition, message[0]);
        else
            Assert.assertFalse(condition);
    }

    // Kiểm tra chuỗi có chứa 1 phần text con
    public static void assertContains(String value, String valueContains, String... message) {
        if (message.length > 0)
            Assert.assertTrue(value.contains(valueContains), message[0]);
        else
            Assert.assertTrue(value.contains(valueContains),
                    "Chuỗi mong đợi phải chứa: " + valueContains + " nhưng thực tế là: " + value);
    }

    // Kiểm tra chuỗi KHÔNG chứa 1 phần text con
    public static void assertNotContains(String value, String valueContains, String... message) {
        if (message.length > 0)
            Assert.assertFalse(value.contains(valueContains), message[0]);
        else
            Assert.assertFalse(value.contains(valueContains),
                    "Chuỗi KHÔNG được chứa: " + valueContains + " nhưng thực tế là: " + value);
    }
}
