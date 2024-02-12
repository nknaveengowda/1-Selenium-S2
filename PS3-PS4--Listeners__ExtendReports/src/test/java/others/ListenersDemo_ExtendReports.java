package others;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

@Listeners(utilities.MyTestListener.class)
public class ListenersDemo_ExtendReports<TakeScreenshot> {

    static WebDriver driver;
    String siteUrl = "https://demowebshop.tricentis.com/login";

    ExtentReports extent;
    ExtentTest logger;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.get(siteUrl);

        // Initialize ExtentReports and attach the HTML reporter
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("test-output/extentReport.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }

    @Test(priority = 1)
    public void searchItemTest() {
        logger = extent.createTest("Search Item Test");

        // Perform search for 14.1-inch Laptop
        driver.findElement(By.id("small-searchterms")).sendKeys("14.1-inch Laptop");
        driver.findElement(By.cssSelector("input[value='Search']")).click();

        // Assertion for search results
        Assert.assertTrue(driver.getTitle().contains("Search results for: '14.1-inch Laptop'"));
        logger.log(Status.PASS, "Search for 14.1-inch Laptop successful");
    }

    public void captureScreenshot(String testName) {
        TakesScreenshot takesscreenshot = (TakesScreenshot) driver;
        File file = takesscreenshot.getScreenshotAs(OutputType.FILE);
        File destfile = new File("./Screenshots/" + testName + ".png");

        try {
            FileUtils.copyFile(file, destfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Screenshot saved successfully");
    }

    @AfterMethod
    public void tearDown(ITestResult result) {
        if (result.getStatus() == ITestResult.FAILURE) {
            // Log failure information to Extend Reports
            logger.log(Status.FAIL, "Test Case Failed is " + result.getName());
            logger.log(Status.FAIL, "Test Case Failed is " + result.getThrowable());
        } else if (result.getStatus() == ITestResult.SKIP) {
            logger.log(Status.SKIP, "Test Case Skipped is " + result.getName());
        }
        extent.flush();
        driver.quit();
    }

}