package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationOfCreateOrganization {

	public ValidationOfCreateOrganization(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateOrganizationIsCreated(WebDriver driver,String OrgName)
	{
		String actData = driver.findElement(By.xpath("//span[@id=\"dtlview_Organization Name\"]")).getText();
//		if(OrgName.contains(actData))
//		{
//			System.out.println("Organization is created");
//		}
//		else {
//			System.out.println("Orgaization is not created");
//		}
		Assert.assertEquals(actData, OrgName , "Orgaization is not created");
		System.out.println("Orgaization is created");
	}
}
