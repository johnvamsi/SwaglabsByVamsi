package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.google.common.collect.ImmutableMap;


import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class CartPage {
	static AndroidDriver driver;
	public CartPage(AndroidDriver driver)
	{
		//super(driver);
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public static By elePath=By.xpath("//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]");
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-REMOVE\"]")
	public WebElement remove_Button;
	
	@AndroidFindBy(className="android.widget.ScrollView")
	public static WebElement scrollArea;
	
	public void removeProductsFromCart()
	{
		remove_Button.click();
	}
	
	
}
	


