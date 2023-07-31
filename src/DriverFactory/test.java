package DriverFactory;

import java.util.concurrent.TimeUnit;

import Utilites.PropertiesFileUtil;

import org.apache.poi.sl.usermodel.Sheet;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import CommonFunctionalLibrary.FunctionalLibrary;
import Utilites.PropertiesFileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class test {
		
	public   WebDriver driver;
		// TODO Auto-generated method stub
@Test
public void SignUpTest ()
{
	

	System.out.println("SignUpTest from TestClass "+""+Thread.currentThread().getId());
 
			try {
				String Modules = "Modules";
				DriverScipt.starttest(driver, Modules);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}



/*@Parameters("browser")
@BeforeTest
public void launchapp(String browser) throws Throwable {


	System.out.println("Launching" +""+Thread.currentThread().getId());
	String URL = PropertiesFileUtil.getValueForKey("URL");
   if (browser.equalsIgnoreCase("firefox")) {
      System.out.println(" Executing on FireFox");
      WebDriverManager.firefoxdriver().setup();
       driver = new FirefoxDriver();
      driver.get(URL);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
   } else if (browser.equalsIgnoreCase("chrome")) {
	   WebDriverManager.chromedriver().setup();
	 
      System.out.println(" Executing on CHROME");
       driver = new ChromeDriver();
      driver.get(URL);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
   } else if (browser.equalsIgnoreCase("ie")) {
      System.out.println("Executing on IE");
      System.setProperty("webdriver.ie.driver", "D:\\IEDriverServer.exe");
      WebDriverManager.iedriver().setup();
      
      driver.get(URL);
      driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
      driver.manage().window().maximize();
   } else {
      throw new IllegalArgumentException("The Browser Type is Undefined");
   }
} */

@BeforeTest
public void LaunchBrowser () throws Throwable
{
	
	System.out.println("LaunchBrowser from Test class"+""+Thread.currentThread().getId());
	
	WebDriverManager.chromedriver().setup();
	String URL = PropertiesFileUtil.getValueForKey("URL");
    System.out.println(" Executing on CHROME Through Testclass");
     driver = new ChromeDriver();
    driver.get(URL);
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().window().maximize();
 }


//@AfterTest
//public void closeBrowser () throws Throwable
//{
//	System.out.println("Closing the Browser Chrome");
//	FunctionalLibrary.closeBrowser(driver);
//}
}

