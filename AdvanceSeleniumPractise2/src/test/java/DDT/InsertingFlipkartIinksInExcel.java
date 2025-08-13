package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class InsertingFlipkartIinksInExcel {
public static void main(String[] args) throws Throwable {
	
	FileInputStream fis = new FileInputStream("../AdvanceSeleniumPractise/src/test/resources/InsertDataInExcel.xlsx");
	Workbook book = WorkbookFactory.create(fis);
	Sheet sheet = book.getSheet("Sheet1");
	WebDriver driver = new ChromeDriver();
	driver.get("https://www.flipkart.com/");
    List<WebElement> links = driver.findElements(By.xpath("//a"));
    for (int i = 0; i<links.size(); i++) {
    	
    	@Nullable
		String link = links.get(i).getAttribute("href");
    	Row row = sheet.createRow(i);
    	Cell cell = row.createCell(0);
    	cell.setCellValue(link);
    	System.out.println(link);
		
	}
    FileOutputStream fos = new FileOutputStream("../AdvanceSeleniumPractise/src/test/resources/InsertDataInExcel.xlsx");
    book.write(fos);
    book.close();
    driver.close();
}
}
