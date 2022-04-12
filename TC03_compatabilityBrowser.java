package ABC_Dataprovider;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;
import CommonUtil.TestBrowser;

public class TC03_compatabilityBrowser {
	
	
	static WebDriver driver;
	
	@DataProvider(name = "compatabilityBrowser")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Skills98.xlsx", "Sheet5");
		
		
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	@Test(dataProvider="compatabilityBrowser")
	public void  SkillsTest(String Browser,String TestURL,String UserName,String Password,String SkillName,String SkillDescription) throws Exception{
		
	//	File pathToBinary = new File("C:\\Program Files\\Mozilla Firefox15\\Firefox.exe");
		
		  
		TC03_compatabilityBrowser T2=new TC03_compatabilityBrowser();
		
		//Browser compatibility
		
		if(Browser.equalsIgnoreCase("Chrome"))
		{
			driver=TestBrowser.OpenChromeBrowser();
				
		}
		if(Browser.equalsIgnoreCase("Edge"))
		{    
			System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");
            driver = new EdgeDriver();
			driver.manage().window().maximize() ;	
		
		}
			
		T2.OpenOrangeHRM(TestURL);
		T2.Login(UserName,Password);
		T2.Add_skills(SkillName,SkillDescription);
		
		
		
	}
public void  OpenEdgeBrowser() throws Exception
{	  
	System.setProperty("webdriver.edge.driver","C:\\msedgedriver.exe");
	            driver = new EdgeDriver();
				driver.manage().window().maximize() ;		
}
public void  OpenChromeBrowser() throws Exception
{	  
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;		
}
public void  OpenOrangeHRM(String TestURL1) throws Exception{
	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	driver.get(TestURL);
}
public void  Login(String UserName1,String Password1 ) throws Exception{
	
	String UserName="Admin",Password="admin123";
	
	 findElement(By.id("txtUsername")).sendKeys("Admin");
	 findElement(By.id("txtPassword")).sendKeys("admin123");
	 findElement(By.id("btnLogin")).click();
	
	
}
public void  Add_skills(String SkillName1,String SkillDescription1) throws Exception{
	
	String SkillName="salesforce",SkillDescription="salesforce description";
	
	findElement(By.id("menu_admin_viewAdminModule")).click();
	findElement(By.id("menu_admin_Qualifications")).click();
	findElement(By.id("menu_admin_viewSkills")).click();
	findElement(By.id("btnAdd")).click();
	findElement(By.id("skill_name")).sendKeys("MainFrame");
	findElement(By.id("skill_description")).sendKeys("MainFrame descr");
	findElement(By.id("btnSave")).click();
	
	driver.quit();
	
}

public   WebElement findElement(By by) throws Exception {
	  
    WebElement elem = driver.findElement(by);
    if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
    }
    return elem;
}
}

