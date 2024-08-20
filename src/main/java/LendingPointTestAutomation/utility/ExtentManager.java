package LendingPointTestAutomation.utility;

import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentManager {
	
	public static ExtentHtmlReporter htmlReporter;
	public static ExtentReports extent;
	public static ExtentTest test;
	
	public static void setExtent() {
	htmlReporter= new ExtentHtmlReporter(System.getProperty("user.dir")+"/test-output/ExtentReport/"+"MyReport.html");
	htmlReporter.loadXMLConfig(System.getProperty("user.dir")+"/extentReport_config.xml");
	
	extent = new ExtentReports();
	extent.attachReporter(htmlReporter);
	
	extent.setSystemInfo("HostName", "MyHost");
	extent.setSystemInfo("ProjectName", "LendingPoint");
	extent.setSystemInfo("QA", "Ankit Mittal");
	
	extent.setSystemInfo("OS", "Win11");
	extent.setSystemInfo("Browser", "Chrome");
	}
	
	public static void endReport() {
	extent.flush();
	}
}
