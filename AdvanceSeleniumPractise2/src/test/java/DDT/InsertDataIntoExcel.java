package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataIntoExcel {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("../AdvanceSeleniumPractise/src/test/resources/ExcelData2.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet("Sheet1");
	Row row = sheet.createRow(0);
	Cell cell = row.createCell(0);
	cell.setCellValue("Patil");
	
	FileOutputStream fos = new FileOutputStream("../AdvanceSeleniumPractise/src/test/resources/ExcelData2.xlsx");
	book.write(fos);
	book.close();
	
	
}
}
