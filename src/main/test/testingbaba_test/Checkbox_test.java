package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingbaba_pages.Checkbox_page;
import testingbaba_pages.Textbox_page;

public class Checkbox_test extends Baselibrary{

	Checkbox_page ob;
		
	@Parameters ({"env","browsername"})
	@BeforeTest
	public void getLaunchUrl_testingbaba(String env, String browsername)
	{
		getlaunchurl(getreaddata(env), browsername);
		ob=new Checkbox_page();
	}
	
	@Test(priority=0)
	public void clickonelements()
	{
		ob.clickonelements();
	}
	@Test(priority=1)
	public void clickoncheckbox()
	{
		ob.clickoncheckbox();
	}
	@Test(priority=2)
	public void clickonactions() throws InterruptedException
	{
		ob.clickonactions();
	}
	
	
	
	
}
