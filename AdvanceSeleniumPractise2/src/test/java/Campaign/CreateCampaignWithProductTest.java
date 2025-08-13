package Campaign;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.Iterator;
import java.util.Properties;
import java.util.Random;
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
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.File_Utility;
import Generic_Utilities.Java_Utility;
import Generic_Utilities.WebDriver_Utility;
import POM_Repo.CampLookUpImgPage;
import POM_Repo.CreateCampaignPage;
import POM_Repo.CreateProductPage;
import POM_Repo.Home_Page;
import POM_Repo.Login_Page;
import POM_Repo.ProductLookUpImgPage;
import POM_Repo.ValidationCreateCampaignWithProduct;
import POM_Repo.WindowSwitchingPage;

//->Login to vtiger application
//->mouseOverOn more Link
//->click on campaigns
//->click on create campaign lookup image
//->Enter campaignName
//->Click on Product plus img-
//>Handle the PopUp
//->Product name should be added to campaign createpage
//->click on save Btn
//->verify whether the campaign name is created in campaign Information page and
//->Logout from the application. 



//branch2 --> Regression

// branch1 --> smoke

public class CreateCampaignWithProductTest extends Base_Class{
	@Test(groups="SmokeTest")
public void createCampaignTest() throws Throwable {

	//Create Product
	Home_Page home = new Home_Page(driver);
	home.clickProductLink();

	ProductLookUpImgPage lookup = new ProductLookUpImgPage(driver);
	lookup.clickPrdLookUpImg();
	
	//RanNum
	Java_Utility jlib = new Java_Utility();
	int ranNum = jlib.getRandomNumber();
	
	Excel_Utility elib = new Excel_Utility();
	String PrdName = elib.getExcelData("Product", 0, 0)+ranNum;

	CreateProductPage pro = new CreateProductPage(driver);
	pro.enterProductName(PrdName);
	pro.clickOnPrdSaveButton();
	
	home.clickCampLink();

	CampLookUpImgPage Img = new CampLookUpImgPage(driver);
	Img.clickLookUpImg();
	
	String campName = elib.getExcelData("Campaign", 0, 0)+ranNum;
	
	CreateCampaignPage camp = new CreateCampaignPage(driver);
	camp.enterCampName(campName);
	camp.clickOnAddProductImage();
	
	WebDriver_Utility wlib = new WebDriver_Utility();
	wlib.switchToWindow(driver, "Products&action");

	WindowSwitchingPage winSwitch = new WindowSwitchingPage(driver);
	winSwitch.enterPrdDetails(PrdName);
	winSwitch.enterPrdNameInCamp(driver, PrdName);
	
	wlib.switchToWindow(driver, "Campaigns&action");

	camp.clickOnSaveButton();

	ValidationCreateCampaignWithProduct validate = new ValidationCreateCampaignWithProduct(driver);
	validate.validateCreateCampaignWithProduct(driver, campName);
	
}
}
