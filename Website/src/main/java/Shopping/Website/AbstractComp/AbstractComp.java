package Shopping.Website.AbstractComp;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Shopping.Website.PageObject.CartPage;

public class AbstractComp {
	WebDriver driver;

	public AbstractComp(WebDriver driver) {
		// TODO Auto-generated constructor stub
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "[routerlink*=cart]")
	WebElement CartHeader;

	public void WaitForElementToAppear(WebElement ele) {
		// WebDriverWait WaitForToast = new WebDriverWait(driver,
		// Duration.ofSeconds(10));
		// WaitForToast.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		WebDriverWait WaitForToast = new WebDriverWait(driver, Duration.ofSeconds(10));
		WaitForToast.until(ExpectedConditions.visibilityOf(ele));
	}
	public void WaitForErrorMessage(WebElement ErrorMeesage) {
		// WebDriverWait WaitForToast = new WebDriverWait(driver,
		// Duration.ofSeconds(10));
		// WaitForToast.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("toast-container"))));
		WebDriverWait WaitForToast = new WebDriverWait(driver, Duration.ofSeconds(10));
		WaitForToast.until(ExpectedConditions.visibilityOf(ErrorMeesage));
		
	}
	public void WaitForElementToDisapper(By findBy) {
		WebDriverWait WaitForToast = new WebDriverWait(driver, Duration.ofSeconds(10));
		WaitForToast.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

	}

	public void goToCartPage(By findBy) {

		WebDriverWait WaitForToast = new WebDriverWait(driver, Duration.ofSeconds(10));
		WaitForToast.until(ExpectedConditions.invisibilityOfElementLocated(findBy));

	}

	public CartPage CartHeader() {
		CartHeader.click();
		CartPage cartPage = new CartPage(driver);
		return cartPage;
	}

}

