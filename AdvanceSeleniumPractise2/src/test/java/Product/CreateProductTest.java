package Product;

//Login to vtiger application
//->click on product link
//->click on create product lookup image
//->Enter product name
//->click on save Btn
//->verify whether the product is created in product Information page 
//->and Logout from the application.

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repo.CreateProductPage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ProductLookUpImgPage;
import POM_Repo.ValidationOfCreateProduct;


public class CreateProductTest extends Base_Class{

@Test
public void createProductTest() throws Throwable {
	
	Home_Page home = new Home_Page(driver);
	home.clickProductLink();
	
	ProductLookUpImgPage Img = new ProductLookUpImgPage(driver);
	Img.clickPrdLookUpImg();
	
	Excel_Utility elib = new Excel_Utility();
	String PrdName = elib.getExcelData("Product", 0, 0);
	
	CreateProductPage pro = new CreateProductPage(driver);
	pro.enterProductName(PrdName);
	pro.clickOnPrdSaveButton();
	
	   ValidationOfCreateProduct validate = new ValidationOfCreateProduct(driver);
	   validate.validateProductCreated(driver, PrdName);

}
}
