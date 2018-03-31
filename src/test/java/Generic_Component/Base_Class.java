package Generic_Component;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Base_Class {

	public Process process;
	public AppiumDriver driver;
	
	
	public void Start_Server() throws IOException, InterruptedException
	{
		String Start_Server="D:\\Appium\\node.exe  D:\\Appium\\node_modules\\appium\\bin\\appium.js";
		process = Runtime.getRuntime().exec(Start_Server);
		
		if(process!= null)
		{
			System.out.println("Started the Appium Server");
		}
		else
		{
			System.out.println("NOT started");
		}
		
		Thread.sleep(12000);
		//*********************************
	}
	
	
	public void Launch_App() throws InterruptedException, IOException
	{
		DesiredCapabilities capabilities= new DesiredCapabilities();
		
		capabilities.setCapability("deviceName","GT-I9300I");
		capabilities.setCapability("platformName","Android");
		capabilities.setCapability("platformVersion","4.4.4");		
		
		capabilities.setCapability("appPackage",Utility_Class.Reading_properties("Package_name"));
		capabilities.setCapability("appActivity",Utility_Class.Reading_properties("Activity_name"));
		
		
		 driver= new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
		
		Thread.sleep(3000);
		
	}
	
	
	public void Explicit_Wait(WebElement ele, long T1)
	{
		WebDriverWait wait= new WebDriverWait(driver, T1);
		wait.until(ExpectedConditions.visibilityOf(ele)).isDisplayed();
		
		
	}
	
	
	public void Capture_Screenshot1(String TC_ID,String Order_Set) throws IOException
	{
		
		Date date= new Date();
		SimpleDateFormat df= new SimpleDateFormat("yyyy-MM-dd hh-mm-ss");
		
		String str=df.format(date)+".png";
		
		TakesScreenshot screenshot=(TakesScreenshot) driver;
		File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshotAs, new File("D:\\Apr30_BB_project\\Screenshot\\"+TC_ID+"-"+Order_Set+"-"+str));
		
		
		
		
	}
	
	
	
	
	
	
	public void Stop_Server() throws InterruptedException
	{
		//stop server
		if(process!=null)
		{
			process.destroy();
			Thread.sleep(4000);
			System.out.println("Stopped the Appium Server");
			
		}
		
		
	}
	
	
	
}
