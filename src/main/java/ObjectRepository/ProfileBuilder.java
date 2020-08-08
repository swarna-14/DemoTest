
package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfileBuilder {
	
	WebDriver driver;
	public ProfileBuilder(WebDriver driver) {
		
		this.driver=driver;
	}
	 
	
			
	By ApplicantName = By.id("txtName");
	
	By MobileNo = By.id("txtMobNo");
	
	By Email = By.id("txtEmail");
	
	By Country = By.id("selCountry");
	
	By State = By.id("selState");
	
	By District = By.id("txtDistrict");
	
	By Pin = By.id("txtPin");
	
	By SpecialCategory = By.id("selSpecialCat");
	
	By Adress = By.id("txtAddress");
	
	By BankName = By.id("txtBankName");
	
	By BranchName = By.id("txtBranchName");
	
	By IfscCode = By.id("txtBankIfscCode");
	
	By AccounNo = By.id("txtAccNo");
	
	By SaveProceed = By.id("btnNext");
	
	public WebElement SelectApplicantName()
	{
		return driver.findElement(ApplicantName);
	}
	public WebElement SelectMobileNo()
	{
		return driver.findElement(MobileNo);
	}
	public WebElement SelectEmail()
	{
		return driver.findElement(Email);
	}
	public WebElement SelectCountry()
	{
		return driver.findElement(Country);
	}
	public WebElement SelectState()
	{
		return driver.findElement(State);
	}
	public WebElement SelectDistrict()
	{
		return driver.findElement(District);
	}
	public WebElement SelectPin()
	{
		return driver.findElement(Pin);
	}
	public WebElement SelectSpecialCategory()
	{
		return driver.findElement(SpecialCategory);
	}
	public WebElement SelectAdress()
	{
		return driver.findElement(Adress);
	}
	public WebElement SelectBankName()
	{
		return driver.findElement(BankName);
	}
	public WebElement SelectBranchName()
	{
		return driver.findElement(BranchName);
	}
	public WebElement SelectIfscCode()
	{
		return driver.findElement(IfscCode);
	}
	public WebElement SelectAccounNo()
	{
		return driver.findElement(AccounNo);
	}
	public WebElement SelectSaveproceed()
	{
		return driver.findElement(SaveProceed);
	}
	
	
	
	
	
}
