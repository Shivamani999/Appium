package org.shivamani.AppiumPOMFramework.android;

import java.util.List;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.shivamani.Utils.ActionsClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidBy;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CartCatalogClass extends ActionsClass{

	AndroidDriver driver;
	
	public CartCatalogClass(AndroidDriver driver) {
			
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
	private List<WebElement> productPrize;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
	private WebElement purchasePrize;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
	private WebElement conditions;
	
	@AndroidFindBy(id="android:id/button1")
	private WebElement closeConditions;
	
	@AndroidFindBy(className = "android.widget.CheckBox")
	private WebElement checkBox;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
	private WebElement order;
	
	public Double prizes() {
		
		int productSize = productPrize.size();
		double productSum = 0;
		for(int i=0;i<productSize;i++) {
			String prize = productPrize.get(i).getText();
			Double formattedPrize = formattedAmount(prize);
			productSum += formattedPrize;
		}
		
		return productSum;
	}
	
	public Double amount() {
		
		String purchaseAmount = purchasePrize.getText();
		Double formattedPurchaseAmount = formattedAmount(purchaseAmount);
		return formattedPurchaseAmount;
		
	}
	
	public void termsAndConditions() {
		
		LongPress(conditions);
		closeConditions.click();
		
	}
	
	public void acceptAndplaceOrder() {
		
		checkBox.click();
		order.click();
	}
	
}
