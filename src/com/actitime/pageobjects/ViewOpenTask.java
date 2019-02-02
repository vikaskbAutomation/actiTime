package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class ViewOpenTask 
{
	SeleniumLib slib;
	
	@FindBy(css="input[value='Delete This Task']")
	private WebElement deleteThisTaskBtn;
	
	@FindBy(css="input[value='Delete Task']")
	private WebElement confirmDeleteTaskBtn;
	
	public ViewOpenTask(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//STEP
	public void clickOnDeleteTaskBtn()
	{
		deleteThisTaskBtn.click();
		confirmDeleteTaskBtn.click();
	}
}
