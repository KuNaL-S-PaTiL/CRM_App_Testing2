package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationCreateCampaignWithProduct {

	public ValidationCreateCampaignWithProduct(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateCreateCampaignWithProduct(WebDriver driver,String campName)
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		 
//		 if(campName.contains(actData))
//		 {
//			 System.out.println("Campaign is created with product");
//		 }
//		 else
//		 {
//			 System.out.println("Campaign is not created with product");
//		 }
		Assert.assertEquals(actData, campName , "Campaign is not created with product");
		System.out.println("Campaign is created with product");
	}
}
