package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class Button_page extends Baselibrary{

	public Button_page()
	{
		PageFactory.initElements(driver,this);
	}
	@FindBy(xpath ="//*[@data-target=\"#elements\"]")
	private WebElement elements;
	@FindBy (xpath="//*[text()=\"buttons\"]")
	private WebElement buttons;
	@FindBy (xpath=" //*[@ondblclick=\"doubletext()\"]")
	private WebElement doubleclick;
	@FindBy (xpath="//*[@oncontextmenu=\"righttext()\"]")
	private WebElement rightclick;

	public void clickonlements()
	{
		elements.click();
	}
		public void clickonbuttons()
		{
			buttons.click();
		}
		public void performDoubleclick()
		{
			doubleclick(doubleclick);
			rightclick(rightclick);
		}
}
