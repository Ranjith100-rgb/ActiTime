package com.genricUtility;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImplementaion implements ITestListener
{

	public void onTestFailure(ITestResult result) 
	{
		String methodName = result.getMethod().getMethodName();
		
		TakesScreenshot ts=(TakesScreenshot)BaseClass.rdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String timeStamp = LocalDateTime.now().toString().replace(":", "-");
		File des = new File("./Screenshot/"+methodName+"_"+timeStamp+".png");
		try {
			FileUtils.copyFile(src, des);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	}

