package StepDefination;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

import Shopping.Website.PageObject.CartPage;
import Shopping.Website.PageObject.CheckOutPage;
import Shopping.Website.PageObject.LoginPage;
import Shopping.Website.PageObject.ProductPage;
import TestComp.TestComp;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.*;

public class StepDefinationImp extends TestComp  {
	
	public LoginPage LoginPage;
	public ProductPage productCatalog;
	public CheckOutPage Page;
	
	@Given("I landed on Ecommerce page")
	public void I_landed_on_Ecommerce_page() throws IOException
	{
		LoginPage = LaunchApplication();
	}
	
    @Given("^logged in with username (.+) and password (.+)$")
    public void logged_in_with_username_and_password(String username, String password)
    {
		productCatalog = LoginPage.LoginApplication(username, password);

    }
    
    @When("^I add the product (.+) to cart$")
    public void add_the_product_to_cart(String ProductName)
    {
    	List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(ProductName);
    }
    
    @Then("^Checkout (.+)and submit$")
    public void Checkout_ProductName_and_submit()
    {
    	CartPage cartPage = productCatalog.CartHeader();
		Boolean Match = cartPage.VerifyProductDisplay("product");
		Assert.assertFalse(Match);
		CheckOutPage Page = cartPage.CheckoutButton();
		Page.SelectCountryField("India");
		Page.SubmitOrder();
		driver.close();
    }
    
    }


 
