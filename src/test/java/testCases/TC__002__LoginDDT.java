package testCases;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import pageObjects.LoginPage;
import testBase.BaseTest;
import utilities.DataProviders;

public class TC__002__LoginDDT extends BaseTest{
	
	@Test(dataProviderClass=DataProviders.class,dataProvider="LoginData",groups= {"sanity","regression"})
	public void Test__LoginDDT(HashMap<String,String>input) throws Exception
	{
		LoginPage lp = new LoginPage(driver);
		lp.setUsername(input.get("username"));
		lp.setPassword(input.get("password"));
		lp.clickLogin();
		boolean bb=lp.isPageDisplayed();
		if(input.get("status").equals("Valid"))
		{
			
			if(bb==true)
			{
				Assert.assertTrue(true);
				lp.clickMenu();
				lp.clickLogout();
			}
			else
			{
				captureScreen("LoginDDT");
				Assert.assertTrue(false);
			}
		}
		else if(input.get("status").equals("Invalid"))
		{
			if(bb==true)
			{
				captureScreen("LoginDDT");
				lp.clickMenu();
				lp.clickLogout();
				Assert.assertTrue(false);
				
			}
			else
			{
				
				Assert.assertTrue(true);
			}
		}
	}
	
	
	
	
	
	

}
