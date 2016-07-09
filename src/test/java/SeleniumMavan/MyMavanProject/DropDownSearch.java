package SeleniumMavan.MyMavanProject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class DropDownSearch {
	
	@Test
	public void GoogleDropDown()
	{

		System.setProperty("webdriver.chrome.driver","./chromedriver.exe" );
	
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://www.redbus.in");
		
		driver.findElement(By.id("txtSource")).sendKeys("chem");
		
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		JavascriptExecutor je = (JavascriptExecutor)driver;
		
		WebElement element = driver.findElement(By.xpath(".//li[contains(text(),'Chemmad')]"));
		
		boolean chemmad = element.isDisplayed();
		System.out.println(chemmad);
		je.executeScript("arguments[0].scrollIntoView(true)", element);
		element.click();
		je.executeScript("scroll(0,400)");
		
		try {
			Thread.sleep(7500);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		driver.quit();
		
		
		
		
	}

}
