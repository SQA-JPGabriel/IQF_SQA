package base;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.ITestResult;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ExtentReportsManager;
import utilities.ReadPropertyFile;

public class BaseTest extends ReadPropertyFile {

    protected static ExtentReports extent;
    protected static ExtentTest test;
    public static WebDriver driver;
    public static Properties prop = new Properties();

    @BeforeSuite
    public void setUpReport() {
        extent = ExtentReportsManager.getInstance();
    }

    @BeforeMethod
    public void registerTestAndSetup(Method method) throws IOException {
        // Register ExtentTest
        test = extent.createTest(method.getName());

        // Load properties
        if (prop.isEmpty()) {
            FileReader fr = new FileReader("D:\\Eclipse workplace\\SQAMAutomationDemo\\DemoAutomation\\src\\test\\resources\\configfiles\\config.properties");
            prop.load(fr);
            FileReader fr2 = new FileReader("D:\\Eclipse workplace\\SQAMAutomationDemo\\DemoAutomation\\src\\test\\resources\\configfiles\\locators.properties");
            prop.load(fr2);
        }

        // Browser setup
        String browser = prop.getProperty("browser");
        if (browser.equalsIgnoreCase("chrome")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
            driver.manage().window().maximize();
        } else if (browser.equalsIgnoreCase("edge")) {
            WebDriverManager.edgedriver().setup();
            driver = new EdgeDriver();
            driver.manage().window().maximize();
        }

        // Open URL
        driver.get(prop.getProperty("testurl"));
    }

    @AfterMethod
    public void logResultAndTearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            test.fail(result.getThrowable());
        } else if (result.getStatus() == ITestResult.SUCCESS) {
            test.pass("Test Passed");
        } else if (result.getStatus() == ITestResult.SKIP) {
            test.skip("Test Skipped: " + result.getThrowable());
        }

        if (driver != null) {
            driver.quit();  // Always quit browser after each test
        }
    }

    @AfterSuite
    public void tearDownReport() {
        extent.flush();
    }
}
