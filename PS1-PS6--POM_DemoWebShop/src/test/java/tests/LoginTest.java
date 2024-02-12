package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;

public class LoginTest {
	private WebDriver driver;

	@BeforeMethod
	public void setUp() {
		// Set up the WebDriver instance
		System.setProperty("webdriver.chrome.driver", "C:\\ZSelenium Jars and drivers\\chromedriver-win64\\chromedriver-win64\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	@Test
	public void testLogin() {	
		driver.get("https://demowebshop.tricentis.com/");// Open the website
		driver.findElement(By.linkText("Log in")).click();// Click on the Login link
		LoginPage loginPage = new LoginPage(driver);// Initialize the LoginPage
		loginPage.login("naveennk@gmail.com", "naveen");// Perform login
	}

	@AfterMethod
	public void tearDown() {
		driver.quit();// Close the browser
	}
}