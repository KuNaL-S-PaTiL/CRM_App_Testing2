package Practise;

import org.testng.annotations.Test;

import Generic_Utilities.Base_Class;
import Generic_Utilities.Excel_Utility;
import Generic_Utilities.Java_Utility;
import POM_Repo.CreateOrganizatonPage;
import POM_Repo.CreateProductPage;
import POM_Repo.Home_Page;
import POM_Repo.OrgLookUpImgPage;
import POM_Repo.ProductLookUpImgPage;
import POM_Repo.ValidationOfCreateOrganization;
import POM_Repo.ValidationOfCreateProduct;

public class OrganizationAndProductRegionalRegression extends Base_Class {

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
	//---------------------------------------------------------------------------------

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
