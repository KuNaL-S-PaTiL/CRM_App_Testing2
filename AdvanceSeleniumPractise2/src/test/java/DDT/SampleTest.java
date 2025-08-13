package DDT;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import POM_Repo.LoginPage1;
import POM_Repo.LoginPage2;

public class SampleTest {

	public static void main(String[] args) {
		WebDriver driver = new ChromeDriver();
		driver.get("http://localhost:8888/");
		driver.manage().window().maximize();
		LoginPage1 login = new LoginPage1(driver);
//		login.loginToApp("admin", "admin");
		
//		login.enterUserName("admin");
//		login.enterPassword("admin");
//		login.clickLoginButton();

		LoginPage2 log = new LoginPage2(driver);
		log.loginToVtigerApp("admin","admin");
	}
}
