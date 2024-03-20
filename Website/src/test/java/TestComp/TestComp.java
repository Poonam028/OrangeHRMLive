package TestComp;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.BeforeMethod;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.FileInputStream;
import Shopping.Website.PageObject.LoginPage;
import io.github.bonigarcia.wdm.WebDriverManager;

public class TestComp {
	public WebDriver driver;

	public WebDriver InitializeDriver() throws IOException {
		// WebDriverManager.chromedriver().setup();
		// WebDriver driver = new ChromeDriver();
		// driver.manage().window().maximize();
		// driver.manage().deleteAllCookies();
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\Resources\\Global.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("Browser");

		if (BrowserName.equalsIgnoreCase("chrome")) {

			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
		} else if (BrowserName.equalsIgnoreCase("edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();

			// In real time we can work on multiple browsers so for that a global properties
			// will be setup.
		}
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		return driver;
	}
	
	public List<HashMap<String, String>> getJsonDataToMap(String filePath) throws IOException
		{
			//reading the Json to string 
		String JsonContent=	FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		//Convert String content to hashmap
		ObjectMapper mapper = new ObjectMapper();
		
		//readvalue method helps to convert string content to hashmap
		List<HashMap<String, String>>data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>(){
		});
		return data;
		}
	
	public String getScreenshot(String testCaseName, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot) driver;
		File Source = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir") + "//reports//"+ testCaseName + ".png");
		FileUtils.copyFile(Source, file);
		return System.getProperty("user.dir") + "//reports//"+ testCaseName + ".png";
	}

	@BeforeMethod
	public LoginPage LaunchApplication() throws IOException {
		driver = InitializeDriver();
		LoginPage LoginPage = new LoginPage(driver);
		LoginPage.goTo();
		return LoginPage;
	}
	
	
		

	// @AfterMethod
	public void tearDown() {
		driver.close();
	}
}
