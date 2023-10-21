package testingbaba_pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baselibrary.Baselibrary;

public class Upload_page extends Baselibrary {
 String filepath="S:\\Eclipse\\NewAutomation\\testdata\\testdata_7Nov.xlsx";
	public void Upload_page() {
		PageFactory.initElements(driver,this);
	}
	@FindBy (xpath="//*[@data-target=\"#elements\"]")
	private WebElement elements;
	@FindBy (xpath="//*[text()='upload and download']")
	private WebElement Uploadfile;
	@FindBy (xpath="//*[text()='Select a file']")
	private WebElement selectfile;
	
	public  void clickonelements()
	{
		clickme(elements);
	}
	public void clickonuploadfile()
	{
		clickme(Uploadfile);
	}
	public void fileuploading() throws InterruptedException
	{
		clickme(selectfile);
		Thread.sleep(2000);
		fileuploading(filepath);
	}
	
	public void getalerts()
	{
		driver.switchTo().alert().accept();
		driver.switchTo().alert().dismiss();
		driver.switchTo().alert().sendKeys("ram");
		driver.switchTo().alert().accept();
		
	}
}
