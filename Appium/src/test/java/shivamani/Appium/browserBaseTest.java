package shivamani.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class browserBaseTest {
	
	AndroidDriver driver;
	AppiumDriverLocalService service;

	@BeforeClass
	public void configureAppium() throws MalformedURLException {
		/*
		 * C://Users//lenovo//node_modules//appium//build//lib//main.js
		 * "C://Users//lenovo//AppData//Roaming//npm//node_modules//appium//build//lib//main.js"
		 */
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//lenovo//node_modules//appium//build//lib//main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setDeviceName("Google");
		options.setChromedriverExecutable("C:\\Users\\lenovo\\Downloads\\chromedriver-1.exe");
		options.setCapability("browserName", "Chrome");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), options);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public double formattedAmount(String amount) {
		
		double forAmount = Double.parseDouble(amount.substring(1));
		return forAmount;
		
	}
	
	@AfterClass
	public void tearDown() {
		
		driver.quit();
		service.stop();
		
	}
	
}
