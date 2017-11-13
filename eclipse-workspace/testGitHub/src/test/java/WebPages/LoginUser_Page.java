package WebPages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginUser_Page {
	WebDriver driver;
	//string all elements of login page
	By userGS1Name = By.id("userNameInput");
	By passwordGS1 = By.id("passwordInput");
	By login = By.id("submitButton");
	By textonPage = By.id("NavBarDashboard_label");
	
	public LoginUser_Page(WebDriver driver)
	{
		this.driver=driver;
	}
//creating methods for each object
	public void clearField()
	{
		driver.findElement(userGS1Name).clear();
	}
	public void setUserName(String strUserName)
	{
		
		driver.findElement(userGS1Name).sendKeys(strUserName);
	}
	public void setPassword(String strPassword)
	{
		driver.findElement(passwordGS1).sendKeys(strPassword);
	}
	public void clickLogin() {
		driver.findElement(login).click();
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
	}

	public void maximizeWindow() {
		driver.manage().window().maximize();
	}
	
	// calling all methods in a single main method, this method will get called in the Test Case class
	public void loginToGS1(String strUserName, String strPassword)
	{
		this.clearField();
		this.setUserName(strUserName);
		this.setPassword(strPassword);
		this.clickLogin();
	}
	
	//storing text from the page for verification purpose
	public String getHeadingTitle() {
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		return driver.findElement(textonPage).getText();
	}
}
