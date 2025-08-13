package TestNG_Practise;

import java.time.Duration;

import javax.swing.GroupLayout.ParallelGroup;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class DataProviderEx2 {

	@Test(dataProvider = "readContactData")
	
	public void createContact(String FirstName,String LastName) throws Throwable
	{
		
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.findElement(By.name("user_name")).sendKeys("admin");
		driver.findElement(By.name("user_password")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		driver.findElement(By.name("firstname")).sendKeys(FirstName);
		driver.findElement(By.name("lastname")).sendKeys(LastName);
		driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@src=\"themes/softed/images/user.PNG\"]")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
	}
	
	@DataProvider
	public Object[][] readContactData()
	{
		
		Object[][] objArr = new Object[3][2];
		objArr[0][0]="Kunal";
		objArr[0][1]="Patil";
		
		objArr[1][0]="Pranav";
		objArr[1][1]="Thite";
		
		objArr[2][0]="Pravin";
		objArr[2][1]="Solankar";
		
		
		return objArr;
		
	}
}
