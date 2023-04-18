package vtiger.GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

/**
 * This class provides implementation for ITestListener Interface of TestNG
 * @author kavya
 *
 */
public class ListenersImplementation implements ITestListener
{
	ExtentReports report;
	ExtentTest test;
	

	public void onTestStart(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"=== test script execution started ===");		
		
		test = report.createTest(methodName);
		test.log(Status.INFO, methodName+"=== test script execution started ===");
	}

	public void onTestSuccess(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"=== test script PASSED ===");
		
		test.log(Status.PASS, methodName+"=== PASS ===");
	}

	public void onTestFailure(ITestResult result) {
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"=== test script FAILED ===");
		//System.out.println(result.getThrowable());		// print the exception
		
		test.log(Status.FAIL, methodName+"=== FAIL ===");
		test.log(Status.INFO, result.getThrowable());		//print the exception in report
		
		WebDriverUtility wUtil = new WebDriverUtility();
							
		String screenShotName = methodName+"-"+new JavaUtility().getSystemDateInFormat();
		
		try {
			String path = wUtil.takeScreenshot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);		//going to the screenshot location and it will attached to the report
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
		// TODO Auto-generated method stub

		String methodName = result.getMethod().getMethodName();
		//System.out.println(methodName+"=== test script SKIPED ===");
		//System.out.println(result.getThrowable());		// print the exception
		
		test.log(Status.SKIP, methodName+"=== SKIP ===");
		test.log(Status.INFO, result.getThrowable());		//print the exception in report
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=== execution started ===");
		
		//Extent Report Configuration 								 //Report-05 Apr 2023-10-235.html
		ExtentSparkReporter htmlReporter = new ExtentSparkReporter(".\\ExtentReports\\Report-"+new JavaUtility().getSystemDateInFormat()+".html");
		htmlReporter.config().setDocumentTitle("Vtiger Execution Report");
		htmlReporter.config().setTheme(Theme.DARK);
		htmlReporter.config().setReportName("Execution Report");
		
		report = new ExtentReports();
		report.attachReporter(htmlReporter);
		report.setSystemInfo("Base URl", "http://localhost8888");
		report.setSystemInfo("Base Browser", "Firefox");
		report.setSystemInfo("Base Platform", "Windows");
		report.setSystemInfo("Reporter Name", "Chaitra");
	
	
	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub
		System.out.println("=== execution finished ===");
		
		report.flush();   			//generate the report
	}
	
}
