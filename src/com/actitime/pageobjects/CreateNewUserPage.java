package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class CreateNewUserPage 
{

	SeleniumLib slib;
	
	@FindBy(name="username")
	private WebElement usernameTxtBx;
	
	@FindBy(name="passwordText")
	private WebElement passwordTxtBx;
	
	@FindBy(name="passwordTextRetype")
	private WebElement reTypePasswordTxtBx;
	
	@FindBy(name="firstName")
	private WebElement firstNameTxtBx;
	
	@FindBy(name="lastName")
	private WebElement lastNameTxtBx;
	
	@FindBy(name="email")
	private WebElement emailTxtBx;
	
	@FindBy(css="input[value*='Create User']")
	private WebElement createUserBtn;
	
	public CreateNewUserPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	public void loginInfo(String newUsername, String newPassword)
	{
		
		slib.enterData(usernameTxtBx, newUsername);
		slib.enterData(passwordTxtBx, newPassword);
		slib.enterData(reTypePasswordTxtBx, newPassword);
	}
	public void contactInfo(String firstName, String lastName, String emailID)
	{
		slib.enterData(firstNameTxtBx, firstName);
		slib.enterData(lastNameTxtBx, lastName);
		slib.enterData(emailTxtBx, emailID);
		
	}
	
	public void clickOnCreateUserBtn()
	{
		slib.clickButon(createUserBtn);
	}
}
