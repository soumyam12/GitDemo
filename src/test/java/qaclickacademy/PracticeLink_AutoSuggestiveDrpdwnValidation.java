package qaclickacademy;

import java.io.IOException;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.PracticePage;
import resources.BaseClass;

public class PracticeLink_AutoSuggestiveDrpdwnValidation extends BaseClass{
	
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
	public void autoSuggestiveDropdownValidation() throws InterruptedException
	{
		PracticePage prac = new PracticePage(driver);
		prac.autoDropdwn().sendKeys("IND");
		Thread.sleep(3000);
		
		JavascriptExecutor js = (JavascriptExecutor)driver;
		String script = "return document.getElementById(\"autocomplete\").value;";
		
		String text = (String) js.executeScript(script);
		
		int i=0;
		while(!text.equalsIgnoreCase("India"))
		{
			prac.autoDropdwn().sendKeys(Keys.DOWN);
			
			text = (String) js.executeScript(script);
			System.out.println(text);
			
			if(i>5) {
				break;
			}
		}
		
		if(i>5)
		{
			System.out.println("The option is not found");
		}
		else
			System.out.println("The option is found");
		
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
