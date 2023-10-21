package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingbaba_pages.ToolTip_page;

public class ToolTip_Test extends Baselibrary{

	ToolTip_page ob;
	@Parameters ({"env","browsername"})
	@BeforeTest
	public void getlaunchurl_testingbaba (String env,String browsername)
	{
		getlaunchurl(getreaddata(env),browsername);
		ob=	new ToolTip_page();
	}
	
	@Test (priority=1)
	public void clickonwidgets()
	{
		ob.clickonwidgets();
	}
	
	@Test (priority=2)
	public void clickontooltip()
	{
		ob.clickontooltips();
	}
	@Test (priority=3)
	public void clickongettooltip()
	{
		ob.mousehover();
	}
}
