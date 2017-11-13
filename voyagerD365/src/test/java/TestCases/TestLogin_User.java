package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utility.Excel;
import WebPages.LoginUser_Page;


public class TestLogin_User extends Functionality_test {
	public static Logger log =LogManager.getLogger(Functionality_test.class.getName());
	WebDriver driver;
	LoginUser_Page objLogin;
	//String browserName=prop.getProperty("browser");
	
@BeforeClass
	public void browsersetUp() throws IOException {
	//calling setup method to initiate the browser from the functionality base class
		driver=setUp();
		log.info("Browser started");
	}
	

@Test
public void test_case_login_user()throws InterruptedException {
	
	//Retrieving data from excel
	String browserName=prop.getProperty("browser");
	String xl = "C:/Users/AM01/Desktop/auto_Frame/username_password.xlsx";
    String Sheet = "Sheet1";
    String UserName=Excel.getCellValue(xl, Sheet, 1, 0);
    String Pwd=Excel.getCellValue(xl, Sheet, 1, 1);
   
    //calling URL from data.properties
    driver.get(prop.getProperty("url"));
    
 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	objLogin=new LoginUser_Page(driver);
 	objLogin.maximizeWindow();
 	
 	if(browserName.equalsIgnoreCase("chrome"))
	{
 		
 	//Calling login method from login page
 	objLogin.loginToGS1(UserName, Pwd);
 	
 	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
 	Thread.sleep(5000);
	}
 	else
 	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	 	Thread.sleep(5000);
 	}
	String objectLogin=objLogin.getHeadingTitle();
	System.out.println(objLogin.getHeadingTitle());
	//Assert.assertTrue(objectLogin.contains("gdfgfdg"));
	
	//Verification of user logged in
	Assert.assertEquals(objectLogin, "Finance and Operations");
	log.info("User logged in");
	Thread.sleep(2000);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
}
@AfterTest 
//after completion of test browser will get closed
public void browserclose() {
 driver =tearDown();
}
}
