package FunctionalTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Objectrepo {

	WebDriver driver;
	
	public void landapply(WebDriver driver)
	{
		this.driver = driver;
	}
	
	By username = By.xpath("//input[@id='txtUserName']");
	By password = By.xpath("//input[@id='txtPassword']");
	By login = By.xpath("//input[@id='btnLogin']");
	
	public WebElement Emaild()
	   {
		   return driver.findElement(username);
	   }
	         
	   public WebElement Password()
	   {
		   return driver.findElement(password);
	   }
	   
	   public WebElement login()
	   {
		   return driver.findElement(login);
	   }
}
