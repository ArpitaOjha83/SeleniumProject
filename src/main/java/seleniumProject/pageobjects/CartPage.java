package seleniumProject.pageobjects;

import java.time.Duration;
import java.time.temporal.TemporalAmount;
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

public class CartPage extends AbstractComponent {
	
	WebDriver driver;
	
	
	public CartPage(WebDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	


	
	By cartprodTitleBy = By.xpath("//h3[@class='item-title']/a");

	@FindBy(xpath="//div[@class='basket-view']//article//div//h3")
	List<WebElement> cartproducts;
	
	@FindBy(xpath="//h3[@class='item-title']/a")
	List<WebElement> cartprodTitle;
	
		
//	@FindBy(xpath="//i[@class='ti-close ada_screen_icon']")
	@FindBy(xpath="//h3[@class='item-title']/a/ancestor::div//aside//i[@class='ti-close ada_screen_icon']")
	WebElement removeproduct;
	
	
	
	
	public List<WebElement> getCartProductList()
	{
		
		return cartproducts;
	}
	
	public List<WebElement> getCartProduct()
	{
		
		return cartprodTitle;
	}
	


	
	public Boolean VerifyCartProduct(String productName)
	{
	
	Boolean match= 	cartprodTitle.stream().anyMatch(cproduct->cproduct.getText().equalsIgnoreCase(productName));
	return match;
			
	}
	
	
	public void Removeproduct (String productName)
	{
		waitForElementToAppear(cartprodTitleBy);
		for (int i=0;i<=cartprodTitle.size()-1;i++)
			 	   {
			if(cartprodTitle.get(i).getText().equals(productName))
			   	    	{
				       
			   	    	System.out.println(cartprodTitle.get(i).getText()+  " is removed from the cart ");
			   	    	
			   	        removeproduct.click();
			   	        break;
			   	   	
			   	    	}
			
			 	   }
		
			 }
	
	
	
		
	
}




