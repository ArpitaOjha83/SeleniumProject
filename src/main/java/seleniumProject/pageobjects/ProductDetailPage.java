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

public class ProductDetailPage extends AbstractComponent{
	
	WebDriver driver;
	
	
	public ProductDetailPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

		
	@FindBy(xpath="//a[@alt='add to cart']")
	WebElement addtocart;
	
	By addtocartBy = By.xpath("//a[@alt='add to cart']");
	
	
	
	public void goTo()
	{
	   driver.get("https://www.deloittemerchglobal.com");

	}
	
	public void AddToCart()
	{
		waitForElementToAppear(addtocartBy);
		scroll();
		
		addtocart.click();
	}
	

	
	
	
	
}
