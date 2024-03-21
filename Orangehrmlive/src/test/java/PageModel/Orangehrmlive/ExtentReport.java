package PageModel.Orangehrmlive;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ExtentReport {
	ExtentReports extent;
	@BeforeTest
	public void config()
	{
		
	String path = System.getProperty("user.dir")+"\\reports\\index.html";
	ExtentSparkReporter reporter= new ExtentSparkReporter(path);
	reporter.config().setReportName("Poonam sawant");
	reporter.config().setDocumentTitle("Priya");
	
    extent = new ExtentReports();
	extent.attachReporter(reporter);
	extent.setSystemInfo("Tester", "Poonam Sawant");
	
	}
	
	@Test
	public void LoginPage() throws InterruptedException
	{
	ExtentTest test = extent.createTest("Login page");
    WebDriverManager.chromedriver().setup();
    ChromeOptions Opt = new ChromeOptions();
    WebDriver driver = new ChromeDriver(Opt);
	driver.manage().deleteAllCookies();
	//driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
	Thread.sleep(9000);
	driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys("Admin");
	driver.findElement(By.name("password")).sendKeys("admin123");
	driver.findElement(By.xpath("//button[@type='submit']")).click();
	Thread.sleep(7000);
	test.addScreenCaptureFromBase64String("Screenshot");
	extent.flush();
	}
}
