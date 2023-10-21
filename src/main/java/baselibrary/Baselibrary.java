


 package baselibrary;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import applicationutility.Applicationutility;
import excelutility.Excelutility;
import propertyutility.Propertyutility;
import screenshotutility.Screenshotutility;
import waitutility.Waitutility;

public class Baselibrary implements Propertyutility, Excelutility,Applicationutility,Screenshotutility,Waitutility{
	
	static public WebDriver driver;
	String configpath="S:\\Eclipse\\NewAutomation\\testdata\\config.properties";
	String excelpath="S:\\Eclipse\\NewAutomation\\testdata\\testdata_7Nov.xlsx";
	
	public void getlaunchurl (String url,String browsername)
	{
	try {
		if (browsername.equalsIgnoreCase("chrome"))
		{
			
		System.setProperty("webdriver.chrome.driver", "S:\\Eclipse\\NewAutomation\\drivers\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//*[text()='×']")).click();
		driver.findElement(By.xpath("//*[text()='Practice']")).click();
	}
		else if (browsername.equalsIgnoreCase("mozila"))
		{
			System.setProperty("webdriver.gecko.driver","S:\\Eclipse\\NewAutomation\\drivers\\geckodriver.exe");                     
			driver=new FirefoxDriver();
			driver.get(url);
			driver.manage().window().maximize();
			driver.findElement(By.xpath("//*[text()='×']")).click();
			driver.findElement(By.xpath("//*[text()='Practice']")).click();
		}
		
		else if (browsername.equalsIgnoreCase("edge"))
		{
			 
		}     
	}  
catch (Exception e)
	{
	System.out.println("issue in get launch"+e);
	}
	}
	@Override
	public String getreaddata(String key) {
		String value="";
		try {
			
			FileInputStream fis= new FileInputStream(configpath);
			Properties prop=new Properties();
			prop.load(fis);
			value=prop.getProperty(key);
		} catch (Exception e) {
			System.err.println("Issue in Get Read data property file "+e);
		}
		
		
		return value;
	}

	@Override
	public String getReaddata(int sheetno, int col, int rowno) {
		String value ="";
		try {
			FileInputStream fis=new FileInputStream(excelpath);
			XSSFWorkbook wb = new XSSFWorkbook (fis);
			XSSFSheet sheet=wb.getSheetAt(sheetno);
			value=sheet.getRow(rowno).getCell(col).getStringCellValue();
		} catch (Exception e) {
			System.out.println("Issue in Get read data Excelutility "+ e);
		}
		return value;
	}
	@Override
	public void getScreenshot(String foldername, String filename) {
		String loc=System.getProperty("user.dir");
		String path=loc +"\\screenshot\\"+foldername+"\\"+filename+".png";
		 try {
			 
			 EventFiringWebDriver efw= new EventFiringWebDriver(driver);
			 File src=efw.getScreenshotAs(OutputType.FILE);
			 FileUtils.copyFile(src, new File(path));
			
		} catch (Exception e) {

System.out.println("Issue in getScreenshot"+e);
		}
		
	}
@AfterMethod
	public void getanalysis(ITestResult result)
	{
		String filename=result.getMethod().getMethodName();
		try {
			if (result.getStatus()==ITestResult.SUCCESS)
			{
				getScreenshot("passed",filename+getDatetime());
			}
			else if (result.getStatus()==ITestResult.FAILURE)
			{
				getScreenshot("failed",filename+getDatetime());
			}
		} catch (Exception e) {
			
		}
	}
	
@Override
public String getDatetime() {
	String value="";
	try {
		Date sb= new Date();
		DateFormat db= new SimpleDateFormat("ddMMyyyy_hhmmss");
		value=db.format(sb);
		
	} catch (Exception e) {
		// TODO: handle exception
	}
	 return value;
}

@Override
public int getrowcount(int sheetno) {
	int value=0;
	try {
		FileInputStream fis=new FileInputStream(excelpath);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet= wb.getSheetAt(sheetno);
		value=sheet.getLastRowNum();
	} catch (Exception e) {
		System.out.println("Issue in Get row count Excelutility"+e);
	}
	return value;
}

@Override
public void doubleclick(WebElement ele) {
	Actions act=new Actions(driver);
	act.doubleClick(ele).perform();
	
}

@Override
public void rightclick(WebElement ele) {
	Actions act=new Actions(driver);
	act.contextClick(ele).perform();
	
}

@Override
public void changewindow(int tabindex) 
{
Set<String> set=driver.getWindowHandles();
ArrayList<String> tabs=new ArrayList<String>(set);
driver.switchTo().window(tabs.get(tabindex));
}

public void elementtobeselected (WebElement ele,int time)
{
	WebDriverWait wait=new WebDriverWait (driver,time);
	wait.until(ExpectedConditions.elementToBeSelected(ele));
}
public void elementtobeclickable(WebElement ele,int time)
{
WebDriverWait wait= new WebDriverWait(driver,time);
wait.until(ExpectedConditions.elementToBeClickable(ele));
}
public void visibleofelement(WebElement ele,int time) {
	WebDriverWait wait=new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.visibilityOf(ele));
}

public void clickme(WebElement ele)
{
	WebDriverWait wait=new WebDriverWait(driver,2);
	wait.until(ExpectedConditions.elementToBeClickable(ele));
	ele.click();	
}
public void fileuploading (String path) {
	try {
		StringSelection sel= new StringSelection(path);
		Clipboard clip= Toolkit.getDefaultToolkit().getSystemClipboard();
		clip.setContents(sel,null);
		Robot robot= new Robot();
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_ENTER);
		robot.delay(350);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);
		
	} catch (Exception e) {
		System.out.println("Issue in file uploading"+e);
	}
}
public void alertispresent(int time)
{
	WebDriverWait wait=new WebDriverWait(driver,time);
	wait.until(ExpectedConditions.alertIsPresent());
}

@Override
public void selectbyvalue1(WebElement ele,String value) {
	Select sel=new Select(ele);
	sel.selectByVisibleText(value);
	
}
public void mousehover(WebElement ele)
{
	Actions act=new Actions(driver);
	act.moveToElement(ele).perform();
	
}
public void mousehoverandclick(WebElement ele,String ele1)
{
	Actions act=new Actions(driver);
	act.moveToElement(ele).build().perform();
	driver.findElement(By.linkText(ele1)).click();
	
}

}


