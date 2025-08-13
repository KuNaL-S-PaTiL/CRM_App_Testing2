package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ContactLookUpImg {

	public ContactLookUpImg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	 
	public WebElement getContactLookUpImg() {
		return contactLookUpImg;
	}

	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement contactLookUpImg;
	
	public void clickOnContactLookUpImg()
	{
		getContactLookUpImg().click();
	}
}
