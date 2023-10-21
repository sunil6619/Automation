package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingbaba_pages.Button_page;


public class Button_Test extends Baselibrary {

	Button_page ob;
	@Parameters("env")
	@BeforeTest
	public void getlaunchurl_testingbaba(String env)
	{
		getlaunchurl(getreaddata(env));
		ob= new Button_page();
	}
	@Test (priority=1)
	public void clickonlements()
	{
		ob.clickonlements();
	}
	@Test (priority=2)
	public void clickonbuttons()
	{
		ob.clickonbuttons();
	}
	@Test (priority=3)
	public void performDoubleclick()
	{
		ob.performDoubleclick();
	}
}
