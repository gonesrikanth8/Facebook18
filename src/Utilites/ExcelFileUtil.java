package Utilites;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtil {
	
	static Workbook wb;
	
	public ExcelFileUtil() throws EncryptedDocumentException, InvalidFormatException, IOException
	{
		FileInputStream fis = new FileInputStream("D:\\JavaSeleniumPlayground\\Facebook\\DataFolder\\InputSheet.xlsx");
		wb = WorkbookFactory.create(fis);
				
	}
	
	public static int RowCount(String sheetname)
	{
		
		return  wb.getSheet(sheetname).getLastRowNum();
		 
	}
	
	public static int ColumnCount(String sheetname, int row)
	{
		return wb.getSheet(sheetname).getRow(row).getLastCellNum();
	}
	
	public static String getData(String sheetname, int row, int column)
	{
		String Data = " ";
		if(wb.getSheet(sheetname).getRow(row).getCell(column).getCellType()==Cell.CELL_TYPE_NUMERIC)
		{
			
			int celldata =  (int) wb.getSheet(sheetname).getRow(row).getCell(column).getNumericCellValue();
			Data = String.valueOf(celldata);
		}
		else 
			Data = wb.getSheet(sheetname).getRow(row).getCell(column).getStringCellValue();
		return Data;
	}
	
	

}
