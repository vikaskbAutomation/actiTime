package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class OpenTaskPage 
{
	SeleniumLib slib;
	
	@FindBy(linkText="Projects & Customers")
	private WebElement projAndCustLink;
	
	@FindBy(css="input[value='Create New Tasks']")
	private WebElement createNewTaskBtn;
	
	@FindBy(className="successmsg")
	private WebElement successmsg;
	
	@FindBy(xpath="//a[contains(@href,'/tasks/task_details.do?')]")
	private WebElement selectTask;
	
	@FindBy(id="cpSelector.cpButton.contentsContainer")
	private WebElement custAndProjDrpDwn;
	
	@FindBy(css="span[class*='check-listbox-caption']")
	private WebElement selCustAndProj;
	
	@FindBy(id="closeButton")
	private WebElement custAndProjTaskCloseBtn;
	
	@FindBy(name="visiableFilterString")
	private WebElement tasksFilterKeyword;
	
	@FindBy(id="tasksFilterSubmitButton")
	private WebElement taskFilterSubmitBtn;
	
	@FindBy(xpath="//a[text()='Open Tasks']")
	private WebElement openTasks;
	
	public OpenTaskPage(WebDriver driver)
	{
		slib= new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//STEP
	public void clickOnProjAndCustLink()
	{
		projAndCustLink.click();
		
	}
	
	//STEP
	public void clickOnCreateNewTask()
	{
		createNewTaskBtn.click();
	}
	
	public void verifyNewTaskAddedProjName(String taskProjName)
	{
		slib.validateElementDisplyed(successmsg, taskProjName, successmsg.getText());
	}
	public void verifyNewTaskAddedCustName(String CustName)
	{
		slib.validateElementDisplyed(successmsg, CustName, successmsg.getText());
	}
	
	public void clickOnTask(String selectTaskName, String custName)
	{
		custAndProjDrpDwn.click();
		if(selCustAndProj.getText().equalsIgnoreCase(custName))
		{
			selCustAndProj.click();
		}
		else
		{
			System.out.println("Data not found");
		}
		slib.clickButon(custAndProjTaskCloseBtn);
		
		slib.enterData(tasksFilterKeyword, selectTaskName);
		
		slib.clickButon(taskFilterSubmitBtn);
		
		if(selectTask.getText().equalsIgnoreCase(selectTaskName))
		{
			selectTask.click();
		}
		else
		{
			System.out.println("Task not Found");
		}
	}
	
	public void verifyDeleteTask()
	{
		String expected = "Task has been successfully deleted.";
		String actual = successmsg.getText();
		slib.validate(expected, actual, expected);
	}
	
}
