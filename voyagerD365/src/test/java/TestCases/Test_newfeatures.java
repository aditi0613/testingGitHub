package TestCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import Utility.Excel;
import WebPages.LoginUser_Page;
import WebPages.NewFeaures_Page;
import WebPages.VendorCreation_Page;



public class Test_newfeatures extends Functionality_test {
	public static Logger log =LogManager.getLogger(Functionality_test.class.getName());
	WebDriver driver;
	NewFeaures_Page objNewFeature;
	LoginUser_Page objFromLogin;
	
	@BeforeClass
	public void browsersetUp() throws IOException {
		driver=setUp();
		log.info("Browser started");
	}
	
	@Test
	public void test_case_new_feature()throws InterruptedException {
		
		 String xl = "C:/Users/AM01/Desktop/Automation/eclipse/data_sheet.xlsx";

	     String Sheet = "Sheet1";


	     //for login user
	     String UserName=Excel.getCellValue(xl, Sheet, 1, 0);
	     String Pwd=Excel.getCellValue(xl, Sheet, 1, 1);
	     String keywordN = "All Customers";
	     String filter = "testingCustomer1234";
	     
	     driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objNewFeature =new NewFeaures_Page(driver);
		objFromLogin = new LoginUser_Page(driver);
		objFromLogin.maximizeWindow();
		
		//user logged in
		objFromLogin.loginToGS1(UserName, Pwd);
		log.info("User logged in");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		objNewFeature.enterKeywordSearchN(keywordN);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		objNewFeature.filterField(filter);
 	
}    
}
