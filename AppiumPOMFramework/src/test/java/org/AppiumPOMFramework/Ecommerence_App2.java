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

public class Ecommerence_App2 extends baseTest{
	
	/*
	 * If you are having more than one Test we have to give (alwaysRun=true) for higher and lower level
	 * of TESTNG levels, or else we can mention directly with group name.
	 */
	
	@BeforeMethod(groups = {"JsonData"})
	public void setup() {
		
		elementC.setActivity("com.androidsample.generalstore",
											"com.androidsample.generalstore.MainActivity");
		
	}
	
	@Test(dataProvider = "getdataJson", groups = {"JsonData"})
	public void successFlow(HashMap<String,String> input) throws InterruptedException {
		
		elementC.setName(input.get("name"));
		elementC.setGender(input.get("gender"));
		elementC.setCountry(input.get("country"));
		
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
	public Object[][] getdataJson() throws IOException {
		
		List<HashMap<String,String>> data = getJsonData(System.getProperty("user.dir")+"src\\test\\java\\org\\resources\\Data.json");
		
		return new Object[][] {
			
			{  data.get(0), data.get(1)  }
			
		};
		
	}

}
