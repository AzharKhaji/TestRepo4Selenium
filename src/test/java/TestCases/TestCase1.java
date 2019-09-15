package TestCases;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCase1 {

	public static WebDriver Driver;
	
	@BeforeSuite
	public static void setUp() {
		
		WebDriverManager.chromedriver().setup();
		Driver = new ChromeDriver();
		Driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	}
	
	@Test
	public static void Login() {
		System.out.println("Inside Login Test case after integrating with github");
		Driver.get("http://www.gmail.com");
		
		Driver.findElement(By.xpath("//*[@id=\"identifierId\"]")).sendKeys("azharkhaji313");
		//Driver.findElement(By.id("Passwd")).sendKeys("abc");
		
		
	}
	
	@AfterSuite
	public static void Exit() {
		Driver.quit();
		
	}
}
