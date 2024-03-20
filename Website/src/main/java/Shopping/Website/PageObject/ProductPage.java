package Shopping.Website.PageObject;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shopping.Website.AbstractComp.AbstractComp;

public class ProductPage extends AbstractComp {
	WebDriver driver;

	public ProductPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}
	// List<WebElement> products =
	// driver.findElements(By.xpath("//div[contains(@class, 'mb-3')]"));

	@FindBy(xpath = "//div[contains(@class, 'mb-3')]")
	List<WebElement> products;

	By addToCart = By.xpath(".//div[@class='card-body']/button[2]");
	By spinner = By.tagName("//ngx-spinner");

	@FindBy(id = "toast-container")
	WebElement toast;

	public List<WebElement> getProductList() {
		return products;

	}

	public WebElement getProductByName(String ProductName) {
		WebElement prod = products.stream().filter(product -> product
				.findElement(By.xpath("//div[@class='card-body']//b")).getText().equals("ZARA COAT 3")).findFirst()
				.orElse(null);
		return prod;
	}

	public void addProductToCart(String ProductName) {
		WebElement prod = getProductByName(ProductName);
		prod.findElement(By.xpath(".//div[@class='card-body']/button[2]")).click();
		// need to send the actual webElement
		// WaitForToast.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		WaitForElementToAppear(toast);
		WaitForElementToDisapper(spinner);
	}

}


