package org.AppiumPOMFramework;

import java.io.IOException;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.TestUtils.baseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shivamani.AppiumPOMFramework.android.CartCatalogClass;
import org.shivamani.AppiumPOMFramework.android.ProductCatalogClass;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import io.appium.java_client.functions.ExpectedCondition;

public class Ecommerence_App extends baseTest{
	
	@BeforeMethod
	public void setup() {
		
		elementC.setActivity("com.androidsample.generalstore",
											"com.androidsample.generalstore.MainActivity");
		
	}
	
	@Test
	public void errorFlow() throws InterruptedException {
		
		//elementC.setName("Harshitha");
		elementC.setGender("Female");
		elementC.setCountry("Argentina");
		elementC.login();
		String toastMsg = elementC.toastMsg("name"); 
		Assert.assertEquals(toastMsg, "Please enter your name");
		
	}
	
	@Test(dataProvider = "getdata")
	public void successFlow(String name, String gender, String country) throws InterruptedException {
		
		elementC.setName(name);
		elementC.setGender(gender);
		elementC.setCountry(country);
		
		ProductCatalogClass productC = elementC.login();
		productC.selectProduct("Jordan 6 Rings");
		productC.selectProduct("Converse All Star");
		
		CartCatalogClass cart = productC.gotoCartPage();
		double productSum = cart.prizes();
		double formattedPurchaseAmount = cart.amount();
		Assert.assertEquals(productSum, formattedPurchaseAmount);
		cart.termsAndConditions();
		cart.acceptAndplaceOrder();
		
 	}
	
	@DataProvider
	public Object[][] getdata() throws IOException {
		
		return new Object[][] {
			
			{"Harshitha","Female","Argentina"}
			
		};
		
	}

}
