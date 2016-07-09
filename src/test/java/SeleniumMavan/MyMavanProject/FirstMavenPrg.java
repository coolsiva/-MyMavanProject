package SeleniumMavan.MyMavanProject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Helper.captureScreenshot;

public class FirstMavenPrg {
	
	WebDriver driver;
	ExtentReports report;
	ExtentTest logger;

	
	@Test
	public void demorun()
	
	{
		
		report = new ExtentReports("./Reports//customer.html");
		logger = report.startTest("demorun");
		
		System.out.println("welcome to maven");
		System.setProperty("webdriver.chrome.driver", "./chromedriver.exe");
		driver = new ChromeDriver();
		
		logger.log(LogStatus.INFO, "your chrome browser started  ");
		
		driver.get("http://www.google.com");

		logger.log(LogStatus.INFO, " ==== opening google ");
		Assert.assertTrue(driver.getTitle().contains("Goo;"));
		
		
	}
	
	@AfterMethod
	public void teardown(ITestResult result)
	{
		if (result.getStatus() == ITestResult.FAILURE)
		{
			String path = captureScreenshot.screenshot(driver, result.getName());
			
			String testpath = logger.addScreenCapture(path);
			
			logger.log(LogStatus.FAIL,"Verified title" , testpath );
			
			
		}
		
		report.endTest(logger);
		
		report.flush();
		
		driver.close();
		
	}

}
