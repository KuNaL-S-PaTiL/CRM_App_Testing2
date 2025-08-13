package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class WindowSwitchingPage {

	public WindowSwitchingPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy(name = "search_text")
	private WebElement searchProduct;
	
	@FindBy(name = "search")
	private WebElement PrdsearchButton;

	
	@FindBy(name = "search_text")
	private WebElement OrgName;
	
	@FindBy(xpath = "//input[@name=\"search\"]")
	private WebElement OrgSearchButton;
	
	@FindBy(xpath = "(//a[@href=\"javascript:window.close();\"])[1]")
	private WebElement selectOrg;
	
	public WebElement getOrgName() {
		return OrgName;
	}



	public WebElement getOrgSearchButton() {
		return OrgSearchButton;
	}



	public WebElement getSelectOrg() {
		return selectOrg;
	}



	public WebElement getSearchProduct() {
		return searchProduct;
	}


	
	public WebElement getPrdsearchButton() {
		return PrdsearchButton;
	}



	/**
	 * This method is used to enter product name and search
	 * @param PrdName
	 */
	public void enterPrdDetails(String PrdName)
	{
		getSearchProduct().sendKeys(PrdName);
		getPrdsearchButton().click();
	}
	
	/**
	 * This method is used to select Product name and enter it 
	 * @param driver
	 * @param PrdName
	 */
	public void enterPrdNameInCamp(WebDriver driver, String PrdName)
	{
		driver.findElement(By.xpath("//a[text()='"+PrdName+"']")).click();
	}
	
	public void enterOrgDetails(String name) 
	{
		getOrgName().sendKeys(name);
		getOrgSearchButton().click();
		
	}
	
	public void enterOrgNameInContact()throws Throwable
	{
		Thread.sleep(3000);
		getSelectOrg().click();
	}
}
