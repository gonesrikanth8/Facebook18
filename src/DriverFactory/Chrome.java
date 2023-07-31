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
import io.github.bonigarcia.wdm.WebDriverManager;

public class Chrome {
		
	public   WebDriver driver1;
	// TODO Auto-generated method stub
	
@Test
public void SignUpTest ()
{
	

	System.out.println("SignUpTest from ChromeClass"+""+Thread.currentThread().getId());
 
			try {
				String Modules = "Modules";
				DriverScipt.starttest(driver1, Modules);
			} catch (Throwable e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}


@BeforeTest
public void LaunchBrowser () throws Throwable
{
	
	System.out.println("LaunchBrowser from ChromeClass"  +""+Thread.currentThread().getId());
	String URL = PropertiesFileUtil.getValueForKey("URL");
	  
	      System.out.println(" Executing on FireFox");
	      WebDriverManager.firefoxdriver().setup();
	       driver1 = new FirefoxDriver();
	      driver1.get(URL);
	      driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	      driver1.manage().window().maximize();
 }

//@AfterTest
//public void closeBrowser () throws Throwable
//{
//	
//	System.out.println("Closing the Browser Chrome");
//	FunctionalLibrary.closeBrowser(driver1);
//}
}

