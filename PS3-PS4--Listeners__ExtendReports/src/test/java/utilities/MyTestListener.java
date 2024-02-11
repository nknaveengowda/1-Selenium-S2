package utilities;


import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyTestListener extends ListenersDemo implements ITestListener  {
	
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

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
	
		
	}

	public void onStart(ITestContext context) {
		
		
	}

	public void onFinish(ITestContext context) {
		System.out.println("** Test completed : " +context.getName());
	}
}