package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingbaba_pages.Textbox_page;


public class Textbox_test extends Baselibrary{
	
	
	Textbox_page ob;
	@Parameters("env")
	@BeforeTest
	public void getLaunchUrl_testingbaba(String env)
	{
		getlaunchurl(getreaddata(env));
		ob=new Textbox_page();
	}
private void getlaunchurl(String getreaddata) {
		// TODO Auto-generated method stub
		
	}
@Test()
public void clickonelements()
{
	ob.clickonelements(); 	
}


