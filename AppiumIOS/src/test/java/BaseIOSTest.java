import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.IOSMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

public class BaseIOSTest {

	public static IOSDriver DesiredCapabilities() throws MalformedURLException
	{
		// TODO Auto-generated method stub

	//	
		DesiredCapabilities capabilites =new DesiredCapabilities();
		capabilites.setCapability(MobileCapabilityType.PLATFORM_VERSION, "14.3");
		capabilites.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 12 Pro");
		//IOS_XCUI_Test     Apple 
		capabilites.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		capabilites.setCapability(IOSMobileCapabilityType.LAUNCH_TIMEOUT, 500000);
		capabilites.setCapability("commandTimeouts", "12000"); //.app
		
		capabilites.setCapability(MobileCapabilityType.APP, "Users/rahulshetty/Desktop/LongTap.app");
		
		IOSDriver driver = new IOSDriver<>(new URL("http://localhost:4723/wd/hub"),capabilites);
		
		return driver;
		
		
	
	
		
	}

}
