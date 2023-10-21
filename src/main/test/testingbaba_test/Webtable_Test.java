package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingbaba_pages.Webtable_pages;

public class Webtable_Test extends Baselibrary {

	Webtable_pages ob;
	@Parameters("env")
	@BeforeTest
	
		public void getLaunchUrl_testingbaba(String env)
		{
		getlaunchurl(getreaddata (env));
		ob=new Webtable_pages();	
}
	@Test(priority=1)
	public void clickonelements()
	{
		ob.clickonelements();
	}
	@Test (priority=2)
	public void clickonwebtable()
	{
		ob.clickonwebtable();
	}
	
	@Test (priority=3)
	public void filldetails()
	{
		ob.filldetails();
	}
	@Test (priority=4)
	public void editdetails()
	{
		ob.getedits();
	}
}

	
	
	

