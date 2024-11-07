package testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import pageObjects.CartPage;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import testBase.BaseTest;

public class TC__004__RemoveProductFromCart extends BaseTest {
	
	@Test(groups={"sanity","regression"})
	public void Test__RemoveProducts() throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLogin();
		ProductsPage pp= new ProductsPage(driver);
		pp.addVisibleProducts();
		Thread.sleep(3000);
		pp.clickCart();
		CartPage cp= new CartPage(driver);
		cp.removeProductsFromCart();
		Thread.sleep(2000);
		cp.removeProductsFromCart();
		
	
		
		
	}
	

}
