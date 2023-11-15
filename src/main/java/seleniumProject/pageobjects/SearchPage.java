package seleniumProject.pageobjects;

import java.time.Duration;
import java.util.List;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import seleniumProject.AbstractComponents.AbstractComponent;

public class SearchPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public SearchPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	

	@FindBy(xpath="//ul[@class='login-icon-list']//input[@id='key']")
	WebElement searchElement;
	
	

	@FindBy(xpath="//ul[@class='login-icon-list']//button[@value='Search']")
	WebElement search;
	
	
	@FindBy(xpath="//div//div[@class='item']")
	List<WebElement> products;

	By productsBy = By.xpath(("//div//div[@class='item']"));
	By searchElementBy = By.xpath("//ul[@class='login-icon-list']//input[@id='key']");
	
	public void SearchProduct(String productName)
	{
		waitForElementToAppear(searchElementBy);
		searchElement.sendKeys(productName);
		search.click();
		
	}
	
	
	public List<WebElement> getProductList()
	{
		
		waitForElementToAppear(productsBy);
		return products;
	}
	
	
	
	

	public void getFirstProduct(String productName)
	{
		 WebElement prod = getProductList().stream().filter(product->
		 product.findElement(By.xpath("//div[@class='item-title']/span")).getText().contains(productName)).findFirst().orElse(null);
		 prod.click();
		    
	}
	
	
	public boolean verifySearchProduct(String productName)
	{
	//	 Boolean prodName = getProductList().stream().filter(product->
	//	 driver.findElement(By.xpath("//div//div[@class='item']")).getText().contains(productName)).anyMatch().orElse(null);;
		 boolean match = getProductList().stream().anyMatch(product->
		 driver.findElement(By.xpath("//div//div[@class='item']")).getText().contains(productName));  
		 return match;
		
		    
	}
	
}
