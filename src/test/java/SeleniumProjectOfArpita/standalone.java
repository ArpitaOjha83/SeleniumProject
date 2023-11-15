package SeleniumProjectOfArpita;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumProject.pageobjects.LoginPage;

public class standalone {

	public static void main(String[] args) {
		
		
		String productName = "Wireless Speaker";
		//go to url
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		driver.get("https://www.deloittemerchglobal.com");
		
		LoginPage loginpage = new LoginPage(driver);
		
		
		//login
		driver.findElement(By.name("login")).sendKeys("arpitaojha@deloitte.com");
		driver.findElement(By.id("password")).sendKeys("Hello123");
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		
		//modal dialog close
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginModal")));
		WebElement md = driver.findElement(By.id("loginModal")); 
	//	System.out.println(md.getText());
		md.click();
		md.sendKeys(Keys.ESCAPE);
		
	
		
		
		//search speaker
		driver.findElement(By.xpath("(//input[@id='key'])[1]")).sendKeys("SPEAKER");
	    driver.findElement(By.xpath("(//button[@value='Search'])[1]")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div//div[@class='item']")));
	    List<WebElement> products = driver.findElements(By.xpath("//div//div[@class='item']"));
		 
	 
	    
	    //click first available speaker
	    WebElement prod = products.stream().filter(product->
	    product.findElement(By.xpath("//div[@class='item-title']/span")).getText().contains(productName)).findFirst().orElse(null);
	    prod.click();
	    
	    
	    //click cart to cart
	    driver.findElement(By.xpath("//a[@alt='add to cart']")).click();
	    wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h3[@class='item-title']/a")));
	    
	    
	    //verify added cart item
	    List <WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='basket-view']//article//div"));
	    WebElement cprod = cartProducts.stream().filter(cproduct->
	    cproduct.findElement(By.xpath("//aside//div//div//h3")).getText().contains(productName)).findFirst().orElse(null);
	    Assert.assertTrue(true);
	    System.out.println("Product is added successfully");
	    
	    
	   
	  
	    //Remove product from Cart
	    for (int i=0;i<=cartProducts.size()-1;i++)
	   	   {
	   	    	if(cartProducts.get(i).getText().contains(productName))
	   	    	{
	   	    		driver.findElement(By.xpath("//i[@class='ti-close ada_screen_icon']")).click();
	   	    		System.out.println("Added Product is removed from the cart ");
	   	    		//Assert.assertTrue(true);
	   	   		break;
	   	    	}
	    
	   	   } 
		   
		   //logout
		   driver.findElement(By.xpath("//li[@id='welcome-data']//i[@class='ti-power-off']")).click();
		   
		  
		 
		   
//			public void VerifyHomeDisplayed()
//			{
			 
//			 if(checkHomepage.isDisplayed())
//			 {
//			 System.out.println("HomePage is displayed");
//			 }
//			 else
//			 {
//				 System.out.println("Homepage is not diaplyed");
//			 }
//			}
	       

//			public void VerifyCartProduct (String productName)
//			{
				
//				for (int i=0;i<=cartprod.size()-1;i++)
//					 	   {
//					if(cartprod.get(i).getText().equals(productName))
//					   	    	{
//						        System.out.println(  "Product is added sucessfully ");
//					   	    	break;
					   	   	
//					   	    	}
//					 	   }
				
//			 }
			
			
		   
		//follow: https://www.youtube.com/watch?v=BKefIqoUD3w
//			LoginPage loginpage = new LoginPage(driver);
	
	}

}
