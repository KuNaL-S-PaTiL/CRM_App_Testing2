package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrgLookUpImgPage {

	public OrgLookUpImgPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}

	public WebElement getOrgLookUpImg() {
		return orgLookUpImg;
	}

	@FindBy(xpath = "//img[@src=\"themes/softed/images/btnL3Add.gif\"]")
	private WebElement orgLookUpImg;
	
	public void clickOnOrgLookUpImg()
	{
		getOrgLookUpImg().click();
	}
}
