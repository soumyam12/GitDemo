package qaclickacademy;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.BaseClass;

public class HomePage_TitleValidation extends BaseClass{
	
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
		String actualTitle = lp.getTitle().getText();
		
		Assert.assertEquals(actualTitle, "FEATURED COURSES");
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
