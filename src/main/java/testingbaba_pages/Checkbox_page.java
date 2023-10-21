package testingbaba_pages;

import java.util.LinkedHashMap;
import java.util.Map.Entry;
import java.util.Set;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import baselibrary.Baselibrary;

public class Checkbox_page extends Baselibrary{

	
	public Checkbox_page()  {
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(xpath="//*[@data-target=\"#elements\"]")
	private WebElement elements;
	@FindBy(xpath="//*[text()='check box']")
	private WebElement checkbox;
	@FindBy(xpath="//*[@id=\"tab_2\"]/div/iframe")
	private WebElement checkboxframe;
	@FindBy(xpath="//*[@onclick=\"myFunction()\"]")
	private WebElement mobilecheckbox;
	@FindBy(xpath="//*[@onclick=\"myFunction1()\"] 	")
	private WebElement laptopcheckbox;
	@FindBy(xpath="//*[@onclick=\"myFunction2()\"]")
	private WebElement desktopcheckbox;
	@FindBy(xpath="//*[@id=\"text\"]")
	private WebElement mobiletext;
	@FindBy(xpath="//*[@id=\"text1\"]")
	private WebElement laptoptext;
	@FindBy(xpath="//*[@id=\"text2\"]")
	private WebElement desktoptext;
	
	public void clickonelements()
	{
		elements.click();
	}
	public void clickoncheckbox()
	{
		checkbox.click();
	}
	public void clickonactions() throws InterruptedException
	{
		SoftAssert asertt=new SoftAssert();
		driver.switchTo().frame(checkboxframe);
		LinkedHashMap<String,String> map= new LinkedHashMap<String,String>();
		for (int i=1;i<=3;i++)
		{
			map.put(getReaddata(0,0,i) , getReaddata(0,1,i));
		}
	
	Set<Entry<String,String>>set=map.entrySet();
	for (Entry <String ,String> dd:set)
	{
		String action=dd.getKey();
		String status=dd.getValue();
		if (action.equalsIgnoreCase("mobile"))
		{
			if (status .equalsIgnoreCase("yes"))
			{
				mobilecheckbox.click();
				Thread.sleep(1000);
				String mobilevalue=mobiletext.getText();
			Assert.assertEquals(mobilevalue, getReaddata(0, 2, 1));	
			}
			
		}
		else if (action.equalsIgnoreCase("laptop"))
		{
			if (status .equalsIgnoreCase("yes"))
			{
				laptopcheckbox.click();
				String mobilevalue=laptoptext.getText();
				asertt.assertEquals(mobilevalue, getReaddata(0, 2, 2));	
			}
		}
		else if (action.equalsIgnoreCase("desktop"))
		{
			if (status .equalsIgnoreCase("yes"))
			{
				desktopcheckbox.click();
				String mobilevalue=desktoptext.getText();
				asertt.assertEquals(mobilevalue, getReaddata(0, 2, 3));	
			}
		}
		
	}
	
	}
}


