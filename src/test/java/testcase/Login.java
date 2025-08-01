package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;
import utilities.ScreenshotUtil;

import com.aventstack.extentreports.MediaEntityBuilder;
import utilities.ScreenshotUtil;

public class Login extends BaseTest {

    @Test(dataProvider = "xlsTestData", dataProviderClass = ReadXLSData.class)
    public void LoginSuccess(String username, String password) throws InterruptedException, IOException {
        test = extent.createTest("Login Test: Correct credentials");

        try {
            driver.findElement(By.xpath(prop.getProperty("Username"))).sendKeys(username);
            test.info("Entered username: " + username);
            Thread.sleep(1000);

            driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(password);
            test.info("Entered password");
            Thread.sleep(1000);

            driver.findElement(By.xpath(prop.getProperty("YesTermsCondition"))).click();
            test.info("Clicked Terms and Conditions");

            driver.findElement(By.xpath(prop.getProperty("LoginBtn"))).click();
            test.info("Clicked Login Button");
            Thread.sleep(3000);
            
            test.pass("Login successful",MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "LoginSuccess")).build());
            driver.findElement(By.xpath(prop.getProperty("WelcomeContinueBtn"))).click();  // Corrected 'clear()' to 'click()'
            test.pass("Login successful");
            
           // driver.findElement(By.xpath(prop.getProperty("Logout"))).click();
            //test.info("Log-out");
            
            
           
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "LoginFailure");
            test.fail("Login test failed due to: " + e.getMessage(),
                      MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e;
        }
    }
}
