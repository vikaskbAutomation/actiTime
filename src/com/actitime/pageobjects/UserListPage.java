package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class UserListPage extends BasePage
{

	SeleniumLib slib;
	
	@FindBy(xpath="//span[text()='Create New User']")
	private WebElement createNewUserBtn;
	
	@FindBy(className="successmsg")
	private WebElement successmsg;
	
	@FindBy(id="userCombo")
	private WebElement userComboDrpDwn;
	
	@FindBy(css="div[class*='x-combo-list-item']")
	private WebElement selUser;
	
	public UserListPage(WebDriver driver)
	{
		super(driver);
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//STEPS
	public void clickOnNewUSerBtn()
	{
		createNewUserBtn.click();
	}
	
	public void verifyNewUserCreated()
	{
		String expected="User account has been successfully created.";
		String actual = successmsg.getText();
		slib.validate(expected, actual, expected);
	}
	
	public void selectUserToDelete(String delUser)
	{
		slib.enterData(userComboDrpDwn, delUser);
		if(selUser.getText().contains(delUser))
		{
			selUser.click();
		}
		else
		{
			System.out.println("User not Found");
		}
	}
	public void verifyUserDeleted()
	{
		String expected = "User account has been successfully deleted.";
		String actual = successmsg.getText();
		slib.validate(expected, actual, expected);
	}
}
