package WebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class CreateCustomer_page {
	WebDriver driver;
	By searchD365OC = By.id("NavigationSearchExpandableControl");
	By keywordSearchC = By.xpath("//input[@id='NavigationSearchBox_searchBoxInput_input']");
	By clickNewCustomer = By.id("custtablelistpage_3_NewCustomer");
	By fieldNameCustomer = By.id("dirpartyquickCreateForm_4_Org_Name_input");
	By fieldCustGroup = By.id("dirpartyquickCreateForm_4_DynamicDetail_CustGroup_input");
	By textCustomerName = By.id("custtablelistpage_3_HeaderTitle");

		
	public CreateCustomer_page(WebDriver driver)
	{
		this.driver=driver;
	}

	public void clickSearchIconC() {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(searchD365OC).click();
	}
	
	public void enterSearchC(String searchKey)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(keywordSearchC).sendKeys(searchKey);
	}
	public void pressEnterC()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(keywordSearchC).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	}
	
	public void clickLinkCustomer()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(clickNewCustomer).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void enterCustName(String strCustName)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldNameCustomer).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldNameCustomer).sendKeys(strCustName);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldNameCustomer).sendKeys(Keys.TAB);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	public void enterCustGroup(String strCustGroup)
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldCustGroup).sendKeys(strCustGroup);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldCustGroup).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldCustGroup).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		
	}
	
	public String getCustomerName()
	{
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		return driver.findElement(textCustomerName).getText();
	}
	public void enterKeywordSearchC(String searchKeyC)
	{
		
		this.clickSearchIconC();
		this.enterSearchC(searchKeyC);
		this.pressEnterC();
	}
	
	public void clickNewCustomerBtn()
	{
		this.clickLinkCustomer();
	}
	
	public void formFillCust(String strCustName, String strCustGroup)
	{
		this.enterCustName(strCustName);
		this.enterCustGroup(strCustGroup);
	}
}
