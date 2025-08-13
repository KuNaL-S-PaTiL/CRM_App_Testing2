package POM_Repo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class ValidationOfCreateContactWithOrg {

	public ValidationOfCreateContactWithOrg(WebDriver driver)
	{
		PageFactory.initElements(driver, this);
	}
	
	public void validateContactCreatedWithOrg(WebDriver driver,String OrgName,String LN,String FN)
	{
		  String OrgActData = driver.findElement(By.xpath("//a[@href=\"index.php?module=Accounts&action=DetailView&record=45\"]")).getText();
		  String FNactData = driver.findElement(By.xpath("//span[@id=\"dtlview_First Name\"]")).getText();
		  String LNactData = driver.findElement(By.xpath("//span[@id=\"dtlview_Last Name\"]")).getText();
		  
//		  if(OrgName.contains(OrgActData)&& LN.contains(LNactData)&&FN.contains(FNactData))
//		 {
//			 System.out.println("Contact is created with Organization");
//		 }
//		  else
//		  {
//				 System.out.println("Contact and Organization is not created");
//			 }
		  Assert.assertEquals(FN, FNactData , "Contact and Organization is not created");
			 Assert.assertEquals(LN, LNactData , "Contact and Organization is not created");
			 Assert.assertEquals(OrgName, OrgActData , "Contact and Organization is not created");
			 System.out.println("Contact is created with Organization");
	}
}
