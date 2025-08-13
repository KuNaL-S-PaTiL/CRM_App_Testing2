package Generic_Utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import POM_Repo.Home_Page;
import POM_Repo.Login_Page;

public class Base_Class {
	public WebDriver driver;
	public static WebDriver sdriver;
	
	@BeforeSuite(groups = {"SmokeTest","RegressionTest"})
	public void BS()
	{
		System.out.println("Database Connection");
	}
	
	@BeforeTest(groups = {"SmokeTest","RegressionTest"})
	public void BT()
	{
		System.out.println("Paralle Execution");
	}
	
//	@Parameters("BROWSER")
	@BeforeClass(groups = {"SmokeTest","RegressionTest"})
//	public void BC(String BROWSER) throws Throwable
//	{
		public void BC() throws Throwable
		{
		
		File_Utility flib = new File_Utility();
		String BROWSER = flib.getKeyAndValue("browser");
		
		//maven/Jenkins command line...
//		String BROWSER = System.getProperty("browser");

		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver = new ChromeDriver();
		}
		else if (BROWSER.equalsIgnoreCase("firefox"))
		{
			driver = new FirefoxDriver();
		}
		else if(BROWSER.equalsIgnoreCase("edge"))
		{
			driver = new EdgeDriver();
		}
		else
		{
			driver = new ChromeDriver();
		}

		sdriver = driver;
		System.out.println("Launching " + BROWSER + " Browser");
	}
	
//	@Parameters({"URL","USERNAME","PASSWORD"})
	@BeforeMethod(groups = {"SmokeTest","RegressionTest"})
//	public void BM(String URL,String USERNAME,String PASSWORD) throws Throwable
//	{
	public void BM() throws Throwable
	{
		File_Utility flib = new File_Utility();
		String URL = flib.getKeyAndValue("url");
		String USERNAME = flib.getKeyAndValue("username");
		String PASSWORD = flib.getKeyAndValue("password");
		
		//maven command line...
//		String URL = System.getProperty("url");
//		String USERNAME = System.getProperty("username");
//		String PASSWORD = System.getProperty("password");
		
		driver.get(URL);

		WebDriver_Utility wlib = new WebDriver_Utility();
		wlib.maximizeWindow(driver);
		wlib.waitForElimentsToLoad(driver);

		Login_Page login = new Login_Page(driver);
		login.loginToApp(USERNAME, PASSWORD);
		System.out.println("Login To App");
	}
	
	@AfterMethod(groups = {"SmokeTest","RegressionTest"})
	public void AM()
	{
		Home_Page home = new Home_Page(driver);
		home.logoutFromApp();
		System.out.println("Logout from App");
	}
	
	@AfterClass(groups = {"SmokeTest","RegressionTest"})
	public void AC()
	{
		driver.quit();
		System.out.println("Closing Browser");
	}
	
	@AfterTest(groups = {"SmokeTest","RegressionTest"})
	public void AT()
	{
		System.out.println("Paraller Execution close");
	}
	
	@AfterSuite(groups = {"SmokeTest","RegressionTest"})
	public void AS()
	{
		System.out.println("Close Database Connection");
	}
}
