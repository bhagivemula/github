package  ABC_Dataprovider;
import CommonUtil.*;
import org.openqa.selenium.JavascriptExecutor;


import org.openqa.selenium.WebDriver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.*;
public class OrangeHRM_DataProvider_Lab1
{
	static WebDriver driver;
	
	
	//if u want to execute u r test with multiple input test data , we can use Data Provider
	
	//step1
	 @DataProvider(name = "Orange1")
	  public static Object[][] Test1() throws Exception {
	 
	        return new Object[][] { 
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123" },
	        	{ "https://opensource-demo.orangehrmlive.com/","Admin", "admin123" },
	        	};
	  }
	 
	 
	
@Test(dataProvider = "Orange1") //step2 u r test will be connected to dataProvider 
public void Test1(String TestURL,String UserName,String Password) throws Exception {   
	//step3 ensure number of parameters
		
		
		//OpenChromeBrowser
		driver = TestBrowser.OpenChromeBrowser();

		//OpenUrl
		driver.get(TestURL);
		

		//SendKeys
		 findElement(By.id("txtUsername")).sendKeys(UserName);
		 findElement(By.id("txtPassword")).sendKeys(Password);
		 findElement(By.id("btnLogin")).click();
		
			  
		 findElement(By.linkText("Performance")).click();
		 findElement(By.linkText("Configure")).click();
		 findElement(By.linkText("KPIs")).click();
		 findElement(By.id("btnAdd")).click();
		 

			
		 	  
		 driver.quit();	 
		 

	}
	

private Select selectByVisibleText(String string) {
	// TODO Auto-generated method stub
	return null;
}



// Draws a red border around the found element. Does not set it back anyhow.
		public  WebElement findElement(By by) throws Exception {
			
		    WebElement elem = driver.findElement(by);
		    	    
		    // draw a border around the found element
		    if (driver instanceof JavascriptExecutor) {
		        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
		        
		  //  TH3.HTMLScreenShot("Screen Shot","Click Here","Pass", HtmlOutputFileName,driver);
		        
		    }
		    return elem;
		}
		
	
	
}
	
	
	
	
	
	
	 
	













