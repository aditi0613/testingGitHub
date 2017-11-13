package WebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class ExpenseCreation_Page {
	WebDriver driver;
	By searchD365OE = By.id("NavigationSearchExpandableControl");
	By keywordSearchExpense = By.xpath("//input[@id='NavigationSearchBox_searchBoxInput_input']");
	By btnNewExpenseReport = By.id("trvexprptlistpage_mylistpage_3_CreateCommandButton");
	By inputPurposefield = By.xpath("//input[@id='TrvExpenseReportDetails_4_TrvExpTable_Txt2_input']");
	By inputDescriptionfield = By.xpath("//textarea[@id='TrvExpenseReportDetails_4_TrvExpTable_Txt1_textArea']");
	By inputMapField = By.xpath("//input[@id='TrvExpenseReportDetails_4_MapTravelRequisition_input']");
	By btnOK = By.id("TrvExpenseReportDetails_4_OkButton");
	By fielddateExpense = By.xpath("//input[@id='TrvExpenses_5_TrvExpTrans_TransDate_Grid_input']");
	By fieldExpenseCat = By.xpath("//input[@id='TrvExpenses_5_TrvExpTrans_CostType_Grid_input']");
	By fieldAmount = By.xpath("//input[@id='TrvExpenses_5_TrvExpTrans_AmountCurr_Grid_input']");
	By buttonOpen = By.id("trvexprptlistpage_mylistpage_3_ExpenseLines");	
	
	public ExpenseCreation_Page(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void clickSearchIconE() {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(searchD365OE).click();
	}
	
	
	public void enterSearchE(String searchKey)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(keywordSearchExpense).sendKeys(searchKey);
	}
	
	public void pressEnterE()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(keywordSearchExpense).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	}

	public void enterKeywordSearchE(String searchKey)
	{
		this.clickSearchIconE();
		this.enterSearchE(searchKey);
		this.pressEnterE();
	}
	
	public void clickbtnNewExpenseReport()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(btnNewExpenseReport).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void expensePurpose(String strPurpose) {
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.switchTo().activeElement();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(inputPurposefield).sendKeys(strPurpose);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(inputPurposefield).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	public void enterDescriptionEx(String strdescExpense)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(inputDescriptionfield).sendKeys(strdescExpense);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(inputDescriptionfield).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void enterMapEx(String strMapex)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(inputMapField).sendKeys(strMapex);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void clickOkButton()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(btnOK).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void expenseReportCreation( String strPurpose, String strdescExpense, String strMapex)
	{
		
		this.clickbtnNewExpenseReport();
		this.expensePurpose(strPurpose);
		this.enterDescriptionEx(strdescExpense);
		this.enterMapEx(strMapex);
		this.clickOkButton();
	}
	
	public void enterExpenseDate(String strExpenseDate)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fielddateExpense).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fielddateExpense).sendKeys(strExpenseDate);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	public void enterExpenseCategory(String strExpenseCat)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldExpenseCat).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldExpenseCat).sendKeys(strExpenseCat);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void enterExpenseAmount(String strExpenseAmt)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldAmount).click();
		driver.findElement(fieldAmount).sendKeys(strExpenseAmt);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void clickOpenButton()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(buttonOpen).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void goBackExpense()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.navigate().back();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	}
	
	public void fieldsExpenseIner(String strExpenseDate, String strExpenseCat, String strExpenseAmt)
	{
		this.enterExpenseDate(strExpenseDate);
		this.enterExpenseCategory(strExpenseCat);
		this.enterExpenseAmount(strExpenseAmt);
	}
	
	public void verificationExpense()
	{
		this.clickOpenButton();	
	}

}
