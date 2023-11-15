package seleniumProject.pageobjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumProject.AbstractComponents.AbstractComponent;

public class LoginPage extends AbstractComponent{
	
	public WebDriver driver;
	
	
	public LoginPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(name="login")
	WebElement userEmail;
	
	
	@FindBy(id="password")
	WebElement passwordEle;
	
	
	@FindBy(css="input[value='Login']")
	WebElement submit;
	
	
	@FindBy(xpath="//div[@class='modal-content']/div//button//span")
	WebElement modalclose;
	
	@FindBy(tagName = "a") 
	List<WebElement> allLinks;
	
	//a[@class='navbar-brand']//img[@alt="Online Store"]
	@FindBy(xpath="//a[@class='navbar-brand']//img[@alt='Online Store']")
	WebElement verifyHome;
	

	By allLinksBy = By.tagName("a");
	By modalcloseBy = By.xpath("//div[@class='modal-content']/div//button//span");
	
	
	public void loginApplication(String email, String password)
	{
		userEmail.sendKeys(email);
		passwordEle.sendKeys(password);
		submit.click();
	}
	
	public void goTo()
	{
	   driver.get("https://www.deloittemerchglobal.com");
	  
	 

	}
	
	public void closeModal()
	{
		
		 waitForElementToAppear(modalcloseBy);
	      modalclose.click();	
		
	}
	
	
	
	
	
	public boolean VerifyHomeDisplayed()
	{
	 
	 return verifyHome.isDisplayed();
	
	}
	
	public int  PrintTotalLinkInHome()
	{
	 
		return allLinks.size();
	
	}
	
	
	
	

	

	
	
	
}
