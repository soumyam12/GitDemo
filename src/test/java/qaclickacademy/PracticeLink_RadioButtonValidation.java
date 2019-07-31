package qaclickacademy;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.PracticePage;
import resources.BaseClass;

public class PracticeLink_RadioButtonValidation extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		driver.get(prop.getProperty("url"));
		
        LandingPage lp = new LandingPage(driver);
		
		WebDriverWait d = new WebDriverWait(driver,20);
		d.until(ExpectedConditions.elementToBeClickable(lp.practiceLnk()));
		
		lp.practiceLnk().click();
	}
	
	@Test
	public void radioBtnValidation()
	{
		PracticePage prac = new PracticePage(driver);
		prac.getsecondRadio().click();
		
		System.out.println(prac.getsecondRadio().isEnabled());
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
