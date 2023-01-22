import java.net.MalformedURLException;

import org.testng.Assert;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;

public class SliderTest extends BaseIOSTest{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		
		IOSDriver driver = DesiredCapabilities();
		
		driver.findElementByAccessibilityId("Sliders").click();
	IOSElement slider =(IOSElement)driver.findElementByXPath("//XCUIElementTypeSlider");
	slider.setValue("0%");
	slider.setValue("0.5%"); // 0 0.90 1.
	Assert.assertEquals("100%", slider.getAttribute("value"));
	
	
	
	
	
		
		
	}

}
