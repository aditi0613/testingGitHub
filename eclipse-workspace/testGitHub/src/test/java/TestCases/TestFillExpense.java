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
import WebPages.FillExpenses_page;
import WebPages.LoginUser_Page;

public class TestFillExpense extends Functionality_test{
	public static Logger log =LogManager.getLogger(Functionality_test.class.getName());
	WebDriver driver;
	FillExpenses_page objFillExpense;
	LoginUser_Page objFromLogin2;
	
@BeforeClass
	public void browsersetUp() throws IOException {
		driver=setUp();
		log.info("Browser started");
	}

@Test
public void test_case_expense_fill()throws InterruptedException {
	
	 String xl = "C:/Users/AM01/Desktop/Automation/eclipse/data_sheet.xlsx";
     String Sheet = "Sheet1";

     //for login user
     String UserName=Excel.getCellValue(xl, Sheet, 1, 0);
     String Pwd=Excel.getCellValue(xl, Sheet, 1, 1);
     
     //for expense report creation
     String keywords= "Expense Reports";
     String DateE="11/8/2017";
     String Category="car rental";
     String Amount = "400";
     String purpose = "testing1";
     
     
     driver.get(prop.getProperty("url"));
	driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	objFillExpense=new FillExpenses_page(driver);
	objFromLogin2 = new LoginUser_Page(driver);
	objFromLogin2.maximizeWindow();
	//user logged in
	objFromLogin2.loginToGS1(UserName, Pwd);
	log.info("User logged in");
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	Thread.sleep(5000);
	objFillExpense.enterKeywordSearchEx(keywords);
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	Thread.sleep(5000);
	objFillExpense.fillAllFieldss();
	Thread.sleep(5000);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	objFillExpense.fieldsExpenseIner(DateE, Category, Amount);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	driver.navigate().back();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	objFillExpense.verificationExpense();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	Thread.sleep(5000);
	Assert.assertTrue(driver.getPageSource().contains(purpose));
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
}


}
