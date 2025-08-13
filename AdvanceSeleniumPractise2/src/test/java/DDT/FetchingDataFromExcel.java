package DDT;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchingDataFromExcel {

	public static void main(String[] args) throws Throwable, IOException {
		FileInputStream fis = new FileInputStream("../AdvanceSeleniumPractise/src/test/resources/ExcelData2.xlsx");
		Workbook book = WorkbookFactory.create(fis);
		Sheet Sheet = book.getSheet("Sheet1");
		Row row = Sheet.getRow(1);
		Cell cell = row.getCell(2);
		String celldata = cell.getStringCellValue();
		System.out.println(celldata);
	}
}
