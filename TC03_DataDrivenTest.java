package ABC_Dataprovider;

import org.openqa.selenium.By;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import ExcelUtil.ExcelApiTest4;

public class TC03_DataDrivenTest {
	
	static WebDriver driver;
	
	@DataProvider(name = "Recuritments")
	public static Object[][] Authentication1() throws Exception {
		
		ExcelApiTest4 eat = new ExcelApiTest4();
		Object[][] testObjArray = eat.getTableArray("C:\\HTML Report\\OrangeHRM6//BhagyaLaxmi.xlsx", "Bhagya");
		
		
		System.out.println(testObjArray.length);
		return (testObjArray);
	}
	
	
	
	
  @Test(dataProvider="Recuritments")
  public void trialdataprovider (String URL1,String UserName,String Password,String FirstName,String MiddleName,String LastName, String Email, String ContactNo) throws Exception
  {
	  
	  TC03_DataDrivenTest T1=new TC03_DataDrivenTest();
	  
	  T1.OpenChromeBrowser();
	  T1.OpenOrangeHRM(URL1);
	  T1.Login(UserName,Password);
	  T1.recruitment(FirstName,MiddleName,LastName,Email,ContactNo);
	  
	 
	  
  }
	  
	  public void OpenChromeBrowser () throws Exception{
		  
		  
	  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
		driver =new ChromeDriver();
		driver.manage().window().maximize() ;
	  }
	  
	  public void OpenOrangeHRM (String URL) throws Exception{
		driver.get("https://opensource-demo.orangehrmlive.com/");
		
		String TestURL="https://opensource-demo.orangehrmlive.com/";
		
		driver.get(TestURL);
	  }
		
	  
	  public void Login (String UserName,String Password) throws Exception{
		findElement(By.name("txtUsername")).sendKeys(UserName);
		findElement(By.name("txtPassword")).sendKeys(Password);
		findElement(By.id("btnLogin")).click();
	  }
	  public void recruitment (String FirstName,String MiddleName,String LastName,String Email,String ContactNo) throws Exception{
	
		 System.out.println(FirstName);
		 findElement(By.linkText("Recruitment")).click();
	     findElement(By.id("btnAdd")).click();
	     findElement(By.id("addCandidate_firstName")).sendKeys(FirstName);
	     findElement(By.id("addCandidate_middleName")).sendKeys(MiddleName);
	     findElement(By.id("addCandidate_lastName")).sendKeys(LastName);
	     findElement(By.id("addCandidate_email")).sendKeys(Email);
	     findElement(By.id("addCandidate_contactNo")).sendKeys(ContactNo);
	     findElement(By.id("btnSave")).click();
	  }
		
  
		
		
  public   WebElement findElement(By by) throws Exception 
	{
				
		 WebElement elem = driver.findElement(by);    	    
		
		 
		if (driver instanceof JavascriptExecutor) 
		{
		 ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	 
		}
		
		return elem;
	}

  
}