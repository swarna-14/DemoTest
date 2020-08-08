package RegressionTest;

import java.awt.Image;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;


public class FuncTest {
	
	WebDriver driver;
	
	@Test
	public void landapply() throws InterruptedException, IOException, TesseractException {
		FileInputStream fis= new FileInputStream("D:\\eclipse\\AuricAutomationTest\\config.properties");	
		System.setProperty("webdriver.chrome.driver","D:/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20000, TimeUnit.SECONDS);
		Properties prop=new Properties();
		try {
	    	prop.load(fis);
	    	}
	    	catch(IOException e)

	    	{
	    		e.printStackTrace();
	    	}
		driver.get(prop.getProperty("url"));
		//add implicitly wait statement
		// Thread.sleep(5000);
		driver.findElement(By.xpath(prop.getProperty("existingUserButton"))).click();
		
		driver.findElement(By.xpath(prop.getProperty("xpathusername"))).sendKeys("AUR2002294");
		driver.findElement(By.xpath(prop.getProperty("xpathpassword"))).sendKeys("Admin@123");
		//Thread.sleep(2000);
//		File src = driver.findElement(By.xpath("//*[@id=\"captchaImage\"]")).getScreenshotAs(OutputType.FILE);
//		Thread.sleep(3000);
//		String path = System.getProperty("user.dir")+"\\screenshot\\ccha.png";
//		FileHandler.copy(src , new File (path));
//		ITesseract image = new Tesseract();
//		String imageText = image.doOCR(new File(path));
//		    
//		System.out.println(imageText);
		
		Thread.sleep(20000);
		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
		//driver.findElement(By.id("txtCaptcha")).sendKeys(imageText);
		
		//Thread.sleep(3000);
		driver.findElement(By.xpath("//span[@class='nav-label'][contains(text(),'Land Application')]")).click();
	// driver.findElement(By.xpath("//a[@class='btn btn2'][contains(text(),'Applicant')]")).click();	
	// driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
	
  //  WebElement wbsel = driver.findElement(By.xpath("//select[@id='selCountry']"));
	//create object of select class and pass the parameter wbsel 
	//Select sel=new Select(wbsel);
	//wait statements
	//Thread.sleep(1000);
	// .selectbyvisibleText() returns required date 
	// sel.selectByVisibleText("India");	
	
	WebDriverWait wait5 = new WebDriverWait(driver,80);
    WebElement element6 =  wait5.until(ExpectedConditions.elementToBeClickable(By.xpath("//select[@id='selCountry']")));
   // element5.click();
    Select sell=new Select(element6);
	//wait statements
	Thread.sleep(1000);
	// .selectbyvisibleText() returns required date 
	sell.selectByVisibleText("India");
	
	
	 WebElement wbsel1 = driver.findElement(By.xpath("//select[@id='selState']"));
	//create object of select class and pass the parameter wbsel 
	Select sel1=new Select(wbsel1);
	//wait statements
	Thread.sleep(1000); 
	sel1.selectByVisibleText("Maharashtra");
		
	WebElement wb1 = driver.findElement(By.xpath("//input[@id='txtDistrict']"));
	wb1.clear();
	wb1.sendKeys("Andheri");
	
	WebElement wb2 = driver.findElement(By.xpath("//input[@id='txtPin']"));
	wb2.clear();
	wb2.sendKeys("756432");	
		
	WebElement wbsel2 = driver.findElement(By.xpath("//select[@id='selSpecialCat']"));
	//create object of select class and pass the parameter wbsel 
	Select sel2=new Select(wbsel2);
	//wait statements
	Thread.sleep(1000); 
	sel2.selectByVisibleText("General");	
		
	WebElement wb3 = driver.findElement(By.xpath("//textarea[@id='txtAddress']"));
	wb3.clear();
	wb3.sendKeys("Maharashtra");
	
	
	driver.findElement(By.xpath("//a[contains(text(),'Bank Details (Entity')]")).click();
	
	
	WebElement wb4 = driver.findElement(By.xpath("//input[@id='txtBankName']"));	
	wb4.clear();
	wb4.sendKeys("SBI");
	
	WebElement wb5 = driver.findElement(By.xpath("//input[@id='txtBranchName']"));
	wb5.clear();
	wb5.sendKeys("Andheri");
	
	
	WebElement wb6 = driver.findElement(By.xpath("//input[@id='txtBankIfscCode']"));
	wb6.clear();
	wb6.sendKeys("SBIN0003089");
	
	WebElement wb7 = driver.findElement(By.xpath("//input[@id='txtAccNo']"));
	wb7.clear();
	wb7.sendKeys("2020452023456785");
		
    //driver.findElement(By.xpath("//input[@id='btnNext']")).click();
    
	WebDriverWait wait6 = new WebDriverWait(driver,80);
    WebElement element7 =  wait6.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btnNext")));
    element7.click();
	
    driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
    
    WebDriverWait wait1 = new WebDriverWait(driver,50);
    WebElement element1 =  wait1.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@id='selVentureType']")));
	
    // driver.findElement(By.xpath("//i[@class='fa pull-right fa-chevron-down']")).click();
     
    // WebElement wbsel3 = driver.findElement(By.xpath("//select[@id='selVentureType']"));
	//create object of select class and pass the parameter wbsel 
	Select sel3=new Select(element1);
	 //wait statements
    // Thread.sleep(1000);
	sel3.selectByVisibleText("Small Scale Industries(SSI)");	
		
	WebElement wbsel4 = driver.findElement(By.xpath("//select[@id='selIndustryType']"));
	//create object of select class and pass the parameter wbsel 
	Select sel4=new Select(wbsel4);
	//wait statements
	Thread.sleep(1000);
	sel4.selectByVisibleText("Automobile");	
		
	WebElement wbsel5 = driver.findElement(By.xpath("//select[@id='selSector1']"));
	//create object of select class and pass the parameter wbsel 
	Select sel5=new Select(wbsel5);
	//wait statements
	Thread.sleep(1000);
	sel5.selectByVisibleText("Sector - 5");		
	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
		
	WebElement wbsel6 = driver.findElement(By.xpath("//select[@id='selPlots1']"));
	//create object of select class and pass the parameter wbsel 
	Select sel6=new Select(wbsel6);
	//wait statements
	Thread.sleep(1000);
	sel6.selectByVisibleText("Plot - 18");		
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);	
	
