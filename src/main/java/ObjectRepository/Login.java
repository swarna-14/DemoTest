package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Login {

	WebDriver driver;
	
	public Login(WebDriver driver) {
		
		this.driver=driver;
	}
	
	
	By Username = By.id("txtUserName");
	By Password = By.id("txtPassword");
	By getCapcha = By.id("captchaImage");
	By writeCapcha = By.id("txtCaptcha");
	By LoginButton = By.xpath("//input[@id='btnLogin']");
	By LandApplication = By.xpath("//*[@id=\"side-menu\"]/li[2]/a");
	By buttonNext = By.id("btnNext");
	By buttonNext1 = By.id("btnNext");

	
	public WebElement SelectUserName()
	{
		return driver.findElement(Username);
		//return typeUsername;
	}
	
	public WebElement SelectPassWord()
	{
		return driver.findElement(Password);
		//return typePassword;
	}
	
	public WebElement GetCaptcha()
	{
		return driver.findElement(getCapcha);
		//return typeCaptchaText;
	}
	
	public WebElement WriteCaptcha()
	{
		return driver.findElement(writeCapcha);
		//return typeCaptcha;
	}
	
	public WebElement ClickLoginButton()
	{
		return driver.findElement(LoginButton);
		//return typeSignInButton;
	}
	
	public WebElement ApplyLandApplication()
	{
		return driver.findElement(LandApplication);
		//return typeSignInButton;
	}
	
	public WebElement SaveANDProceed()
	{
		return driver.findElement(buttonNext);
		//return typeSignInButton;
	}
	
	public WebElement SaveANDProceed1()
	{
		return driver.findElement(buttonNext1);
		//return typeSignInButton;
	}
}
