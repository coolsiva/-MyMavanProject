package sikuliDemo;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

public class GoogleSearch {
	
	WebDriver driver;
	
	@Test
	public void search()
	{
		driver.get("http://www.google.com");
		
	}

}
