package Shopping.Website.PageObject;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Shopping.Website.AbstractComp.AbstractComp;

public class LoginPage extends AbstractComp {
	WebDriver driver;

	public LoginPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(id = "userEmail")
	WebElement userEmail;

	@FindBy(id = "userPassword")
	WebElement Password;

	@FindBy(id = "login")
	WebElement submitbutton;
	
	@FindBy(css = "[Class*='flyInOut']")
	WebElement ErrorMessage;

	public ProductPage LoginApplication(String email, String password) {
		userEmail.sendKeys(email);
		Password.sendKeys(password);
		submitbutton.click();
		ProductPage productCatalog = new ProductPage(driver);
		return productCatalog;

	}

	public void goTo() {
		driver.get("https://rahulshettyacademy.com/client");
	}
	public String errorMessage() {
		 WaitForErrorMessage(ErrorMessage);
		return ErrorMessage.getText();
}
		
}
		
		
		
		