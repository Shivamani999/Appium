package org.shivamani.Utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class ActionsClass extends AppiumUtils{

	AndroidDriver driver;
	
	public ActionsClass(AndroidDriver driver) {
		
		this.driver = driver;
	
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
	
	public void scrollToElement(String element) {
		
		driver.findElement(AppiumBy.androidUIAutomator(
				"new UiScrollable(new UiSelector()).scrollIntoView(text(\""+element+"\"));"));
		
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
	
}
