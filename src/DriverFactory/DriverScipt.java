package DriverFactory;


import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;


import CommonFunctionalLibrary.FunctionalLibrary;
import Utilites.ExcelFileUtil;
import Utilites.PropertiesFileUtil;

public class DriverScipt {
	
	Workbook wb;
	

	//static WebDriver driver = null;
	//ExcelFileUtil exel = new ExcelFileUtil();

	 
	public static void starttest(WebDriver driver,String Modules ) throws Throwable 
	{
			ExcelFileUtil excel = new ExcelFileUtil();
		//Sheet sheetname= wb.get(Modules);tShee
		int row_count= ExcelFileUtil.RowCount("Modules");
		for(int i=1; i<=row_count;i++)
		{
			if (ExcelFileUtil.getData("Modules", i, 2).equalsIgnoreCase("Y"))
			{
				
				String TCModule = ExcelFileUtil.getData("Modules", i, 1);
				int row_count1=ExcelFileUtil.RowCount(TCModule);
				for(int j=1; j<=row_count1;j++)
				{
					String description = ExcelFileUtil.getData(TCModule, j, 0);
					String Method = ExcelFileUtil.getData(TCModule, j,1);
					String Locator_Type=ExcelFileUtil.getData(TCModule, j, 2);
					String Locator_Value=ExcelFileUtil.getData(TCModule, j, 3);
					String data = ExcelFileUtil.getData(TCModule, j, 4);
					
					if (Method.equalsIgnoreCase("startBrowser"))
					{
						FunctionalLibrary.startBrowser(driver);
					
						
					}
					if(Method.equalsIgnoreCase("openURL"))
					{
					
						
						FunctionalLibrary.openURL(driver);
						
					}
					if(Method.equalsIgnoreCase("WaitForElement"))
					{
						
						FunctionalLibrary.WaitForElement(driver,Locator_Type, Locator_Value);
					}
					if(Method.equalsIgnoreCase("typeAction"))
					{
						System.out.println( description );
						FunctionalLibrary.TypeAction(driver, Locator_Type, Locator_Value, data);
					}
					if(Method.equalsIgnoreCase("clickAction"))
					{
						System.out.println( description);
						FunctionalLibrary.clickAction(driver, Locator_Type, Locator_Value);
					}
					if (Method.equalsIgnoreCase("TypeActionDrop"))
					{
						FunctionalLibrary.TypeActionDrop(driver,Locator_Type, Locator_Value, data);
					}
					
					if (Method.equalsIgnoreCase("VerifyingElement"))
					{
						FunctionalLibrary.VerifyingElement(driver,Locator_Type, Locator_Value, data);
					}
				}
				
			}
					
							
			
		}
		
		
	}

}
