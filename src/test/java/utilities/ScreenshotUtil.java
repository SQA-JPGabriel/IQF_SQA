package utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ScreenshotUtil {

    public static String captureScreenshot(WebDriver driver, String screenshotName) throws IOException {
        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String screenshotDir = System.getProperty("user.dir") + "/test-output/screenshots/";
        File dir = new File(screenshotDir);
        if (!dir.exists()) dir.mkdirs();  // create folder if missing

        String destPath = screenshotDir + screenshotName + "_" + timestamp + ".png";
        File destFile = new File(destPath);
        FileUtils.copyFile(srcFile, destFile);

        // Return relative path for ExtentReports
        return "./screenshots/" + screenshotName + "_" + timestamp + ".png";
    }
}
