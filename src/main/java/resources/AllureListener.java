package resources;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.openqa.selenium.TakesScreenshot;

import io.qameta.allure.Attachment;

public class AllureListener implements ITestListener {
	
	
	private static String getTestMethodName(ITestResult iTestResult) {
		return iTestResult.getMethod().getConstructorOrMethod().getName();
	}
	
	@Attachment
	public byte[] saveFailureScreenShot(WebDriver driver) {
		return ((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
	}
	
	@Attachment(value = "{0}", type = "text/plain")
	public static String saveTextLog(String message) {
		return message;
	}
	

	@Override
	public void onTestStart(ITestResult iTestResult) {
		System.out.println("Execution has started for " + getTestMethodName(iTestResult));
		
	}

	@Override
	public void onTestSuccess(ITestResult iTestResult) {
		System.out.println("Successfully executed the " + getTestMethodName(iTestResult));
		
	}

	@Override
	public void onTestFailure(ITestResult iTestResult) {
		System.out.println("Execution has failed for " + getTestMethodName(iTestResult));
		WebDriver driver = BaseClass.getDriver();
		// Allure ScreenShot and SaveTestLog
		if (driver instanceof WebDriver) {
			System.out.println("Screenshot captured for test case " + getTestMethodName(iTestResult));
			saveFailureScreenShot(driver);
		}
		saveTextLog(getTestMethodName(iTestResult) + " has failed and screenshot taken!");
		
	}

	@Override
	public void onTestSkipped(ITestResult iTestResult) {
		System.out.println("Execution has been skipped for " + getTestMethodName(iTestResult));
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult iTestResult) {
		System.out.println("Test has failed but it is in defined success ratio " + getTestMethodName(iTestResult));
		
	}

	@Override
	public void onStart(ITestContext iTestContext) {
		System.out.println("Test Execution has started" + iTestContext.getName());
		iTestContext.setAttribute("WebDriver", BaseClass.getDriver());
		
	}

	@Override
	public void onFinish(ITestContext iTestContext) {
		System.out.println("Test execution has ended" + iTestContext.getName());
		
	}

}
