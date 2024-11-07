package pageObjects;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.interactions.PointerInput.Origin;
import java.time.Duration;
import java.util.Arrays;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class BasePage {
	AndroidDriver driver;
	public BasePage(AndroidDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	
	public WebElement ExplicitlyWait(WebElement Element)
	{
		WebDriverWait mywait = new WebDriverWait(driver,(Duration.ofSeconds(10)));
		WebElement element=mywait.until(ExpectedConditions.visibilityOf(Element));
		return(element);
	}
    
	public void clickGestureElement(WebElement element)
	{
		driver.executeScript("mobile: clickGesture",ImmutableMap.of("elementId",
				((RemoteWebElement)element).getId(),
				"duration",1000));
	}
	
	public static List<HashMap<String, String>> supplyData(String path) throws IOException
	{
		String jsonPath= FileUtils.readFileToString(new File(path),StandardCharsets.UTF_8);
	    ObjectMapper mapper = new ObjectMapper();
	    List<HashMap<String,String>>data= mapper.readValue(jsonPath,
	    		new TypeReference<List<HashMap<String,String>>>()
	    		{
	    	
	    		});
		return data;
	
	}
	
	public void scrollToElementByText(String Text)
	{
		  String uiAutomatorString = "new UiScrollable(new UiSelector()).scrollIntoView(text(\"" + Text + "\"));";
	         driver.findElement(AppiumBy.androidUIAutomator(uiAutomatorString));
	       
	}
	

	
	
	
	
	
	
	
}
