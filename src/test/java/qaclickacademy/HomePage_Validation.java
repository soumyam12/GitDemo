package qaclickacademy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.BaseClass;

public class HomePage_Validation extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void loginClick() throws IOException
	{	
		LandingPage lp = new LandingPage(driver);
		
		lp.login().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	
	

}
