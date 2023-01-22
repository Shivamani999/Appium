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

public class baseTest {
	
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
		
		UiAutomator2Options option = new UiAutomator2Options();
		option.setDeviceName("ShivamaniEmulator");
		option.setChromedriverExecutable("C:\\Users\\lenovo\\Downloads\\chromedriver.exe");
		//option.setApp("D://shiv//workspace//Appium//src//test//java//resources//ApiDemos-debug.apk");
		option.setApp("D://shiv//workspace//Appium//src//test//java//resources//General-Store.apk");
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723"), option);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}
	
	public void LongPress(WebElement ele) {
		
		((JavascriptExecutor)driver).executeScript("mobile: longClickGesture", 
				ImmutableMap.of("elementId", ((RemoteWebElement) ele).getId(),
						"duration",2000));
		
	}
	
	public void scrollToEndAction() {
		
		boolean canScrollMore;
		do {
		canScrollMore = (Boolean) ((JavascriptExecutor) driver).executeScript("mobile: scrollGesture", ImmutableMap.of(
			    "left", 100, "top", 100, "width", 200, "height", 200,
			    "direction", "down",
			    "percent", 3.0
			));
		}while(canScrollMore);
		
	}
	
	public void swipe(WebElement ele, String direction) {
		
		((JavascriptExecutor) driver).executeScript("mobile: swipeGesture", ImmutableMap.of(
			    "elementId",((RemoteWebElement)ele).getId(),
			    "direction", direction,
			    "percent", 0.75
			));

	}
	
	public void dragDropElement(WebElement element,int x_axis,int y_axis) {
		
		((JavascriptExecutor) driver).executeScript("mobile: dragGesture", ImmutableMap.of(
			    "elementId", ((RemoteWebElement) element).getId(),
			    "endX", x_axis,
			    "endY", y_axis
			));
		
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
