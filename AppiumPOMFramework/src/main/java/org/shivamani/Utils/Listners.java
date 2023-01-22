package org.shivamani.Utils;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import io.appium.java_client.AppiumDriver;

public class Listners extends AppiumUtils implements ITestListener{

	ExtentTest test;
	ExtentReports extent = ExtentReportNG.getReportObject();
	AppiumDriver driver;
	
	@Override
	public void onTestStart(ITestResult result) {
		
		test = extent.createTest(result.getMethod().getMethodName());
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		
		test.log(Status.PASS, "Test Passed Successfully");
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		
		test.fail(result.getThrowable());
		
		try{
			
			driver = (AppiumDriver) result.getTestClass().getRealClass()
											.getField("driver").get(result.getInstance());
	
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		try {
	
			test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(),
					                                  driver), result.getMethod().getMethodName());
			
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
		extent.flush();
		
	}

	
	
}
