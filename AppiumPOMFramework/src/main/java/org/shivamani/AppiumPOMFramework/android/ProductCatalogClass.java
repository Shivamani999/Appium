package org.shivamani.AppiumPOMFramework.android;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.shivamani.Utils.ActionsClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class ProductCatalogClass extends ActionsClass{
	
	AndroidDriver driver;

	public ProductCatalogClass(AndroidDriver driver) {
		
		super(driver);
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
		
	}
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/productName")
	private List<WebElement> products;
	
	@AndroidFindBy(xpath="//android.widget.TextView[@text='ADD TO CART']")
	private List<WebElement> addToCart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
	private WebElement Cart;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/toolbar_title")
	private WebElement cartTitle;
	
	public void addItemToCart(int index) {
		
		addToCart.get(index).click();
		
	}
	
	public CartCatalogClass gotoCartPage() throws InterruptedException {
		
		Cart.click();
		Thread.sleep(3000);
		webDriverWait(cartTitle,"Cart",driver);
		return new CartCatalogClass(driver);
		
	}
	
	public void selectProduct(String productName) throws InterruptedException {
		
		scrollToElement(productName);
		Thread.sleep(2000);
		int productSize = products.size();
		for(int i=0;i<productSize;i++) {
			String name = products.get(i).getText();
			if(name.equalsIgnoreCase(productName)) {
				addToCart.get(i).click();
			}
		}
		
	}
	
}
