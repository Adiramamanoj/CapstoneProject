package timeTrack;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Test;

import genericLibrary.Base_Class;
import genericLibrary.ExcelUtil;
import pomRepository.LockAndApprovePage;

/**
 * 
 * @author Adi rama venkata manoj
 *
 */
public class TC_TT_031Test extends Base_Class{
	ExcelUtil excelUtil= new ExcelUtil();
	String approvedTextStatus=excelUtil.readStringDataFromExcel("Sheet1",2,0);
	String expectedLockPage=excelUtil.readStringDataFromExcel("Sheet1",1,3);
	String expectedReadyToApprovalStatus= excelUtil.readStringDataFromExcel("Sheet1", 2, 1);

	@Test
	public void unlockAndRevokeTheUserTimeTrack() {
		LockAndApprovePage lockApprovePage= new LockAndApprovePage(driver);
		lockApprovePage.getLockTimeTrackModuleLink().click();
		Assert.assertEquals(driver.getTitle(),expectedLockPage, "Lock Time Track page is not displayed");
		Reporter.log("Lock Time Track page is displayed",true);
		lockApprovePage.getUsermoduleLink().click();
		lockApprovePage.getLockDateField().click();
		
		lockApprovePage.getApproveModuleLink().click();
		lockApprovePage.getUserCheckBoxOption().click();
		lockApprovePage.getApproveButton().click();
		
		String approvedText = lockApprovePage.getApprovedStatusText().getText();
		Assert.assertEquals(approvedText,approvedTextStatus, "Approved Status is not dispalyed");
		Reporter.log("Approved Status is dispalyed",true);
		
		lockApprovePage.getRevokeUserOption().click();
		String readyToApprovalText = lockApprovePage.getReadyToApprovalText().getText();
		Assert.assertEquals(readyToApprovalText,expectedReadyToApprovalStatus , "Approved Status is not dispalyed");
		Reporter.log("Ready To Approval Status is displayed",true);
	}
}
