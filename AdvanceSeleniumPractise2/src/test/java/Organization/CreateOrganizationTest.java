package Organization;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
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
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repo.CreateOrganizatonPage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.OrgLookUpImgPage;
import POM_Repo.ValidationOfCreateOrganization;

//Login to vtiger application
//->click on organizations link
//->click on create organization lookup image
//->Enter organisation name,phone number and email
//->click on save Btn
//->verify whether the organization is created in Organization Information page 
//-->and Logout from the application. 


public class CreateOrganizationTest extends Base_Class{
	@Test(groups={"RegressionTest","SmokeTest"})
public void createOrganizationTest() throws Throwable {
	
	Home_Page home = new Home_Page(driver);
	home.clickOrgLink();

	OrgLookUpImgPage Img = new OrgLookUpImgPage(driver);
	Img.clickOnOrgLookUpImg();
	
	Java_Utility jlib = new Java_Utility();
	int ranNum = jlib.getRandomNumber();
	
	Excel_Utility elib = new Excel_Utility();
	String OrgName = elib.getExcelData("Organization", 0, 0)+ranNum;

	CreateOrganizatonPage org = new CreateOrganizatonPage(driver);
	org.enterOrgName(OrgName);
	
	String PhoneNo = elib.getExcelData("Organization", 1, 0);
	org.enterPhoneNo(PhoneNo);
	
	String Email = elib.getExcelData("Organization", 2, 0);
	org.enterEmail(Email);
	
	org.clickOnOrgSaveButton();
	
	ValidationOfCreateOrganization validate = new ValidationOfCreateOrganization(driver);
	validate.validateOrganizationIsCreated(driver, OrgName);	
}
}
