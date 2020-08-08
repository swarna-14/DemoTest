package ObjectRepository;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
public class SetUPDriver {
	
	public static WebDriver driver;
	public void getDriver() throws InterruptedException
	{
		if(constants.browser.equalsIgnoreCase("firefox"))
				{
			     driver = new FirefoxDriver();
				}
		else if(constants.browser.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:/chromedriver/chromedriver.exe");
			driver  = new ChromeDriver();
			driver.manage().deleteAllCookies();
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			driver.get(constants.url);	
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//a[@class='btn btn2'][contains(text(),'Applicant')]")).click();
			Thread.sleep(3000);
			
		}
		
		
		//return driver;
	}

}

