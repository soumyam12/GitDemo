package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	
	public WebDriver driver;
	
	By loginLink = By.cssSelector("[href*='sign_in']");
	
	By title = By.xpath("//h2[contains(text(),'Featured Courses')]");
	
	By navBar = By.cssSelector("ul[class='nav navbar-nav navbar-right']");
	
	By practiceLink = By.xpath("//a[contains(text(),'Practice')]");
	
	public LandingPage(WebDriver driver) {
		
		this.driver=driver;
	}

	public WebElement login()
	{
		return driver.findElement(loginLink);
	}
	
	public WebElement getTitle()
	{
		return driver.findElement(title);
	}
	
	public WebElement getNavBar()
	{
		return driver.findElement(navBar);
	}
	
	public WebElement practiceLnk()
	{
		return driver.findElement(practiceLink);
	}

}
