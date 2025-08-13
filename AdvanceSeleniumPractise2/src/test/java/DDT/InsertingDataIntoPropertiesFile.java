package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.google.j2objc.annotations.Property;

public class InsertingDataIntoPropertiesFile {
public static void main(String[] args) throws Throwable {
	FileInputStream fis = new FileInputStream("../AdvanceSeleniumPractise/src/test/resources/InsertCommonData.properties.txt");
	
	Properties pro = new Properties();
	pro.load(fis);
	pro.setProperty("browser", "firefox");
	pro.setProperty("url", "http://localhost:8888/index.php?action=index&module=Home");
	pro.setProperty("username", "admin");
	pro.setProperty("password", "admin");
	
	FileOutputStream fos = new FileOutputStream("../AdvanceSeleniumPractise/src/test/resources/InsertCommonData.properties.txt");
	pro.store(fos, "common data");
	
	String BROWSER = pro.getProperty("browser");
	String URL = pro.getProperty("url");
	String USERNAME = pro.getProperty("username");
	String PASSWORD = pro.getProperty("password");
	
	WebDriver driver;
	if(BROWSER.equalsIgnoreCase("chrome"))
	{
		driver = new ChromeDriver();
	}
	else if(BROWSER.equalsIgnoreCase("firefox"))
	{
		driver = new FirefoxDriver();
	}
	
	else if (BROWSER.equalsIgnoreCase("edge"))
	{
		driver = new EdgeDriver();
	}
	else
	{
		driver = new ChromeDriver();
	}
	
	Thread.sleep(2000);
	driver.manage().window().maximize();
	Thread.sleep(2000);
	driver.get(URL);
	Thread.sleep(2000);
	driver.findElement(By.name("user_name")).sendKeys(USERNAME);
	Thread.sleep(2000);
	driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
	Thread.sleep(2000);
	driver.findElement(By.id("submitButton")).click();
	Thread.sleep(2000);
	driver.close();
}
}
