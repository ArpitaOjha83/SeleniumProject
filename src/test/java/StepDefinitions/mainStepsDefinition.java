package StepDefinitions;

import java.time.Duration;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import seleniumProject.AbstractComponents.AbstractComponent;
import seleniumProject.pageobjects.CartPage;
import seleniumProject.pageobjects.LoginPage;
import seleniumProject.pageobjects.Logout;
import seleniumProject.pageobjects.ProductDetailPage;
import seleniumProject.pageobjects.SearchPage;

public class mainStepsDefinition  {
	
	public WebDriver driver ;
	LoginPage loginpage;
	SearchPage searchpage;
	ProductDetailPage productdetailpage;
	CartPage cartpage;
	Logout logout;
	
	
	
	 
	 @Given("User launch the merchant website")
		public void User_launch_the_merchant_website() {
		 WebDriverManager.chromedriver().setup();
		 driver = new ChromeDriver();
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
		 driver.manage().window().maximize();
		 
		}
	
	
	@Given("User in landing page")
	public void user_in_landing_page() {
		loginpage = new LoginPage(driver);
		loginpage.goTo();
		AbstractComponent.captureScreenshot("Deloitte Merchant website is opened");
	    
	}
	
	@When("^User login in application with (.+) and (.+)$")
	public void user_login_in_application(String username, String password) {
		loginpage.loginApplication(username,password);
		loginpage.closeModal();
	}
	
	@Then("User verifies Home Page is displayed")
	public void user_verifies_home_page_is_displayed() {
		loginpage.VerifyHomeDisplayed();
		Boolean match = loginpage.VerifyHomeDisplayed();
		Assert.assertTrue(match);
		System.out.println("**********Home page is displayed Sucessfully*****************");
		AbstractComponent.captureScreenshot("Login is sucessful");
		
	}
	
	@And ("Print total link in home page")
	public void Print_total_link_in_home_page() {
		
		int totalLink = loginpage.PrintTotalLinkInHome();
		System.out.println("Total link in the webpage is " + totalLink);
	}
		
	@Then("^User search the product (.+)$")
	public void User_search_the_product(String productName) {
		
		searchpage = new SearchPage(driver);
		searchpage.SearchProduct(productName);
		AbstractComponent.captureScreenshot("search product");
	
		
	}
	
	@Then("^User verifes if searched product (.+) is displayed$")
	public void User_verifes_if_searched_product_is_displayed(String productName) {
		
	   Boolean verifySearchPage = searchpage.verifySearchProduct(productName);
	   Assert.assertTrue(verifySearchPage);
	   System.out.println("Search Product "+ productName + " is displayed Sucessfully");
	   AbstractComponent.captureScreenshot("Search product is displayed");
		
	}
	

	
	@And("^User clicks on first (.+)$")
	public void user_clicks_on_first_product(String productName) {
		 searchpage.getFirstProduct(productName);
		 AbstractComponent.captureScreenshot("Search"); 
	}
	
	
	@Then("User clicks on Add to Cart")
	public void User_clicks_on_Add_to_Cart(){
		
		productdetailpage = new ProductDetailPage(driver);
	    productdetailpage.AddToCart();
	    AbstractComponent.captureScreenshot("Add to Cart");
		
	}
	
	
	
	@Then("^User verifies first search product (.+) is added to Cart")
	public void User_verifies_first_search_product_is_added_to_Cart(String productName ){
		cartpage = new CartPage(driver);
		Boolean verifyCProduct= cartpage.VerifyCartProduct(productName);
		Assert.assertTrue(verifyCProduct);
		System.out.println("Cart Product "+ productName + " is added to cart Sucessfully");
		AbstractComponent.captureScreenshot("CartPage");
	
		}
	
	
	@Then("^User removes the same cart item (.+)$")
	public void user_removes_the_same_cart_item(String productName) {
	   
		cartpage.Removeproduct(productName);
		AbstractComponent.captureScreenshot("Product is removeded from cart");
	    System.out.println("in cart page *****************");
	}
	
	
	
	@Then("User logs out")
	public void User_logs_out() throws InterruptedException{
		logout = new Logout(driver);
	    logout.LogOut();
	    AbstractComponent.captureScreenshot("Logout complete");
	
		}
	
	
	
	
	
}


