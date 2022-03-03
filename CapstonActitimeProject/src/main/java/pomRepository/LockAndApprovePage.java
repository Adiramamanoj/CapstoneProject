package pomRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * 
 * @author Adi rama venkata manoj
 *
 */

public class LockAndApprovePage {

	public LockAndApprovePage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText = "Lock Time-Track") private WebElement lockTimeTrackModuleLink;
	
	@FindBy(xpath = "//div[contains(text(),'Moreno, Andrew')]") private WebElement usermoduleLink;
	
	@FindBy(xpath = "(//div[contains(text(),'Moreno, Andrew')]/../../..//div[text()='Android calibration'])[2]/../../..//img[@class='showComments']")
	private WebElement bugCommentIcon;
	
	@FindBy(xpath="//div[text()='View Time-Track Comments']/../../..//div[text()='Fixing motion bugs']")
	private WebElement commentOption;
	
	@FindBy(xpath = "//div[text()='View Time-Track Comments']/..//span[@id='closeDescriptionPopupSpan']")
	private WebElement closeCommentOption;
	
	@FindBy(xpath = "(//div[text()='Android calibration'])[2]/../../..//td[text()='0:30']")
	private WebElement lockDateField;
	
	@FindBy(linkText = "Approve Time-Track") 
	private WebElement approveModuleLink;
	
	@FindBy(xpath = "//div[text()='Moreno, Andrew']/../../..//td[@class='selectionCell']")
	private WebElement moneroUserCheckBoxOption;
	
	@FindBy(xpath = "//div[text()='Klein, Hannah']/../../..//td[@class='selectionCell']")
	private WebElement userCheckBoxOption;
	
	@FindBy(id = "approveButton")
	private WebElement approveButton;
	
	@FindBy(xpath = "(//div[text()='Klein, Hannah']/../../../..//span[text()='Approved'])[1]")
	private WebElement approvedStatusText;
	
	@FindBy(xpath = "//div[text()='Klein, Hannah']/../../..//a[text()='revoke']")
	private WebElement revokeUserOption;
	
	@FindBy(xpath = "(//div[text()='Klein, Hannah']/../../../..//span[text()='Ready for Approval'])[1]")
	private WebElement readyToApprovalText;
	
	@FindBy(linkText = "Enter Time-Track")
	private WebElement EnterTimeTrackModule;
	
	@FindBy(xpath = "//span[text()='Android calibration']/../..//div[text()='Locked by John Doe on Mar 02, 2022']")
	private WebElement lockTimeTrackText;


	//  Getters Methods for all webElements
	public WebElement getEnterTimeTrackModule() {
		return EnterTimeTrackModule;
	}

	public WebElement getApproveModuleLink() {
		return approveModuleLink;
	}

	public WebElement getUserCheckBoxOption() {
		return userCheckBoxOption;
	}

	public WebElement getApproveButton() {
		return approveButton;
	}

	public WebElement getCommentOption() {
		return commentOption;
	}

	public WebElement getCloseCommentOption() {
		return closeCommentOption;
	}

	public WebElement getLockTimeTrackModuleLink() {
		return lockTimeTrackModuleLink;
	}

	public WebElement getUsermoduleLink() {
		return usermoduleLink;
	}

	public WebElement getBugCommentIcon() {
		return bugCommentIcon;
	}

	public WebElement getLockDateField() {
		return lockDateField;
	}
	
	public WebElement getLockTimeTrackText() {
		return lockTimeTrackText;
	}

	public WebElement getRevokeUserOption() {
		return revokeUserOption;
	}

	public WebElement getApprovedStatusText() {
		return approvedStatusText;
	}

	public WebElement getReadyToApprovalText() {
		return readyToApprovalText;
	}

	public WebElement getMoneroUserCheckBoxOption() {
		return moneroUserCheckBoxOption;
	}
	
	
	
	
}
