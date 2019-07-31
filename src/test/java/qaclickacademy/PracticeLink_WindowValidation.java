package qaclickacademy;

import java.io.IOException;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.PracticePage;
import resources.BaseClass;

public class PracticeLink_WindowValidation extends BaseClass{
	
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
	public void windowValidation()
	{
		PracticePage prac = new PracticePage(driver);
		prac.winOpen().click();
		
		Set<String> ids = driver.getWindowHandles();
		Iterator<String> it = ids.iterator();
		
		String parentWin = it.next();
		String childWin = it.next();
		
		driver.switchTo().window(childWin);
		String actTitle = driver.getTitle();
		System.out.println(actTitle);
		
		if(actTitle.contains("QA Click Academy"))
		{
			System.out.println("The title is correct");
		}
		else
			System.out.println("The title is not correct");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.quit();
	}
	

}
