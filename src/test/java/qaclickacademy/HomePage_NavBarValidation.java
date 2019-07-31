package qaclickacademy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.BaseClass;

public class HomePage_NavBarValidation extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void NavBarValidation()
	{
		LandingPage lp = new LandingPage(driver);
		boolean nb = lp.getNavBar().isDisplayed();
		Assert.assertTrue(nb);
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
