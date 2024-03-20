package Shopping.Website;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Shopping.Website.PageObject.CartPage;
import Shopping.Website.PageObject.CheckOutPage;
import Shopping.Website.PageObject.LoginPage;
import Shopping.Website.PageObject.ProductPage;
import TestComp.TestComp;

public class SubmitOrder extends TestComp {
	
	@Test (dataProvider="getData", groups = {"purchase"})
	public void TestEcomm(HashMap<String, String> input) throws IOException { 
		// public static void main(String[] args) throws InterruptedException {
		// Commented because converted to Testng with @test

		// TODO Auto-generated method stub
		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		//String ProductName = "ZARA COAT 3";

		LoginPage loginPage = LaunchApplication();
		// driver.get("https://rahulshettyacademy.com/client");
		// LandingPage landingPage= new LandingPage(driver);
		// landingPage.goTo();

		//Since dataProvider is added we can remove the following and add the names 
	//	ProductPage productCatalog = loginPage.LoginApplication("anshika@gmail.com", "Iamking@000");

		ProductPage productCatalog = loginPage.LoginApplication(input.get("email"), input.get("password"));

		// driver.findElement(By.id("userEmail")).sendKeys("anshika@gmail.com");
		// driver.findElement(By.id("userPassword")).sendKeys("Iamking@000");
		// driver.findElement(By.id("login")).click();

		// ProductCatalog productCatalog= new ProductCatalog(driver); This is commented
		// because 38 line is added

		// ProductCatalog productCatalog= new ProductCatalog(driver);
		List<WebElement> products = productCatalog.getProductList();

		// List<WebElement> products =
		// driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));
		productCatalog.addProductToCart(input.get("product"));

		productCatalog.addProductToCart(input.get("product"));

		// WebElement prod = products.stream().filter(product->
		// product.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals("ZARA
		// COAT 3")).findFirst().orElse(null);
		// prod.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();

		// WebDriverWait WaitForToast = new WebDriverWait(driver,
		// Duration.ofSeconds(10));
		// WaitForToast.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		// WaitForToast.until(ExpectedConditions.invisibilityOfElementLocated(By.tagName("//ngx-spinner")));
		

		CartPage cartPage = productCatalog.CartHeader();

		// driver.findElement(By.cssSelector("[routerlink*=cart]")).click();

		// CartPage cartPage= new CartPage(driver); == commented because line 60 is
		// added

		// CartPage cartPage= new CartPage(driver);
		// List <WebElement> CartProducts=
		// driver.findElements(By.cssSelector(".cartSection h3"));
		

		Boolean Match = cartPage.VerifyProductDisplay("product");
		// Boolean Match =
		// CartProducts.stream().anyMatch(CartProduct->CartProduct.getText().equalsIgnoreCase(ProductName));
	
		Assert.assertFalse(Match);

		// Assert conditions will remain same in page object model.
		

		CheckOutPage Page = cartPage.CheckoutButton();
		// driver.findElement(By.xpath("//button[.='Checkout']")).click();

		// CheckoutPage Page= new CheckoutPage(driver); == commented because line 75 is
		// added
		// CheckoutPage Page= new CheckoutPage(driver);

		Page.SelectCountryField("India");
		Page.SubmitOrder();

		// Actions a= new Actions(driver);
		// a.sendKeys(driver.findElement(By.cssSelector("input[placeholder$='Select
		// Country']")),"India").build().perform();
		// WebDriverWait WaitF = new WebDriverWait(driver, Duration.ofSeconds(20));
		// WaitF.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector(".ta-results")));
		// driver.findElement(By.xpath("(//i[@class='fa fa-search'])[2]")).click();
		// WebElement OrderPlace =
		// driver.findElement(By.cssSelector(".action__submit"));
		// a.scrollToElement(OrderPlace);
		// WebDriverWait PlacOrderWait = new WebDriverWait(driver,
		// Duration.ofSeconds(50));
		// PlacOrderWait.until(ExpectedConditions.elementToBeClickable(OrderPlace));
		// WebElement element = driver.findElement(By.cssSelector(".action__submit"));
		// ((JavascriptExecutor)
		// driver).executeScript("arguments[0].scrollIntoView(true);", element);
		// driver.findElement(By.cssSelector(".action__submit")).click();
		// driver.findElement(By.cssSelector(".action__submit")).click();
		// OrderPlace.click();
		// String Confirmation=
		// driver.findElement(By.cssSelector(".hero-primary")).getText();
		// Assert.assertEquals(Confirmation, "Thankyou for the order.");

	}
	@DataProvider
	public Object[][] getData() throws IOException
	{
	// HashMap<String, String> map = new HashMap<String, String>();
//	 map.put("email", "anshika@gmail.com");
//	 map.put("password", "Iamking@000");
//	 map.put("productName", "ZARA COAT 3");
	 
//	 HashMap<String, String> map1 = new HashMap<String, String>();
//	 map1.put("email", "shetty@gmail.com");
//	 map1.put("password", "Iamking@000");
//	 map1.put("productName", "IPHONE 13 PRO");
	List<HashMap<String, String>> data = getJsonDataToMap(System.getProperty("user.dir") + "//src//test//java//Website//data//PurchaseOrder.Json");	
	return new Object[][] {{data.get(0)}, {data.get(1)}};
	 
	 
	}
	
	
	//@DataProvider
	//DataProvider will provide the data required in the selected class. 
	//public Object[][] getData()
	//{
		//If you want to run the test with two different data set then simply create two dimensional array. 
		//this is two dimensional syntax. for two data set two curly braces will be used. 
		//Object is something which is parent data the data can be string or integer so object is generic dataset which is used. 
	//	return new Object [] [] {{"anshika@gmail.com", "Iamking@000", "ZARA COAT 3"}, {"shetty@gmail.com", "Iamking@000", "IPHONE 13 PRO"}};
	
	
	//}
}
