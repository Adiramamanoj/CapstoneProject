package pomRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Reporter;

import genericLibrary.ExcelUtil;
import genericLibrary.UtilityMethods;

/**
 * 
 * @author Adi rama venkata manoj
 *
 */

public class TimeTrackPage {

	
//	Constructor
	public TimeTrackPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	
//	Properties or WebElements
	@FindBy(id= "addTaskButtonId")
	private WebElement newOptionlink;
	
	@FindBy(xpath = "//div[contains(@class,'customerSelector')]//div[@class=\"dropdownButton\"]") 
	private WebElement customerNameListBox;
	
	@FindBy(xpath = "//div[text()='- New Customer -']")
	private WebElement newCustomerOption;
	
	@FindBy(xpath = "(//div[text()='Galaxy Corporation'])")
	private WebElement customerName;
	
	@FindBy(xpath = "//div[contains(@class,'projectSelector')]//div[@class=\"dropdownButton\"]")
	private WebElement projectNameListBox;
	
	@FindBy(xpath ="//div[text()='- New Project -']")
	private WebElement newProjectOption;
	
	@FindBy(xpath = "//div[text()='Android testing']")
	private WebElement tempProjectName;
	
	
	@FindBy(xpath = "//input[contains(@class,'newProject')]")
	private WebElement projectNameTextField;
	
	@FindBy(xpath = "(//input[@placeholder='Enter task name'])[1]")
	private WebElement taskNameTextField;
	
	@FindBy(xpath = "(//input[@placeholder='not needed'])[1]")
	private WebElement estimateTimetextField;
	
	@FindBy(xpath = "(//button[text()='set deadline'])[1]")
	private WebElement setDeadlineTextField;
	
	@FindBy(id = "ext-gen79")
	private WebElement rightnavigateicon;
	
	@FindBy(xpath = "(//div[text()='engineering'])[3]")
	private WebElement typeOfWorkListBox;
	
	@FindBy(xpath = "(//div[text()='BILLABLE:'])[2]/..//div[text()='support']")
	private WebElement WorkTypeName;
	
	@FindBy(xpath = "//div[text()='Create Tasks']") 
	private WebElement createTaskButton;
	
	@FindBy(xpath = "//td[@class='userSelectorButton']")
	private WebElement usersDropDown;
	
	@FindBy(xpath = "//span[text()='Moreno, Andrew']")
	private WebElement userNameInListBox;
	
	@FindBy(xpath = "//td[text()='Enter Time-Track']/../../../../../..//div[@class='ttaHistoryButton']")
	private WebElement readyForApprovalRecordButton;
	
	@FindBy(id = "ttaHistoryLightBoxDiv")
	private WebElement ApprovedRecordList;
	
	@FindBy(xpath = "//td[text()='Enter Time-Track']/../../../../../..//td[contains(text(),'Approved')]")
	private WebElement statusApprovedOption;

	@FindBy(xpath = "(//span[text()='Task']/../../../..//div[text()='Smoke Testing']/../../../..//div[text()='New'])[1]")
	private WebElement newCreatedTask;
	
	@FindBy(xpath = "//td[text()='Enter Time-Track']/../../../../../..//span[contains(text(),'Revoke')]")
	private WebElement revokeElemntOption;
	
	@FindBy(xpath = "//td[text()='Enter Time-Track']/../../../../../..//td[contains(text(),'Status:')]/..//td[text()='Ready']")
	private WebElement readystatusText;
	
	
//	Getter Methods of all the WebElements
	public WebElement getNewOptionlink() {
		return newOptionlink;
	}

	public WebElement getCustomerNameListBox() {
		return customerNameListBox;
	}

	public WebElement getNewCustomerOption() {
		return newCustomerOption;
	}

	public WebElement getCustomerName() {
		return customerName;
	}

	public WebElement getProjectNameListBox() {
		return projectNameListBox;
	}

	public WebElement getNewProjectOption() {
		return newProjectOption;
	}

	public WebElement getTempProjectName() {
		return tempProjectName;
	}

	public WebElement getProjectNameTextField() {
		return projectNameTextField;
	}

	public WebElement getTaskNameTextField() {
		return taskNameTextField;
	}

	public WebElement getEstimateTimetextField() {
		return estimateTimetextField;
	}

	public WebElement getSetDeadlineTextField() {
		return setDeadlineTextField;
	}

	public WebElement getTypeOfWorkListBox() {
		return typeOfWorkListBox;
	}

	public WebElement getWorkTypeName() {
		return WorkTypeName;
	}

	public WebElement getCreateTaskButton() {
		return createTaskButton;
	}

//	public WebElement getNewCreatedTask() {
//		return newCreatedTask;
//	}

	public WebElement getRightnavigateicon() {
		return rightnavigateicon;
	}
	
	public WebElement getUsersDropDown() {
		return usersDropDown;
	}
	

	public WebElement getUserNameInListBox() {
		return userNameInListBox;
	}
	

	public WebElement getReadyForApprovalRecordButton() {
		return readyForApprovalRecordButton;
	}

	public WebElement getApprovedRecordList() {
		return ApprovedRecordList;
	}
	

	public WebElement getStatusApprovedOption() {
		return statusApprovedOption;
	}

	public WebElement getNewCreatedTask() {
		return newCreatedTask;
	}
	

	public WebElement getRevokeElemntOption() {
		return revokeElemntOption;
	}
	

	public WebElement getReadystatusText() {
		return readystatusText;
	}

	/*
	 * Actions Methods For First Test Script TimeTrack or Business logic
	 */
	public void createNewTask(WebDriver driver, String taskname) {
		ExcelUtil excelUtil = new ExcelUtil();
		UtilityMethods utilMethods= new UtilityMethods();
		Actions actions= new Actions(driver);
		
		String projectName=excelUtil.readStringDataFromExcel("Sheet1",0,0);
		String taskName=excelUtil.readStringDataFromExcel("Sheet1",0,1);
		double estimateTime= excelUtil.readNumberDataFromExcel("Sheet1", 0, 2);
		
		TimeTrackPage timeTrack = new TimeTrackPage(driver);
		timeTrack.getNewOptionlink().click();
		timeTrack.getCustomerNameListBox().click();
		
		timeTrack.getNewCustomerOption().click();
		timeTrack.getCustomerNameListBox().click();
		timeTrack.getCustomerName().click();
		timeTrack.getProjectNameListBox().click();
		timeTrack.getTempProjectName().click();
		timeTrack.getProjectNameListBox().click();
		timeTrack.getNewProjectOption().click();
		timeTrack.getProjectNameTextField().sendKeys(projectName);
		timeTrack.getTaskNameTextField().sendKeys(taskName);
		timeTrack.getEstimateTimetextField().sendKeys(" "+estimateTime);
		utilMethods.systemDateAndTimeForCalender(driver);
		timeTrack.getTypeOfWorkListBox().click();
		timeTrack.getWorkTypeName().click();
		timeTrack.getCreateTaskButton().click();
		Reporter.log("New Task is successfully created",true);
	}
	
	
}
