package Actions.Common;

import Common.GlobalVariables;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public class BaseTest {
    // khoi tạo cai dat load và dong het lại
    private static WebDriver driver;
    ChromeOptions chromeOptions;
    EdgeOptions edgeOptions;
    FirefoxOptions firefoxOptions;
  //  protected WebDriver driver;

    @BeforeMethod(alwaysRun = true)
    public void setup() {
        Drivers.DriverFactory.initDriver();
        driver = Drivers.DriverFactory.getDriver();
        driver.get("https://demoqa.com");
    }
//
//    @AfterMethod(alwaysRun = true)
//    public void tearDown() {
//        Drivers.DriverFactory.quitDriver();
//    }

    //public class DriverFactory {

//        public static WebDriver createDriver() {
//            ChromeOptions options = new ChromeOptions();
//            options.addArguments("--headless=new"); // 👈 chạy ẩn
//            options.addArguments("--no-sandbox");
//            options.addArguments("--disable-gpu");
//            options.addArguments("--disable-dev-shm-usage");
//            options.addArguments("--window-size=1920,1080");
//
//            return new ChromeDriver(options);
      //  }

        public WebDriver getBrowserDriver(String browserName, String url) {
            String browser = browserName.toUpperCase();
            switch (browser) {
                case "CHROME":
                    WebDriverManager.chromedriver().setup();
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--remote-allow-origins=*");
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "EDGE":
                    WebDriverManager.edgedriver().setup();
                    edgeOptions = new EdgeOptions();
                    edgeOptions.addArguments("--remote-allow-origins=*");
                    driver = new EdgeDriver(edgeOptions);
                    break;
                case "FIREFOX":
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    break;
                case "HCHROME":
                    chromeOptions = new ChromeOptions();
                    chromeOptions.addArguments("--headless=new");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(chromeOptions);
                    break;

                default:
                    throw new RuntimeException("Please enter correct browser name");
            }
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GlobalVariables.LONG_TIMEOUT));
            driver.manage().window().maximize();
            driver.get(url);
            return driver;
        }


        public static WebDriver getDriver() {
            return driver;
        }

        @AfterMethod(alwaysRun = true)
        public void tearDown() {
            if (driver != null) driver.quit();
        }

    }

