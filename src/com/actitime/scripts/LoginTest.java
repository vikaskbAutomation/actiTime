package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class LoginTest extends BaseLib 
{
	
	//FEATURE
	@Test(enabled=false, priority=1, description="Verifying home page")
	public void validLogin()
	{
		String file="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 1, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 1, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.verifyHomePage();
	}
	
	//FEATURE
	@Test(enabled=false, priority=2, description="Verifying invalid login message")
	public void invalidLogin()
	{
		String file="./testdata/testdata.xlsx";
		String username=ExcelUtilities.readData(file, "sheet1", 2, 1);
		String password=ExcelUtilities.readData(file, "sheet1", 2, 2);
		LoginPage lp= new LoginPage(driver);
		lp.login(username, password);
		lp.verifyInvalidLoginPage();
	
	}
}
