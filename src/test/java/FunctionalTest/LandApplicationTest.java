package FunctionalTest;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.ui.Select;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.lowagie.text.Image;

import ObjectRepository.Login;
import ObjectRepository.PreviewRepo;
import ObjectRepository.ProfileBuilder;
import ObjectRepository.SetUPDriver;
import ObjectRepository.UploadImage;
import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;

public class LandApplicationTest extends SetUPDriver {

	//WebDriver driver; 
	
	SetUPDriver st = new SetUPDriver();
	
	
	
	UploadImage ui = new UploadImage(driver);
	
	ProfileBuilder pbuilder = new ProfileBuilder(driver);
	
	PreviewRepo pr = new PreviewRepo(driver);
	
	
	public ExtentHtmlReporter htmlReporter;
	ExtentReports extent;
    public ExtentTest test;
	
	 @BeforeTest
		public void SetupReport() throws IOException
		{
	    	htmlReporter = new ExtentHtmlReporter(System.getProperty("user.dir") + "/AuricExtentReport/Verification-Report.html");

			htmlReporter.config().setDocumentTitle("Auric Automation"); 
			htmlReporter.config().setReportName("Functional Test"); 
			
			  
			extent = new ExtentReports();
			extent.attachReporter(htmlReporter);
			
			extent.setSystemInfo("Environment", "Test");
		}
	
	 @AfterTest
	 public void  finishSetup()
	 {
		extent.flush();
		driver.quit(); 

	 }
	@Test(priority=0)
	public void setUp() throws InterruptedException, IOException, TesseractException{
		
	//	extent.createTest("setUp");
		st.getDriver();
		FileInputStream fis= new FileInputStream("D:\\eclipse\\AuricAutomationTest\\config.properties");	
		
		Properties prop=new Properties();
		try {
	    	prop.load(fis);
	    	}
	    	catch(IOException e)

	    	{
	    		e.printStackTrace();
	    	}
		Login ln = new Login(driver);
		
		ln.SelectUserName().sendKeys(prop.getProperty("UserName"));
		ln.SelectPassWord().sendKeys(prop.getProperty("Password"));
		Thread.sleep(20000);
		
		
//	
//		File src = driver.findElement(By.xpath("//*[@id=\"frmLogin\"]/div[2]/div/div/div[4]")).getScreenshotAs(OutputType.FILE);
//		String path = System.getProperty("user.dir")+"/test-output/ccha.png";
//		try {
//		FileHandler.copy(src , new File (path));
//		
//		ITesseract image = new Tesseract();
//		
//		String imageText;
//		
//		imageText = image.doOCR(new File(path));
//	
//		System.out.println(imageText);	
//		ln.WriteCaptcha().sendKeys(imageText);
// 	    Thread.sleep(3000);
//		driver.findElement(By.xpath("//input[@id='btnLogin']")).click();
//		} catch (NoSuchElementException e) {
//			// TODO Auto-generated catch block
//			//System.out.println(e.getMessage());
//		}
		
		ln.ClickLoginButton().click();
		Thread.sleep(3000);
	}
	
	
	
