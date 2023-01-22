package org.shivamani.AppiumPOMFramework.android;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.shivamani.Utils.ActionsClass;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginElementClass extends ActionsClass {

	AndroidDriver driver;

	public LoginElementClass(AndroidDriver driver) {

		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);

	}

	@AndroidFindBy(id = "com.androidsample.generalstore:id/nameField")
	private WebElement nameField;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Female']")
	private WebElement femaleOption;

	@AndroidFindBy(xpath = "//android.widget.RadioButton[@text='Male']")
	private WebElement maleOption;

	@AndroidFindBy(id = "android:id/text1")
	private WebElement countryDropdown;

	@AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
	private WebElement sumbitForLogin;

	@AndroidFindBy(xpath = "(//android.widget.Toast)[1]")
	private WebElement toastPopup;

	public void setName(String name) {

		nameField.sendKeys(name);
		driver.hideKeyboard();

	}

	public void setGender(String gender) {

		if (gender.contains("Female"))
			femaleOption.click();
		else
			maleOption.click();

	}

	public void setCountry(String country) {

		countryDropdown.click();
		scrollToElement(country);
		driver.findElement(By.xpath("//android.widget.TextView[@text='" + country + "']")).click();

	}

	public ProductCatalogClass login() {

		sumbitForLogin.click();
		return new ProductCatalogClass(driver);

	}

	public String toastMsg(String attribute) {

		return toastPopup.getAttribute(attribute);

	}

	public void setActivity(String appPath, String pagePath) {

		// directs you to page which we are needed by giving required parameters...
		Activity act =  new Activity(appPath, pagePath);
		driver.startActivity(act);

	}

}
