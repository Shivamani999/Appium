package shivamani.Appium;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MobileBrowserTest extends browserBaseTest{

	@Test
	public void browserTesting() throws InterruptedException {
		/*
		 * 
		 * This is as simple as selenium, because if you are known with selenium then its easy
		 * to use browser in mobile. We wont use Appium driver for mobile browser.
		 * 
		 * 
		driver.get("http://google.com");
		System.out.println(driver.getTitle());
		driver.findElement(By.name("q")).sendKeys("who is king of tolloywood");
		driver.findElement(By.name("q")).sendKeys(Keys.ENTER);
		*/
		driver.get("https://www.scaler.com");
		Thread.sleep(5000);
		driver.findElement(By.className("burger")).click();
		Thread.sleep(2000);
		String hamburgerMenu = driver.findElement(By.xpath("//*[@id='main-site-header']/div[3]/div[1]/div[1]/a[1]")).getText();
		Assert.assertEquals(hamburgerMenu, "Scaler Academy");
		driver.findElement(By.className("header__burger-button")).click();
		driver.findElement(By.id("marketing-form-program-ds")).click();
		driver.findElement(By.id("marketing-form__name")).sendKeys("Shivamani");
		driver.findElement(By.id("__email")).sendKeys("shivasuriyakonam@gmail.com");
		
	}
	
}
