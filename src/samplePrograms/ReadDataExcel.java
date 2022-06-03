package samplePrograms;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;

 
public class ReadDataExcel
{

    HSSFWorkbook workbook;
    HSSFSheet sheet;
    HSSFCell cell;
    String currentWindow;
 
 
    public void ReadData() throws IOException
    {
    
	    // Import excel sheet.
        File src=new File("D:\\Ram_Office\\Selenium_Dump\\TestData.xls");
      
        // Load the file.
        FileInputStream finput = new FileInputStream(src);
      
        // Load the workbook.
        workbook = new HSSFWorkbook(finput);
      
        // Load the sheet in which data is stored.
        sheet= workbook.getSheetAt(0);
    
        for(int i=1; i<=sheet.getLastRowNum(); i++)
        {
           	// Import data for Email.
        	cell = sheet.getRow(i).getCell(1);
        	cell.setCellType(Cell.CELL_TYPE_STRING);
        	String username = cell.getStringCellValue();
        	System.out.println("Login Name      : " + username);
                  
        	// Import data for password.
        	cell = sheet.getRow(i).getCell(2);
        	cell.setCellType(Cell.CELL_TYPE_STRING);
        	String password = cell.getStringCellValue();
        	System.out.println("Login Password  : " + password);
        	System.out.println("-----------------------------------");
        	//login(username, password); >> Home Work
        }
    } // end of ReadData() method
 } // end of ReadDataExcel Class
 

