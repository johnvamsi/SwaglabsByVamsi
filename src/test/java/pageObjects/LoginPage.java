package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class LoginPage extends BasePage{
	
	public LoginPage(AndroidDriver driver)
	{
		super(driver);
	}
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"test-Username\"]")
	WebElement UserName_txt;
	
	@FindBy(xpath="//android.widget.EditText[@content-desc=\"test-Password\"]")
	WebElement Password_txt;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-LOGIN\"]")
	WebElement login_button;
	
	@FindBy(xpath="//android.widget.TextView[@text='PRODUCTS']")
	WebElement product_text;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-Menu\"]")
	WebElement click_Menu;
	
	@FindBy(xpath="//android.view.ViewGroup[@content-desc=\"test-LOGOUT\"]")
	WebElement click_Logout;
	
	public void setUsername(String uname)
	{
		UserName_txt.sendKeys(uname);
	}
    public void setPassword(String pwd)
    {
    	Password_txt.sendKeys(pwd);
    }
    public void clickLogin()
    {
    	login_button.click();
    }
    public boolean isPageDisplayed()
    {
    	try
    	{
    		return(product_text.isDisplayed());
    	}
    	catch(Exception e)
    	{
    		return(false);
    	}
    }
    
    public void clickMenu()
    {
    	click_Menu.click();
    }
    public void clickLogout()
    {
    	click_Logout.click();
    }
}
