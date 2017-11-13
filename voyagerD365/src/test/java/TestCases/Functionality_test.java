package TestCases;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.TakesScreenshot;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Functionality_test {
	protected static WebDriver driver; 
	public static Properties prop;
	String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(Calendar.getInstance().getTime());
	
	public static WebDriver setUp() throws IOException{ 
		
		prop= new Properties();
		FileInputStream fis=new FileInputStream("C:\\Users\\AM01\\voyagerD365\\src\\test\\resources\\TestData\\data.properties");
		prop.load(fis);
		String browserName=prop.getProperty("browser");
		System.out.println(browserName);
	
		if(browserName.equalsIgnoreCase("chrome"))
		{
			// System.setProperty("webdriver.chrome.driver", "C://chromedriver.exe");
			driver= new ChromeDriver();
				//execute in chrome driver
		}
		else if (browserName.equalsIgnoreCase("firefox"))
		{
			 driver= new FirefoxDriver();
			//firefox code
		}
		else if (browserName.equalsIgnoreCase("IE"))
		{
			driver = new InternetExplorerDriver();
		}

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		return driver;

	} 
	
	
	
	public void getScreenshot(String result) throws IOException
	{
		File src=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src, new File("C://screen//"+result+"_"+timeStamp+"//screenshot.png"));        
	
	}
	
	public static WebDriver tearDown(){ 
		driver.manage().timeouts().implicitlyWait(2, TimeUnit.MINUTES);
		driver.close(); 
		return driver;
}
}
	

