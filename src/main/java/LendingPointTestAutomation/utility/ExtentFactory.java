package LendingPointTestAutomation.utility;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {
	
	private static ExtentFactory extentInstance = new ExtentFactory();
	
	private ExtentFactory() {
		
	}
	
	public static ExtentFactory getInstance() {
		return extentInstance;
	}
	
	//private static ExtentReports extent;
	//ThreadLocal<ExtentReports> extent = new ThreadLocal<ExtentReports>();
	private static ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();
	
	public ExtentTest getExtent() {
		//return extent;
		return extent_test.get();
	}
	
	public void setExtent(ExtentTest extentTest) {
		//extent.set(exten);
		extent_test.set(extentTest);
	}
	
	//public void dumpExtent() {
		//if(extent != null) {
		//	extent.flush();
		//}	
	//}

}
