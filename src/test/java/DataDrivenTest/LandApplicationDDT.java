package DataDrivenTest;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;



	public class LandApplicationDDT {
	
	WebDriver driver; 
	
	@BeforeTest
	public void setUp() throws FileNotFoundException, InterruptedException {
		
		FileInputStream fis= new FileInputStream("D:\\eclipse\\AuricAutomationTest\\config.properties");	
		System.setProperty("webdriver.chrome.driver","D:/chromedriver/chromedriver.exe");

		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
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
		
	}
	
	
	@DataProvider
	public static Object[][] InputData() throws Exception
	{
		ExcelUtil.GetData obj=new ExcelUtil.GetData();
		Object data[][]= obj.gettingdata("Auricland");
		return data;
		
	}
		
		
		
	@Test(priority=0, dataProvider="InputData")
	public void getDataExcel(String Country, String State, String City, String Pin, String SpecialCategory, String Address, 
				String Area, String CategoryofProperty, String SubcategoryType, String VentureType, String TypeofIndustry, 
				String PropertyType, String RequiredPlotSize, String BuiltupArea, String PlinthArea, String Factory, String EntityName,
				String CompanyAddress, String ConstitutionType, String Country1, String State1, String CityorToSwn, String Pin1,
				String CompanyPAN, String GSTN, String Fax, String STD, String LandlineNumber, String DateofIncorporation,
				String NatureofProject, String NatureofActivity, String RangeofProducts, String ProductType1, String Productioncapacityperyear1,
				String NumberofSkilledEmployees, String NumberofUnskilledEmployees, String NumberofSupervisoryEmployees){
		
		//Select sl = new Select(driver.findElement(By.id("selCountry")));
		//sl.deselectByVisibleText(Country);
		
		driver.findElement(By.id("selCountry")).sendKeys(Country);
		
		driver.findElement(By.id("selState")).sendKeys(State);
		driver.findElement(By.id("txtDistrict")).clear();
		driver.findElement(By.id("txtDistrict")).sendKeys(City);
		driver.findElement(By.id("txtPin")).clear();
		driver.findElement(By.id("txtPin")).sendKeys(Pin);
		
		driver.findElement(By.id("selSpecialCat")).sendKeys(SpecialCategory);
		driver.findElement(By.id("txtAddress")).clear();
		driver.findElement(By.id("txtAddress")).sendKeys(Address);
		
		driver.findElement(By.id("btnNext")).click();
	//	driver.findElement(By.xpath("//*[@id=\"rightCon\"]/div[1]/div[3]/div[1]/a")).click();
		
		driver.findElement(By.id("selInArea")).sendKeys(Area);
		driver.findElement(By.id("selCatProp")).sendKeys(CategoryofProperty);
		driver.findElement(By.id("selSubCatType")).sendKeys(SubcategoryType);
		driver.findElement(By.id("selVentureType")).sendKeys(VentureType);
		driver.findElement(By.id("selIndustryType")).sendKeys(TypeofIndustry);
		driver.findElement(By.id("selPropType")).sendKeys(PropertyType);
		driver.findElement(By.id("txtReqPlSz")).sendKeys(RequiredPlotSize);
		driver.findElement(By.id("txtBuiltUpAr")).sendKeys(BuiltupArea);
		driver.findElement(By.id("txtPlinthAr")).sendKeys(PlinthArea);
		driver.findElement(By.id("txtFactory")).sendKeys(Factory);
		driver.findElement(By.xpath("//*[@id=\"rightCon\"]/div[1]/div[3]/div[1]/a")).click();
		
		driver.findElement(By.id("txtEntityName")).sendKeys(EntityName);
		driver.findElement(By.id("txtCompAddress")).sendKeys(CompanyAddress);
		driver.findElement(By.id("selConstType")).sendKeys(ConstitutionType);
		
		driver.findElement(By.id("selCompCountry")).sendKeys(Country1);
		
		driver.findElement(By.id("txtOtherState")).sendKeys(State1);
		
		driver.findElement(By.id("txtCompCity")).sendKeys(CityorToSwn);
		
		driver.findElement(By.id("txtCompPin")).sendKeys(Pin1);
		
		driver.findElement(By.id("txtCompPan")).sendKeys(CompanyPAN);
		
		driver.findElement(By.id("txtGST")).sendKeys(GSTN);
		
		driver.findElement(By.id("txtCompFax")).sendKeys(Fax);
		driver.findElement(By.id("txtCompLanExt")).sendKeys(STD);
		driver.findElement(By.id("txtCompLandNo")).sendKeys(LandlineNumber);
		
		driver.findElement(By.id("txtCompIncDate")).click();
		
		SelectDayFromMultiDateCalendar("1");
		
//		By calendarXpath = By
//				.xpath("//td[not(contains(@class,'ui-datepicker-other-month'))]/a[text()='"
//						+ day + "']");
//		driver.findElement(calendarXpath).click();
		
//		Select sl = new Select(driver.findElement(By.xpath("/html[1]/body[1]/div[15]/div[1]/table[1]/tbody[1]/tr[4]/td[5]")));
//		sl.deselectByVisibleText(DateofIncorporation);
		//driver.findElement(By.xpath("/html[1]/body[1]/div[15]/div[1]/table[1]/tbody[1]/tr[4]/td[5]")).sendKeys(DateofIncorporation);
		
		driver.findElement(By.xpath("//*[@id=\"rightCon\"]/div[1]/div[4]/div[1]/a")).click();
		
		driver.findElement(By.id("selProjectNature")).sendKeys(NatureofProject);
		
		driver.findElement(By.id("selActivityNature")).sendKeys(NatureofActivity);
		
		driver.findElement(By.id("selProductRange")).sendKeys(RangeofProducts);
				
		driver.findElement(By.id("proposedProduct1")).sendKeys(ProductType1);
		
		driver.findElement(By.id("prodCapacityYr1")).sendKeys(Productioncapacityperyear1);
		
		driver.findElement(By.id("txtNoSkEmp")).sendKeys(NumberofSkilledEmployees);
		
		driver.findElement(By.id("txtNoUSkEmp")).sendKeys(NumberofUnskilledEmployees);
		
		driver.findElement(By.id("txtNoSupEmp")).sendKeys(NumberofSupervisoryEmployees);
		
		String actTotalNUM = driver.findElement(By.id("txtTotalEmp")).getText();
		
		System.out.println(actTotalNUM);
		
	}


	private void SelectDayFromMultiDateCalendar(String string) {
		// TODO Auto-generated method stub
		
	}
	
	
	
}
