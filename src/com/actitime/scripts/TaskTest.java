package com.actitime.scripts;

import org.testng.annotations.Test;
import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjectPage;
import com.actitime.pageobjects.CreateNewTasksPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EditProjectInfo;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTaskPage;
import com.actitime.pageobjects.ViewOpenTask;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class TaskTest extends BaseLib 
{
	@Test(priority=1, description="Verify Create Customer ")
	public void createCustomer()
	{
		
		
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "sheet1", 3, 1);
		String password=ExcelUtilities.readData(file, "sheet1", 3, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTaskPage otp= new OpenTaskPage(driver);
		otp.clickOnProjAndCustLink();
		
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnCreateNewCustBtn();
		
		
		String customerName = ExcelUtilities.readData(file, "sheet1", 3, 3);
		CreateNewCustPage cncp= new CreateNewCustPage(driver);
		cncp.createCustomer(customerName);
		
		apcp.verifyCreateCustMsg(customerName);
		
		apcp.clickOnLogout();
	}
	
	@Test(priority=6)
	public static void deleteCustomer()
	{
		String file = "./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 4, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 4, 2);
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTaskPage otp= new OpenTaskPage(driver);
		otp.clickOnProjAndCustLink();
		
		String customerName = ExcelUtilities.readData(file, "sheet1", 4, 3);
		ActiveProjAndCustPage apcp= new ActiveProjAndCustPage(driver);
		apcp.showCustomer(customerName);
		
		EditCustInfoPage ecip= new EditCustInfoPage(driver);
		ecip.deleteCustomer();
		
		apcp.verifyDeleteCustomer();
		apcp.clickOnLogout();
		
	}
	
	@Test(priority=2)
	public void createProject()
	{
		String file = "./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 5, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 5, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTaskPage otp=new OpenTaskPage(driver);
		otp.clickOnProjAndCustLink();
		
		ActiveProjAndCustPage apcp= new ActiveProjAndCustPage(driver);
		apcp.clickOnCreateNewProject();
		
		CreateNewProjectPage cnpp=new CreateNewProjectPage(driver);
		String customerID = ExcelUtilities.readData(file, "sheet1", 5, 3);
		String projectName = ExcelUtilities.readData(file, "sheet1", 5, 4);
		cnpp.ceateNewProject(customerID, projectName);
		apcp.verifyProjCreated(projectName);
		
	}
	
	@Test(priority=5)
	public void deleteProject()
	{
		String file = "./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 6, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 6, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTaskPage otp=new OpenTaskPage(driver);
		otp.clickOnProjAndCustLink();
		
		String customerName = ExcelUtilities.readData(file, "sheet1", 6, 3);
		String projectName = ExcelUtilities.readData(file, "sheet1", 6, 4);
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.showProject(customerName, projectName);
		
		EditProjectInfo epi=new EditProjectInfo(driver);
		epi.deleteProject();
		 
		apcp.verifyDeleteProject();
		apcp.clickOnLogout();
	}
	
	@Test(priority=3)
	public void createTasks()
	{
		String file="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 7, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 7, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTaskPage otp=new OpenTaskPage(driver);
		otp.clickOnCreateNewTask();
		
		String customerName = ExcelUtilities.readData(file, "sheet1", 7, 3);
		String projectName = ExcelUtilities.readData(file, "sheet1", 7, 4);
		CreateNewTasksPage cntp= new CreateNewTasksPage(driver);
		cntp.selectCust(customerName);
		cntp.selectProj(projectName);
		
		String taskName = ExcelUtilities.readData(file, "sheet1", 7, 5);
		cntp.enterTaskData(taskName);
		String verCustName = ExcelUtilities.readData(file, "sheet1", 7, 3);
		String taskProjName = ExcelUtilities.readData(file, "sheet1", 7, 4);
		otp.verifyNewTaskAddedProjName(taskProjName);
		otp.verifyNewTaskAddedCustName(verCustName);
		
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnLogout();
	}
	
	@Test(priority=4)
	public void deleteTask()
	{
		String file="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 8, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 8, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		String selectTaskName = ExcelUtilities.readData(file, "sheet1",8 , 5);
		String custName = ExcelUtilities.readData(file, "sheet1", 8, 3);
		OpenTaskPage otp=new OpenTaskPage(driver);
		otp.clickOnTask(selectTaskName, custName);
		
		ViewOpenTask vot=new ViewOpenTask(driver);
		vot.clickOnDeleteTaskBtn();
		
		otp.verifyDeleteTask();
		
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnLogout();
		
	}
}
