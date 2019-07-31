package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
	
	public WebDriver driver;
	
	By email = By.id("user_email");
	
	By password = By.id("user_password");
	
	By loginBtn = By.xpath("//input[@value='Log In']");
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getEmail()
	{
		return driver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return driver.findElement(password);
	}
	
	public WebElement loginBtnClick()
	{
		return driver.findElement(loginBtn);
	}

}
