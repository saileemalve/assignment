package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
///import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentManager {
	
	private static ExtentReports extent;
	public static ExtentReports getInstance()
	{
		if(extent==null)
		{
			return createInstance("test-output/extent.html");
		}
		else return extent;
	}
	public static ExtentReports createInstance(String fileName)
	{
		ExtentHtmlReporter reporter = new ExtentHtmlReporter(fileName);
		////reporter.config().setTestViewChartLocation(ChartLocation.BOTTOM);
		//reporter.config().setChartVisibilityOnOpen(true);
		reporter.config().setTheme(Theme.STANDARD);
		reporter.config().setDocumentTitle(fileName);
		reporter.config().setEncoding("utf-8");
		reporter.config().setReportName("automationReport");
		extent=new ExtentReports();
		extent.attachReporter(reporter);
		return extent;
	}

}
