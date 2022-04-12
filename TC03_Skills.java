package ABC_Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;
import CommonUtil.TestBrowser;

public class TC03_Skills {
	
	
	static WebDriver driver;
	
	@DataProvider(name = "TC03_Addskills")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C://HTML Report//OrangeHRM6//TC01_Skills98.xlsx", "Bhagya");
		
		
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	@Test(dataProvider="TC03_Addskills")
	public void  SkillsTest(String TestURL1,String UserName,String Password,String SkillName,String SkillDescription) throws Exception{
		
		
		  
		TC03_Skills T2=new TC03_Skills();
		
		T2.OpenChromeBrowser();
		T2.OpenOrangeHRM(TestURL1);
		T2.Login(UserName,Password);
		T2.Add_skills(SkillName,SkillDescription);
		
		
		
	}
public void  OpenChromeBrowser() throws Exception{
		
		driver=TestBrowser.OpenChromeBrowser();
		
		
	}	
public void  OpenOrangeHRM(String TestURL1) throws Exception{
	
	driver.get("https://opensource-demo.orangehrmlive.com/");
	
	String TestURL="https://opensource-demo.orangehrmlive.com/";
	
}
public void  Login(String UserName1,String Password1 ) throws Exception{
	
	String UserName="Admin",Password="admin123";
	
	 findElement(By.id("txtUsername")).sendKeys(UserName);
	 findElement(By.id("txtPassword")).sendKeys(Password);
	 findElement(By.id("btnLogin")).click();
	
	
}
public void  Add_skills(String SkillName1,String SkillDescription1) throws Exception{
	
	
	
	findElement(By.id("menu_admin_viewAdminModule")).click();
	findElement(By.id("menu_admin_Qualifications")).click();
	findElement(By.id("menu_admin_viewSkills")).click();
	findElement(By.id("btnAdd")).click();
	findElement(By.id("skill_name")).sendKeys(SkillName1);
	findElement(By.id("skill_description")).sendKeys(SkillDescription1);
	findElement(By.id("btnSave")).click();
	
	
}

public   WebElement findElement(By by) throws Exception {
	  
    WebElement elem = driver.findElement(by);
    if (driver instanceof JavascriptExecutor) {
        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
    }
    return elem;
}
}

