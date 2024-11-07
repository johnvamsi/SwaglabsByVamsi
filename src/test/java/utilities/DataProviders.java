package utilities;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;

import pageObjects.BasePage;

public class DataProviders {
	
	@DataProvider(name="LoginData")
	public Object[][] getData() throws IOException
	{
		String path=System.getProperty("user.dir")+"//testData//LoginData.json";
		List<HashMap<String,String>>data=BasePage.supplyData(path);
		Object object[][] = new Object[][]{{data.get(0)},{data.get(1)},
			{data.get(2)},{data.get(3)},{data.get(4)},};
		return object;
	}

}
