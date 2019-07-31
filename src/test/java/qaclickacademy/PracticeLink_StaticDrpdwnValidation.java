package qaclickacademy;

import java.io.IOException;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.PracticePage;
import resources.BaseClass;

public class PracticeLink_StaticDrpdwnValidation extends BaseClass{
	
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
	public void staticDropdownValidation() throws InterruptedException
	{
		PracticePage prac = new PracticePage(driver);
		
		Select s = new Select(prac.staticDrpdwn());
		//s.selectByIndex(1);
		s.selectByValue("option2");	
		//s.selectByVisibleText("Option2");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
