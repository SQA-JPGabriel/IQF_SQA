package testcase;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import utilities.ReadXLSData;
import utilities.ScreenshotUtil;

import com.aventstack.extentreports.MediaEntityBuilder;
import utilities.ScreenshotUtil;

public class MV extends BaseTest {

	@Test(priority = 1, dataProvider = "xlsTestData", dataProviderClass = ReadXLSData.class)  
    public void SearchByPlateNumber(String username, String password, String plateno, String Name, String BirthDate ) throws InterruptedException, IOException 
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
            
            driver.findElement(By.xpath(prop.getProperty("ByPlateNumberLink"))).click();
            Thread.sleep(3000);
        	driver.findElement(By.xpath(prop.getProperty("PlateNoFld"))).sendKeys(plateno);
        	Thread.sleep(3000);
        	driver.findElement(By.xpath(prop.getProperty("PlateNoFld"))).sendKeys(Keys.ENTER);
        	Thread.sleep(3000);
        	

        	boolean testFailed = false;
        	// Name validation
        	if (driver.findElement(By.xpath(prop.getProperty("MVName"))).getText().equals(Name)) {
        	    System.out.println("Name matches");
        	    test.info("Test Data name matches " + Name);
        	    test.pass("Name Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Match!")).build());
            	
        	    Actions actions = new Actions(driver);
            	actions.sendKeys(Keys.PAGE_DOWN).perform();
            	actions.sendKeys(Keys.PAGE_DOWN).perform();
        	} else {
        	    test.fail("Name MISMATCH!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Mismatch!")).build());
        	    testFailed = true;
        	}

        	// Birthdate validation
        	if (driver.findElement(By.xpath(prop.getProperty("MVBDay"))).getText().equals(BirthDate)) {
        	    System.out.println("birthdate matches");
        	    test.info("Test Data birthday matches " + BirthDate);
        	    test.pass("Birthday Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Birthday Match!")).build());
        	    
        	    Actions actions = new Actions(driver);
            	actions.sendKeys(Keys.PAGE_DOWN).perform();
            	actions.sendKeys(Keys.PAGE_DOWN).perform();
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
	public void SearchByEngineNumber(String username, String password, String engineno, String Name, String BirthDate ) throws InterruptedException, IOException 
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
            
            driver.findElement(By.xpath(prop.getProperty("ByEngineNumberLink"))).click();
            Thread.sleep(3000);
        	driver.findElement(By.xpath(prop.getProperty("EngineNoFld"))).sendKeys(engineno);
        	Thread.sleep(3000);
        	driver.findElement(By.xpath(prop.getProperty("EngineNoFld"))).sendKeys(Keys.ENTER);
        	Thread.sleep(3000);
        	

        	boolean testFailed = false;
        	// Name validation
        	if (driver.findElement(By.xpath(prop.getProperty("MVName"))).getText().equals(Name)) {
        	    System.out.println("Name matches");
        	    test.info("Test Data name matches " + Name);
        	    test.pass("Name Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Match!")).build());
            	
        	    Actions actions = new Actions(driver);
            	actions.sendKeys(Keys.PAGE_DOWN).perform();
            	actions.sendKeys(Keys.PAGE_DOWN).perform();
        	} else {
        	    test.fail("Name MISMATCH!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Mismatch!")).build());
        	    testFailed = true;
        	}

        	// Birthdate validation
        	if (driver.findElement(By.xpath(prop.getProperty("MVBDay"))).getText().equals(BirthDate)) {
        	    System.out.println("birthdate matches");
        	    test.info("Test Data birthday matches " + BirthDate);
        	    test.pass("Birthday Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Birthday Match!")).build());
        	    
        	    Actions actions = new Actions(driver);
            	actions.sendKeys(Keys.PAGE_DOWN).perform();
            	actions.sendKeys(Keys.PAGE_DOWN).perform();
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
	
	@Test(priority = 3, dataProvider = "xlsTestData", dataProviderClass = ReadXLSData.class)
	public void SearchByChassisNumber(String username, String password, String chassisno, String Name, String BirthDate ) throws InterruptedException, IOException 
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
	            
	            driver.findElement(By.xpath(prop.getProperty("ByChassisNumberLink"))).click();
	            Thread.sleep(3000);
	        	driver.findElement(By.xpath(prop.getProperty("ChassisNoFld"))).sendKeys(chassisno);
	        	Thread.sleep(3000);
	        	driver.findElement(By.xpath(prop.getProperty("ChassisNoFld"))).sendKeys(Keys.ENTER);
	        	Thread.sleep(3000);
	        	

	        	boolean testFailed = false;
	        	// Name validation
	        	if (driver.findElement(By.xpath(prop.getProperty("MVName"))).getText().equals(Name)) {
	        	    System.out.println("Name matches");
	        	    test.info("Test Data name matches " + Name);
	        	    test.pass("Name Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Match!")).build());
	            	
	        	    Actions actions = new Actions(driver);
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	        	} else {
	        	    test.fail("Name MISMATCH!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Mismatch!")).build());
	        	    testFailed = true;
	        	}

	        	// Birthdate validation
	        	if (driver.findElement(By.xpath(prop.getProperty("MVBDay"))).getText().equals(BirthDate)) {
	        	    System.out.println("birthdate matches");
	        	    test.info("Test Data birthday matches " + BirthDate);
	        	    test.pass("Birthday Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Birthday Match!")).build());
	        	    
	        	    Actions actions = new Actions(driver);
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
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
		
	@Test(priority = 4, dataProvider = "xlsTestData", dataProviderClass = ReadXLSData.class)
	public void SearchByEngineAndChassisNumber(String username, String password, String engineno, String chasisno, String Name, String BirthDate ) throws InterruptedException, IOException 
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
	            
	            driver.findElement(By.xpath(prop.getProperty("ByPalteNumberAndChassesNumberLink"))).click();
	            Thread.sleep(3000);
	            
	        	//Element ChassisNoFld was tagged as EngineNoFld
	            //In order to fix this i swapped the data driven variable for ChassisNoFld and EngineNoFld
	            driver.findElement(By.xpath(prop.getProperty("ChassisNoFld"))).sendKeys(engineno);
	            
	        	driver.findElement(By.xpath(prop.getProperty("EngineNoFld"))).sendKeys(chasisno);
	        	
	        	driver.findElement(By.xpath(prop.getProperty("EngineNoFld"))).sendKeys(Keys.ENTER);
	        	Thread.sleep(3000);


	        	boolean testFailed = false;
	        	// Name validation
	        	if (driver.findElement(By.xpath(prop.getProperty("MVName"))).getText().equals(Name)) {
	        	    System.out.println("Name matches");
	        	    test.info("Test Data name matches " + Name);
	        	    test.pass("Name Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Match!")).build());
	            	
	        	    Actions actions = new Actions(driver);
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	        	} else {
	        	    test.fail("Name MISMATCH!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Mismatch!")).build());
	        	    testFailed = true;
	        	}

	        	// Birthdate validation
	        	if (driver.findElement(By.xpath(prop.getProperty("MVBDay"))).getText().equals(BirthDate)) {
	        	    System.out.println("birthdate matches");
	        	    test.info("Test Data birthday matches " + BirthDate);
	        	    test.pass("Birthday Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Birthday Match!")).build());
	        	    
	        	    Actions actions = new Actions(driver);
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
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
		
	@Test(priority = 5, dataProvider = "xlsTestData", dataProviderClass = ReadXLSData.class)
	public void SearchByMVFileNumber(String username, String password, String mvfileno, String Name, String BirthDate ) throws InterruptedException, IOException 
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
	            
	            driver.findElement(By.xpath(prop.getProperty("ByMVFileNumberLink"))).click();
	            Thread.sleep(3000);
	        	driver.findElement(By.xpath(prop.getProperty("MVFielNoFld"))).sendKeys(mvfileno);
	        	Thread.sleep(3000);
	        	driver.findElement(By.xpath(prop.getProperty("MVFielNoFld"))).sendKeys(Keys.ENTER);
	        	Thread.sleep(3000);
	        	

	        	boolean testFailed = false;
	        	// Name validation
	        	if (driver.findElement(By.xpath(prop.getProperty("MVName"))).getText().equals(Name)) {
	        	    System.out.println("Name matches");
	        	    test.info("Test Data name matches " + Name);
	        	    test.pass("Name Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Match!")).build());
	            	
	        	    Actions actions = new Actions(driver);
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	        	} else {
	        	    test.fail("Name MISMATCH!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Name Mismatch!")).build());
	        	    testFailed = true;
	        	}

	        	// Birthdate validation
	        	if (driver.findElement(By.xpath(prop.getProperty("MVBDay"))).getText().equals(BirthDate)) {
	        	    System.out.println("birthdate matches");
	        	    test.info("Test Data birthday matches " + BirthDate);
	        	    test.pass("Birthday Match!", MediaEntityBuilder.createScreenCaptureFromPath(ScreenshotUtil.captureScreenshot(driver, "Birthday Match!")).build());
	        	    
	        	    Actions actions = new Actions(driver);
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
	            	actions.sendKeys(Keys.PAGE_DOWN).perform();
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
    
    }

