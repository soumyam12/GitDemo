package qaclickacademy;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import resources.BaseClass;

public class HomePage_PracticeLinkValidation extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		driver.get(prop.getProperty("url"));
	}
	
	@Test
	public void practiceLinkValidation()
	{
		LandingPage lp = new LandingPage(driver);
		
		WebDriverWait d = new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(lp.practiceLnk()));
		
		lp.practiceLnk().click();
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
