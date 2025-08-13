package Contact;

import java.io.FileInputStream;
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
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repo.ContactLookUpImg;
import POM_Repo.CreateContactPage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ValidationCreateContactPage;

//@Listeners(Generic_Utilities.ListnerImp.class)
public class CreateContactTest extends Base_Class{
	@Test(retryAnalyzer = Generic_Utilities.RetryAnalyserImp.class)
public void createContactTest() throws Throwable {
	 
	 Home_Page home = new Home_Page(driver);
	 home.clickContactLink();
 
	 ContactLookUpImg img = new ContactLookUpImg(driver);
	 img.clickOnContactLookUpImg();
	 
	 CreateContactPage con = new CreateContactPage(driver);
	 con.selectSalutation(driver);
	 
	 Excel_Utility elib = new Excel_Utility();
	 String FN = elib.getExcelData("Contact", 0, 0);
	 String LN = elib.getExcelData("Contact", 1, 0);

	 con.enterFirstName(FN);
	 con.enterLastName(LN);
	 con.clickOnSaveButton();
	 
	// Assert.fail();
	 ValidationCreateContactPage validation = new ValidationCreateContactPage(driver);
	 validation.validateContactCreated(driver, FN, LN);


}
}
