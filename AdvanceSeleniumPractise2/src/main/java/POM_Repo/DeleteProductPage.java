package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DeleteProductPage {

	public DeleteProductPage(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(css = "[value='Delete']")
	private WebElement DeleteButton;
	
	/**
	 * This method is used to delete product
	 * @param driver
	 * @param prdName
	 * @throws Throwable 
	 */
	public void clickOnProductCheckBox(WebDriver driver,String prdName) throws Throwable
	{
		Thread.sleep(3000);
		driver.findElement(By.xpath("//table[@class='lvt small']//a[text()='"+prdName+"']/../preceding-sibling::td[2]//input[@type=\"checkbox\"]")).click();
		
	}
	
	public void deleteProduct()
	{
		getDeleteButton().click();
	}

	public WebElement getDeleteButton() {
		return DeleteButton;
	}
}
