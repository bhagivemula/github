package ABC_Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;

import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class Data_Provider_Nonstatic_Parameter {
	
	
	
	//step1-Global variables
		 String TestURL="https://opensource-demo.orangehrmlive.com/";
		 String Username="Admin",password="admin123";
		 String AddLanguage="Arabic";
		
	
	
	
	@DataProvider(name = "TestDataDriver")
	 
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","Arabic" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","English" }
	        	};
	  }
	
	 
	
  @Test (dataProvider="TestDataDriver")
  public void test(String TestURL,String UserName,String Password,String AddLanguage) throws Exception{
	  
	  Data_Provider_Nonstatic_Parameter T1=new Data_Provider_Nonstatic_Parameter();
	  
	T1.OpenChromeBrowser();
	T1.OpenOrangeHRM(TestURL);
	T1.Login(UserName,password);
	T1.AddQualifications(AddLanguage);
      
  }
	  
	




	public  void OpenChromeBrowser() throws Exception  {
	  
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
	  }
	  public  void OpenOrangeHRM(String TestURL) throws Exception {
		 
		  driver.get("https://opensource-demo.orangehrmlive.com/");
		  
		  
		  		
	  }
	  
	  public  void Login(String userName, String password) throws Exception {
		  
	  
	  
	     findElement(By.id("txtUsername")).sendKeys("Admin");
		 findElement(By.id("txtPassword")).sendKeys("admin123");
		 findElement(By.id("btnLogin")).click();
	  } 
		 public  void AddQualifications(String AddLanguage) throws Exception {
	   
			 String Name="Arabic"; 
		
		 findElement(By.linkText("Admin")).click();
	     findElement(By.id("menu_admin_Qualifications")).click();
	     findElement(By.linkText("Languages")).click();
	     findElement(By.id("btnAdd")).click();
	     findElement(By.id("language_name")).sendKeys(Name);
	     findElement(By.id("btnSave")).click();
	    
		 
	     
	      driver.quit();
		 
		 
		 
		 
  }
  
  public  WebElement findElement(By by) throws Exception {
	  
	    WebElement elem = driver.findElement(by);
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	    }
	    return elem;
  }
}
