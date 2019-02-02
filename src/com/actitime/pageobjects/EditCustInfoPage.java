package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class EditCustInfoPage
{
	SeleniumLib slib;
	
	@FindBy(css="input[value='Delete This Customer']")
	private WebElement delThisCustBtn;
	
	@FindBy(id="deleteButton")
	private WebElement delCustConfirmBtn;
	
	public EditCustInfoPage(WebDriver driver)
	{
		slib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//FEATURE
	public void deleteCustomer()
	{
		slib.clickButon(delThisCustBtn);
		slib.clickButon(delCustConfirmBtn);
	}

}
