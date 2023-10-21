package testingbaba_test;

import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import baselibrary.Baselibrary;
import testingbaba_pages.Upload_page;

public class Upload_Test extends Baselibrary{
	
	Upload_page ob;
	@Parameters ("env")
	@BeforeTest
	public void getlaunchurl_testingbaba(String env) {
		getlaunchurl(getreaddata(env));
		ob.Upload_page();
		}
@Test (priority=1)
	public void clickonelements()
	{
		ob.clickonelements();
	}
@Test (priority=2)
	public void clikconuploadfile()
	{
		ob.clickonuploadfile();
	}
@Test (priority=3)
	public void fileuploading() throws InterruptedException
	{
		ob.fileuploading();
	}
}

