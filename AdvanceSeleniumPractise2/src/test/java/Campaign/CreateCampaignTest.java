package Campaign;

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
import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repo.CampLookUpImgPage;
import POM_Repo.CreateCampaignPage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ValidationCampaignPage;

// kjdlksjck

//Login to vtiger application
//->mouseOverOn more Link
//->click on campaigns
//->click on create campaign lookup image
//->Enter campaignName
//->click on save Btn
//->verify whether the campaign is created in campaign Information page 
//->and Logout from the application. 

//@Listeners(Generic_Utilities.ListnerImp.class)

//@Listeners(Generic_Utilities.ExtentReportImp.class)

// I am Pulling pull1
// pushBack
// Pull2

//Pushed Final code

public class CreateCampaignTest extends Base_Class {
	@Test(groups="SmokeTest")
public void createCampaignTest() throws Throwable {
	
	Home_Page home = new Home_Page(driver);
	home.clickCampLink();
	
	CampLookUpImgPage Img = new CampLookUpImgPage(driver);
	Img.clickLookUpImg();
	
	Excel_Utility elib = new Excel_Utility();
	String CampName = elib.getExcelData("Campaign", 0, 0);
	
	CreateCampaignPage camp = new CreateCampaignPage(driver);
	camp.enterCampName(CampName);
	camp.clickOnSaveButton();
	
	//Assert.fail("I am failing this Campaign Script");
	
	ValidationCampaignPage vaildate = new ValidationCampaignPage(driver);
	vaildate.ValidateCamp(driver, CampName);
	
	

}
	@Test 
	public void m2()
	{
		System.out.println("Hello KP");
	}
}
