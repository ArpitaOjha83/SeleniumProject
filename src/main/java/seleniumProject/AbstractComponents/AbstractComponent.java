package seleniumProject.AbstractComponents;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;



public class AbstractComponent  {
	
	static WebDriver driver;
	
	public AbstractComponent(WebDriver driver)
	{
		
		
		this.driver = driver;
		
	}

	public void waitForElementToAppear(By findBy)
	{
	
	WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
	wait.until(ExpectedConditions.visibilityOfElementLocated(findBy));
	}
	
	
	
	public void scroll()
	{
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,600)");	
	}
	
	
	public static void captureScreenshot(String screenshotName) 
	{
		
		try {
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File src = ts.getScreenshotAs(OutputType.FILE);
			FileUtils.copyFile(src, new File("./Screenshots/"+ screenshotName+".png"));
			
		} catch (Exception e) {
			
			System.out.println("Exception while taking screenshot" + e.getMessage());
		//	e.printStackTrace();
		}
	}
	
}
