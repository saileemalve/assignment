package helper.listener;

import org.apache.log4j.Logger;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import utils.ExtentManager;

public class ExtentListener implements ITestListener {
	private Logger log=Logger.getLogger(ExtentListener.class);
	public static ExtentReports extents;
	public static ExtentTest test;

	public void onTestStart(ITestResult result) {
		//to avoid duplicacy of extend report log with test base we need to comment this
		//test.log(Status.INFO, result.getName()+" started");
		Reporter.log(result.getMethod().getMethodName()+" reporter test start");
		log.info(result.getMethod().getMethodName()+" reporter test start");
		
	}

	public void onTestSuccess(ITestResult result) {
		//test.log(Status.INFO, result.getName()+" passed");
		Reporter.log(result.getMethod().getMethodName()+" reporter test success");
		log.info(result.getMethod().getMethodName()+" reporter test success");
	}

	public void onTestFailure(ITestResult result) {
		//test.log(Status.FAIL, result.getThrowable());
		Reporter.log(result.getMethod().getMethodName()+" reporter test failed "+result.getThrowable());
		log.error(result.getMethod().getMethodName()+" reporter test failed "+result.getThrowable());
		
	}

	public void onTestSkipped(ITestResult result) {
		////test.log(Status.SKIP, result.getName()+" skipped");
		Reporter.log(result.getMethod().getMethodName()+" reporter test skipped " + result.getThrowable());
		log.warn(result.getMethod().getMethodName()+" reporter test skipped " + result.getThrowable());
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onTestFailedWithTimeout(ITestResult result) {
		// TODO Auto-generated method stub
		
	}

	public void onStart(ITestContext context) {
		//extents = ExtentManager.getInstance();
		//test = extents.createTest(context.getName());
		//test=extents.createTest(context.getCurrentXmlTest().getName()));
		Reporter.log(context.getName()+" testng reporter test started...");
		log.info(context.getName()+" testng reporter test started...");
	}

	public void onFinish(ITestContext context) {
		//extents.flush();
		Reporter.log(context.getName()+" reporter test finished...");
		log.info(context.getName()+" reporter test finished...");
	}

}
