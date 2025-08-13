package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateOrganizatonPage {

	public CreateOrganizatonPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
//	driver.findElement(By.name("accountname")).sendKeys(OrgName);
//
//	String PhoneNo = elib.getExcelData("Organization", 1, 0);
//	driver.findElement(By.name("phone")).sendKeys(PhoneNo);
//	
//	String Email = elib.getExcelData("Organization", 2, 0);
//	driver.findElement(By.name("email1")).sendKeys(Email);
//	
//	driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
	
	@FindBy(name = "accountname")
	private WebElement orgName;
	
	@FindBy(name = "phone")
	private WebElement phoneNo;
	
	@FindBy(name = "email1")
	private WebElement email;
	
	@FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement orgSaveButton;

	public WebElement getOrgName() {
		return orgName;
	}

	public WebElement getPhoneNo() {
		return phoneNo;
	}

	public WebElement getEmail() {
		return email;
	}

	public WebElement getOrgSaveButton() {
		return orgSaveButton;
	}
	/**
	 * This method is used to enter organization name
	 * @param orgname 
	 */
	public void enterOrgName(String orgname)
	{
		getOrgName().sendKeys(orgname);
	}
	/**
	 * This method is used to enter phone no.
	 */
	public void enterPhoneNo(String phoneno)
	{
		getPhoneNo().sendKeys(phoneno);
	}
	/**
	 * This method is used to enter email
	 */
	public void enterEmail(String email)
	{
		getEmail().sendKeys(email);
	}
	/**
	 * This method is used to click on save button
	 */
	public void clickOnOrgSaveButton()
	{
		getOrgSaveButton().click();
	}
}

