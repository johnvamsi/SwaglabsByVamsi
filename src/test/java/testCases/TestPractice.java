package testCases;

import java.io.File;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class TestPractice {
	public AppiumDriverLocalService service;
	public AndroidDriver driver;
	@Test
	public void startServer() throws Exception
	{
		
		service= new 	AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress("127.0.0.1").usingPort(4723).build();
		service.start();
		
		UiAutomator2Options options= new UiAutomator2Options();
		options.setAutomationName("UiAutomator2");
		options.setPlatformName("Android");
		options.setDeviceName("motorola edge 20");
		options.setUdid("192.168.1.2:5555");
//		options.setAppPackage("com.androidsample.generalstore");
//		options.setAppActivity("com.androidsample.generalstore.MainActivity");
		URL myurl = new URL("http://127.0.0.1:4723");
		driver =new AndroidDriver(myurl,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		
		
   



		driver.quit();
		service.stop();

	}
}
