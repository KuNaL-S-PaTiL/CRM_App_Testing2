package Contact;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Set;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repo.ContactLookUpImg;
import POM_Repo.CreateContactPage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ValidationOfCreateContactWithOrg;
import POM_Repo.WindowSwitchingPage;


public class CreateContactWithOrganizationTest extends Base_Class{
	@Test(groups="RegressionTest")
public void createContactWithOrganizationTest() throws Throwable {

	Home_Page home = new Home_Page(driver);
	home.clickContactLink();
	ContactLookUpImg Img = new ContactLookUpImg(driver);
	Img.clickOnContactLookUpImg();

	CreateContactPage con = new CreateContactPage(driver);
	con.selectSalutation(driver);

	Excel_Utility elib = new Excel_Utility();
	String FN = elib.getExcelData("Contact", 0, 0);
	String LN = elib.getExcelData("Contact", 1, 0);

	con.enterFirstName(FN);
	con.enterLastName(LN);
	con.clickOnAddOrgToContactButton();

//	Assert.fail("I am failing this Campaign Script");
	
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.switchToWindow(driver, "Accounts&action");

	String OrgName = elib.getExcelData("Organization", 0, 0);

	WindowSwitchingPage win = new WindowSwitchingPage(driver);
	win.enterOrgDetails(OrgName);
	win.enterOrgNameInContact();
	
	wlib.switchToWindow(driver, "Contacts&action");

	 con.clickOnSaveButton();
	 
	 ValidationOfCreateContactWithOrg validate = new ValidationOfCreateContactWithOrg(driver);
	 validate.validateContactCreatedWithOrg(driver, OrgName, LN, FN);
	  
//	  home.logoutFromApp();
}
}
