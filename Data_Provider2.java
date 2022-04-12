package ABC_Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class Data_Provider2 {
	
	
	private static final String JavascriptExecutor = null;


	WebDriver driver;
	
	@DataProvider(name = "TC01_OrangeHRM")
	  public static Object[][] test3() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","English" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","English" }, 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123","English" }
	        	};
	  }
	
	
	
  @Test (dataProvider="TC01_OrangeHRM")
  public void Dataprovider(String TestURL,String UserName,String Password,String Language) throws Exception{
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  
	 // String TestURL="https://opensource-demo.orangehrmlive.com/";
	  
	driver.get(TestURL);
	  
	     findElement(By.id("txtUsername")).sendKeys(UserName);
		 findElement(By.id("txtPassword")).sendKeys(Password);
		 findElement(By.id("btnLogin")).click();
	
	     findElement(By.linkText("Admin")).click();
	     findElement(By.id("menu_admin_Qualifications")).click();
	     findElement(By.linkText("Languages")).click();
	     findElement(By.id("btnAdd")).click();
	     findElement(By.id("language_name")).sendKeys(Language);
	     findElement(By.id("btnSave")).click();
	    
	     
	     
	     //Javascript executor method
	     WebElement name1=findElement(By.id("language_name"));
	     
	     //web pixel scorll
	     JavascriptExecutor js=(JavascriptExecutor)driver;
        js.executeScript("arguments[0].scrollIntoView()",name1);
		 
		 
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
