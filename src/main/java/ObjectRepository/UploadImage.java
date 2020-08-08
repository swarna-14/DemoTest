package ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class UploadImage {

	WebDriver driver;
	
	public UploadImage(WebDriver driver) {
		
		this.driver=driver;
		
	}
	
	
	
	By DPRUpload = By.id("txtFile1_1");
	By PANUpload = By.id("txtFile1_6");
	By DulyNotarizedUpload = By.id("txtFile1_7");
	By CopyOfConstitution =  By.id("txtFile1_20");
	By PowerOfAttorney = By.id("txtFile1_22");
	By CopyOfBoardResolution = By.id("txtFile1_23");
	By AuthorizedSignatories = By.id("txtFile1_24");
	By BalanceSheet = By.id("txtFile1_35");
	By LeaseAgreementMIDC = By.id("txtFile1_3");
	By BankDetails = By.id("txtFile1_4");
	By LetterOfAuthorization = By.id("txtFile1_21");
	By pdfremove = By.id("clearDocs1");
	
	
	
	
	public WebElement UploadDPR_PDF() {
		
		return driver.findElement(DPRUpload);
	}
	
	
	public WebElement UploadPAN_PDF()
	{
		return driver.findElement(PANUpload);
	}
	
	
	public WebElement UploadDulynotarized_PDF()
	{
		return driver.findElement(DulyNotarizedUpload);
	}
	
	public WebElement UploadCopyOfConstitution_PDF()
	{
		return driver.findElement(CopyOfConstitution);
	}
	
	public WebElement UploadPowerOfAttorney_PDF()
	{
		return driver.findElement(PowerOfAttorney);
	}
	
	public WebElement UploadCopyOfBoardResolution_PDF()
	{
		return driver.findElement(CopyOfBoardResolution);
	}
	
	public WebElement UploadAuthorizedSignatories_PDF()
	{
		return driver.findElement(AuthorizedSignatories);
	}
	
	public WebElement UploadBalanceSheetSignatories_PDF()
	{
		return driver.findElement(BalanceSheet);
	}
	
	public WebElement UploadLeaseAgreementMIDC_PDF()
	{
		return driver.findElement(LeaseAgreementMIDC);
	}
	
	public WebElement UploadBankDetails_PDF()
	{
		return driver.findElement(BankDetails);
	}
	
	public WebElement UploadLetterOfAuthorization_PDF()
	{
		return driver.findElement(LetterOfAuthorization);
	}
	
	public WebElement RemovePDFFile()
	{
		return driver.findElement(pdfremove);
	}
	
}
