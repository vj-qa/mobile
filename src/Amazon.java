import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import com.thoughtworks.selenium.webdriven.commands.IsElementPresent;
public class Amazon {
	
	AndroidDriver driver;
	@Test
	public void AppTest() throws MalformedURLException, InterruptedException{
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("deviceName", "samsung-sm-g900a");
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "5.1.1");
		caps.setCapability("appPackage", "com.amazon.mShop.android.shopping");
		caps.setCapability("appActivity", "com.amazon.mShop.home.HomeActivity");
		driver=new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),caps);
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		System.out.println(driver.isAppInstalled("com.amazon.mShop.android.shopping"));
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"gw-mobile-greeting-bar\")").click();
		Thread.sleep(5000);
		driver.findElementByAndroidUIAutomator("UiSelector().text(\"Email (phone for mobile accounts)"
				+ "\")").click();
		driver.hideKeyboard();
		TouchAction action = new TouchAction(driver);
		Thread.sleep(3000);
		WebElement el = driver.findElementByAndroidUIAutomator("UiSelector().resourceId(\"gw-mobile-greeting-bar\")");
		//action.longPress(el).perform();
	//	driver.pinch(el);;
	//	driver.zoom(el);
		//swipe
		//dial//
		//launch
		int x = el.getLocation().x;
		int y = el.getLocation().y;
		driver.swipe(x, y, x, y-800, 3000);
		driver.quit();
	}

}
