package utilities;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class ListenersDemo_Reports {

    private static WebDriver driver;
    private static ExtentReports extent;
    private static ExtentTest test;

    @BeforeSuite
    public void setUp() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://demowebshop.tricentis.com/login");
    }

    @Test
    public void LoginFailTest() {
        test = extent.createTest("LoginFailTest");
        driver.findElement(By.id("Email")).sendKeys("naveennk@gmail.com");
        driver.findElement(By.id("Password")).sendKeys("naveen");
        driver.findElement(By.cssSelector("input[value='Log in']")).click();

        String expectedUrl = "login |demowebshop";
        String actualUrl = driver.getTitle();
        Assert.assertNotEquals(actualUrl, expectedUrl);
        test.log(Status.INFO, "Test steps completed");
        test.fail("Test failed");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }

    @AfterSuite
    public void tearDownSuite() {
        extent.flush();
    }
}