	/*  Profile Builder- Auto Filled Check after login with valid user credentials*/
	@Test(priority=1)
	public void autoFilledCheckName() throws InterruptedException {
		Login ln = new Login(driver);
		//extent.createTest("autoFilledCheckName");
		ln.ApplyLandApplication().click();
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,200)");
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(3000);
		//String actText = driver.findElement(By.id("txtName")).getText();
		String actText = pbuilder.SelectApplicantName().getText();
		SoftAssert softAssert = new SoftAssert();
		softAssert.assertEquals(actText, "Satyaranjan Mohapatra", "Test case Failed"); 
		
		
		
	}
	
	
	@Test(priority=2)
	public void autoFilledCheckMnumber() {
		
		//extent.createTest("autoFilledCheckMnumber");
		//String actText1 = driver.findElement(By.id("txtMobNo")).getText();
		String actText1 = pbuilder.SelectMobileNo().getText();
		SoftAssert softAssert1 = new SoftAssert();
		softAssert1.assertEquals(actText1, "9248028902", "Test case Failed"); 
		
	}
	
	
	@Test(priority=3)
	public void autoFilledCheckEmail() {
		
		extent.createTest("autoFilledCheckEmail");
		//String actText2 = driver.findElement(By.id("txtEmail")).getText();
		String actText2 = pbuilder.SelectEmail().getText();
		SoftAssert softAssert2 = new SoftAssert();
		softAssert2.assertEquals(actText2, "9248028902", "Test case Failed"); 
		
	}
	
	
	@Test(priority=4)
	public void autoFilledCheckCountry() {
		
		extent.createTest("autoFilledCheckCountry");
		//String actText3 = driver.findElement(By.id("selCountry")).getText();
		String actText3 = pbuilder.SelectCountry().getText();
		SoftAssert softAssert3 = new SoftAssert();
		softAssert3.assertEquals(actText3, "India", "Test case Failed"); 	
		
	}
	
	
	@Test(priority=5)
	public void autoFilledCheckState() {
		
		extent.createTest("autoFilledCheckState");
		//String actText4 = driver.findElement(By.id("selState")).getText();
		String actText4 = pbuilder.SelectState().getText();
		SoftAssert softAssert4 = new SoftAssert();
		softAssert4.assertEquals(actText4, "Maharashtra", "Test case Failed"); 	
		
	}
	
	@Test(priority=6)
	public void autoFilledCheckCity() {
		
		extent.createTest("autoFilledCheckCity");
		//String actText5 = driver.findElement(By.id("txtDistrict")).getText();
		String actText5 = pbuilder.SelectDistrict().getText();
		SoftAssert softAssert5 = new SoftAssert();
		softAssert5.assertEquals(actText5, "Maharashtra", "Test case Failed"); 	
		
	}
	
	
	@Test(priority=7)
	public void autoFilledCheckPin() {
		
		extent.createTest("autoFilledCheckPin");
		//String actText6 = driver.findElement(By.id("txtPin")).getText();
		String actText6 = pbuilder.SelectPin().getText();
		SoftAssert softAssert6 = new SoftAssert();
		softAssert6.assertEquals(actText6, "756432", "Test case Failed"); 	
		
	}
	
	
	@Test(priority=8)
	public void autoFilledCheckCat() {
		
		extent.createTest("autoFilledCheckCat");
		//String actText7 = driver.findElement(By.id("selSpecialCat")).getText();
		String actText7 = pbuilder.SelectSpecialCategory().getText();
		SoftAssert softAssert7 = new SoftAssert();
		softAssert7.assertEquals(actText7, "General", "Test case Failed"); 	
		
	}
	
	
	@Test(priority=9)
	public void autoFilledAddress() {
		
		extent.createTest("autoFilledAddress");
		//String actText8 = driver.findElement(By.id("txtAddress")).getText();
		String actText8 = pbuilder.SelectAdress().getText();
		SoftAssert softAssert8 = new SoftAssert();
		softAssert8.assertEquals(actText8, "Maharashtra" , "Test case Failed"); 	
		
		driver.findElement(By.xpath("//*[@id=\"rightCon\"]/div[1]/div[3]/div[1]/a")).click();
	}
	
	
	@Test(priority=10)
	public void autoFilledBName() {
		
		extent.createTest("autoFilledBName");
		//String actText9 = driver.findElement(By.id("txtBankName")).getText();
		String actText9 = pbuilder.SelectBankName().getText();
		SoftAssert softAssert9 = new SoftAssert();
		softAssert9.assertEquals(actText9, "SBI" , "Test case Failed"); 	
		
	
	}
	
	
	@Test(priority=11)
	public void autoFilledBranch() {
		
		extent.createTest("autoFilledBranch");
		//String actText10 = driver.findElement(By.id("txtBranchName")).getText();
		String actText10 = pbuilder.SelectBranchName().getText();
		SoftAssert softAssert10 = new SoftAssert();
		softAssert10.assertEquals(actText10, "Andheri" , "Test case Failed"); 	
		
		
	}
	
	
	@Test(priority=12)
	public void autoFilledifsc() {
		
		extent.createTest("autoFilledifsc");
		//String actText11 = driver.findElement(By.id("txtBankIfscCode")).getText();
		String actText11 = pbuilder.SelectIfscCode().getText();
		SoftAssert softAssert11 = new SoftAssert();
		softAssert11.assertEquals(actText11, "Andheri" , "Test case Failed"); 	
		
	}
	
	
	@Test(priority=13)
	public void autoFilledaccountNum() {
		
		extent.createTest("autoFilledaccountNum");
		//String actText12 = driver.findElement(By.id("txtAccNo")).getText();
		String actText12 = pbuilder.SelectAccounNo().getText();
		SoftAssert softAssert12 = new SoftAssert();
		softAssert12.assertEquals(actText12, "Andheri" , "Test case Failed"); 	
		
	}
	
	
	
	
	
	/* Land Application-  Verify with both valid and invalid data*/
	@Test(priority=14)
	public void plotSizeInvalid() throws InterruptedException {
		
		extent.createTest("plotSizeInvalid");
		
		driver.findElement(By.id("btnNext")).click();
		driver.findElement(By.id("selInArea")).sendKeys("AURIC Shendra");
		Thread.sleep(3000);
		driver.findElement(By.id("selCatProp")).sendKeys("Industrial");
		Thread.sleep(3000);
		driver.findElement(By.id("selSubCatType")).sendKeys("Industrial");
		Thread.sleep(3000);
		driver.findElement(By.id("selVentureType")).sendKeys("FDI");
		Thread.sleep(3000);
		driver.findElement(By.id("selIndustryType")).sendKeys("Automobile");
		Thread.sleep(3000);
		driver.findElement(By.id("selPropType")).sendKeys("Plot");
//		driver.findElement(By.id("txtReqPlSz")).sendKeys("0");
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(3000);
		String actMessage = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		System.out.println(actMessage);
		SoftAssert softAssert13 = new SoftAssert();
		softAssert13.assertEquals(actMessage, "Required plot size must be greater than 0" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
	}
	
	
	@Test(priority=15)
	public void builtupAreaInvalid() throws InterruptedException {
		
		extent.createTest("builtupAreaInvalid");
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(700,0)");
		driver.findElement(By.id("txtReqPlSz")).clear();
		
		driver.findElement(By.id("txtReqPlSz")).sendKeys("10");
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(3000);
		String actMessage1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		System.out.println(actMessage1);
		SoftAssert softAssert14 = new SoftAssert();
		softAssert14.assertEquals(actMessage1, "Built-up area must be greater than 0" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
	}
	
	@Test(priority=16)
	public void plinthAreaInvalid() throws InterruptedException {
		
		extent.createTest("plinthAreaInvalid");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(700,0)");
		driver.findElement(By.id("txtBuiltUpAr")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("txtBuiltUpAr")).sendKeys("10");
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(3000);
		String actMessage2 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		System.out.println(actMessage2);
		SoftAssert softAssert15 = new SoftAssert();
		softAssert15.assertEquals(actMessage2, "Built-up area must be less than required plot size" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
	}
	
	
	@Test(priority=17)
	public void FPWSAreaInvalid() throws InterruptedException {
		
		extent.createTest("FPWSAreaInvalid");
//		JavascriptExecutor js = (JavascriptExecutor) driver;
//		js.executeScript("window.scrollBy(700,0)");
		driver.findElement(By.id("txtPlinthAr")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("txtPlinthAr")).sendKeys("10");
		Thread.sleep(3000);
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,700)");
		driver.findElement(By.id("btnNext")).click();
		Thread.sleep(3000);
		String actMessage2 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		System.out.println(actMessage2);
		SoftAssert softAssert16 = new SoftAssert();
		softAssert16.assertEquals(actMessage2, "Factory / plant / workshop area should be greater than 0" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		driver.findElement(By.id("txtFactory")).clear();
		Thread.sleep(3000);
		driver.findElement(By.id("txtFactory")).sendKeys("10");
		
		driver.findElement(By.xpath("//*[@id=\"rightCon\"]/div[1]/div[3]/div[1]/a")).click();
		Thread.sleep(3000);
		driver.findElement(By.id("txtEntityName")).clear();
		driver.findElement(By.id("txtEntityName")).sendKeys("eLMS Test");
		//driver.findElement(By.id("selConstType")).sendKeys("Banks");
		Select sel = new Select(driver.findElement(By.id("selConstType")));
		sel.selectByVisibleText("Banks");
		Thread.sleep(3000);
		driver.findElement(By.id("selCompCountry")).sendKeys("Afghanistan");
		Thread.sleep(2000);
		driver.findElement(By.id("txtOtherState")).sendKeys("Afghan");
		
		driver.findElement(By.id("txtCompCity")).sendKeys("Afghani");
		
		driver.findElement(By.id("txtCompPin")).sendKeys("879874");
		
		driver.findElement(By.id("txtCompPan")).sendKeys("EBBD217327");
		
		driver.findElement(By.id("txtGST")).sendKeys("fert546");
		
		driver.findElement(By.id("txtCompIncDate")).click();
		
		
		driver.findElement(By.xpath("//div[@class='datepicker-days']//th[@class='clear'][contains(text(),'Clear')]")).click();

		driver.manage().timeouts().implicitlyWait(50,TimeUnit.SECONDS);
	   	
		driver.findElement(By.id("txtCompIncDate")).click();
		
	    driver.findElement(By.xpath("//td[@class='day'][contains(text(),'1')]")).click();
	    
	    
	    Thread.sleep(2000);
		
		
		driver.findElement(By.xpath("//*[@id=\"rightCon\"]/div[1]/div[4]/div[1]/a")).click();
		
		driver.findElement(By.id("selProjectNature")).sendKeys("Domestic only");
		
		driver.findElement(By.id("selActivityNature")).sendKeys("Manufacturing");
		
		driver.findElement(By.id("selProductRange")).sendKeys("Core Product + Usable By-product");
				
		driver.findElement(By.id("proposedProduct1")).sendKeys("Test Manufacturing");
		
		driver.findElement(By.id("prodCapacityYr1")).sendKeys("100 ton");
		
	}
	
	
	
	@Test(priority=18)
	public void projectTotalEMPVerification() throws InterruptedException {
		
		extent.createTest("projectTotalEMPVerification");
		
		driver.findElement(By.id("txtNoSkEmp")).sendKeys("33");
		
		driver.findElement(By.id("txtNoUSkEmp")).sendKeys("33");
		
		driver.findElement(By.id("txtNoSupEmp")).sendKeys("33");
		
		String actTotalNUM = driver.findElement(By.id("txtTotalEmp")).getText();
		
		System.out.println(actTotalNUM);
		
		SoftAssert softAssert17 = new SoftAssert();
		
		softAssert17.assertEquals(actTotalNUM, "99" , "Test case Failed");
		
	}
	
	
	
	@Test(priority=19)
	public void RequirementPowerInvalid() throws InterruptedException {
		
		extent.createTest("RequirementPowerInvalid");
		
		driver.findElement(By.xpath("//a[contains(text(),'Details of Utilities Requirement')]")).click();
		
		driver.findElement(By.id("btnNext")).click();
		
		Thread.sleep(3000);
		
		String actMessage18 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		
		System.out.println(actMessage18);
		
		SoftAssert softAssert18 = new SoftAssert();
		
		softAssert18.assertEquals(actMessage18, "Required power cannot be left blank" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtConPower']")).clear();
		driver.findElement(By.xpath("//input[@id='txtConPower']")).sendKeys("50");
	    }
		
		@Test(priority=20)
		public void EstimatedeffluentInvalid() throws InterruptedException
		
		{
			
		extent.createTest("EstimatedeffluentInvalid");
		driver.findElement(By.id("btnNext")).click();
		
		Thread.sleep(3000);
		
		String actMessage19 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		
		System.out.println(actMessage19);
		
		SoftAssert softAssert19 = new SoftAssert();
		
		softAssert19.assertEquals(actMessage19, "Estimated effluent generation cannot be left blank" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txteffluent']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txteffluent']")).sendKeys("100");
	
		}
		
		
		@Test(priority=21)
		public void EstimatedsolidwasteInvalid() throws InterruptedException
		
		{
		extent.createTest("EstimatedsolidwasteInvalid");
        driver.findElement(By.id("btnNext")).click();
		
     	Thread.sleep(3000);
		
		String actMessage20 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		
		System.out.println(actMessage20);
		
		SoftAssert softAssert20 = new SoftAssert();
		
		softAssert20.assertEquals(actMessage20, "Estimated solid waste generation cannot be left blank" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtSolidWaste']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtSolidWaste']")).sendKeys("40");
        
			
		}
		
		@Test(priority=22)
		public void DomesticwaterInvalid() throws InterruptedException
		
		{
			
		extent.createTest("DomesticwaterInvalid");
		driver.findElement(By.id("btnNext")).click();
		
		Thread.sleep(3000);
		
		String actMessage21 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		
		System.out.println(actMessage21);
		
		SoftAssert softAssert21 = new SoftAssert();
		
		softAssert21.assertEquals(actMessage21, "Domestic water demand (MLD) cannot be left blank" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtDomestic']")).clear();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@id='txtDomestic']")).sendKeys("50");
		
		}
		
		@Test(priority=23)
		public void IndustrialwaterInvalid() throws InterruptedException
		
		{
			
		extent.createTest("IndustrialwaterInvalid");
        driver.findElement(By.id("btnNext")).click();
		
		Thread.sleep(3000);
		
		String actMessage22 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		
		System.out.println(actMessage22);
		
		SoftAssert softAssert22 = new SoftAssert();
		
		softAssert22.assertEquals(actMessage22, "Industrial water demand (MLD) cannot be left blanks" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='txtIndustrial']")).clear();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//input[@id='txtIndustrial']")).sendKeys("50");
		
		Thread.sleep(3000);
			
	}
	
	
		@Test(priority=24)
		public void FinancialDetailsInvalid() throws InterruptedException 
		{
		
			extent.createTest("FinancialDetailsInvalid");
		    driver.findElement(By.xpath("//a[contains(text(),'Financial Details')]")).click();
		    
		    Thread.sleep(2000);
			
			 driver.findElement(By.id("btnNext")).click();
				
			 Thread.sleep(3000);
				
			 String actMessage23 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
				
			 System.out.println(actMessage23);
				
			 SoftAssert softAssert23 = new SoftAssert();
				
			 softAssert23.assertEquals(actMessage23, "Either Investment in Machinery or Investment in building must be greater than 0" , "Test case Failed");
				
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);	
			
		    driver.findElement(By.xpath("//input[@id='txtInvPlMach']")).clear();
		    
		    Thread.sleep(3000);
		    
		    driver.findElement(By.xpath("//input[@id='txtInvPlMach']")).sendKeys("2100");
		    
		    Thread.sleep(2000);
		    
		   
		    
		}
		
		
		
		@Test(priority=25)
		public void InvestmentinBuildingInvalid() throws InterruptedException 
		{
		
			extent.createTest("InvestmentinBuildingInvalid");
			driver.findElement(By.id("btnNext")).click();
				
			Thread.sleep(3000);
		    
			String actMessage24 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
				
			System.out.println(actMessage24);
				
			SoftAssert softAssert24 = new SoftAssert();
				
			softAssert24.assertEquals(actMessage24, "Investment in building cannot be left blank" , "Test case Failed");
				
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(4000);
			
			driver.findElement(By.xpath("//input[@id='txtInvBuild']")).clear();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@id='txtInvBuild']")).sendKeys("2000");
			
			Thread.sleep(3000);
			

		}
		
		@Test(priority=26)
		public void FinancialArrangementInvalid() throws InterruptedException 
		{
	
			extent.createTest("FinancialArrangementInvalid");
            driver.findElement(By.id("btnNext")).click();
			
			Thread.sleep(3000);
				
			String actMessage25 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
				
			System.out.println(actMessage25);
				
			SoftAssert softAssert25 = new SoftAssert();
				
			softAssert25.assertEquals(actMessage25, "Financial arrangements must be equal to 100%" , "Test case Failed");
				
			driver.findElement(By.id("btnAlertOk")).click();
		    driver.findElement(By.xpath("//a[contains(text(),'Financial Arrangements')]")).click();
		
		    
		    driver.findElement(By.xpath("//input[@id='txtSelf']")).sendKeys("100");
		    Thread.sleep(3000);
		}
		
		
		@Test(priority=27)
		public void ExperienceInIndustryValidity() throws InterruptedException
		{
		
		extent.createTest("ExperienceInIndustryValidity");
		driver.findElement(By.id("btnNext")).click();
		
		Thread.sleep(3000);
		
		String actMessage26 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
			
		System.out.println(actMessage26);
			
		SoftAssert softAssert26 = new SoftAssert();
			
		softAssert26.assertEquals(actMessage26, "Entity level experience in the industry cannot be left blank" , "Test case Failed");
			
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
		
		driver.findElement(By.xpath("//a[contains(text(),'Experience In Industry')]")).click();
		
		WebElement wbsel13 = driver.findElement(By.xpath("//select[@id='selExpInd1']"));
		
		Select sel13 = new Select(wbsel13);
		
		Thread.sleep(1000);
		
		sel13.selectByVisibleText("New (0 - 2 years)");
		
		Thread.sleep(2000);
		
		}	
		
		@Test(priority=28)
		public void promoterexperience () throws InterruptedException 
		{
			
		extent.createTest("autoFilledCheckEmail");
        driver.findElement(By.id("btnNext")).click();
		
		Thread.sleep(3000);
		
		String actMessage27 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
			
		System.out.println(actMessage27);
			
		SoftAssert softAssert27 = new SoftAssert();
			
		softAssert27.assertEquals(actMessage27, "Promoter's experience in the industry cannot be left blank" , "Test case Failed");
			
		driver.findElement(By.id("btnAlertOk")).click();
		
		WebElement wbsel14 = driver.findElement(By.id("selExpInd2"));
		
		Select sel14=new Select(wbsel14);
		
		Thread.sleep(1000);
		
		sel14.selectByVisibleText("New (0 - 2 years)");
		
		Thread.sleep(2000);
		}
		
		
		@Test(priority=29)
		public void OtherOperationalUnitsinIndiavalidity() throws InterruptedException
		{
			
			extent.createTest("OtherOperationalUnitsinIndiavalidity");
			driver.findElement(By.xpath("//*[@id=\"rightCon\"]/div[1]/div[9]/div[1]/a")).click();
			
			driver.findElement(By.id("btnNext")).click();
			
			Thread.sleep(3000);
			
			String actMessage28 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
				
			System.out.println(actMessage28);
				
			SoftAssert softAssert28 = new SoftAssert();
				
			softAssert28.assertEquals(actMessage28, "Do you have any other existing unit in operations" , "Test case Failed");
				
			driver.findElement(By.id("btnAlertOk")).click();
			
			//driver.findElement(By.xpath("//div[@class='radio pull-left']//input[@name='opUnit']")).clear();
			
			Thread.sleep(2000);
			
		    driver.findElement(By.name("opUnit")).click();	
		    
		    Thread.sleep(2000);
		    
		    driver.findElement(By.id("btnNext")).click();
		    
		    Thread.sleep(4000);
		    
		  //  driver.quit();
		}
		
		//DPR (Detailed Project Report)
		/*  Mandatory Document Upload  */
		
		@Test(priority=30)
		public void DetailedProjectReportBlank() throws InterruptedException
		{
			
			extent.createTest("DetailedProjectReportBlank");
            driver.findElement(By.id("btnNext")).click();
			
			Thread.sleep(3000);
			
			String actMessage29 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
				
			System.out.println(actMessage29);
				
			SoftAssert softAssert29 = new SoftAssert();
				
			softAssert29.assertEquals(actMessage29, "DPR (Detailed Project Report) cannot be left blank" , "Test case Failed");
				
			driver.findElement(By.id("btnAlertOk")).click();
		}
			
			@Test(priority=31)
			public void DetailedProjectReportValid() throws InterruptedException {
			
			extent.createTest("DetailedProjectReportValid");
			//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
			
			driver.findElement(By.xpath("//input[@id='txtFile1_1']")).sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
			
			
			driver.findElement(By.id("btnNext")).click();
			
			String actText = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText, "PAN of Established Banks cannot be left blank" , "Test case Failed");
			
			driver.findElement(By.id("clearDocs1")).click();
			
			
			
			Thread.sleep(3000);
		}
			
			@Test(priority=32)
			public void DetailedProjectReportExcelFile() throws InterruptedException {
			
			extent.createTest("DetailedProjectReportExcelFile");
			//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
			
			driver.findElement(By.xpath("//input[@id='txtFile1_1']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file_example_XLS_10.xls");
			
			Thread.sleep(3000);
			//driver.findElement(By.id("btnNext")).click();
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
		}	
			
			@Test(priority=33)
			public void DetailedProjectReportTxtFile() throws InterruptedException {
			
			extent.createTest("DetailedProjectReportTxtFile");
			//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
			
			driver.findElement(By.xpath("//input[@id='txtFile1_1']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file-sample_1MB.doc");
			
			Thread.sleep(3000);
			//driver.findElement(By.id("btnNext")).click();
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
		}	
			
			
			@Test(priority=34)
			public void DetailedProjectReportDocFile() throws InterruptedException {
			
			extent.createTest("DetailedProjectReportDocFile");
			//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
			
			driver.findElement(By.xpath("//input[@id='txtFile1_1']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file-sample_1MB.doc");
			
			Thread.sleep(3000);
			//driver.findElement(By.id("btnNext")).click();
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
		}	
			
			@Test(priority=35)
			public void DetailedProjectReportMP4File() throws InterruptedException {
			
			extent.createTest("DetailedProjectReportMP4File");
			//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
			
			driver.findElement(By.xpath("//input[@id='txtFile1_1']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file_example_MP4_1280_10MG.mp4");
			
			Thread.sleep(3000);
			//driver.findElement(By.id("btnNext")).click();
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
		}	
		
			@Test(priority=36)
			public void DetailedProjectReportImageFile() throws InterruptedException {
			
			extent.createTest("DetailedProjectReportImageFile");
			//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
			
			driver.findElement(By.xpath("//input[@id='txtFile1_1']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\dummypic.jpg.png");
			
			Thread.sleep(3000);
			//driver.findElement(By.id("btnNext")).click();
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
			
			driver.findElement(By.xpath("//input[@id='txtFile1_1']")).sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
			
			Thread.sleep(3000);
		
		//PAN of Established Banks
		/*  Mandatory Document Upload  */	
			
		}	
			
		@Test(priority=37)
		public void PANofEstablishedBanks() throws InterruptedException
		{
			extent.createTest("PANofEstablishedBanks");
			//driver.findElement(By.xpath("//input[@id='txtFile1_6']")).clear();
			driver.findElement(By.xpath("//input[@id='txtFile1_6']")).sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		    Thread.sleep(3000);
		    
		    driver.findElement(By.id("btnNext")).click();
		    
		    String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Duly notarized undertaking stating to fulfill the use of water, pollution control measures, construction of BUA, employment generation, proposed timelines for commencement of production, etc. as mentioned in application/ DPR cannot be left blank" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=38)
		public void PANofEstablishedBanksExcelFile() throws InterruptedException {
		
		extent.createTest("PANofEstablishedBanksExcelFile");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_6']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file_example_XLS_10.xls");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
	}	
		
		@Test(priority=39)
		public void PANofEstablishedBanksTxtFile() throws InterruptedException {
		
		extent.createTest("PANofEstablishedBanksTxtFile");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_6']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file-sample_1MB.doc");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
	}	
		
		
		@Test(priority=40)
		public void PANofEstablishedBanksDocFile() throws InterruptedException {
		
		extent.createTest("PANofEstablishedBanksDocFile");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_6']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file-sample_1MB.doc");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
	}	
		
		@Test(priority=41)
		public void PANofEstablishedBanksMP4File() throws InterruptedException {
		
		extent.createTest("PANofEstablishedBanksMP4File");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_6']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file_example_MP4_1280_10MG.mp4");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
	}	
	
		@Test(priority=42)
		public void PANofEstablishedBanksImageFile() throws InterruptedException {
		
		extent.createTest("PANofEstablishedBanksImageFile");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_6']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\dummypic.jpg.png");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
		
		}
		
		
		
		
		//Duly notarized undertaking stating to fulfill the use of water, pollution control measures, construction of BUA, employment generation, proposed timelines for commencement of production, etc. as mentioned in application/ DPR
		                                           /*  Mandatory Document Upload  */	
		
		
		@Test(priority=43)
		public void dulyNotarizedUndertaking() throws InterruptedException
		{
			extent.createTest("dulyNotarizedUndertaking");
			//driver.findElement(By.xpath("//input[@id='txtFile1_6']")).clear();
			driver.findElement(By.xpath("//input[@id='txtFile1_7']")).sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
		    Thread.sleep(3000);
		    
		    driver.findElement(By.id("btnNext")).click();
		    
		    String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Copy of the constitution/registration cannot be left blank" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
			
		}
		
		
		
		                                                /*  Invalid Files  */
		
		@Test(priority=44)
		public void dulyNotarizedUndertakingExcelFile() throws InterruptedException {
		
		extent.createTest("dulyNotarizedUndertakingExcelFile");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_7']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file_example_XLS_10.xls");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
		}	
		
		
		
		@Test(priority=45)
		public void dulyNotarizedUndertakingTxtFile() throws InterruptedException {
		
		extent.createTest("dulyNotarizedUndertakingTxtFile");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_7']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file-sample_1MB.doc");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
		}	
		
		
		
		@Test(priority=46)
		public void dulyNotarizedUndertakingDocFile() throws InterruptedException {
		
		extent.createTest("dulyNotarizedUndertakingDocFile");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_7']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file-sample_1MB.doc");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
		}	
		
		
		@Test(priority=47)
		public void dulyNotarizedUndertakinMP4File() throws InterruptedException {
		
		extent.createTest("dulyNotarizedUndertakinMP4File");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_7']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\file_example_MP4_1280_10MG.mp4");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
		}	
		
		
		
		@Test(priority=48)
		public void dulyNotarizedUndertakinImageFile() throws InterruptedException {
		
		extent.createTest("dulyNotarizedUndertakinImageFile");
		//driver.findElement(By.xpath("//input[@id='txtFile1_1']")).clear();
		
		driver.findElement(By.xpath("//input[@id='txtFile1_7']")).sendKeys("C:\\Users\\SAI SWARAJ\\Desktop\\New folder (2)\\dummypic.jpg.png");
		
		Thread.sleep(3000);
		//driver.findElement(By.id("btnNext")).click();
		
		String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
	    System.out.println(actText1);
		
		SoftAssert softAssert29 = new SoftAssert();
		
		softAssert29.assertEquals(actText1, "Invalid file format. Upload (.PDF) file only" , "Test case Failed");
		
		driver.findElement(By.id("btnAlertOk")).click();
		
		Thread.sleep(3000);
		
		}
		
		
		
		
		//Copy of the constitution registration
        /*  Mandatory Document Upload  */
		
		@Test(priority=49)
		public void Copyoftheconstitutionregistration() throws InterruptedException
		{
			
			extent.createTest("Copyoftheconstitutionregistration");
			driver.findElement(By.xpath("//input[@id='txtFile1_20']")).sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("btnNext")).click();
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "An officially valid document in respect of the person holding a power of attorney to transact on its behalf cannot be left blank" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
		}
		
		
		
		@Test(priority=50)
		public void powerofattorney() throws InterruptedException
		{
			
			extent.createTest("powerofattorney");
			driver.findElement(By.xpath("//input[@id='txtFile1_22']")).sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
			Thread.sleep(3000);
			
			driver.findElement(By.id("btnNext")).click();
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Copy of the Board Resolution for investment cannot be left blank" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
		}
		
		@Test(priority=51)
		public void BoardResolution() throws InterruptedException
		{
			
			extent.createTest("BoardResolution");
			//driver.findElement(By.xpath("//input[@id='txtFile1_23']")).clear();
			driver.findElement(By.xpath("//input[@id='txtFile1_23']")).sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("btnNext")).click();
			
			Thread.sleep(3000);
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Authorized signatories list with specimen signatures cannot be left blank" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
			
		}
		
		@Test(priority=52)
		public void Authorizedsignatorieslist() throws InterruptedException
		{
			
			extent.createTest("Authorizedsignatorieslist");
			//driver.findElement(By.xpath("//input[@id='txtFile1_24']")).clear();
			driver.findElement(By.xpath("//input[@id='txtFile1_24']")).sendKeys("C:/Users/SAI SWARAJ/Desktop/New folder (2)/file-example_PDF_500_kB.pdf");
			
			Thread.sleep(3000);
			
			driver.findElement(By.id("btnNext")).click();
			
			Thread.sleep(3000);
			
			String actText1 = driver.findElement(By.xpath("//*[@id=\"alertModal\"]/div/div/div/h2")).getText();
			
		    System.out.println(actText1);
			
			SoftAssert softAssert29 = new SoftAssert();
			
			softAssert29.assertEquals(actText1, "Authorized signatories list with specimen signatures cannot be left blank" , "Test case Failed");
			
			driver.findElement(By.id("btnAlertOk")).click();
			
			Thread.sleep(3000);
		}

		
		
		/*  Preview Application */
		
		@Test(priority= 53)
		
		public void Checkenablepreviewpage()
		{
		 boolean chk =	pr.SelectUniqueId().isEnabled();
		 
		 SoftAssert softAssert30 = new SoftAssert();
		
			softAssert30.assertTrue(true);
		}	
		
		@Test(priority =54)
			public void checkexpectedtext()
			{
			String actres = pr.SelectMno().getText();
			SoftAssert softAssert31 = new SoftAssert();
			softAssert31.assertEquals(actres, "9248028902", "Test Failed");
			}
		
		@AfterMethod
		 public void tearDown(ITestResult result) throws IOException {
		  if (result.getStatus() == ITestResult.FAILURE) {
		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getName()); // to add name in extent report
		   test.log(Status.FAIL, "TEST CASE FAILED IS " + result.getThrowable()); // to add error/exception in extent report
		   String screenshotPath = Testlisten.getScreenshot(driver, result.getName());
		   test.addScreenCaptureFromPath(screenshotPath);// adding screen shot
		  } else if (result.getStatus() == ITestResult.SKIP) {
		   test.log(Status.SKIP, "Test Case SKIPPED IS " + result.getName());
		  }
		  else if (result.getStatus() == ITestResult.SUCCESS) {
		   test.log(Status.PASS, "Test Case PASSED IS " + result.getName());
		  }
		 
		 }
		
		
	}
