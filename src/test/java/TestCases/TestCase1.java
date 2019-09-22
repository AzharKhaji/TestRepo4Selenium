package TestCases;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static WebDriver Driver;
	public static WebDriverWait Ewait;

	@AfterSuite
	public static void Exit() {
		// Driver.quit();
		System.out.println("Program execution completed successfully");
	}

	@BeforeSuite
	public static void setUp() throws IOException {
		Properties configr = new Properties();
		FileInputStream fstream = new FileInputStream(
				"C:\\Users\\user\\eclipse-workspace\\20190915\\src\\test\\java\\config\\confg.properties");
		configr.load(fstream);
		String browserType = configr.getProperty("browser"); 
		System.out.println(browserType);

		if (browserType.equals("chrome")) {
			WebDriverManager.chromedriver().setup();
			Driver = new ChromeDriver();
		} else if (browserType.equals("firefox")) {
			WebDriverManager.firefoxdriver().setup();
			Driver = new FirefoxDriver();
		} else if (browserType.equals("IE")) {
			WebDriverManager.iedriver().setup();
			Driver = new InternetExplorerDriver();
		}

		Ewait = new WebDriverWait(Driver, 20);
		Driver.manage().window().maximize();
	} 

	@Test
	public static void launchDropDownPage() {
		
		Driver.get("http://the-internet.herokuapp.com/");
		Ewait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")))
				.click();

		System.out.println(Driver.getTitle());
	}

	@Test
	public static void selectOptions() {
		Select DropDown = new Select(Driver.findElement(By.xpath("//*[@id=\"dropdown\"]")));
		List<WebElement> Options = DropDown.getOptions();
		for (WebElement eachOption : Options) {
			System.out.println(eachOption.getAttribute("text"));
		}
	}

}
