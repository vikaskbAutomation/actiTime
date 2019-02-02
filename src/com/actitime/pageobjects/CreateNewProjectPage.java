package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class CreateNewProjectPage 
{
	SeleniumLib slib;
	
	@FindBy(name="customerId")
	private WebElement custIdDrpDwn;
	
	@FindBy(name="name")
	private WebElement projName;
	
	@FindBy(name="createProjectSubmit")
	private WebElement createProjSubmitBtn;
	
	public CreateNewProjectPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//FEATURE
	public void ceateNewProject(String customerID, String projectName)
	{
		slib.selectOptionByText(custIdDrpDwn, customerID);
		slib.enterData(projName, projectName);
		slib.clickButon(createProjSubmitBtn);
	}
}
