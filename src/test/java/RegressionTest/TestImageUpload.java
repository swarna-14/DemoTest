package RegressionTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import ObjectRepository.Login;
import ObjectRepository.SetUPDriver;
import ObjectRepository.UploadImage;

public class TestImageUpload extends SetUPDriver{

	
	SetUPDriver st = new SetUPDriver();
	
	
	@Test(priority=0)
	public void setUp() throws InterruptedException {
			
		st.getDriver();
		Thread.sleep(3000);
		
	
	}
	
	@Test(priority=1)
	public void login() throws InterruptedException {
		Login ln = new Login(driver);
		ln.SelectUserName().sendKeys("AUR2002294");
		ln.SelectPassWord().sendKeys("Admin@123");
		Thread.sleep(20000);
		ln.ClickLoginButton().click();
		ln.ApplyLandApplication().click();
		ln.SaveANDProceed().click();
		Thread.sleep(4000);
		ln.SaveANDProceed1().click();
	}
	
	@Test(priority=2)
	public void UploadPDF() throws InterruptedException {
		
		UploadImage ui = new UploadImage(driver);
		
		ui.UploadDPR_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		//ui.RemovePDFFile().click();
		ui.UploadPAN_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadDulynotarized_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadCopyOfConstitution_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadPowerOfAttorney_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadCopyOfBoardResolution_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadAuthorizedSignatories_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadBalanceSheetSignatories_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadLeaseAgreementMIDC_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadBankDetails_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		ui.UploadLetterOfAuthorization_PDF().sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		Thread.sleep(3000);
		
		
	}
}
