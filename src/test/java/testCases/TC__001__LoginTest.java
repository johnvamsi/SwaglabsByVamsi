package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.LoginPage;
import testBase.BaseTest;

public class TC__001__LoginTest extends BaseTest {
	
	@Test(groups= {"sanity","regression"})
	public void Test__Login()
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername("standard_user");
		lp.setPassword("secret_sauce");
		lp.clickLogin();
		boolean bb=lp.isPageDisplayed();
		Assert.assertEquals(bb, true);
		lp.clickMenu();
		lp.clickLogout();
		
	}

}
