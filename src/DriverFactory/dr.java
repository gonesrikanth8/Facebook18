package DriverFactory;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import Utilites.PropertiesFileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class dr {
	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		Date date = new Date();
		  DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
		   LocalDateTime now = LocalDateTime.now();
		   System.out.println(dtf.format(now));
		
		 
	       
        System.out.println("Current Time is : " + date);
 
        // set format in 12 hours
        SimpleDateFormat formatTime = new SimpleDateFormat("hhmmss");
        // hh = hours in 12hr format
        // mm = minutes
        // aa = am/pm
 
        String time = formatTime.format(
            date); // changing the format of 'date'
 
        // display time as per format
        System.out.println(
            "Current Time in AM/PM Format is : " + time);
    
//		String URL = PropertiesFileUtil.getValueForKey("URL");
//		 WebDriverManager.firefoxdriver().setup();
//	     WebDriver  driver1 = new FirefoxDriver();
//	      driver1.get(URL);
//	      driver1.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//	      driver1.manage().window().maximize();
//	      Scren(driver1, "D:\\JavaSeleniumPlayground\\Facebook\\Screenshots\\test.png");
}

	

public static void Scren(WebDriver driver, String fileWithPath) throws IOException
{
	TakesScreenshot scr = ((TakesScreenshot)driver);
	File F=scr.getScreenshotAs(OutputType.FILE);
	File DestFile=new File(fileWithPath);

    FileUtils.copyFile(F, DestFile);
    System.out.println("DOne");
}
	

}
