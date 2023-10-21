package testingbaba_pages;

import baselibrary.Baselibrary;

public class Login_page extends Baselibrary{
	
	
	public void getTitle_testingbaba()
	{
		String title=driver.getTitle();
		System.out.println(title);
	}

}
