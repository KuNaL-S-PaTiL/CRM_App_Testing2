package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateCampaignPage {

	public CreateCampaignPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getCampName() {
		return campName;
	}

	public WebElement getSaveButton() {
		return SaveButton;
	}

	@FindBy (xpath = "//input[@name=\"campaignname\"]")
	private WebElement campName;
	
	@FindBy (xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement SaveButton;
	
//	driver.findElement(By.xpath("//img[@src=\"themes/softed/images/select.gif\"]")).click();
	@FindBy (xpath = "//img[@src=\"themes/softed/images/select.gif\"]")
	private WebElement addPrdImg;
	
	public WebElement getAddPrdImg() {
		return addPrdImg;
	}

	/**
	 * This method is used to click on Campaign Name
	 */
	public void enterCampName(String campName)
	{
		getCampName().sendKeys(campName);;
	}
	
	/**
	 * This method is used to click on Save Button 
	 */
	public void clickOnSaveButton()
	{
		getSaveButton().click();
	}
	
	/**
	 * This method is used to click on add product Image icon
	 */
	public void clickOnAddProductImage()
	{
		getAddPrdImg().click();
	}
}
