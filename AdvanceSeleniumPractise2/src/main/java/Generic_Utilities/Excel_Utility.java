package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Utility {

	/**
	 * This method is used to get data from Excel
	 * @param sheet
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws Throwable
	 */
	public String getExcelData(String sheet,int rowNum,int cellNum) throws Throwable
	{
		FileInputStream fis = new FileInputStream("../AdvanceSeleniumPractise/src/test/resources/ExcelData2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		 Cell data = book.getSheet(sheet).getRow(rowNum).getCell(cellNum);
		 DataFormatter format = new DataFormatter();
		 String actData = format.formatCellValue(data);
		 return actData;
		
	}
	
	public Object[][] getExcelDataByDataProvider(String sheetName) throws Throwable
	{
		FileInputStream fis = new FileInputStream("../AdvanceSeleniumPractise/src/test/resources/ExcelData2.xlsx");
		Workbook book = WorkbookFactory.create(fis); 
		Sheet sheet = book.getSheet(sheetName);
		int lastRow = sheet.getLastRowNum()+1;
		int lastCell = sheet.getRow(0).getLastCellNum();
		
		Object[][] objArr = new Object[lastRow][lastCell];
		
		for(int i=0;i<lastRow;i++)
		{
			for (int j = 0; j < lastCell; j++)
			{
				objArr[i][j]=sheet.getRow(i).getCell(j).toString();
			}
		}
		return objArr;
	}
}
