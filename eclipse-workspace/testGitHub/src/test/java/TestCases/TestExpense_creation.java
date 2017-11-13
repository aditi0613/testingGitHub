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
import WebPages.ExpenseCreation_Page;
import WebPages.LoginUser_Page;

public class TestExpense_creation extends Functionality_test{
		public static Logger log =LogManager.getLogger(Functionality_test.class.getName());
		WebDriver driver;
		ExpenseCreation_Page objExpenseCreate;
		LoginUser_Page objFromLogin1;
		
	@BeforeClass
		public void browsersetUp() throws IOException {
			driver=setUp();
			log.info("Browser started");
		}
		

	@Test
	public void test_case_expense_creation()throws InterruptedException {
		
		 String xl = "C:/Users/AM01/Desktop/Automation/eclipse/data_sheet.xlsx";
	     String Sheet = "Sheet1";

	     //for login user
	     String UserName=Excel.getCellValue(xl, Sheet, 1, 0);
	     String Pwd=Excel.getCellValue(xl, Sheet, 1, 1);
	     
	     //for expense report creation
	     String keywords= Excel.getCellValue(xl, Sheet, 1, 7);
	     String purposefield = Excel.getCellValue(xl, Sheet, 1, 8);
	     String Description = Excel.getCellValue(xl, Sheet, 1, 9);
	     String Map = Excel.getCellValue(xl, Sheet, 1, 10);
	     //String DateE="11/8/2017";
	     String DateE=Excel.getCellValue(xl, Sheet, 1, 11);
	     String Category=Excel.getCellValue(xl, Sheet, 1, 12);
	     String Amount = "400";
	     //String Amount=Excel.getCellValue(xl, Sheet, 1, 13);
	     
	    driver.get(prop.getProperty("url"));
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		objExpenseCreate=new ExpenseCreation_Page(driver);
		objFromLogin1 = new LoginUser_Page(driver);
		objFromLogin1.maximizeWindow();
		
		//user logged in
		objFromLogin1.loginToGS1(UserName, Pwd);
		log.info("User logged in");
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		
		//expense report creation
		objExpenseCreate.enterKeywordSearchE(keywords);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		Thread.sleep(5000);
		objExpenseCreate.expenseReportCreation( purposefield,Description,Map);
		Thread.sleep(5000);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		objExpenseCreate.fieldsExpenseIner(DateE, Category, Amount);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		objExpenseCreate.verificationExpense();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		Thread.sleep(5000);
		Assert.assertTrue(driver.getPageSource().contains(purposefield));
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}

	@AfterTest 
	public void browserclose() {
	 driver =tearDown();
	}

	}

