package Helper;

import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;



public class captureScreenshot {
	
	public  static String screenshot(WebDriver driver, String name) 
	{
		try 
		{
			TakesScreenshot ts = (TakesScreenshot)driver;
			
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			String dest = "C:\\Users\\Elcot\\workspace\\MyMavanProject\\Screenshot" + name + ".png";
		
			File destination = new File(dest);
				
				FileUtils.copyFile(source, destination);
				
				return dest;
				
		} 
		catch (Exception e) 
		{
			
			 e.printStackTrace();
			 return e.getMessage();
		}
	
		
		
		
	}

}
