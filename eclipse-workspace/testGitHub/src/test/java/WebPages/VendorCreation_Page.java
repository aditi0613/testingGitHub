package WebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;



public class VendorCreation_Page {
WebDriver driver;
By searchD365O = By.id("NavigationSearchExpandableControl");
By keywordSearch = By.xpath("//input[@id='NavigationSearchBox_searchBoxInput_input']");
By newVendor = By.id("vendtablelistpage_3_SystemDefinedNewButton");
By vendorAccount = By.xpath("//input[@id='vendtablelistpage_3_Identification_AccountNum_input']");
By searchVenClick = By.xpath("//input[@id='vendtablelistpage_3_Org_NameAlias_input']");
By vendorGroup = By.xpath("//input[@id='vendtablelistpage_3_Posting_VendGroup_input']");
By vendorName = By.xpath("//input[@id='vendtablelistpage_3_Org_Name_input']");
By addressCaption = By.id("vendtablelistpage_3_TabAddress_caption");
By saveVendor = By.id("vendtablelistpage_2_SystemDefinedSaveButton_label");
By allVendorsLink = By.linkText("ALL VENDORS");
By filterVendor = By.xpath("//input[@id='vendtablelistpage_3_QuickFilterControl14_Input']");
By namecolumn = By.id("vendtablelistpage_3_VendTable_Name_2");
By namefield = By.id("__FilterField_VendTable_Name_Name_Input_0_0_input");
By textVendor = By.xpath("//input[@id='vendtablelistpage_3_VendTable_Name_input']");
By vendorNamedetails = By.id("DirPartyTable_5_HeaderTitle");


public VendorCreation_Page(WebDriver driver)
{
	this.driver=driver;
}

public void clickSearchIcon() {
	
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	driver.findElement(searchD365O).click();
}
public void clicknewVendor() {
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(newVendor).click();
}

public void setVendorAccount(String strVendorAccount)
{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(vendorAccount).sendKeys(strVendorAccount);
}

public void clickSearchVendor()
{
	
	driver.findElement(searchVenClick).click();
}

public void setVendorGroup(String strVendorGroup)
{
	driver.findElement(vendorGroup).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(vendorGroup).sendKeys(strVendorGroup);
}

public void clickAddressCaption()
{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(addressCaption).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	
}
public void setVendorName(String strVendorName)
{
	
	
	driver.findElement(vendorName).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(vendorName).sendKeys(strVendorName);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(vendorName).click();
}

public void clickSaveVendor() {
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(saveVendor).click();
}

public void namefilterVendor(String strfiltervendor) {
	//driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	//driver.findElement(filterVendor).click();
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(filterVendor).sendKeys(strfiltervendor);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(filterVendor).sendKeys(Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
}

public void clicksearchNameColumn()
{
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	driver.findElement(namecolumn).click();
}

public void clicnamefield()
{
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	driver.findElement(namefield).click();
}

public void enternamefield(String strNameColumn)
{
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	driver.findElement(namefield).sendKeys(strNameColumn);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
}

public void entersearchNameColumn()
{
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	driver.findElement(namefield).sendKeys(Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(keywordSearch).sendKeys(Keys.ENTER);
}
public void allVendors()
{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(allVendorsLink).click();
}


public void enterSearch(String searchKey)
{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(keywordSearch).sendKeys(searchKey);
}
public void pressEnter()
{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	driver.findElement(keywordSearch).sendKeys(Keys.ENTER);
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
}

public void enterVendorNamelink()
{
	
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	driver.findElement(textVendor).click();
	driver.manage().timeouts().implicitlyWait(3, TimeUnit.MINUTES);
	//driver.findElement(textVendor).click();
	
}
public void enterKeywordSearch(String searchKey)
{
	
	this.clickSearchIcon();
	this.enterSearch(searchKey);
	this.pressEnter();
}
public String getVendorName()
{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	return driver.findElement(vendorNamedetails).getText();
}

public void waitforall()
{
	driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
}
public void goback()
{
	driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	driver.navigate().back();
}
public void createNewVendor(String strVendorAccount, String strVendorGroup, String strVendorName)
//public void createNewVendor(String strNameColumn)
{
	this.clicknewVendor();
	this.setVendorAccount(strVendorAccount);
	this.clickSearchVendor();
	this.setVendorGroup(strVendorGroup);
	this.setVendorName(strVendorName);
	this.clickAddressCaption();
	//this.clickSaveVendor();

	
}
 public void searchvendorname(String searchKey)
 {
	 
	 this.waitforall();
	 this.clickSearchIcon();
		this.enterSearch(searchKey);
		this.pressEnter();
 }
public void verifyCreatedVendor() 
{
	
	
	this.waitforall();
	//this.namefilterVendor(strfiltervendor);
	
	this.goback();
	//this.clicksearchNameColumn();
	//this.clicnamefield();
	//this.enternamefield(strNameColumn);
	//this.entersearchNameColumn();
	
}
public void clickVendorNameDetails()
{
	this.waitforall();
	this.enterVendorNamelink();
}



}
