package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class BaseClass {
	
	public WebDriver driver;
	public Properties prop;
	
	public WebDriver browserInitialization() throws IOException
	{
		prop = new Properties();
		
		FileInputStream fis = new FileInputStream("C:\\Users\\soumya.mohanty\\MyFrameworkProject\\src\\main\\java\\resources\\data.properties");
		
		prop.load(fis);
		String browser = prop.getProperty("browser");
		
		if(browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
			System.out.println("chrome driver is launched");
		}
		else
			if(browser.equalsIgnoreCase("firefox"))
			{
				System.setProperty("webdriver.firefox.marionette", "C:\\Selenium\\geckodriver-v0.24.0-win64");
				driver = new FirefoxDriver();
				System.out.println("firefox driver is launched");
			}
			else
				if(browser.equalsIgnoreCase("IE"))
				{
					driver = new InternetExplorerDriver();
					System.out.println("IE driver is launched");
				}
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		
		//String url = prop.getProperty("url");
		//driver.get(url);
		
		return driver;
	}

	public void getScreenshot(String result) throws IOException {
		
		//File src = ((TakesScreenshot)driver)).getScreenshotAs(OutputType.FILE);
		File src = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//To copy src variable to local file
		FileUtils.copyFile(src, new File("C:\\Users\\soumya.mohanty\\ss\\"+System.currentTimeMillis()+"screenshot1.png"));
		
	}

}
