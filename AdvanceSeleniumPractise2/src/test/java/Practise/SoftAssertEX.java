package Practise;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class SoftAssertEX {

	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		SoftAssert s = new SoftAssert();
		s.assertEquals(true, false);
		System.out.println("Step3");
		System.out.println("Step4");
		s.assertAll();
		
	}
}
