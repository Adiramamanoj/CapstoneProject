package timeTrack;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.Base_Class;
import genericLibrary.ExcelUtil;
import genericLibrary.UtilityMethods;
import pomRepository.LockAndApprovePage;
import pomRepository.TimeTrackPage;

/**
 * 
 * @author Adi rama venkata manoj
 *
 */
public class TC_AT_032Test extends Base_Class{
	public ExcelUtil excelUtil = new ExcelUtil();
	public UtilityMethods utilMethods= new UtilityMethods();
	public Actions action;
	
	String projectName=excelUtil.readStringDataFromExcel("Sheet1",0,0);
	String taskName=excelUtil.readStringDataFromExcel("Sheet1",0,1);
	String timeCommentText=excelUtil.readStringDataFromExcel("Sheet1",1,2);
	String expectedLockTimeTrackTitle= excelUtil.readStringDataFromExcel("Sheet1",1,3);
	String expectedApproveTimeTrackTitle=excelUtil.readStringDataFromExcel("Sheet1",1,4);
	String expectedHomePageTitle=excelUtil.readStringDataFromExcel("Sheet1",1,5);
	
	
	

	@Test
	public void LockAndApproveUserTimeTrack() {
		
		LockAndApprovePage lockAndApprove= new LockAndApprovePage(driver);
		lockAndApprove.getLockTimeTrackModuleLink().click();
		Assert.assertEquals(driver.getTitle(), expectedLockTimeTrackTitle, "Lock Time Track Page is not displayed");
		lockAndApprove.getUsermoduleLink().click();
		lockAndApprove.getBugCommentIcon().click();
		
		String commentText = lockAndApprove.getCommentOption().getText();
		Assert.assertEquals(commentText,timeCommentText , "Approved Status Text not displayed properly");
		Reporter.log(commentText,true);
		Reporter.log("Appoved Status is displayed properly");
		WebElement lockTimeTrack = lockAndApprove.getLockDateField();
		lockTimeTrack.click();
		String lockText = lockTimeTrack.getText();
		Reporter.log(lockText,true);
		
		lockAndApprove.getApproveModuleLink().click();
		Assert.assertEquals(driver.getTitle(),expectedApproveTimeTrackTitle , "Approve time track page not displayed");
		Reporter.log("Approve time track page is displayed",true);
		lockAndApprove.getMoneroUserCheckBoxOption().click();
		lockAndApprove.getApproveButton().click();		
		
		
		lockAndApprove.getEnterTimeTrackModule().click();
		Assert.assertEquals(driver.getTitle(), expectedHomePageTitle, "Enter time track page not displayed");
		Reporter.log("Enter time track page is displayed",true);
		TimeTrackPage timeTrack= new TimeTrackPage(driver);
		timeTrack.getUsersDropDown().click();
		timeTrack.getUserNameInListBox().click();
		String approvedText = timeTrack.getStatusApprovedOption().getText();
		Reporter.log(approvedText);
		Reporter.log("Successfully Approved Time track",true);
	}
}
