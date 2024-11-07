package testBase;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.ResourceBundle;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.annotations.*;
import org.testng.annotations.BeforeClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;

public class BaseTest {
	public AppiumDriverLocalService service;
	public Logger logger;
	public ResourceBundle rb;
	public static AndroidDriver driver;
	
	
	@BeforeClass(alwaysRun=true)
	public void setUp() throws Exception
	{
		rb=ResourceBundle.getBundle("config");
		logger=LogManager.getLogger(getClass());
		logger.info("Setting Up The server");
		service =new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\HP\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
				.withIPAddress(rb.getString("ipAddress")).usingPort(Integer.parseInt(rb.getString("port"))).build();
		service.start();
		logger.info("Server is Running");
		
		UiAutomator2Options options =new UiAutomator2Options();
		options.setAutomationName("UiAutomator2");
		options.setPlatformName("Android");
		options.setDeviceName("motorola edge 20");
		options.setUdid("192.168.1.4:5555");
		options.setAppPackage("com.swaglabsmobileapp");
		options.setAppActivity("com.swaglabsmobileapp.MainActivity");
		options.setNoReset(true);//Prevent reinstalling the app
//		String appPath = System.getProperty("user.dir") + "//src//test//resources//General-Store.apk";
//		options.setApp(appPath);
		URL myurl= new URL("http://127.0.0.1:4723");
		driver=new AndroidDriver(myurl,options);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		logger.info("Device Configuration is Done");
				
				
	}

	
	
				@AfterClass(alwaysRun=true)
				public void tearDown()
				{
					//driver.close();
					driver.quit();
					logger.info("driver is closed");
					service.stop();
					logger.info("Server is Closed");
				
					
				}
	
			
	
	
	public String captureScreen(String tname) throws IOException 
	{

		String timeStamp = new SimpleDateFormat("yyyyMMddhhmmss").format(new Date());
				
		TakesScreenshot takesScreenshot = (TakesScreenshot) driver;
		File source = takesScreenshot.getScreenshotAs(OutputType.FILE);
		String destination = System.getProperty("user.dir") + "\\screenShots\\" + tname + "_" + timeStamp + ".png";
        
				try 
				{
					FileUtils.copyFile(source, new File(destination));
				} 
				catch (Exception e) 
				{
					e.getMessage();
				}
				return destination;

	}
}
