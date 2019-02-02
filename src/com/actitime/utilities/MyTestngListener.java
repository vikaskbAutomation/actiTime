package com.actitime.utilities;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.google.common.io.Files;

public class MyTestngListener implements ITestListener
{
	public static int scriptExecCount, passCount, failCount, skipCount=0;

	@Override
	public void onTestStart(ITestResult result)
	{
		scriptExecCount++;
		Reporter.log(result.getName()+"script execution starts"+new Date(),true);
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		passCount++;
		Reporter.log(result.getName()+"script is passed :)", true);
	}

	@Override
	public void onTestFailure(ITestResult result)
	{
		failCount++;
		Reporter.log(result.getName()+ " script failed", true);
		
		TakesScreenshot ts= (TakesScreenshot) BaseLib.driver;
		File srcFile= ts.getScreenshotAs(OutputType.FILE);
		File dstFile=new File("./screenshots/"+result.getName()+".png");
		
		try 
		{
			Files.copy(srcFile, dstFile);
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		skipCount++;
		Reporter.log(result.getName()+"script skipped :(", true);
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
	}

	@Override
	public void onStart(ITestContext context) 
	{
		Reporter.log("Suite Execution Starts"+new Date(), true);
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		Reporter.log("Suite Execution Ends"+new Date(), true);
		Reporter.log("Total Script Executed: "+scriptExecCount, true);
		Reporter.log("Total Script Passed: "+ passCount, true);
		Reporter.log("Total Script failed: "+failCount, true);
		Reporter.log("Total Script Skipped: "+skipCount, true);
	}

}
