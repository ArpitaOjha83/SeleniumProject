package seleniumProject.pageobjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumProject.AbstractComponents.AbstractComponent;

public class Logout extends AbstractComponent{
	
	WebDriver driver;
	
	
	public Logout(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	
	@FindBy(xpath="//i[@class='ti-power-off']")
	WebElement logout;
	
	By logoutBy = By.xpath("//i[@class='ti-power-off']");
	
	
	public void LogOut() throws InterruptedException
	{
		//waitForElementToAppear(logoutBy);
		Thread.sleep(2000);
		logout.click();
	}
	
	

	

	
	
	
}
