zpackage ABC_Dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Day_034_TestNG_Listeners.TestBrowser;

public class Data_Provider_recruitement_parameter {
	
	 static WebDriver driver;
	
	//step1-Global variables
	
	 String TestURL="https://opensource-demo.orangehrmlive.com/";
	 String Username="Admin",password="admin123";
	 String FirstName="Bhagya",MiddleName="laxmi",LastName="Vemula",Email="dhanya323@gmail.com",ContactNo="1234567890",JobVacancy="Payroll Administrator",Comment="bhagyalaxmibobbala",DateOfApplication="2022-03-28";
		 
	@DataProvider(name = "Testdataprovider1")
	 public Object[] myDataProvider() {
	      
	     Object data[][]=  new Object[2][11];
	     // First student details
	     data[0][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[0][1]= "Admin";
	     data[0][2]= "admin123";
	     data[0][3]= "Bhagya";
	     data[0][4]= "laxmi";
	     data[0][5]= "Vemula";
	     data[0][6]= "dhanya321@gmail.com";
	     data[0][7]= "1234567820";
	     data[0][8]= "Associate IT Manager";
	     data[0][9]= "bhagyalaxmi";
	     data[0][10]= "2022-03-23";
	   
	     
	  // second student details
	     data[1][0]= "https://opensource-demo.orangehrmlive.com/"; 
	     data[1][1]= "Admin";
	     data[1][2]= "admin123";
	     data[1][3]= "Bhagya";
	     data[1][4]= "laxmi";
	     data[1][5]= "Vemula";
	     data[1][6]= "dhanya322@gmail.com";
	     data[1][7]= "1234567810";
	     data[1][8]= "Senior QA Lead";
	     data[1][9]= "bhagyalaxmibobbala";
	     data[1][10]= "2022-03-24"; 
	    
	     
	     return data;  
	     
	}
		
  @Test (dataProvider="Testdataprovider1")
  public void recruitment(String TestURL,String UserName,String Password,String FirstName,String MiddleName,String LastName,String Email,String ContactNo,String JobVacancy,String Comment,String DateOfApplication)
  throws Exception{
	  
	  Data_Provider_recruitement_parameter.OpenChromeBrowser();
	  Data_Provider_recruitement_parameter.OpenOrangeHRM(TestURL);
	  Data_Provider_recruitement_parameter.Login(UserName,Password);
	  Data_Provider_recruitement_parameter.AddRecruitment(FirstName,MiddleName,LastName,Email,ContactNo,JobVacancy,Comment,DateOfApplication);
	  
  }
	  public static  void OpenChromeBrowser() throws Exception {
	  
		  System.setProperty("webdriver.chrome.driver","C:\\chromedriver_win32\\chromedriver.exe");
			driver =new ChromeDriver();
			driver.manage().window().maximize() ;
  }
			public static  void OpenOrangeHRM(String TestURL) throws Exception {
				  
		 
		  //driver.get("https://opensource-demo.orangehrmlive.com/");
		  driver.get(TestURL);
			}
		  public static void Login(String UserName,String Password) throws Exception {
			  	  
	     findElement(By.id("txtUsername")).sendKeys(UserName);
		 findElement(By.id("txtPassword")).sendKeys(Password);
		 findElement(By.id("btnLogin")).click();
		  }
		  
		  
		 public  static void AddRecruitment(String FirstName,String MiddleName,String LastName,String Email,String ContactNo,String JobVacancy,String Comment,String DateOfApplication) throws Exception {
			 
		 
		 findElement(By.linkText("Recruitment")).click();
	     findElement(By.id("btnAdd")).click();
	     findElement(By.id("addCandidate_firstName")).sendKeys(FirstName);
	     findElement(By.id("addCandidate_middleName")).sendKeys(MiddleName);
	     findElement(By.id("addCandidate_lastName")).sendKeys(LastName);
	     findElement(By.id("addCandidate_email")).sendKeys(Email);
	     findElement(By.id("addCandidate_contactNo")).sendKeys(ContactNo);
	     
	     
	     Select se=new Select(driver.findElement(By.id("addCandidate_vacancy")));
	     se.selectByVisibleText(JobVacancy);
	     
	     
	     findElement(By.id("addCandidate_comment")).sendKeys(Comment);
	     
	    WebElement Date=findElement(By.id("addCandidate_appliedDate"));
	     Date.clear();
		Date.sendKeys(DateOfApplication);
	     
	     //Select Date=new Select(driver.findElement(By.id("addCandidate_appliedDate")));
	     //Date.selectByVisibleValue(DateOfApplication);
	     
	    findElement(By.id("btnSave")).click();
	     
	     
	     
	    driver.quit();
		 
		 
		 
		 
  }
  
  private Select selectByVisibleValue(String string) {
			// TODO Auto-generated method stub
			return null;
		}





private Select selectByVisibleText(String string) {
			// TODO Auto-generated method stub
			return null;
		}





public  static WebElement findElement(By by) throws Exception {
	  
	    WebElement elem = driver.findElement(by);
	    if (driver instanceof JavascriptExecutor) {
	        ((JavascriptExecutor)driver).executeScript("arguments[0].style.border='3px solid red'", elem);
	    }
	    return elem;
  }
}
