package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationCampaignPage {

	public ValidationCampaignPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	public void ValidateCamp(WebDriver driver,String CampName)
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Campaign Name\"]")).getText();
		
//		if(CampName.equals(actData))
//		{
//			System.out.println("Campaign is created");
//		}
//		else
//		{
//			System.out.println("Campaign is not created");
//		}

		Assert.assertEquals(actData, CampName , "Campaign is not created");
		System.out.println("Campaign is created");
	}
}
