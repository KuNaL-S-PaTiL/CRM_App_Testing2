package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateProductPage {

	public CreateProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public WebElement getProductName() {
		return productName;
	}

	public WebElement getPrdSaveButton() {
		return prdSaveButton;
	}

	@FindBy (name = "productname")
	private WebElement productName;
	
	@FindBy (xpath = "//input[@title=\"Save [Alt+S]\"]")
	private WebElement prdSaveButton;
	
	/**
	 * This method is used to enter product name
	 * @param ProdName
	 */
	public void enterProductName(String ProdName)
	{
		getProductName().sendKeys(ProdName);
	}
	
	/**
	 * This method is used to click on Save Button(in create Product Page)
	 */
	public void clickOnPrdSaveButton()
	{
		getPrdSaveButton().click();
	}
	
	
}
