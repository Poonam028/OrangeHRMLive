package Shopping.Website;

import org.testng.annotations.Test;
import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import Shopping.Website.PageObject.CartPage;
import Shopping.Website.PageObject.CheckOutPage;
import Shopping.Website.PageObject.LoginPage;
import Shopping.Website.PageObject.ProductPage;
import TestComp.TestComp;

public class ErrorValidationTest extends TestComp {
	
	@Test
	public void TestEcomm() throws IOException {
		String ProductName = "ZARA COAT 3";
		LoginPage loginPage = LaunchApplication();
		ProductPage productCatalog = loginPage.LoginApplication("anshika@gmail.com", "Iaking@000");
		Assert.assertEquals("Incorrect email password.", loginPage.errorMessage());
		
	}
		
		@Test
		public void ProductValidation() throws IOException {
		String ProductName = "ZARA COAT 3";

		LoginPage loginPage = LaunchApplication();
		ProductPage productCatalog = loginPage.LoginApplication("anshika@gmail.com", "Iamking@000");
		List<WebElement> products = productCatalog.getProductList();
		productCatalog.addProductToCart(ProductName);
		CartPage cartPage = productCatalog.CartHeader();
		Boolean Match = cartPage.VerifyProductDisplay(ProductName);
		Assert.assertTrue(Match);
	}
	}


