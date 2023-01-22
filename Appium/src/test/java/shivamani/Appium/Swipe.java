package shivamani.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Swipe extends baseTest{
		
	@Test
	public void swipeIt() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Gallery']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@text='1. Photos']")).click();
		WebElement firstEle = driver.findElement(By.xpath("//android.widget.ImageView[1]"));
		Assert.assertEquals(firstEle.getAttribute("focusable"), "true");
		swipe(firstEle, "left");
		Assert.assertEquals(firstEle.getAttribute("focusable"), "false");
				
	}
	
}
