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
	
	//public ExtentReports getExtent() {
		//return extent;
	//}
	
	public void setExtent() {
		//extent.set(exten);
	}
	
	//public void dumpExtent() {
		//if(extent != null) {
		//	extent.flush();
		//}	
	//}

}
