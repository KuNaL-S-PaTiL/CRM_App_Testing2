package Practise;

import org.testng.Assert;
import org.testng.annotations.Test;

public class HardAssertEx {

	@Test
	public void m1()
	{
		System.out.println("Step1");
		System.out.println("Step2");
		Assert.assertEquals("A", "B");
		System.out.println("Step3");
		System.out.println("Step4");
	}
	
	@Test
	public void m2()
	{
		String ActData = "Kunal";
		String ExpData = "Kunal";
		Assert.assertEquals(ActData, ExpData);
	}
	
	
	@Test
	public void m3()
	{
		String actData = "Kunal";
		String expData = "Kunal";
		Assert.assertEquals(actData, expData, "Assert Fail");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m4()
	{
		 int a =10;
		int b =20;
		Assert.assertEquals(a, b, "Assert Fail");
		System.out.println("Assert Pass");
	}
	
	@Test
	public void m5()
	{
		int a = 10;
		int b = 10;
		Assert.assertNotEquals(a, b, "Assert Equals");
		System.out.println("Assert Not Equals");
		
	}
	@Test
	public void m6()
	{
		int a = 10;
		int b = 20;
		Assert.assertNotEquals(a, b, "Assert Equals");
		System.out.println("Assert Not Equals");
	}
		@Test
		public void m7()
		{
			String actData = "Patil";
			String exptData = "Patil";
			Assert.assertTrue(actData.equals(exptData), "Assert Fail");
			System.out.println("Assert Pass");
			
		}
		
		@Test
		public void m8()
		{
			String actData = "Patil";
			String exptData = "PatiL";
			Assert.assertTrue(actData.equals(exptData), "Assert Fail");
			System.out.println("Assert Pass");	
		}
		
		@Test
		public void m9()
		{
			String expData = "Welcome";
			String actData = "Welcome";
			Assert.assertFalse(expData.equals(actData), "Assert False");
			System.out.println("Assert True");
			
		}
		
		@Test
		public void m10()
		{
			String expData = "Welcome";
			String actData = "Welcome ";
			Assert.assertFalse(expData.equals(actData), "Assert False");
			System.out.println("Assert True");
		}
		
		@Test
		public void m11()
		{
			Object s = null;
			Assert.assertNull(s, "Assert FAIL");
			System.out.println("Assert PASS");
		}
		
		@Test
		public void m12()
		{
			String s = "kp";
			Assert.assertNull(s, "Assert FAIL");
			System.out.println("Assert PASS");
		}
		
		@Test
		public void m13()
		{
			Object s = null;
			Assert.assertNotNull(s, "Assert FAIL");
			System.out.println("Assert PASS");
		}
		
		@Test
		public void m14()
		{
			String s = "KSP";
			Assert.assertNotNull(s, "Assert FAIL");
			System.out.println("Assert PASS");
		}
		
		
		@Test
		public void m15()
		{
			String exp = "KSP";
			String act = "KSP";
			Assert.assertSame(act, exp, "Assert FAIL");
			System.out.println("Assert PASS");
		}
		
		@Test
		public void m16()
		{
			String exp = "KSP";
			String act = "KSP ";
			Assert.assertSame(act, exp, "Assert FAIL");
			System.out.println("Assert PASS");
		}
		
		@Test
		public void m17()
		{
			String exp = "KSP";
			String act = "KSP ";
			Assert.assertNotSame(act, exp, "Assert FAIL");
			System.out.println("Assert PASS");
		}
		
		
		@Test
		public void m18()
		{
			String exp = "KSP";
			String act = "KSP";
			Assert.assertNotSame(act, exp, "Assert FAIL");
			System.out.println("Assert PASS");
		}
		
		@Test
		public void m19()
		{
			Assert.fail("I am failing this script");
		}
}


