package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class Webtable_pages extends Baselibrary {
	
	public Webtable_pages()
	{
		PageFactory.initElements(driver,this);
	}
@FindBy (xpath="//*[text()='web tables']")
private WebElement webtable;

@FindBy (xpath="//*[@data-target=\"#elements\"]")
private WebElement elements;

@FindBy (xpath="//*[@id=\"tab_4\"]/div/iframe")
private WebElement webtableiframe;

@FindBy (xpath="//*[text()='Name:']/following::input[@name=\"name\"]")
private WebElement name;

@FindBy (xpath="//*[text()='Name:']/following::input[@name=\"email\"]")
private WebElement email;

@FindBy (xpath="//*[text()='Save']")
private WebElement submit;
@FindBy (xpath="//*[text()='Edit']")
private java.util.List<WebElement>edits;
@FindBy (xpath="//*[@name=\"edit_name\"]")
private WebElement editname;
@FindBy (xpath="//*[@name=\"edit_email\"]")
private WebElement editemail;
@FindBy (xpath="//*[text()='Update']")
		private WebElement updatebtn;

public void clickonelements()
{
	elements.click();
}
public void clickonwebtable()
{
	webtable.click();
}
public void filldetails()
{
	driver.switchTo().frame(webtableiframe);
	for (int i=1;i<=getrowcount(1);i++)
	{
		name.sendKeys(getReaddata(1, 0, i));
		email.sendKeys(getReaddata(1, 1, i));
		submit.click();
	}	
}
public void getedits()
{
int j=1;
for (WebElement edit:edits) 
{
	edit.click();
	editname.clear();
	editname.sendKeys(getReaddata(1,2,j));
	editemail.clear();
	editemail.sendKeys(getReaddata(1,3,j));
j++;
updatebtn.click();
}
} 	}

