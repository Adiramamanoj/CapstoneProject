package timeTrack;

import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import genericLibrary.Base_Class;
import genericLibrary.ExcelUtil;
import genericLibrary.UtilityMethods;
import pomRepository.TimeTrackPage;

/**
 * 
 * @author Adi rama venkata manoj
 *
 */
public class TC_TT_030Test extends Base_Class{
	public ExcelUtil excelUtil = new ExcelUtil();
	public UtilityMethods utilMethods= new UtilityMethods();
	public Actions action;
	
	String projectName=excelUtil.readStringDataFromExcel("Sheet1",0,0);
	String taskName=excelUtil.readStringDataFromExcel("Sheet1",0,1);
	double estimateTime= excelUtil.readNumberDataFromExcel("Sheet1", 0, 2);
	
	
	@Test
    public void CreateNewTaskOnTimeTrackSheetPage() {
	
		
		TimeTrackPage timeTrack= new TimeTrackPage(driver);
		timeTrack.createNewTask(driver, taskName);
		
  }
}
 