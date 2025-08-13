package Product;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repo.CreateProductPage;
import POM_Repo.DeleteProductPage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ProductLookUpImgPage;
import POM_Repo.ValidationForCreateProductAndDeleteProduct;
import POM_Repo.ValidationOfCreateProduct;

//->Login to vtiger application
//->click on products link
//->click on create product lookup image
//->Enter product name
//->click on save Btn
//->verify whether the product is created in product Information page
//->click on product link->navigate to product table page 
//->select the product created checkbox
//->click on delete
//->Handle the Alert popup 


public class CreateProductAndDeleteProductTest extends Base_Class{

@Test
public void createProductAndDeleteProductTest() throws Throwable {

	Home_Page home = new Home_Page(driver);
	home.clickProductLink();
	
	ProductLookUpImgPage Img = new ProductLookUpImgPage(driver);
	Img.clickPrdLookUpImg();

	Java_Utility jlib = new Java_Utility();
	int ranNum = jlib.getRandomNumber();

	Excel_Utility elib = new Excel_Utility();
	String prdName = elib.getExcelData("Product", 0, 0)+ ranNum;

	CreateProductPage prd = new CreateProductPage(driver);
	prd.enterProductName(prdName);
	prd.clickOnPrdSaveButton();
	
	ValidationOfCreateProduct validate = new ValidationOfCreateProduct(driver);
	validate.validateProductCreated(driver, prdName);

	home.clickProductLink();

	DeleteProductPage del = new DeleteProductPage(driver);
	del.clickOnProductCheckBox(driver, prdName);
	del.deleteProduct();
	
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.acceptAlert(driver);
 	
	ValidationForCreateProductAndDeleteProduct validate1 = new ValidationForCreateProductAndDeleteProduct(driver);
	validate1.validateForProductIsDeleted(driver, prdName);
	
	Thread.sleep(5000);
}
}
