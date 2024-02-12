package utilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

public class MyTestListener extends ListenersDemo implements ITestListener  {
	private static ExtentReports extent;
    private static ExtentTest test;

    public MyTestListener() {
        ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("extent.html");
        extent = new ExtentReports();
        extent.attachReporter(htmlReporter);
    }
	
	public void onTestStart(ITestResult result) {
		System.out.println("** Test Started : " +result.getName());
	}

	public void onTestSuccess(ITestResult result) {
		System.out.println("** Test success : " +result.getName());
	}

	public void onTestFailure(ITestResult result) {
		captureScreenshot(result.getMethod().getMethodName());
		
	}

	public void onTestSkipped(ITestResult result) {
		System.out.println("** Test skipped : " +result.getName());

	}

	public void onFinish(ITestContext context) {
		System.out.println("** Test completed : " +context.getName());
	}
}