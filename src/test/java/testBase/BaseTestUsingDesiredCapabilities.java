package testBase;

import java.io.File;
import java.net.URL;
import java.time.Duration;
import java.util.ResourceBundle;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTestUsingDesiredCapabilities {
	public AppiumDriverLocalService service;
	public Logger logger;
	public ResourceBundle rb;
	public static AndroidDriver driver;
	
	@BeforeClass()
	public void setUp() throws Exception
	{
		rb=ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(getClass());
		logger.info("Setting Up The server");
		 service = new AppiumServiceBuilder()
					.withAppiumJS(new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js")).withIPAddress("127.0.0.1").usingPort(4723).build();
				service.start();
				DesiredCapabilities caps = new DesiredCapabilities();
				caps.setCapability("appium:automationName", "UiAutomator2");
				caps.setCapability("appium:platformName", "Android");
				caps.setCapability("appium:deviceName", "motorola edge 20");
				caps.setCapability("appium:udid", "192.168.1.2:5555");
				caps.setCapability("appium:appPackage", "com.swaglabsmobileapp");
				caps.setCapability("appium:appActivity", "com.swaglabsmobileapp.MainActivity");
				//String appPath=System.getProperty("user.dir")+"//src//test//resources//General-Store.apk";
				//caps.setCapability("appium:app", appPath);
				URL myurl= new URL("http://127.0.0.1:4723");
				AndroidDriver driver = new AndroidDriver(myurl,caps);
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Device Configuration is Done");
				
				
	}

	
	
	@AfterClass()
	public void tearDown()
	{
		//driver.close();
		driver.quit();
		logger.info("driver is closed");
		service.stop();
		logger.info("Server is Closed");
	}
}
