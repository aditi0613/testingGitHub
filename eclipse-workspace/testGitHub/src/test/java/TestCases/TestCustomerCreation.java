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
import WebPages.CreateCustomer_page;
import WebPages.LoginUser_Page;


public class TestCustomerCreation extends Functionality_test {
	public static Logger log =LogManager.getLogger(Functionality_test.class.getName());
	WebDriver driver;
	CreateCustomer_page objCustomerCreate;
	LoginUser_Page objFromLoginC;
	
@BeforeClass
	public void browsersetUp() throws IOException {
		driver=setUp();
		log.info("Browser started");
	}
	

@Test
public void test_case_customer_creation()throws InterruptedException {
	
	 String xl = "C:/Users/AM01/Desktop/Automation/eclipse/data_sheet.xlsx";

     String Sheet = "Sheet1";

     //for login user
     String UserName=Excel.getCellValue(xl, Sheet, 1, 0);
     String Pwd=Excel.getCellValue(xl, Sheet, 1, 1);
     String sKeyword=Excel.getCellValue(xl, Sheet, 1, 14);
     String CName = Excel.getCellValue(xl, Sheet, 1, 15);
     String CGroup=Excel.getCellValue(xl, Sheet, 1, 16);
     
     driver.get(prop.getProperty("url"));
 	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
 	objCustomerCreate=new CreateCustomer_page(driver);
 	objFromLoginC = new LoginUser_Page(driver);
 	objFromLoginC.maximizeWindow();
 	//user logged in
 	objFromLoginC.loginToGS1(UserName, Pwd);
 	log.info("User logged in");
 	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 	Thread.sleep(1000);
 	//vendor creation process starts
 	objCustomerCreate.enterKeywordSearchC(sKeyword);
 	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 	Thread.sleep(5000);
 	objCustomerCreate.clickNewCustomerBtn();
 	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 	Thread.sleep(5000);
 	objCustomerCreate.formFillCust(CName,CGroup);
 	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
 	Thread.sleep(5000);
 	String objCust=objCustomerCreate.getCustomerName();
 	System.out.println(objCustomerCreate.getCustomerName());
	Assert.assertTrue(objCust.contains(CName));
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.navigate().back();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
}

@AfterTest 
public void browserclose() {
 driver =tearDown();
}

}
