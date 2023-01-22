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

public class DragAndDrop extends baseTest{
		
	@Test
	public void dragGeasture() throws MalformedURLException, InterruptedException {
		
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Drag and Drop']")).click();
		WebElement dragEle= driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
		LongPress(dragEle); // this is used only because of the specific element requires longPress to drag 
		dragDropElement(dragEle, 830, 735);
		Thread.sleep(10000);
		Assert.assertEquals(driver.findElement(By
				.id("io.appium.android.apis:id/drag_result_text")).getText(), "Dropped!");
				
	}
	
}
