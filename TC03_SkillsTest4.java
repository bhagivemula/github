package ABC_Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import CommonUtil.TestBrowser;
import ExcelUtil.ExcelApiTest4;

public class TC03_SkillsTest4 {
	
static WebDriver driver;
	
	
	
	
	 
		@DataProvider(name = "TC01_Add_SkillsData")
		public static Object[][] Authentication1() throws Exception {
			
			ExcelApiTest4 T1 = new ExcelApiTest4();
			Object[][] testObjArray = T1.getTableArray("C://HTML Report//OrangeHRM6//TC01_Skills90.xlsx", "Sheet5");
			System.out.println(testObjArray.length);
			return (testObjArray);
		}
		
	 
	
  @Test(dataProvider="TC01_Add_SkillsData") //Step2 
  public void SkillsTest(String TestURL,String USerName,String Password,
		  String SkillName,String SkillDescr)throws Exception {
	  
	  TC03_SkillsTest4 T1=new TC03_SkillsTest4();
	  
	//  T1.OpenChromeBrowser();
	  
	  
	 // if(Browser.equalsIgnoreCase("Chrome"))
	 // {
		//  driver=TestBrowser.OpenChromeBrowser();
	//  }
	  
	 // if(Browser.equalsIgnoreCase("FireFox"))
	//  {
	//	  driver=TestBrowser.FirefoxBrowser();
	//  }
	  
	  T1.OpenOrangeHRM(TestURL); //Step2
	  T1.Login(USerName,Password);//step2
	T1.AddSKills(SkillName,SkillDescr);//Step2
	
	  
  }
  
  
  
  
  
  public void OpenChromeBrowser()throws Exception {
	  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;	
  }
  
  
  public void OpenOrangeHRM(String TestURL1)throws Exception {
	  

		driver.get(TestURL1);
  }
  
  public void Login(String USerName1,String Password1)throws Exception {
	  
		findElement(By.id("txtUsername")).sendKeys(USerName1);
		findElement(By.id("txtPassword")).sendKeys(Password1);
		findElement(By.id("btnLogin")).click();
  }
  
  public void AddSKills(String SkillName1,String SkillDescr1)throws Exception {
	  
		
		findElement(By.id("menu_admin_viewAdminModule")).click();
		findElement(By.id("menu_admin_Qualifications")).click();
		findElement(By.id("menu_admin_viewSkills")).click();
		findElement(By.id("btnAdd")).click();
		findElement(By.id("skill_name")).sendKeys(SkillName1);
		findElement(By.id("skill_description")).sendKeys(SkillDescr1);
		findElement(By.id("btnSave")).click();
  }
  
  public  WebElement findElement(By by) throws Exception 
	{

		WebElement elem = driver.findElement(by);  
		
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid blue'", elem);
	 
		}
		return elem;
	}



  
}