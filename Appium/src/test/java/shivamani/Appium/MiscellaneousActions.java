package shivamani.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.DeviceRotation;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class MiscellaneousActions extends baseTest{
		
	@Test
	public void createWiFiName() throws MalformedURLException {
		
		Activity activity = new Activity("io.appium.android.apis",
										"io.appium.android.apis.preference.PreferenceDependencies");
		driver.startActivity(activity);
		driver.findElement(By.id("android:id/checkbox")).click();
		//rotating the screen
		DeviceRotation landscape = new DeviceRotation(0,0,90);
		driver.rotate(landscape);
		driver.findElement(By.xpath("(//android.widget.RelativeLayout)[2]")).click();
		String title = driver.findElement(By.id("android:id/alertTitle")).getText();
		Assert.assertEquals(title, "WiFi settings");
		//copy and paste the text from clipboard
		driver.setClipboardText("shivamani");
		driver.findElement(By.id("android:id/edit")).sendKeys(driver.getClipboardText());
		//any actions key in the mobile
		driver.pressKey(new KeyEvent(AndroidKey.ENTER));
		driver.findElements(AppiumBy.className("android.widget.Button")).get(1).click();
		driver.pressKey(new KeyEvent(AndroidKey.BACK));
		driver.pressKey(new KeyEvent(AndroidKey.HOME));
		
	}
	
}
