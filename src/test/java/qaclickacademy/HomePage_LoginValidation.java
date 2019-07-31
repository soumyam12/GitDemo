package qaclickacademy;

import java.io.IOException;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageObject.LandingPage;
import pageObject.LoginPage;
import resources.BaseClass;

public class HomePage_LoginValidation extends BaseClass{
	
	@BeforeTest
	public void initialize() throws IOException
	{
		driver = browserInitialization();
		
	}
	
	@Test(dataProvider="getData")
	public void loginValidation(String username, String password)
	{
     driver.get(prop.getProperty("url"));
	
		LandingPage lp = new LandingPage(driver);
		lp.login().click();
		
		LoginPage l = new LoginPage(driver);
		l.getEmail().sendKeys(username);
		l.getPassword().sendKeys(password);
		l.loginBtnClick().click();
		
		System.out.println("initialize1");
		System.out.println("initialize2");
	}
	
	@DataProvider
	public Object[][] getData()
	{
		Object[][] obj = new Object[2][2];
		
		obj[0][0] = "user1";
		obj[0][1] = "pass1";
		
		obj[1][0] = "user2";
		obj[1][1] = "pass2";
		
		return obj;
	}
	
	@AfterTest
	public void tearDown()
	{
		driver.close();
	}
	

}
