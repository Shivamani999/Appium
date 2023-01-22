package shivamani.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class Exercise1 extends baseTest{
	
	@Test
	public void Ex1() {
		
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Alert Dialogs']")).click();
		driver.findElement(By.id("io.appium.android.apis:id/radio_button")).click();
		String listmenu = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(listmenu, "Single choice list");
		driver.findElement(By.xpath("//android.widget.CheckedTextView[4]")).click();
		driver.findElement(By.id("android:id/button1")).click();
		
	}
	
}
