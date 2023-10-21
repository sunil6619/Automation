package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class Textbox_page extends Baselibrary{
	
	public Textbox_page()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	
	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement elements;
	
	public void clickonelements()
	{
		elements.click();
	}

}
