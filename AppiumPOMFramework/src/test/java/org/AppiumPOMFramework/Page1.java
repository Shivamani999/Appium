package org.AppiumPOMFramework;

import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.TestUtils.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shivamani.AppiumPOMFramework.android.CartCatalogClass;
import org.shivamani.AppiumPOMFramework.android.LoginElementClass;
import org.shivamani.AppiumPOMFramework.android.ProductCatalogClass;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.functions.ExpectedCondition;

public class Page1 extends baseTest{
	
	@Test
	public void loginPage() throws InterruptedException {
		
		elementC.setName("Harshitha");
		elementC.setGender("Female");
		elementC.setCountry("Argentina");
		
		ProductCatalogClass productC = elementC.login();
		productC.addItemToCart(0);
		productC.addItemToCart(0);
		
		CartCatalogClass cart = productC.gotoCartPage();
		double productSum = cart.prizes();
		double formattedPurchaseAmount = cart.amount();
		Assert.assertEquals(productSum, formattedPurchaseAmount);
		cart.termsAndConditions();
		cart.acceptAndplaceOrder();
		
 	}

}
