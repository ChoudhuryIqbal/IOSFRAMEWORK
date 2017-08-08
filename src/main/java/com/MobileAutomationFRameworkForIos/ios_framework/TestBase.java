package com.MobileAutomationFRameworkForIos.ios_framework;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.remote.AutomationName;
import io.appium.java_client.remote.MobileCapabilityType;

public class TestBase {
	Dimension size;
	static IOSDriver<IOSElement> driver;

	/**
	 * Sets the up.
	 *
	 * @throws MalformedURLException the malformed URL exception
	 */
	@Test
	public void setUp() throws MalformedURLException {
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone 6");
		cap.setCapability(MobileCapabilityType.BROWSER_NAME,"chrome");
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
		cap.setCapability(MobileCapabilityType.PLATFORM_VERSION,"10.1.2  ");
		cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, AutomationName.IOS_XCUI_TEST);
		//cap.setCapability(MobileCapabilityType.APP, "/Users/choudhuryiqbal/Desktop/UICatalog.app");
		driver = new IOSDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("http://gmail.com");
		driver.findElementById("Email").sendKeys("rahul");
		driver.findElementByName("Passwd").sendKeys("rahul");
		driver.findElementByName("signIn").click();
	}
	
	public void SafariBrowser(){
		
	}

	
	public void clickandclick001() throws MalformedURLException {
		driver.findElementByAccessibilityId("Alert Views").click();
		driver.findElementByName("Text Entry").click();
		driver.findElementByClassName("XCUIElementTypeTextField").sendKeys("OK");
		driver.findElementByXPath("//*[@name='OK']").click();

	}
	

	public void quito(){
		driver.quit();
	}

	public void test02scrolldown() throws InterruptedException{
		
		//find out steppers 
		//scrollDown();
		//scrollios("down");
		driver.swipe(150,350,150,-100,300);
		driver.findElementByAccessibilityId("Steppers").click();
		driver.findElementByAccessibilityId("Increment").click();
		//driver.finElemetnByAccesibilityId("Increment").click();
		driver.findElementByAccessibilityId("Increment").click();
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(1).getText());
		System.out.println(driver.findElementsByClassName("XCUIElementTypeStaticText").get(2).getText());
		driver.navigate().back();
		driver.findElementByAccessibilityId("Picker View").click();
		driver.findElementByName("Green color component value").sendKeys("220");
		driver.findElementsByClassName("XCUIElementTypePickerWheel").get(0).sendKeys("55");
		driver.findElementByXPath("//*[@name='Blue color component value']").sendKeys("130");

		Thread.sleep(4000);
		
	}
	public static void scrollios(String move){
		//down,up,left,right
		JavascriptExecutor js = (JavascriptExecutor) driver;
		HashMap scrollObject = new HashMap();
		scrollObject.put("direction", move);
		js.executeScript("mobile: scroll", scrollObject);

		}
	
	

}
