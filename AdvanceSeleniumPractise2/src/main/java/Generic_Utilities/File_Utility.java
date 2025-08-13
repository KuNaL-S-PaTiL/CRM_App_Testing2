package Generic_Utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class File_Utility {

	/**
	 * This method is used to get key and value data from properties file
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String getKeyAndValue(String key) throws Throwable
	{
		FileInputStream fis = new FileInputStream("../AdvanceSeleniumPractise/src/test/resources/CommonData2.properties.txt");
		Properties pro = new Properties();
		pro.load(fis);
		String value = pro.getProperty(key);
		return value;
	}
}
