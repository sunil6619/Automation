	 package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingbaba_pages.Login_page;

public class Login_test extends Baselibrary {
	
	Login_page ob;
	@Parameters("env")
	@BeforeTest
	public void getLaunchUrl_testingbaba(String env)
	{
		getlaunchurl(getreaddata(env));
		ob=new Login_page();
	}
@Test
public void gettitle()
{
	ob.getTitle_testingbaba();
}
}
