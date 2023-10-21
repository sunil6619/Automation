package testingbaba_test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingbaba_pages.Selectmenu_page;

public class Selectmenu_test extends Baselibrary {

	Selectmenu_page ob;
	@Parameters ("env")
	@BeforeTest
	public void getlaunchurl_testingbaba()
	{
		getlaunchurl(getreaddata("env"));
		ob.Selectmenu_page();
	}
	@Test (priority=1)
	
	public void clickonwidgets() {
		ob.clickonwidgets();
	}
	@Test (priority=2)
	public void clickonselectmenu()
	{
		ob.clikconselectmenu();
	}
	@Test (priority=3)
	public void clikconselectmenu()
	{
		ob.selectmenu();
	}
}

