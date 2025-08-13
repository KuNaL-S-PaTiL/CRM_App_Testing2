package Practise;

import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import POM_Repo.CampLookUpImgPage;
import POM_Repo.ContactLookUpImg;
import POM_Repo.CreateCampaignPage;
import POM_Repo.CreateContactPage;
import POM_Repo.Home_Page;
import POM_Repo.ValidationCampaignPage;
import POM_Repo.ValidationCreateContactPage;

public class CampaignAndContactRegionalRegressionTest extends Base_Class {
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
	
	ValidationCampaignPage vaildate = new ValidationCampaignPage(driver);
	vaildate.ValidateCamp(driver, CampName);
}
//---------------------------------------------------------------------------------
	@Test(groups="RegressionTest")
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
	 
	 ValidationCreateContactPage validation = new ValidationCreateContactPage(driver);
	 validation.validateContactCreated(driver, FN, LN);


}
}
