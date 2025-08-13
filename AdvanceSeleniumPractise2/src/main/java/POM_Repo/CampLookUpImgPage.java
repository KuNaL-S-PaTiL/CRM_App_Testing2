package POM_Repo;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CampLookUpImgPage {
	
	public CampLookUpImgPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath = "//img[@src='themes/softed/images/btnL3Add.gif']")
	private WebElement lookUpImg;
	
	public WebElement getLookUpImg() {
		return lookUpImg;
	}
	
	/**
	 * This method is used to click on Look Up Image
	 */
	public void clickLookUpImg()
	{
		getLookUpImg().click();
	}
}
