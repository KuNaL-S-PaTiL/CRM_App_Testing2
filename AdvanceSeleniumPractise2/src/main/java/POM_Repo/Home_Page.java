package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {

	//initialize elements
	public Home_Page(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	//elements declaration
	@FindBy (linkText = "More")
	private WebElement moreLink;
	
	@FindBy (linkText = "Campaigns")
	private WebElement campaignsLink;
	
	@FindBy (linkText = "Products")
	private WebElement productsLink;
	
	@FindBy (linkText = "Contacts")
	private WebElement contactsLink;
	
	@FindBy (linkText = "Organizations")
	private WebElement organizationLink;
	
	@FindBy(xpath = "//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdmLink;
	
	@FindBy (linkText = "Sign Out")
	private WebElement signOutLink;
	
	
	//getter methods
	public WebElement getMoreLink() {
		return moreLink;
	}
	public WebElement getCampaignsLink() {
		return campaignsLink;
	}
	public WebElement getProductsLink() {
		return productsLink;
	}
	public WebElement getContactsLink() {
		return contactsLink;
	}
	public WebElement getOrganizationLink() {
		return organizationLink;
	}
	public WebElement getAdmLink() {
		return AdmLink;
	}
	public WebElement getSignOutLink() {
		return signOutLink;
	}
	
	//business logic
	/**
	 * This method is used to click on Campaign Link
	 */
	public void clickCampLink()
	{
		getMoreLink().click();
		getCampaignsLink().click();
	}
	
	/**
	 * This method is used to click on Organization Link
	 */
	public void clickOrgLink()
	{
		getOrganizationLink().click();
	}
	/**
	 * This method is used to click on Product Link
	 */
	public void clickProductLink()
	{
		getProductsLink().click();
	}
	/**
	 * This method is used to click on Contact Link
	 */
	public void clickContactLink()
	{
		getContactsLink().click();
	}
	/**
	 * This method is used to Logout from Application
	 */
	public void logoutFromApp()
	{
		getAdmLink().click();
		getSignOutLink().click();
	}
	
	
	
	
}
