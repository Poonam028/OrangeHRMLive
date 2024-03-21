package PageModel.Orangehrmlive;
import java.time.Duration;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.ExtentReports;

import io.github.bonigarcia.wdm.WebDriverManager;


public class EndToEndTest {
	WebDriver driver= new ChromeDriver();   

	@SuppressWarnings("deprecation")
		// TODO Auto-generated method stub
	@BeforeTest
	public void config()
	{
	    WebDriverManager.chromedriver().setup();
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("Poonam sawant");
	reporter.config().setDocumentTitle("Priya");
	
    ExtentReports extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Poonam Sawant");
	
	}
	
	@Test
	public void LoginPage() throws InterruptedException
	{
	WebDriver driver= new ChromeDriver();   
	ChromeOptions Opt= new ChromeOptions();
	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(9000);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(7000);
	
	}
	
	//@Test
	
	public void AddUser() throws InterruptedException
	
	{
	driver.findElement(By.xpath("//li[@class='oxd-main-menu-item-wrapper'][1]")).click();
	// Add the users 
	Thread.sleep(7000);
	driver.findElement(By.xpath("//button [.=' Add ']")).click();
	//driver.findElement(By.cssSelector("div.oxd-layout div.oxd-layout-container div.oxd-layout-context div.orangehrm-background-container div.orangehrm-card-container form.oxd-form div.oxd-form-row:nth-child(1) div.oxd-grid-2.orangehrm-full-width-grid div.oxd-grid-item.oxd-grid-item--gutters:nth-child(1) div.oxd-input-group.oxd-input-field-bottom-space div:nth-child(2) div.oxd-select-wrapper div.oxd-select-text.oxd-select-text--active > div.oxd-select-text-input")).click();
	//driver.findElement(By.xpath("//div[@role=\"option\"][2]")).click();
	Thread.sleep(5000);
	driver.findElement(By.cssSelector("div[class='oxd-input-group oxd-input-field-bottom-space'] div input[class='oxd-input oxd-input--active']"))
	.sendKeys("Poonam");
	driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys("Poonam123");
	driver.findElement(By.xpath("//div[@class='oxd-grid-item oxd-grid-item--gutters']//div[@class='oxd-input-group oxd-input-field-bottom-space']//div//input[@type='password']")).sendKeys("Poonam123");
	driver.findElement(By.xpath("//body/div[@id='app']/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[1]/div[1]/div[2]/div[1]/div[1]")).click();
	WebElement admin = driver.findElement(By.xpath("//div/span[contains(text(),'Admin')]"));
	WebDriverWait Wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	Wait.until(ExpectedConditions.visibilityOf(admin));
	admin.click();
	driver.findElement(By.xpath("//body[1]/div[1]/div[1]/div[2]/div[2]/div[1]/div[1]/form[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div[1]/div[1]/div[1]")).click();
	Thread.sleep(5000);
	WebElement Enable = driver.findElement(By.xpath("//div/span[contains(text(),'Enabled')]"));
	WebDriverWait Wait2 = new WebDriverWait(driver, Duration.ofSeconds(20));
	Wait2.until(ExpectedConditions.visibilityOf(Enable));
	Enable.click();
	///Getting and error the page changes automatically 
	Thread.sleep(5000);	
	WebElement inputField = driver.findElement(By.cssSelector("input[placeholder='Type for hints...']"));
	WebDriverWait elementToBeClickable = new WebDriverWait(driver, Duration.ofSeconds(20));
	elementToBeClickable.until(ExpectedConditions.elementToBeClickable(inputField));
	inputField.sendKeys("Rahul");
	
    // Wait for the dropdown options to be visible
    List<WebElement> DPlist = driver.findElements(By.xpath("//div[@role=\"option\"]"));
    WebDriverWait waitOptions = new WebDriverWait(driver, Duration.ofSeconds(20));
    waitOptions.until(ExpectedConditions.visibilityOfAllElements(DPlist));

    for (WebElement option : DPlist) {
        if (option.getText().contains("Rahul mulge patil")) {
            Wait.until(ExpectedConditions.elementToBeClickable(option));
            option.click();
            break;

        }
    }
	}
}    
