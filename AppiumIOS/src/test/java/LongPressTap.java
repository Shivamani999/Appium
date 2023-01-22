import java.net.MalformedURLException;

import io.appium.java_client.MobileElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSTouchAction;
import static io.appium.java_client.touch.LongPressOptions.longPressOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static java.time.Duration.ofSeconds;
import static io.appium.java_client.touch.TapOptions.tapOptions;



public class LongPressTap extends BaseIOSTest{

	public static void main(String[] args) throws MalformedURLException {
		// TODO Auto-generated method stub

		IOSDriver driver = DesiredCapabilities();
	MobileElement e=	(MobileElement)driver.findElementByName("Long tap");
	IOSTouchAction touch = new IOSTouchAction(driver);
	touch.longPress(longPressOptions().withElement(element(e)).withDuration(ofSeconds(2)))
			.release().perform();
	
	MobileElement tap= (MobileElement)driver.findElementByXPath("//XCUIElementTypeSwitch[2]");
	touch.tap(tapOptions().withElement(element(tap))).perform();
	
	
	
	
	
	
		
		
		
		
		
		
		
		
	}

}
