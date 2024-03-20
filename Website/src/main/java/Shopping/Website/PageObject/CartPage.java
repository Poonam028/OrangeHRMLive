package Shopping.Website.PageObject;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shopping.Website.AbstractComp.AbstractComp;

public class CartPage extends AbstractComp {
	WebDriver driver;

	public CartPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = ".cartSection h3")
	List<WebElement> CartProducts;

	@FindBy(xpath = "//button[.='Checkout']")
	WebElement CheckoutButton;

	public List<WebElement> CartProduct() {
		return CartProducts;

	}

	public Boolean VerifyProductDisplay(String ProductName) {
		Boolean Match = CartProducts.stream()
				.anyMatch(CartProduct -> CartProduct.getText().equalsIgnoreCase(ProductName));
		return Match;

	}

	public CheckOutPage CheckoutButton() {
		CheckoutButton.click();
		CheckOutPage Page = new CheckOutPage(driver);
		return Page;
	}

}


