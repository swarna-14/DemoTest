package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PreviewRepo {

	
	WebDriver driver;
	public PreviewRepo(WebDriver driver)
	{
		this.driver = driver;
	}
	
	

	By UniqueId = By.xpath("//td[contains(text(),'AUR2002294')]");
	By MobileNo = By.xpath("//td[contains(text(),'9248028902')]");
	public WebElement SelectUniqueId()
	{
		return driver.findElement(UniqueId);
	}
	
	public WebElement SelectMno()
	{
		return driver.findElement(MobileNo);
	}
}
