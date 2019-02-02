package com.actitime.scripts;

import org.testng.annotations.Test;

import com.actitime.pageobjects.ActiveProjAndCustPage;
import com.actitime.pageobjects.CreateNewUserPage;
import com.actitime.pageobjects.EditUserSettingsPage;
import com.actitime.pageobjects.EnterTimeTrackPage;
import com.actitime.pageobjects.LoginPage;
import com.actitime.pageobjects.UserListPage;
import com.actitime.utilities.BaseLib;
import com.actitime.utilities.ExcelUtilities;

public class UsersTest extends BaseLib
{

	@Test
	public void createNewUser()
	{
		String file="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 9, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 9, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnUsers();
		
		UserListPage ulp=new UserListPage(driver);
		ulp.clickOnNewUSerBtn();
		
		CreateNewUserPage cnup=new CreateNewUserPage(driver);
		String newUsername = ExcelUtilities.readData(file, "sheet1", 9, 3);
		String newPassword = ExcelUtilities.readData(file, "sheet1", 9, 4);
		
		 cnup.loginInfo(newUsername, newPassword);
		 
		 String firstName = ExcelUtilities.readData(file, "sheet1", 9, 5);
		 String lastName = ExcelUtilities.readData(file, "sheet1", 9, 6);
		 String emailID = ExcelUtilities.readData(file, "sheet1", 9, 7);
		 cnup.contactInfo(firstName, lastName, emailID);
		 
		 cnup.clickOnCreateUserBtn();
		
		ulp.verifyNewUserCreated();
		
		ActiveProjAndCustPage apcp=new ActiveProjAndCustPage(driver);
		apcp.clickOnLogout();
	}
	
	@Test(enabled=false)
	public void newUserLogin()
	{
		String file="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 10, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 10, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.verifyHomePage();
	}
	
	@Test
	public void deleteuser()
	{
		String file="./testdata/testdata.xlsx";
		String username = ExcelUtilities.readData(file, "sheet1", 11, 1);
		String password = ExcelUtilities.readData(file, "sheet1", 11, 2);
		LoginPage lp=new LoginPage(driver);
		lp.login(username, password);
		
		EnterTimeTrackPage ettp=new EnterTimeTrackPage(driver);
		ettp.clickOnUsers();
		
		String delUser = ExcelUtilities.readData(file, "sheet1", 11, 3);
		UserListPage ulp=new UserListPage(driver);
		ulp.selectUserToDelete(delUser);
		
		EditUserSettingsPage eusp=new EditUserSettingsPage(driver);
		eusp.clickOnDelThisUserBtn();
		
		ulp.verifyUserDeleted();
	}
}
