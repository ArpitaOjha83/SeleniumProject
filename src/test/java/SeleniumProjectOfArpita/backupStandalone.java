package SeleniumProjectOfArpita;


import java.time.Duration;

import java.util.List;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumProject.AbstractComponents.AbstractComponent;
import seleniumProject.pageobjects.CartPage;
import seleniumProject.pageobjects.LoginPage;
import seleniumProject.pageobjects.Logout;
import seleniumProject.pageobjects.ProductDetailPage;
import seleniumProject.pageobjects.SearchPage;

public class backupStandalone extends AbstractComponent {

	public backupStandalone(WebDriver driver) {
		super(driver);
		
	}

	public static void main(String[] args) throws InterruptedException {
		
		
		String productName = "Wireless Speaker";
		//go to url
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		driver.manage().window().maximize();
		
		
				
		//login
		LoginPage loginpage = new LoginPage(driver);
		loginpage.goTo();
		//loginpage.loginApplication("arpojha@deloitte.com", "Hello123");
		loginpage.loginApplication("arpitaojha@deloitte.com", "Hello123");
		
		
				
		//modal dialog close
	//	loginpage.closeModal();
		
		//verify Home Page is displayed
		loginpage.VerifyHomeDisplayed();
		Boolean match = loginpage.VerifyHomeDisplayed();
		Assert.assertTrue(match);
		System.out.println("Home page is displayed Sucessfully");
		captureScreenshot("Login is sucessful");
		
		

		
		//Print total link in home page
		int totalLink = loginpage.PrintTotalLinkInHome();
		System.out.println("Total link in the webpage is " + totalLink);
		
				
	
	   //search product: speaker in the page
	    SearchPage searchpage = new SearchPage(driver);
	    searchpage.SearchProduct(productName);
	    List<WebElement> products = searchpage.getProductList();
	   
	    
	 
	    //verify if searched product is displayed
	      
	   Boolean verifySearchPage = searchpage.verifySearchProduct(productName);
	   Assert.assertTrue(verifySearchPage);
	   System.out.println("Search Product "+ productName + " is displayed Sucessfully");
	   captureScreenshot("search Speaker");
	
	   
	    
	    
	    //click on  first search product: speaker
	    searchpage.getFirstProduct(productName);
	    captureScreenshot("Search");
	    
	    
	    //click cart to cart
	    ProductDetailPage productdetailpage = new ProductDetailPage(driver);
	    productdetailpage.AddToCart();
	    captureScreenshot("Add to Cart");
	    
	    
	  //verify first search product is added in cart 
    
	    CartPage cartpage = new CartPage(driver);
	  //  cartpage.getCartProductList();
	    Boolean verifyCProduct= cartpage.VerifyCartProduct(productName);
	    Assert.assertTrue(verifyCProduct);
	    System.out.println("Cart Product "+ productName + " is added to cart Sucessfully");
	    captureScreenshot("CartPage");
	    
	    
	    
	 //   Remove the same item
	    cartpage.Removeproduct(productName);
	    captureScreenshot("Product is removedr");
	    
	    
	    
	    //logout
	    
	    Logout logout = new Logout(driver);
	    logout.LogOut();
	    captureScreenshot("Logout complete");
	    
	 
		  
		
		   
		   
		
	 
	
	}

}
