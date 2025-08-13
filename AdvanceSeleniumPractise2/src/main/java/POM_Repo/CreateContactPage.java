package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Generic_Utilities.WebDriver_Utility;

public class CreateContactPage {

	public CreateContactPage (WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 
	 @FindBy(name = "firstname")
	 private WebElement firstName;
	 
	 @FindBy(name = "lastname")
	 private WebElement lastName;
	 
	 @FindBy(xpath = "//input[@title=\"Save [Alt+S]\"]")
	 private WebElement saveButton;

//		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
	 @FindBy(xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	 private WebElement AddOrgToContactButton;
	
	public WebElement getAddOrgToContactButton() {
		return AddOrgToContactButton;
	}

	public WebElement getFirstName() {
		return firstName;
	}

	public WebElement getLastName() {
		return lastName;
	}

	public WebElement getSaveButton() {
		return saveButton;
	}
	
	/**
	 * This method is used to select salutation
	 * @return 
	 */
	public void selectSalutation(WebDriver driver)
	{
		WebElement dropd = driver.findElement(By.name("salutationtype"));
		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.DropDownSelectByValue(driver, "Mr.", dropd);
	
	}
	/**
	 * This method is used to enter first name
	 * @param FN
	 */
	public void enterFirstName(String FN)
	{
		getFirstName().sendKeys(FN);
	}
	/**
	 * This method is used to enter last name
	 * @param LN
	 */
	public void enterLastName(String LN)
	{
		getLastName().sendKeys(LN);
	}
	
	/**
	 * This method is used used to save create contact details entered
	 */
	public void clickOnSaveButton()
	{
		getSaveButton().click();
	}
	
	/**
	 * This method is used to click on add organization button in create contact page
	 */
	public void clickOnAddOrgToContactButton()
	{
		getAddOrgToContactButton().click();
	}
	 
}
