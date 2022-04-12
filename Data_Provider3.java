package ABC_Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class Data_Provider3 {
	
	WebDriver driver;
	
	 @DataProvider(name = "TestDataProvider2")
	 public Object[] myDataProvider() {
	      
	     Object data[][]=  new Object[2][4];
	     // First student details
	     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[0][1]= "Admin";
	     data[0][2]= "admin123";
	     data[0][3]= "carpenter";
	      
	     // Second student details
	     data[1][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[1][1]= "Admin";
	     data[1][2]= "admin123";
	     data[1][3]= "handlooms3";
	     
	     return data;
	      
	      
	 }
	

	
  @Test (dataProvider="TestDataProvider2")
  public void Dataprovider(String TestURL,String UserName,String Password,String Name) throws Exception{
	  
	  driver=TestBrowser.OpenChromeBrowser();
	  
	  String TestURL1="https://opensource-demo.orangehrmlive.com/";
	  
	  driver.get(TestURL1);
	  
	     findElement(By.id("txtUsername")).sendKeys(UserName);
		 findElement(By.id("txtPassword")).sendKeys(Password);
		 findElement(By.id("btnLogin")).click();
	
	     findElement(By.linkText("Admin")).click();
	     findElement(By.id("menu_admin_Qualifications")).click();
	     findElement(By.linkText("Languages")).click();
	     findElement(By.id("btnAdd")).click();
	     findElement(By.id("language_name")).sendKeys(Name);
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
