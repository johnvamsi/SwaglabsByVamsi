package testCases;

import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.google.common.collect.ImmutableMap;
import pageObjects.LoginPage;
import pageObjects.ProductsPage;
import testBase.BaseTest;

public class TC__003__AddProductToCart extends BaseTest {
	
	@Test(groups= {"sanity","regression"})
	public void Test___AddProductsToCart() throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLogin();
		ProductsPage pp= new ProductsPage(driver);
		pp.addVisibleProducts();
		Thread.sleep(3000);
		pp.clickCart();
		System.out.println("TestCase is Executed ");
		
	}
	

}
