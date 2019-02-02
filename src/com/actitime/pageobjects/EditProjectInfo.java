package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class EditProjectInfo 
{

	SeleniumLib slib;
	
	@FindBy(css="input[value='Delete This Project']")
	private WebElement delThisProjBtn;
	
	@FindBy(id="deleteButton")
	private WebElement delProjConfirmBtn;
	
	public EditProjectInfo(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
		
	}
	
	//FEATURE
	public void deleteProject()
	{
		slib.clickButon(delThisProjBtn);
		slib.clickButon(delProjConfirmBtn);
	}
	
	
	
}
