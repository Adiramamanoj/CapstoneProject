package genericLibrary;

import java.time.LocalDateTime;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import pomRepository.TimeTrackPage;

/***
 * 
 * @author Yogita
 *
 */
public class UtilityMethods {
	
	/**
	 * This method is used to switch the driver control to a particular titled window
	 * @param title of the expected page
	 */
	public void switchToASpecificTitledWindow(WebDriver driver,String title) { 
		String parentWindowId = driver.getWindowHandle(); 
		Set<String> allWindowIds = driver.getWindowHandles(); 
		allWindowIds.remove(parentWindowId); 
		for(String windowId:allWindowIds){ 
			driver.switchTo().window(windowId);
			if(driver.getTitle().equalsIgnoreCase(title)){ 
				break; 
			} 
		} 
	} 
	
	/**
	 * This method is used to switch the driver control to a particular window where the given element is present
	 * @param element that is present on the required page
	 */
	public void switchToASpecificWindow(WebDriver driver,WebElement element) {
		String parent=driver.getWindowHandle(); 
		Set<String> allWid=driver.getWindowHandles(); 
		allWid.remove(parent); 
		for(String sessionID:allWid){ 
			driver.switchTo().window(sessionID);
			if(element.isDisplayed()){ 
				break; 
			} 
		} 
	}
	
	/**
	 * This Method is for Reading System Date And Time By Java Methods
	 * @param
	 */
	public void systemDateAndTimeForCalender(WebDriver driver) {
		ExcelUtil excelutil1= new ExcelUtil();
		TimeTrackPage timeTrackPage = new TimeTrackPage(driver);
		String systemMonth = excelutil1.readStringDataFromExcel("Sheet1", 1, 0);
		LocalDateTime ldt = LocalDateTime.now();
		String month = ldt.getMonth().name();
		String monthFormat = systemMonth;
		month = month.substring(0, 1).toUpperCase() + month.substring(1, month.length()).toLowerCase();
		String month1 = month.replaceAll(month, monthFormat);
		int year = ldt.getYear();
		int days = ldt.getDayOfMonth();
				
		timeTrackPage.getSetDeadlineTextField().click();
//		timeTrackPage.getRightnavigateicon().click();
		driver.findElement(By.xpath("//button[text()='" + month1 + " " + year +"']/../../../../../../../..//span[text()='" + days +"']")).click();

	}
	
}

