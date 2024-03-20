package Shopping.Website.PageObject;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Shopping.Website.AbstractComp.AbstractComp;

public class CheckOutPage extends AbstractComp {
	WebDriver driver;

	public CheckOutPage(WebDriver driver) {
		super(driver);
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(css = "input[placeholder$='Select Country']")
	WebElement SelectCountryField;

	@FindBy(xpath = "(//i[@class='fa fa-search'])[2]")
	WebElement SelectIndia;

	@FindBy(xpath = ".action__submit")
	WebElement SubmitButton;

	By WaitForList = By.cssSelector(".ta-results");

	public void SelectCountryField(String CountryName) {
		Actions a = new Actions(driver);
		a.sendKeys(SelectCountryField, CountryName).build().perform();
		WebDriverWait WaitF = new WebDriverWait(driver, Duration.ofSeconds(20));
		WaitF.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(WaitForList));
		SelectIndia.click();
	}

	public void SubmitOrder() {
		SubmitButton.click();
	}

}
