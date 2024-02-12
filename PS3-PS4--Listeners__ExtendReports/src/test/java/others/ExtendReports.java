package others;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class ExtendReports {

	WebDriver driver;
	ExtentHtmlReporter htmlReporter;
	ExtentReports extentReports;
	ExtentTest test1,test2;

	String siteUrl="https://demowebshop.tricentis.com/";

	@BeforeClass
	public void beforeClass() {

		// create the htmlReporter object
		htmlReporter = new ExtentHtmlReporter("extentReport.html");

		// create ExtentReport and attach this reports
		extentReports = new ExtentReports();
		extentReports.attachReporter(htmlReporter);

		driver=new ChromeDriver();

		driver.manage().window().maximize();

		driver.get(siteUrl);

	}

	@Test(description = "Search 14.1-inch Laptop")
	public void testSearch1() throws InterruptedException {
		// create a test and add logs
		test1 = extentReports.createTest("Demo Web Shop Search 14.1-inch Laptop", "Test Demo Web Shop Search 14.1-inch Laptop");
		test1.log(Status.INFO, "Starting test case");

		WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
		test1.pass("Find search box on demowebshop.tricentis.com");

		searchBox.sendKeys("14.1-inch Laptop");
		test1.pass("Enter input data '14.1-inch Laptop' ");

		searchBox.submit();
		test1.pass("Click Submit");

		// add delay
		Thread.sleep(2000);

		String expectedTitle = "Demo Web Shop.com : 14.1-inch Laptop";
		String actualTitle = driver.getTitle();

		assertEquals(actualTitle, expectedTitle);
		test1.pass("After search the title are matched");

		test1.log(Status.INFO, "End test case");
	}

	@AfterClass
	public void tearDown() {
		driver.quit();
		extentReports.flush();
	}

}
