package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class ProductsPage extends BasePage{
	
	public ProductsPage(AndroidDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//android.widget.TextView[@content-desc='test-Item title']")
	List<WebElement> VisibleProducts;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc='test-ADD TO CART']")
	List<WebElement>VisibleCartButtons;
	
	@AndroidFindBy(xpath ="//android.view.ViewGroup[@content-desc=\"test-Cart\"]/android.view.ViewGroup/android.widget.ImageView")
	public WebElement cart_Element;
	
	@AndroidFindBy(accessibility = "test-Cart")
	 WebElement Cart_Element;
	
	
			

	
	
	
	public void addVisibleProducts()
	{
		for(WebElement element :VisibleCartButtons)
		{
			element.click();
		}
	}
	public void clickCart()
	{
		driver.findElement(AppiumBy.accessibilityId("test-Cart")).click();
		//Cart_Element.click();
		
	}
	
	
	
	

}
