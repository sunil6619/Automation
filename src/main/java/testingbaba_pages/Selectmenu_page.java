package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class Selectmenu_page extends Baselibrary {

	public void Selectmenu_page ()
	{
		PageFactory.initElements(driver,this);

	}
	@FindBy (xpath="//*[@data-target=\"#widget\"]")
	private WebElement widgets;
	@FindBy (xpath="//*[text()='select menu']")
	private WebElement selectmenu;
	@FindBy (xpath="//*[text()='Select Value']")
	 private WebElement selectbyvalue;
	
	public void clickonwidgets()
	{
		clickme(widgets);
	}
	
	public void clikconselectmenu()
	{
		clickme(selectmenu);
	}
	public void selectmenu()
	{
		selectbyvalue1(selectbyvalue,"Group 1, Option 2");
	}
}

