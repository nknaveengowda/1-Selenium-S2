package tests;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.*;
import org.openqa.selenium.support.ui.*;
import org.testng.annotations.*;
import java.net.*;

public class RegisterTestGrid_0 {

	private WebDriver driver;
	private String hubUrl = "http://192.168.1.100:4444"; //  Selenium Grid Hub IP address

	@BeforeClass
	public void setUp() throws MalformedURLException {
		ChromeOptions chromeOptions = new ChromeOptions();
		driver = new RemoteWebDriver(new URL(hubUrl), chromeOptions);
		driver.manage().window().maximize();
	}

	@Test
	public void testRegistration() {
		driver.get("https://demowebshop.tricentis.com/register");

		WebElement genderMaleRadio = driver.findElement(By.id("gender-male"));
		genderMaleRadio.click();

		WebElement firstNameInput = driver.findElement(By.id("FirstName"));
		firstNameInput.sendKeys("naveen");

		WebElement lastNameInput = driver.findElement(By.id("LastName"));
		lastNameInput.sendKeys("nk");

		WebElement emailInput = driver.findElement(By.id("Email"));
		emailInput.sendKeys("naveennk@gmail.com");

		WebElement passwordInput = driver.findElement(By.id("Password"));
		passwordInput.sendKeys("naveen");

		WebElement confirmPasswordInput = driver.findElement(By.id("ConfirmPassword"));
		confirmPasswordInput.sendKeys("naveen");

		// Submit registration form
		WebElement registerButton = driver.findElement(By.id("register-button"));
		registerButton.click();

		// Wait for registration success message
		// WebDriverWait wait = new WebDriverWait(driver, 10);
		//wait.until(ExpectedConditions.urlContains("registerresult"));
	}

	@AfterClass
	public void tearDown() {
		if (driver != null) {
			//driver.quit();
		}
	}
}