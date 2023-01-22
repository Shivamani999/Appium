package org.TestUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.shivamani.AppiumPOMFramework.android.LoginElementClass;
import org.shivamani.Utils.AppiumUtils;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class baseTest extends AppiumUtils{
	
	public AndroidDriver driver;
	public AppiumDriverLocalService service;
	public LoginElementClass elementC;

	@BeforeClass(alwaysRun=true)
	public void configureAppium() throws MalformedURLException, IOException {
		/*
		 * C://Users//lenovo//node_modules//appium//build//lib//main.js
		 * "C://Users//lenovo//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"
		 */
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\shiv\\workspace\\AppiumPOMFramework\\runConfig.properties");
		prop.load(fis);
		/*
		 * This below line checks whether mvn cmd line is sending any parameter
		 *called ipAddress,if not it takes from .properties
		*/
		String ipAddress = System.getProperty("ipAddress")!=null ? 
											System.getProperty("ipAddress") : prop.getProperty("ipAddress");
		String port = prop.getProperty("port");
		String deviceName = prop.getProperty("AndroidDeviceName");
		String browseringTime = prop.getProperty("browserTime");
		String app = prop.getProperty("app");
		
		service = appiumServer(ipAddress , Integer.parseInt(port) );
		
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName(deviceName);
		//option.setChromedriverExecutable("C:\\Users\\lenovo\\Downloads\\chromedriver-1.exe");
		option.setApp(System.getProperty("user.dir")+app);
		
		driver = new AndroidDriver(service.getUrl(), option);
		driver.manage().timeouts().implicitlyWait(Integer.parseInt(browseringTime), TimeUnit.SECONDS);
		elementC = new LoginElementClass(driver);
	
	}
	
	@AfterClass(alwaysRun=true)
	public void tearDown() {
		
		driver.quit();
		service.stop();
		
	}
	
}
