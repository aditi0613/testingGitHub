
package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.*;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import Utility.Excel;
import WebPages.LoginUser_Page;
import WebPages.VendorCreation_Page;


public class TestVendorCreation extends Functionality_test {
	public static Logger log =LogManager.getLogger(Functionality_test.class.getName());
	WebDriver driver;
	VendorCreation_Page objVendorCreate;
	LoginUser_Page objFromLogin;
	
@BeforeClass
	public void browsersetUp() throws IOException {
		driver=setUp();
		log.info("Browser started");
	}
	

@Test
public void test_case_vendor_creation()throws InterruptedException {
	
	 String xl = "C:/Users/AM01/Desktop/Automation/eclipse/data_sheet.xlsx";

     String Sheet = "Sheet1";

    // int rowCount = Excel.getRowCount(xl, Sheet);
     //for login user
     String UserName=Excel.getCellValue(xl, Sheet, 1, 0);
     String Pwd=Excel.getCellValue(xl, Sheet, 1, 1);
     
     //for vendor creation
     String keyword= Excel.getCellValue(xl, Sheet, 1, 2);
     String VendorAccount = Excel.getCellValue(xl, Sheet, 1, 3);
     String VendorGroup = Excel.getCellValue(xl, Sheet, 1, 4);
     String VendorNames = Excel.getCellValue(xl, Sheet, 1, 5);
     String VendorName1 = Excel.getCellValue(xl, Sheet, 1, 6);
     
     driver.get(prop.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	objVendorCreate=new VendorCreation_Page(driver);
	objFromLogin = new LoginUser_Page(driver);
	objFromLogin.maximizeWindow();
	//user logged in
	objFromLogin.loginToGS1(UserName, Pwd);
	log.info("User logged in");
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	//vendor creation process starts
	objVendorCreate.enterKeywordSearch(keyword);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	objVendorCreate.createNewVendor(VendorAccount, VendorGroup, VendorNames);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	objVendorCreate.verifyCreatedVendor();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	objVendorCreate.clickVendorNameDetails();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	String objectLogin=objVendorCreate.getVendorName();
	System.out.println(objVendorCreate.getVendorName());
	Assert.assertTrue(objectLogin.contains(VendorName1));
	log.info("Assertion passed");
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
		
}

@AfterTest 
public void browserclose() {
 driver =tearDown();
}

}
	