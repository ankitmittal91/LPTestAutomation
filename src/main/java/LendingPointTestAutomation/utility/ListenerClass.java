package LendingPointTestAutomation.utility;
import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;

import LendingPointTestAutomation.action.Action;
import LendingPointTestAutomation.baseClass.BaseClass;

public class ListenerClass extends ExtentManager implements ITestListener {

	Action action= new Action();
	//private static ThreadLocal<ExtentTest> extent_test = new ThreadLocal<ExtentTest>();
	
	public void onTestStart(ITestResult result) {
		ExtentFactory.getInstance().setExtent(extent.createTest(result.getMethod().getMethodName())); 
		//extent_test.set(test);
	}

	public void onTestSuccess(ITestResult result) {
		if (result.getStatus() == ITestResult.SUCCESS) {
		try {
			ExtentFactory.getInstance().getExtent().log(Status.PASS, "Pass Test case is: " + result.getMethod().getMethodName());
			ExtentFactory.getInstance().getExtent().log(Status.PASS,
					MarkupHelper.createLabel(result.getThrowable() + " - Test Case Passed", ExtentColor.GREEN));
			String imgPath = action.screenShot(DriverFactory.getInstance().getDriver(), result.getMethod().getMethodName());
			//extent_test.get().addScreenCaptureFromPath(imgPath);
			ExtentFactory.getInstance().getExtent().pass("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

	public void onTestFailure(ITestResult result) {
		if (result.getStatus() == ITestResult.FAILURE) {
			try {
				ExtentFactory.getInstance().getExtent().log(Status.FAIL,
						MarkupHelper.createLabel(result.getMethod().getMethodName() + " - Test Case Failed", ExtentColor.RED));
				ExtentFactory.getInstance().getExtent().log(Status.FAIL,
						MarkupHelper.createLabel(result.getThrowable() + " - Test Case Failed", ExtentColor.RED));
				String imgPath = action.screenShot(DriverFactory.getInstance().getDriver(), result.getMethod().getMethodName());
				//extent_test.get().addScreenCaptureFromPath(imgPath);
				ExtentFactory.getInstance().getExtent().fail("ScreenShot is Attached", MediaEntityBuilder.createScreenCaptureFromPath(imgPath).build());
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public void onTestSkipped(ITestResult result) {
		if (result.getStatus() == ITestResult.SKIP) {
			ExtentFactory.getInstance().getExtent().log(Status.SKIP, "Skipped Test case is: " + result.getMethod().getMethodName());
		}
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
	}
	
	public void onFinish(ITestContext context) {
		
	}

}
