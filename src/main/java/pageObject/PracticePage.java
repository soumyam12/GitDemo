package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PracticePage {
	
	public WebDriver driver;
	
	By secondRadio = By.xpath("//input[@value='radio2']");
	
	By autoDrpdwn = By.id("autocomplete");
	
	By staticDrpdwn = By.id("dropdown-class-example");
	
	By firstChckBox = By.id("checkBoxOption1");
	
	By secondChckBox = By.id("checkBoxOption2");
	
	By thirdChckBox = By.id("checkBoxOption3");
	
	By windowOpen = By.id("openwindow");
	
	By tabOpen = By.linkText("Open Tab");
	
	public PracticePage(WebDriver driver) {
		this.driver=driver;
	}

	public WebElement getsecondRadio()
	{
		return driver.findElement(secondRadio);
	}
	
	public WebElement autoDropdwn()
	{
		return driver.findElement(autoDrpdwn);
	}
	
	public WebElement staticDrpdwn()
	{
		return driver.findElement(staticDrpdwn);
	}
	
	public WebElement firstChckBox()
	{
		return driver.findElement(firstChckBox);
	}
	
	public WebElement secondChckBox()
	{
		return driver.findElement(secondChckBox);
	}
	
	public WebElement thirdChckBox()
	{
		return driver.findElement(thirdChckBox);
	}
	
	public WebElement winOpen()
	{
		return driver.findElement(windowOpen);
	}
	
	public WebElement openTab()
	{
		return driver.findElement(tabOpen);
	}

}
