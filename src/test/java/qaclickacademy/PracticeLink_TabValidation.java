package qaclickacademy;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.PracticePage;
import resources.BaseClass;

public class PracticeLink_TabValidation extends BaseClass{
	
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
	public void tabValidation()
	{
		PracticePage prac = new PracticePage(driver);
		
		//prac.openTab().click();
		
		String clickOnTab = Keys.chord(Keys.CONTROL,Keys.ENTER);
		prac.openTab().sendKeys(clickOnTab);
		
		System.out.println(driver.getTitle());
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		while(it.hasNext())
		{
			System.out.println(driver.switchTo().window(it.next()).getTitle());
		}
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
