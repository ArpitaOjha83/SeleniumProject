package SeleniumProjectOfArpita;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dev.failsafe.internal.util.Assert;





public class Secondbackup {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		
		//****Login into Deloitte mercant portal with user id and password displayed****	
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.deloittemerchglobal.com");
		driver.manage().window().maximize();
		
	//	driver.findElement(By.xpath("//a[@class='downtime19_close_btn ada_screen_text']")).click();
		
		
		driver.findElement(By.name("login")).sendKeys("arpitaojha@deloitte.com");
		
		driver.findElement(By.id("password")).sendKeys("Hello123");
		
		driver.findElement(By.cssSelector("input[value='Login']")).click();
		
		
		
		WebElement md = driver.findElement(By.id("loginModal")); 
		System.out.println(md.getText());
		
		md.click();
		md.sendKeys(Keys.ESCAPE);
	   
		
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		 WebElement checkLogin = driver.findElement(By.xpath("//ul[@class='navbar-nav']/li[1]/a[1]"));
		 
		 if(checkLogin.isDisplayed())
		 {
		System.out.println("HomePage is displayed");
			}
		 else
		 {
			 System.out.println("Homepage is not diaplyed");
		 }
		 
		 
		 
		 //Print total number of links in console
		 
		 List<WebElement> links = driver.findElements(By.tagName("a"));
	     System.out.println("The number of links is " + links.size());
	     
	     //search speaker and enter
	     
	
	  //   WebElement search = driver.findElement(By.xpath("(//input[@id='key'])[1]"));
	   //  search.click();
	  //   search.sendKeys("Speaker");
	     
	   //  WebElement searchButton = driver.findElement(By.xpath("(//button[@value='Search'])[1]"));
	   //  searchButton.click();
	     
	   
	     WebElement searchlist  = driver.findElement(By.xpath("(//input[@id='key'])[1]"));
	        // enter the search word
	        searchlist.sendKeys("Speaker");
	        // hit enter
	        searchlist.sendKeys(Keys.RETURN);
	     
	     
	     //verify if search product is displayed
	        
	      
	        WebElement  tagName= driver.findElement(By.xpath(" //div[@class='showing-results product-listing']/span[contains(.,'SPEAKER')]"));
	       
	    
	        System.out.println(tagName.getText()); 
	        String searchTagName = tagName.getText();
	   
	        Boolean Display = tagName.isDisplayed();
	     
	       System.out.println("Element displayed is :"+searchTagName);
	        
	   
	   
	  
	//   for (String element: searchTagName.split("\"")) 
	//   {
	//         System.out.println(element);
	      //   String ExpectedValue = "SPEAKER";
	  
	   	
	     //(//div[@class='item'])[1]
	     //  driver.findElement(By.xpath("@id=\"products_list\"]//div[@class=\"item\"]::nth-child(1)")).click();
	       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	   //    driver.findElement(By.xpath("//a[@id='parent-title-71681']")).click();
	    
	   //    (//div[@class='item-detail'])[1]
	   String searchProductName = driver.findElement(By.xpath(" //*[@id=\"products_list\"]/div/div[1]/div")).getText();
	  //     String searchProductName = driver.findElement(By.xpath("//*[@class='item-detail'])[1]")).getText();
	     
	    String[] words =  searchProductName.split("\\s+");
	    System.out.println("Searched product is " + words[1]);
	    String searchprod = words[1];
	    System.out.println("**************" + searchprod);
	     
	  //  System.out.println(searchProductName);
	       driver.findElement(By.xpath(" //*[@id=\"products_list\"]/div/div[1]/div")).click();
	       
	       //Add to cart
	       driver.findElement(By.xpath("//a[@alt='add to cart']")).click();
	       
	    String productInCart = driver.findElement(By.xpath("//h3[@class='item-title'][1]")).getText();
	    System.out.println("Product added in cart is  " + productInCart);
	    String[] cartProduct =  productInCart.split("\\s+");
	    
	   String cartProd= cartProduct[1];
	   System.out.println("**************" + cartProd);
	
	   
	 //berify prodt i need to write
	//   driver.find_element_by_xpath('//a[@href="'+url+'"]')
	    
	    
	   driver.findElement(By.xpath("//i[@class='ti-close ada_screen_icon']")).click();
	   driver.findElement(By.xpath("//li[@id='welcome-data']//i[@class='ti-power-off']")).click();
	    
	   
//		Actions action = new Actions(driver);
		
		//	action.moveToElement(driver.findElement(By.xpath("//div[@class='modal-dialog']//div//div//button/span]"))).click().build().perform();
		//	action.sendKeys(Keys.ESCAPE);
			
	   //   Iterator<WebElement> itr = cartProducts.iterator();
		//	   while(itr.hasNext()) {
		//	     System.out.println(itr.next().getText());
		//	   }
			   
			   
			
	   //  for (int i=0;i<=cartProducts.size()-1;i++)
		 //   {
		  //  	if(cartProducts.get(i).getText().contains(productName))
		 //   	{
		  //  		System.out.println("Product is added successfuly");
		  //  		Assert.assertTrue(true);
		  //  		break;
		  //  	}
		  //  }
			
			
			
//			WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	    
	   } 
	   
	
	}



//verify added cart item
//List <WebElement> cartProducts = driver.findElements(By.xpath("//div[@class='basket-view']//article//div"));
//WebElement cprod = cartProducts.stream().filter(cproduct->
//cproduct.findElement(By.xpath("//aside//div//div//h3")).getText().contains(productName)).findFirst().orElse(null);
//cprod.click();


//   Boolean match = cartProducts.stream().anyMatch(cartProduct-> cartProduct.getText().contains(productName));
//   Assert.assertTrue(match);
//  for (int i=0;i<=cartProducts.size()-1;i++)
//   {
//  	if(cartProducts.get(i).getText().contains(productName))
//   	{
//  		System.out.println("Product is added successfuly");
//  		Assert.assertTrue(true);
//  		break;
//  	}
//  }



//remove the same item
 
//  	   WebElement addedCartProd = cartProducts.stream().filter(cartProduct->
//      cartProduct.findElement(By.xpath("//div[@class='basket-view']//article//div/aside/div/div/h3")).getText().contains(productName)).findFirst().orElse(null);


