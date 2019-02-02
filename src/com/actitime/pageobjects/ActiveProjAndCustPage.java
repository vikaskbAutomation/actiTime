package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class ActiveProjAndCustPage extends BasePage
{

	SeleniumLib slib;
	
	@FindBy(css="input[value='Create New Customer']")
	private WebElement createNewCustBtn;
	
	@FindBy(className="successmsg")
	private WebElement successmsg;
	
	@FindBy(name="selectedCustomer")
	private WebElement custDrpDwn;
	
	@FindBy(css="input[value*='Show']")
	private WebElement showBtn;
	
	@FindBy(xpath="//td[starts-with(@id,'customerNameCell')]//a[contains(@href,'customerId')]")
	private WebElement custNameLink;
	
	@FindBy(css="input[value='Create New Project']")
	private WebElement createNewProjectBtn;
	
	@FindBy(xpath="//td[starts-with(@id,'projectNameCell')]//a[contains(@href,'projectId')]")
	private WebElement projNameLink;
	
	@FindBy(id="showProjects")
	private WebElement showProjChkBx;
	
	@FindBy(xpath="//a[text()='Open Tasks']")
	private WebElement openTasks;
	
	public ActiveProjAndCustPage(WebDriver driver)
	{
		super(driver);
		slib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//STEP
	public void clickOnCreateNewCustBtn()
	{
		slib.clickButon(createNewCustBtn);
	}
	
	public void verifyCreateCustMsg(String customerName)
	{
		
		slib.validateElementDisplyed(successmsg, customerName, successmsg.getText());
	}
	
	public void showCustomer(String customerName)
	{
		slib.selectOptionByText(custDrpDwn, customerName);
		slib.clickButon(showBtn);
		//custNameLink.click();
		//OR
		if(custNameLink.getText().equalsIgnoreCase(customerName))
		{
			custNameLink.click();
		}
		else
		{
			System.out.println("Customer not matching");
		}
	}
	
	//FEATURE
	public void verifyDeleteCustomer()
	{
		String expected = "Customer has been successfully deleted.";
		String actual = successmsg.getText();
		slib.validate(expected, actual, expected);
	}
	
	//FEATURE
	public void clickOnCreateNewProject()
	{
		slib.clickButon(createNewProjectBtn);
	}
	
	//STEP
	public void showProject(String customerName, String projectName)
	{
		slib.clickCheckBox(showProjChkBx);
		slib.selectOptionByText(custDrpDwn, customerName);
		slib.clickButon(showBtn);
	
		if(projNameLink.getText().equalsIgnoreCase(projectName))
		{
			projNameLink.click();
		}
		else
		{
			System.out.println("Project not found");
		}
	}
	
	//FEATURE
	public void verifyProjCreated(String projectName)
	{
		slib.validateElementDisplyed(successmsg, projectName, successmsg.getText());
	}
	
	//FEATURE
	public void verifyDeleteProject()
	{
		String expected = "Project has been successfully deleted.";
		String actual = successmsg.getText();
		slib.validate(expected, actual, expected);
	}
	
	//STEP
	public void cickOpenTasks()
	{
		openTasks.click();
	}
}
