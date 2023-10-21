package testingbaba_pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;



import baselibrary.Baselibrary;

public class Autocomplete_page extends Baselibrary{

	public Autocomplete_page()
	{
		PageFactory.initElements(driver,this);
	}
	
	@FindBy (xpath="//*[@data-target=\"#widget\"]")
	private WebElement widgets;
	@FindBy (xpath="//*[text()=\"auto complete\"]")
	private WebElement autocomplete;
	
	public void clickonwidgets()
	{
		widgets.click();
	}
	public void clickonautocomplete()
	{
		autocomplete.click();
	}
	
	public void fillText_inputbox() throws 	InterruptedException
	{
	driver.switchTo().frame(autocompleteframe);
	Starttypingtext.sendKeys("A");
	int count =0;
	List<WebElement> list=driver.findElements(By.xpath ("//*[@id=\"myInputautocomplete-list\"]"));
			
			for (int i=0;i<list.size()-1;i++)
			{
				count ++;
			for (int j=0;j<count;j++) {
				Thread.sleep(1000);
				Starttypingtext	.sendKeys(Keys.ARROW_DOWN);
			}
			Thread.sleep(1000);
			Starttypingtext.sendKeys(Keys.ENTER);
			
			Startypingtext.clear();
			Startypingtext.sendKeys("A");
			}
	
	}
}
