package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewCustPage;
import com.actitime.pageobjects.EditCustInfoPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.OpenTaskPage;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class MutipleCustomersTest extends BaseLib
{
	@Test
	public void createMultipleCustomers()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "sheet1", 12, 1);
		String password=ExcelUtilities.readData(file, "sheet1", 12, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp= new EnterTimeTrackPage(driver);
		ettp.clickOnTasks();
		
		OpenTaskPage otp= new OpenTaskPage(driver);
		otp.clickOnProjAndCustLink();
		
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		CreateNewCustPage cncp=new CreateNewCustPage(driver);
		
		int row=12;
		int cell=3;
		for(int i=0; i<=3; i++)
		{
			apcp.clickOnCreateNewCustBtn();
			String customerName = ExcelUtilities.readData(file, "sheet1", row, cell);
			cncp.createCustomer(customerName);
			apcp.verifyCreateCustMsg(customerName);
			cell++;
			
		}
		
		EditCustInfoPage ecip=new EditCustInfoPage(driver);
		
		int row1=13;
		int cell1=3;
		for(int i=0; i<=3; i++)
		{
			otp.clickOnProjAndCustLink();
			String customerName2 = ExcelUtilities.readData(file, "sheet1", row1, cell1);
			apcp.showCustomer(customerName2);
			ecip.deleteCustomer();
			apcp.verifyDeleteCustomer();
			cell1++;
		}
	}
}
