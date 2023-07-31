package CommonFunctionalLibrary;

import static org.testng.Assert.assertEquals;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import DriverFactory.DriverScipt;
import Utilites.PropertiesFileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class FunctionalLibrary {
	

	
	public static void openURL(WebDriver driver) throws Throwable
	{
	
		driver.get(PropertiesFileUtil.getValueForKey("URL"));
		driver.manage().window().maximize();
		System.out.println(PropertiesFileUtil.getValueForKey("URL") +" is Loaded");
		
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	Thread.sleep(5000);

	}
	
	public static void Screenshot(WebDriver driver, String fileWithPath ) throws IOException
	{

		TakesScreenshot scr = ((TakesScreenshot)driver);
		File F=scr.getScreenshotAs(OutputType.FILE);
		File DestFile=new File(fileWithPath);

        FileUtils.copyFile(F, DestFile);
	}
	
	
	public static void clickAction(WebDriver driver,String locator_Type, String locator_Value)
	{
		FunctionalLibrary.WaitForElement(driver,locator_Type, locator_Value);
		if(locator_Type.equalsIgnoreCase("id"))
		{
			//System.out.println("locator_Value");
			
		driver.findElement(By.id(locator_Value)).click();
		}
		
		else 
			if (locator_Type.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locator_Value)).click();
				System.out.println( locator_Value+" is clicked");
				
			}
	}
	
	public static void TypeAction(WebDriver driver, String locator_Type, String locator_Value, String Data)
	
	{
		FunctionalLibrary.WaitForElement(driver,locator_Type, locator_Value);
		//FunctionalLibrary.VerifyingElement(driver,locator_Type, locator_Value, Data);
	
		if (locator_Type.equalsIgnoreCase("id") )
		{
			driver.findElement(By.id(locator_Value)).clear();
			driver.findElement(By.id(locator_Value)).sendKeys(Data);
			System.out.println(locator_Value+" is entered with "+ Data);
		}
		else
			if(locator_Type.equalsIgnoreCase("xpath"))
			{
				driver.findElement(By.xpath(locator_Value)).clear();
				
				driver.findElement(By.xpath(locator_Value)).sendKeys(Data);
				System.out.println(locator_Value+" is entered with "+ Data);
				
			}
		  
		try {
			FunctionalLibrary.Screenshot(driver, "D:\\JavaSeleniumPlayground\\Facebook\\Screenshots\\Screenshot"+System.currentTimeMillis()+".png" );
			System.out.println("Scrrenshot");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
	}
	
	public static void TypeActionDrop (WebDriver driver, String locator_Type, String locator_Value, String value )
	{
		
		if ( locator_Type.equalsIgnoreCase("id"))
		{
		
		System.out.println("fdfd" + locator_Type  + " " + locator_Value + " " + value);
		Select aselect = new Select(driver.findElement(By.id(locator_Value)));
		aselect.selectByVisibleText(value);
		
		//((Select) driver.findElement(By.id(locator_Value))).selectByValue(value);
	}
		
		if ( locator_Type.equalsIgnoreCase("xpath"))
		{
		
		System.out.println("fdfd" + locator_Type  + " " + locator_Value + " " + value);
		Select aselect = new Select(driver.findElement(By.xpath(locator_Value)));
		aselect.selectByVisibleText(value);
		
		//((Select) driver.findElement(By.id(locator_Value))).selectByValue(value);
	}
	}
	
	
	 public static void VerifyingElement(WebDriver driver,String locator_Type, String locator_Value, String Data )
	 
	 {
		 System.out.println( driver.findElement(By.xpath(locator_Value)).getText().contentEquals(Data));
		// System.out.println( driver.findElement(By.xpath(locator_Value)).getText() + "  " +contentEquals(Data));
		Assert.assertTrue(((driver.findElement(By.xpath(locator_Value)).getText().equalsIgnoreCase(Data))));
			 }
	 
	 
	 
	public static void WaitForElement( WebDriver driver,String locator_Type, String locator_Value)
	{
	try {WebDriverWait wait = new WebDriverWait(driver, 30);
		if(locator_Type.equalsIgnoreCase("id"))
		{
			
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(locator_Value)));
		}
		
		if(locator_Type.equalsIgnoreCase("xpath"))
		{
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(locator_Value)));
		}
		System.out.println("Waiting... for"+ " "+ locator_Value);
	}
	catch (Exception e) {
		System.out.println(e);
	}
	}
	
	public static void closeBrowser(WebDriver driver)
	{
		driver.quit();
		driver.close();
	}
	

	
	public static void startBrowser(WebDriver driver)
	{
		try {
			if(PropertiesFileUtil.getValueForKey("Browser").equalsIgnoreCase("Chrome"))
			{
				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				System.out.println(PropertiesFileUtil.getValueForKey("Browser") +" is launched");
				//driver.get(PropertiesFileUtil.getValueForKey("URL"));
			//	driver.get("http://www.facebook.com");
			}
			else
			if (PropertiesFileUtil.getValueForKey("Browser").equalsIgnoreCase("Firefox"))
			{
				try {
				driver = new FirefoxDriver();
				}
				catch (Exception e)
				{
					System.out.println(e);
				}
								
			}
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		}

	}
	
	
	
	



