package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;
import utilities.ScreenshotUtil;

import com.aventstack.extentreports.MediaEntityBuilder;
import utilities.ScreenshotUtil;

public class DL extends BaseTest {

	@Test(priority = 1, dataProvider = "xlsTestData", dataProviderClass = ReadXLSData.class)  
    public void SearchByDLValid(String username, String password, String license, String name, String birthdate) throws InterruptedException, IOException 
    {
       //test = extent.createTest("TC01: Search by Driver's License");

        try {
            driver.findElement(By.xpath(prop.getProperty("Username"))).sendKeys(username);
            Thread.sleep(1000);

            driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(password);
            Thread.sleep(1000);

            driver.findElement(By.xpath(prop.getProperty("YesTermsCondition"))).click();

            driver.findElement(By.xpath(prop.getProperty("LoginBtn"))).click();
            Thread.sleep(3000);
            
            test.pass("Login successful",MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Search by DL")).build());
            driver.findElement(By.xpath(prop.getProperty("WelcomeContinueBtn"))).click();
            driver.findElement(By.xpath(prop.getProperty("ByLicenseNumberLink"))).click();
        	driver.findElement(By.xpath(prop.getProperty("LicenseNumberFld"))).sendKeys(license);
        	Thread.sleep(3000);
        	driver.findElement(By.xpath(prop.getProperty("LicenseNumberFld"))).sendKeys(Keys.ENTER);
        	Thread.sleep(3000);
        	
        	boolean testFailed = false;
        	// Name validation
        	if (driver.findElement(By.xpath(prop.getProperty("Name"))).getText().equals(name)) {
        	    System.out.println("Name matches");
        	    test.info("Test Data name matches " + name);
        	    test.pass("Name Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Match!")).build());
        	} else {
        	    test.fail("Name MISMATCH!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Mismatch!")).build());
        	    testFailed = true;
        	}

        	// Birthdate validation
        	if (driver.findElement(By.xpath(prop.getProperty("Birthday"))).getText().equals(birthdate)) {
        	    System.out.println("birthdate matches");
        	    test.info("Test Data birthday matches " + birthdate);
        	    test.pass("Birthday Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Birthday Match!")).build());
        	} else {
        	    test.fail("Birthdate MISMATCH!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Birthday Mismatch!")).build());
        	    testFailed = true;
        	}
        	
        	if (testFailed) {
        	    Assert.fail("One or more validations failed. Check Extent report for details.");
        	}
           
        } catch (Exception e) {
            String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "LoginFailure");
            test.fail("Login test failed due to: " + e.getMessage(),
                      MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
            throw e;
        }
        
        
    }
	@Test(priority = 2, dataProvider = "xlsTestData", dataProviderClass = ReadXLSData.class)
    public void SearchByDLInvalid(String username, String password,  String license, String invalidName, String invalidBirthDate) throws InterruptedException, IOException 
    {
    
    try 
    {
    	driver.findElement(By.xpath(prop.getProperty("Username"))).sendKeys(username);
        Thread.sleep(1000);

        driver.findElement(By.xpath(prop.getProperty("Password"))).sendKeys(password);
        Thread.sleep(1000);

        driver.findElement(By.xpath(prop.getProperty("YesTermsCondition"))).click();

        driver.findElement(By.xpath(prop.getProperty("LoginBtn"))).click();
        Thread.sleep(3000);
        
        test.pass("Login successful",MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Search by DL")).build());
        driver.findElement(By.xpath(prop.getProperty("WelcomeContinueBtn"))).click();
    	Thread.sleep(2000);
    	driver.findElement(By.xpath(prop.getProperty("ByLicenseNumberLink"))).click();
    	driver.findElement(By.xpath(prop.getProperty("LicenseNumberFld"))).sendKeys(license);
    	driver.findElement(By.xpath(prop.getProperty("LicenseNumberFld"))).sendKeys(Keys.ENTER);
    	Thread.sleep(3000);
    	boolean testFailed = false;
    	// Name mismatch expected
    	String actualName = driver.findElement(By.xpath(prop.getProperty("Name"))).getText();
    	if (!actualName.equals(invalidName)) {
    	    System.out.println("Name mismatch as expected");
    	    test.pass("Negative test passed: Name mismatch as expected", 
    	        MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "NameMismatchExpected")).build());
    	} else {
    	    test.fail("Negative test failed: Name unexpectedly matched!",
    	        MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "NameUnexpectedMatch")).build());
    	    testFailed = true;
    	}

    	// Birthdate mismatch expected
    	String actualBirthDate = driver.findElement(By.xpath(prop.getProperty("Birthday"))).getText();
    	if (!actualBirthDate.equals(invalidBirthDate)) {
    	    System.out.println("Birthdate mismatch as expected");
    	    test.pass("Negative test passed: Birthdate mismatch as expected", 
    	        MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "BirthdateMismatchExpected")).build());
    	} else {
    	    test.fail("Negative test failed: Birthdate unexpectedly matched!",
    	        MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "BirthdateUnexpectedMatch")).build());
    	    testFailed = true;
    	}

       
    } 
    	catch (Exception e) 
    	{
    		String screenshotPath = ScreenshotUtil.captureScreenshot(driver, "LoginFailure");
    		test.fail("Login test failed due to: " + e.getMessage(),
            MediaEntityBuilder.createScreenCaptureFromPath(screenshotPath).build());
        throw e;
    }
    }
    
    }

