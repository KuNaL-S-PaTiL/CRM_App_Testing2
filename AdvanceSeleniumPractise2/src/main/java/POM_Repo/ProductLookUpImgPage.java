package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductLookUpImgPage {

	public ProductLookUpImgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy (xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement PrdlookUpImg;

	public WebElement getPrdlookUpImg() {
		return PrdlookUpImg;
	}
	
	/**
	 * This method is used to click on Product look up image
	 */
	public void clickPrdLookUpImg()
	{
		getPrdlookUpImg().click();
	}
	
	
}
