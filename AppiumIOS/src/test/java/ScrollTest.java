import java.net.MalformedURLException;
import java.util.HashMap;

import io.appium.java_client.ios.IOSDriver;

public class ScrollTest extends BaseIOSTest {

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		// TODO Auto-generated method stub

		IOSDriver driver = DesiredCapabilities();
		//scroll 
		HashMap<String,Object>scrollObject =new HashMap<>();
		scrollObject.put("direction", "down");
		scrollObject.put("name", "Web View");
		
		driver.executeScript("mobile:scroll", scrollObject);
		driver.findElementByAccessibilityId("Web View").click();
		Thread.sleep(2000);
		driver.findElementByXPath("//XCUIElementTypeButton[@name='UIKitCatalog']").click();
		driver.findElementByAccessibilityId("Picker View").click();
		driver.findElementByAccessibilityId("Red color component value").sendKeys("80");
		driver.findElementByAccessibilityId("Green color component value").sendKeys("220");
		driver.findElementByAccessibilityId("Blue color component value").sendKeys("105");
		System.out.println(driver.findElementByAccessibilityId("Blue color component value").getText());
		
		
		
		
		
		
		
		
		
		
	}

}
