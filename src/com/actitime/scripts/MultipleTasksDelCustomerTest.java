package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.CreateNewProjectPage;
import com.actitime.pageobjects.CreateNewTasksPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTaskPage;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class MultipleTasksDelCustomerTest extends BaseLib
{
	@Test
	public void createCustCreateProjDelCust()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "sheet1", 14, 1);
		String password=ExcelUtilities.readData(file, "sheet1", 14, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTaskPage otp= new OpenTaskPage(driver);
		otp.clickOnProjAndCustLink();
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		CreateNewCustPage cncp=new CreateNewCustPage(driver);
		
		apcp.clickOnCreateNewCustBtn();
		String customerName = ExcelUtilities.readData(file, "sheet1", 14, 3);
		cncp.createCustomer(customerName);
		apcp.verifyCreateCustMsg(customerName);
		
		apcp.clickOnCreateNewProject();
		
		CreateNewProjectPage cnpp=new CreateNewProjectPage(driver);
		String projectName = ExcelUtilities.readData(file, "sheet1", 14, 4);
		cnpp.ceateNewProject(customerName, projectName);
		apcp.verifyProjCreated(projectName);
		
		apcp.cickOpenTasks();
		CreateNewTasksPage cntp=new CreateNewTasksPage(driver);
		otp.clickOnCreateNewTask();
		cntp.selectCust(customerName);
		cntp.selectProj(projectName);
		
		
		
		int row=14;
		int cell=5;
		for(int i=0; i<=3; i++)
		{
			String newTaskName = ExcelUtilities.readData(file, "sheet1", row, cell);
			cntp.MultipleTasks(newTaskName);
			
			
			cell++;
		}
		
		cntp.clickOnCreateTasksBtn();
		otp.verifyNewTaskAddedCustName(customerName);
		otp.verifyNewTaskAddedProjName(projectName);
		
		
		otp.clickOnProjAndCustLink();
		apcp.showCustomer(customerName);
		
		EditCustInfoPage ecip=new EditCustInfoPage(driver);
		ecip.deleteCustomer();
		
		apcp.verifyDeleteCustomer();
		apcp.clickOnLogout();
	}
}
