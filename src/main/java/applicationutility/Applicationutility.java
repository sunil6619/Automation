package applicationutility;

import org.openqa.selenium.WebElement;

public interface Applicationutility {
	
		public String getDatetime();
		public void doubleclick (WebElement ele);
		public void rightclick (WebElement ele);
		public void changewindow(int tabindex);
		public void clickme(WebElement ele);
		public void fileuploading(String path);
		public void selectbyvalue1(WebElement ele,String value);
		public void mousehover(WebElement ele);
		public void mousehoverandclick (WebElement ele,String ele1);
		}

