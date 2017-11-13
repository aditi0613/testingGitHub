package WebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class FillExpenses_page {
	WebDriver driver;
	By searchD365OEx = By.id("NavigationSearchExpandableControl");
	By keywordSearchExpensex = By.xpath("//input[@id='NavigationSearchBox_searchBoxInput_input']");
	By openBtn = By.id("trvexprptlistpage_mylistpage_3_ExpenseLines");
	By btnNewExpense = By.id("TrvExpenses_5_AddExpenseGridView");
	By fielddateExpense = By.xpath("//input[@id='TrvExpenses_5_TrvExpTrans_TransDate_Grid_input']");
	By fieldExpenseCat = By.xpath("//input[@id='TrvExpenses_5_TrvExpTrans_CostType_Grid_input']");
	By fieldAmount = By.xpath("//input[@id='TrvExpenses_5_TrvExpTrans_AmountCurr_Grid_input']");
	By buttonOpen = By.id("trvexprptlistpage_mylistpage_3_ExpenseLines");
	
	public FillExpenses_page(WebDriver driver)
	{
		this.driver=driver;
	}
	
public void clickSearchIconEx() {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(searchD365OEx).click();
	}
	
	
	public void enterSearchEx(String searchKey)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(keywordSearchExpensex).sendKeys(searchKey);
	}
	
	public void pressEnterEx()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(keywordSearchExpensex).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	}
	
	public void clickbtnOpen()
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(openBtn).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	public void clickLinkExpense()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(btnNewExpense).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
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
	
	public void enterKeywordSearchEx(String searchKey)
	{
		this.clickSearchIconEx();
		this.enterSearchEx(searchKey);
		this.pressEnterEx();
	}
	
	
	public void waitAll()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void fillAllFieldss()
	{
		this.waitAll();
		this.clickbtnOpen();
		this.clickLinkExpense();
		
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
