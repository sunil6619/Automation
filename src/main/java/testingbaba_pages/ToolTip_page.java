package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class ToolTip_page extends Baselibrary{
	
public ToolTip_page()
{
	PageFactory.initElements(driver,this);
}
@FindBy (xpath="//*[@data-target=\"#widget\"]")
private WebElement widgets;
@FindBy (xpath="//*[text()=\'tool tips\']")
private WebElement tooltip;
@FindBy (xpath="//*[@class=\"btn btn-primary\"][@data-toggle=\"tooltip\"]")
private WebElement mousehover;


public void clickonwidgets()
{
	clickme(widgets);
}

public void clickontooltips()
{
	clickme(tooltip);
}

public void mousehover()
{
	mousehover(mousehover);
	String tooltiptext=mousehover.getAttribute("title");
	System.out.println(tooltiptext);
}
}
