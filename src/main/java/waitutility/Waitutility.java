package waitutility;

import org.openqa.selenium.WebElement;

public interface Waitutility {
	
	public void elementtobeselected(WebElement ele,int time);
	public void elementtobeclickable (WebElement ele,int time);
	public void visibleofelement (WebElement ele,int time);
	public void alertispresent (int time);

}
