package Generic_Utilities;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListnerImp implements ITestListener {

	
	public void onTestFailure(ITestResult result) {
		
		TakesScreenshot ts = (TakesScreenshot)Base_Class.sdriver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("../AdvanceSeleniumPractise/src/test/resources/FailedScript.png");
		try {
			FileUtils.copyFile(src, dest);
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
	}

}