	WebElement wb8 = driver.findElement(By.xpath("//input[@id='txtBuiltUpAr']"));
	wb8.clear();
	wb8.sendKeys("400");
	
	WebElement wb9 = driver.findElement(By.xpath("//input[@id='txtPlinthAr']"));
	wb9.clear();
	wb9.sendKeys("200");
	
	WebElement wb10 = driver.findElement(By.xpath("//input[@id='txtFactory']"));
	wb10.clear();
	wb10.sendKeys("100");
	
	driver.findElement(By.xpath("//div[@class='form-con indOptionsExt']//i[@class='fa fa-chevron-down pull-right']")).click();
	
	WebElement wbsel7 = driver.findElement(By.xpath("//select[@id='selConstType']"));
	//create object of select class and pass the parameter wbsel 
	Select sel7=new Select(wbsel7);
	//wait statements
	Thread.sleep(1000);
	sel7.selectByVisibleText("Banks");
	
	WebElement wbsel8 = driver.findElement(By.xpath("//select[@id='selCompCountry']"));
	//create object of select class and pass the parameter wbsel 
	Select sel8=new Select(wbsel8);
	//wait statements
	Thread.sleep(1000);
	sel8.selectByVisibleText("India");
	
	WebElement wbsel9 = driver.findElement(By.xpath("//select[@id='selCompState']"));
	//create object of select class and pass the parameter wbsel 
	Select sel9=new Select(wbsel9);
	//wait statements
	Thread.sleep(1000);
	sel9.selectByVisibleText("Maharashtra");
	
	WebElement wb11 = driver.findElement(By.xpath("//input[@id='txtCompCity']"));
	wb11.clear();
	wb11.sendKeys("Andheri");
	
	WebElement wb12 = driver.findElement(By.xpath("//input[@id='txtCompPin']"));
	wb12.clear();
	wb12.sendKeys("765435");
	
	WebElement wb13 = driver.findElement(By.xpath("//input[@id='txtCompPan']"));
	wb13.clear();
	wb13.sendKeys("GFHUU5632Q");
	
	WebElement wb14 = driver.findElement(By.xpath("//input[@id='txtGST']"));
	wb14.clear();
	wb14.sendKeys("22AAAAA0000A1Z5");
	
	// date of incorporation
	
	WebElement date =  driver.findElement(By.xpath("//input[@id='txtCompIncDate']"));
	date.click();
	
	driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='clear'][contains(text(),'Clear')]")).click();

	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
   	
	date.click();
	
	WebElement date1 =  driver.findElement(By.xpath("//td[@class='day'][contains(text(),'7')]"));
    date1.click();
    
    Thread.sleep(2000);
    
	driver.findElement(By.xpath("//a[contains(text(),'Project Details')]")).click();
	
	WebElement wbsel10 = driver.findElement(By.xpath("//select[@id='selProjectNature']"));
	//create object of select class and pass the parameter wbsel 
	Select sel10=new Select(wbsel10);
	//wait statements
	Thread.sleep(1000);
	sel10.selectByVisibleText("Export only");
	
	WebElement wbsel11 = driver.findElement(By.xpath("//select[@id='selActivityNature']"));
	//create object of select class and pass the parameter wbsel 
	Select sel11=new Select(wbsel11);
	//wait statements
	Thread.sleep(1000);
	sel11.selectByVisibleText("Workshop");
	
	WebElement wbsel12 = driver.findElement(By.xpath("//select[@id='selProductRange']"));
	//create object of select class and pass the parameter wbsel 
	Select sel12=new Select(wbsel12);
	//wait statements
	Thread.sleep(1000);
	sel12.selectByVisibleText("Core Product / Service");
	
	driver.findElement(By.xpath("//input[@id='proposedProduct1']")).sendKeys("Product 1");
	driver.findElement(By.xpath("//input[@id='prodCapacityYr1']")).sendKeys("1000 ton");
	driver.findElement(By.xpath("//input[@id='txtNoSkEmp']")).sendKeys("20");
	driver.findElement(By.xpath("//input[@id='txtNoUSkEmp']")).sendKeys("10");
	driver.findElement(By.xpath("//input[@id='txtNoSupEmp']")).sendKeys("10");
	
	driver.findElement(By.xpath("//a[contains(text(),'Details of Utilities Requirement')]")).click();
	
	driver.findElement(By.xpath("//input[@id='txtConPower']")).sendKeys("50");
	
	driver.findElement(By.xpath("//input[@id='txteffluent']")).sendKeys("100");
	driver.findElement(By.xpath("//input[@id='txtSolidWaste']")).sendKeys("40");
	driver.findElement(By.xpath("//input[@id='txtDomestic']")).sendKeys("50");
	driver.findElement(By.xpath("//input[@id='txtIndustrial']")).sendKeys("50");
	
	driver.findElement(By.xpath("//a[contains(text(),'Financial Details')]")).click();
	
	WebElement wb15 = driver.findElement(By.xpath("//input[@id='txtInvPlMach']"));
	wb15.clear();
	wb15.sendKeys("2100");
	
	WebElement wb16 = driver.findElement(By.xpath("//input[@id='txtInvBuild']"));
	wb16.clear();
	wb16.sendKeys("2000");
	
	driver.findElement(By.xpath("//a[contains(text(),'Financial Arrangements')]")).click();
	
	driver.findElement(By.xpath("//input[@id='txtSelf']")).sendKeys("100");
	
	driver.findElement(By.xpath("//a[contains(text(),'Experience In Industry')]")).click();
	
	WebElement wbsel13 = driver.findElement(By.xpath("//select[@id='selExpInd1']"));
	//create object of select class and pass the parameter wbsel 
	Select sel13=new Select(wbsel13);
	//wait statements
	Thread.sleep(1000);
	sel13.selectByVisibleText("New (0 - 2 years)");
	
	WebElement wbsel14 = driver.findElement(By.xpath("//select[@id='selExpInd2']"));
	//create object of select class and pass the parameter wbsel 
	Select sel14=new Select(wbsel14);
	//wait statements
	Thread.sleep(1000);
	sel14.selectByVisibleText("New (0 - 2 years)");
	
	driver.findElement(By.xpath("//a[contains(text(),'Other Operational Units in India')]")).click();
	
    driver.findElement(By.xpath("//div[@class='radio pull-left']//input[@name='opUnit']")).click();	
	
    /* driver.manage().timeouts().implicitlyWait(80,TimeUnit.SECONDS);
     driver.findElement(By.xpath("//input[@id='btnNext']")).click();
	*/
    
   /* WebDriverWait wait2 = new WebDriverWait(driver,80);
    WebElement element2 =  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[contains(@value, 'Save & Proceed')]")));
    element2.click();*/
    
    /*WebDriverWait wait2 = new WebDriverWait(driver,80);
    WebElement element2 =  wait2.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#btnNext")));
    element2.click();*/
    
    driver.findElement(By.cssSelector("#btnNext")).click();
    
    
    /*WebElement ele = driver.findElement(By.xpath("//input[@id='btnNext']"));
    JavascriptExecutor executor = (JavascriptExecutor)driver;
    executor.executeScript("arguments[0].click();", ele);*/
    
   /* WebDriverWait wait2 = new WebDriverWait(driver, 120);
    wait2.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='btnNext']"))).click();
    */
    
    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	WebElement uploadelement = driver.findElement(By.xpath("//input[@id='txtFile1_1']"));
	uploadelement.clear();
	uploadelement.sendKeys("C:\\Users\\Sukanya\\Desktop\\Images\\1401 - 4-signed.pdf");
    
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	WebElement uploadelement1 = driver.findElement(By.xpath("//input[@id='txtFile1_6']"));
	uploadelement1.clear();
	uploadelement1.sendKeys("C:\\Users\\Sukanya\\Desktop\\Images\\1401 - 5-signed-signed.pdf");
	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	WebElement uploadelement2 = driver.findElement(By.xpath("//input[@id='txtFile1_7']"));
	uploadelement2.clear();
	uploadelement2.sendKeys("C:\\Users\\Sukanya\\Desktop\\Images\\1401 - Copy (6)-signed.pdf");
	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	WebElement uploadelement3 = driver.findElement(By.xpath("//input[@id='txtFile1_20']"));
	uploadelement3.clear();
	uploadelement3.sendKeys("C:\\Users\\Sukanya\\Desktop\\Images\\1401 - Copy (8)-signed.pdf");
	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	WebElement uploadelement4 = driver.findElement(By.xpath("//input[@id='txtFile1_22']"));
	uploadelement4.clear();
	uploadelement4.sendKeys("C:\\Users\\Sukanya\\Desktop\\Images\\1401 - Copy (9)-signed.pdf");
	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	WebElement uploadelement5 = driver.findElement(By.xpath("//input[@id='txtFile1_23']"));
	uploadelement5.clear();
	uploadelement5.sendKeys("C:\\Users\\Sukanya\\Desktop\\Images\\1401 - 5-signed-signed-signed-signed.pdf");
	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	WebElement uploadelement6 = driver.findElement(By.xpath("//input[@id='txtFile1_24']"));
	uploadelement6.clear();
	uploadelement6.sendKeys("C:\\Users\\Sukanya\\Desktop\\Images\\1401 - Copy (4)-signed-signed-signed-signed-signed.pdf");
	
	driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	
	/*WebElement uploadelement7 = driver.findElement(By.xpath(""));
	uploadelement7.sendKeys("");
	
	WebElement uploadelement8 = driver.findElement(By.xpath(""));
	uploadelement8.sendKeys("");
	
	WebElement uploadelement9 = driver.findElement(By.xpath(""));
	uploadelement9.sendKeys("");
	
	WebElement uploadelement10 = driver.findElement(By.xpath(""));
	uploadelement10.sendKeys("");*/
	
	//Find element by link text and store in variable "Element"        		
  //  WebElement scdown = driver.findElement(By.xpath("//input[@class='btn btn-auric-blue btnWid100']"));
   // WebElement scdown = driver.findElement(By.xpath("//a[@class='btn btn-prev btnWid100']"));
    
  //  JavascriptExecutor js = (JavascriptExecutor) driver; 
    //This will scroll the page till the element is found    
   // js.executeScript("arguments[0].scrollIntoView();", scdown);
    
   // driver.manage().timeouts().implicitlyWait(120,TimeUnit.SECONDS);
	
   // scdown.submit();
	
    WebDriverWait wait2 = new WebDriverWait(driver,80);
    WebElement element2 =  wait2.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnNext']")));
    element2.click();
  
    WebDriverWait wait3 = new WebDriverWait(driver,80);
    WebElement element3 =  wait3.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@class='btn btn-primary auric-blue btnWid100']")));
    element3.click();
    
    WebDriverWait wait4 = new WebDriverWait(driver,80);
    WebElement element4 =  wait4.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='radPayOption2']")));
    element4.click();
    
    WebDriverWait wait9 = new WebDriverWait(driver,80);
    WebElement element5 =  wait9.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='btnPayment']")));
    element5.click();
    
    driver.findElement(By.xpath("//a[@id='btnConfirmPayment']")).click();
	
    driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
    
    WebElement wb18 = driver.findElement(By.xpath("//input[@id='ccard_number']"));
    wb18.clear();
    wb18.sendKeys("5123456789012346");
	
    WebElement wb19 = driver.findElement(By.xpath("//input[@id='cname_on_card']"));
    wb19.clear();
    wb19.sendKeys("ria");
	
    WebElement wb20 = driver.findElement(By.xpath("//input[@id='ccvv_number']"));
    wb20.clear();
    wb20.sendKeys("123");
	
    WebElement wbsel15 = driver.findElement(By.xpath("//select[@id='cexpiry_date_month']"));
	//create object of select class and pass the parameter wbsel 
	Select sel15=new Select(wbsel15);
	//wait statements
	Thread.sleep(1000);
	sel15.selectByVisibleText("May (5)");
	
	/*WebElement wbsel16 = driver.findElement(By.xpath("//select[@id='cexpiry_date_year']"));
	//create object of select class and pass the parameter wbsel 
	Select sel16=new Select(wbsel16);
	//wait statements
	Thread.sleep(1000);
	sel16.selectByVisibleText("													2020												");
	*/
	 WebDriverWait wait10 = new WebDriverWait(driver,80);
	 WebElement element10 =  wait10.until(ExpectedConditions.elementToBeClickable(By.cssSelector("#cexpiry_date_year")));
	 Select sel16=new Select(element10);
	 //wait statements
	 Thread.sleep(1000);
	 sel16.selectByVisibleText("2020");
		
	
//	 driver.findElement(By.xpath("//div[@id='credit']//input[@id='pay_button']")).click();
	
	

}

}
