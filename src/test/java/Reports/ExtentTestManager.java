package Reports;

import com.aventstack.extentreports.ExtentTest;

import java.util.concurrent.ConcurrentHashMap;

public class ExtentTestManager {
    private static ConcurrentHashMap<Long, ExtentTest> map = new ConcurrentHashMap<>();

    public static synchronized ExtentTest getTest() {
        return map.get(Thread.currentThread().getId());
    }

    public static synchronized void setTest(ExtentTest test) {
        map.put(Thread.currentThread().getId(), test);
    }

    public static synchronized void remove() {
        map.remove(Thread.currentThread().getId());
    }
}
