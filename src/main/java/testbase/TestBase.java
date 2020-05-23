package testbase;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import com.google.common.io.Files;

import helper.browserConfiguration.ChromeBrowser;
import helper.browserConfiguration.config.ObjectReader;
import helper.browserConfiguration.config.PropertyReader;
import helper.excel.ExcelHelper;
import helper.javascript.JavascriptHelper;
import helper.browserConfiguration.BrowserConfiguration.BrowserType;
import helper.logger.LoggerHelper;
import helper.resource.ResourceHelper;
import helper.wait.WaitHelper;
import practice.JavaScriptExecutor;
import utils.ExtentManager;

public class TestBase {

	public WebDriver driver;
	public static ExtentReports extents;
	public static ExtentTest test;
	private static Logger log = LoggerHelper.getLogger(TestBase.class);
	public static File reportDirectory;

	@BeforeSuite
	public void beforeSuite() {
		extents = ExtentManager.getInstance();

	}

	@BeforeTest
	public void beforeTest() throws Exception {
		ObjectReader.reader = new PropertyReader();
		reportDirectory = new File(ResourceHelper.getResourcePath("\\src\\main\\resources\\screenShots"));
		setupDriver(ObjectReader.reader.getBrowserType());
		test=extents.createTest(getClass().getSimpleName());
	}
	
	@BeforeMethod
	public void beforeMethod(Method method) {
		test.log(Status.INFO, method.getName() + "-test started");
	}

	@AfterMethod
	public void afterMethod(ITestResult result) throws IOException {
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(Status.FAIL, result.getThrowable());
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SUCCESS) {
			test.log(Status.PASS, result.getName() + "-is pass");
			String imagePath = captureScreen(result.getName(), driver);
			test.addScreenCaptureFromPath(imagePath);
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(Status.SKIP, result.getTestName() + " is skip");

		}
		extents.flush();
	}

	@AfterTest
	public void beforeMethod() {
		if (driver != null) {
			driver.quit();
		}

	}

	public WebDriver getBrowserObject(BrowserType btype) throws Exception {
		try {
			switch (btype) {
			case Chrome:
				// get object of chrome browser class
				ChromeBrowser chrome = ChromeBrowser.class.newInstance();
				ChromeOptions options = chrome.getChromeOptions();
				return chrome.getChromeDriver(options);
			default:
				throw new Exception("DRiver not found" + btype.name());

			}
		} catch (Exception e) {
			log.info(e.getMessage());
			throw e;
		}
	}

	public void setupDriver(BrowserType btype) throws Exception {
		driver = getBrowserObject(btype);
		log.info("initialize  web driver" + driver.hashCode());
		WaitHelper wait = new WaitHelper(driver);
		wait.setImplicitWait(ObjectReader.reader.getImpliciteWait(), TimeUnit.SECONDS);
		wait.pageLoadTime(ObjectReader.reader.pageLoadType(), TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}

	public String captureScreen(String fileName, WebDriver driver) {
		if (driver == null) {
			log.info("driver is null");
			return null;
		}
		if (fileName == "") {
			fileName = "blank";
		}
		File destFile = null;
		Calendar calender = Calendar.getInstance();
		SimpleDateFormat formater = new SimpleDateFormat("dd_MM_yyyy_hh_mm_ss");
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			destFile = new File(reportDirectory + "/" + fileName + "_" + formater.format(calender.getTime()) + ".png");
			Files.copy(scrFile, destFile);
			Reporter.log("<a href='" + destFile.getAbsolutePath() + "'><img src='" + destFile.getAbsolutePath()
					+ "'height='100' width='100'/></a>");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return destFile.toString();
	}

	public void getNavigationScreen(WebDriver driver) {
		log.info("capturing ui navigation screen...");
		new JavascriptHelper(driver).zoomInBy60Percent();
		String screen = captureScreen("capture", driver);
		new JavascriptHelper(driver).zoomInBy100Percent();
		try {
			test.addScreenCaptureFromPath(screen);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void logExtentReport(String s1) {
		test.log(Status.INFO, s1);
	}

	public void getApplicationUrl(String url) {
		driver.get(url);
		logExtentReport("navigating to..." + url);
	}

	public Object[][] getExcelData(String excelName, String sheetName) {
		String excelLocation = ResourceHelper.getResourcePath("\\src\\main\\resources\\configFile\\") + excelName;
		log.info("excelLocation " + excelLocation);
		ExcelHelper excelHelper = new ExcelHelper();
		Object[][] data = excelHelper.getExcelData(excelLocation, sheetName);
		return data;
	}
}
