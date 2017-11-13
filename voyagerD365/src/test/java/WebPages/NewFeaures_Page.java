package WebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class NewFeaures_Page {
	WebDriver driver;
	By searchD365ON = By.id("NavigationSearchExpandableControl");
	By keywordSearchNew = By.xpath("//input[@id='NavigationSearchBox_searchBoxInput_input']");
	By fieldInputField = By.xpath("//input[@id='custtablelistpage_3_QuickFilterControl_Input_input']");
	By btnDelete = By.id("custtablelistpage_3_DeleteButton");
	By clickYes = By.id("SysBoxForm_4_Yes");

	public NewFeaures_Page(WebDriver driver)
	{
		this.driver=driver;
	}
public void clickSearchIconE() {
		
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(searchD365ON).click();
	}
	
	
	public void enterSearchE(String searchKey)
	{
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.findElement(keywordSearchNew).sendKeys(searchKey);
	}
	
	public void pressEnterE()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(keywordSearchNew).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	}

	public void enterKeywordSearchN(String searchKey)
	{
		this.clickSearchIconE();
		this.enterSearchE(searchKey);
		this.pressEnterE();
	}
	
	public void clickFilter(String strFilterText)
	{
		//driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		//driver.findElement(fieldInputField).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldInputField).sendKeys(strFilterText);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(fieldInputField).sendKeys(Keys.ENTER);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void clickDeleteBtn()
	{
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(btnDelete).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	
	public void clickYesAlert()
	{
		
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		driver.findElement(clickYes).click();
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}
	public void filterField(String strFilterText)
	{
	this.clickFilter(strFilterText);
	this.clickDeleteBtn();
	this.clickYesAlert();
	}
}
