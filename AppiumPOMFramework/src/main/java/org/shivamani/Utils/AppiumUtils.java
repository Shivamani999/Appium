package org.shivamani.Utils;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.Activity;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class AppiumUtils {
	
	AppiumDriverLocalService service;
	
	public AppiumDriverLocalService appiumServer(String ipAddress,int port) {
		
		service = new AppiumServiceBuilder()
				.withAppiumJS(new File("C://Users//lenovo//node_modules//appium//build//lib//main.js"))
				.withIPAddress(ipAddress).usingPort(port).build();
		service.start();
		return service;
	}

	public double formattedAmount(String amount) {

		double forAmount = Double.parseDouble(amount.substring(1));
		return forAmount;

	}
	
	public void webDriverWait(WebElement ele,String text,AppiumDriver driver) {
		
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		wait.until(ExpectedConditions.attributeContains(ele, "text", text));
		
	}
	
	public List<HashMap<String, String>> getJsonData(String jsonPath) throws IOException {
		
		String jsonString = FileUtils.readFileToString(new File(jsonPath),StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> data = mapper.readValue(jsonString, new TypeReference<List<HashMap<String,String>>>() {
		});
		
		return data;
		
	}
	
	public String getScreenshotPath(String methodName, AppiumDriver driver) throws IOException {
		
		File screenShot = driver.getScreenshotAs(OutputType.FILE);
		String destinationPath = System.getProperty("user.dir")+"//reports//"+methodName+".png";
		FileUtils.copyFile(screenShot, new File(destinationPath));
		return destinationPath;
		
	}

}
