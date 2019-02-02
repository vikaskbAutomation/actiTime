package com.actitime.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.actitime.utilities.SeleniumLib;

public class CreateNewTasksPage 
{
	
	SeleniumLib slib;
	
	@FindBy(name="customerId")
	private WebElement selCustTaskDrpDwn;
	
	@FindBy(name="projectId")
	private WebElement selProjectDrpDwn;
	
	@FindBy(xpath="//input[@name='task[0].name']")
	private WebElement taskNameTextBx;
	
	@FindBy(id="ext-gen7")
	private WebElement deadlineCalendarImg;
	
	@FindBy(id="ext-gen136")
	private WebElement todayDate;
	
	@FindBy(css="select[name*='task[0].billingType']")
	private WebElement billingTypeDrpDwn;
	
	@FindBy(css="input[name='task[0].markedToBeAddedToUserTasks']")
	private WebElement addToMyTimeTrackChkBx;
	
	@FindBy(css="input[value='Create Tasks']")
	private WebElement createTasksBtn;
	
	@FindBy(xpath="//input[contains(@name,'.name')]")
	private WebElement multipleTasksTxtBx;
	
	@FindBy(xpath="//img[contains(@class,'x-form-trigger x-form-date-trigger')]")
	private WebElement calenderImg;
	
	@FindBy(xpath="//button[text()='today']")
	private WebElement multipleTasksTodayDate;
	
	@FindBy(css="select[name*='billingType']")
	private WebElement multipleTasksBillingDrpDwn;
	
	@FindBy(css="input[name*='markedToBeAddedToUserTasks']")
	private WebElement multipleTasksAddToMyTimeTrackChkBx;
	
	public CreateNewTasksPage(WebDriver driver)
	{
		slib=new SeleniumLib(driver);
		PageFactory.initElements(driver, this);
	}
	
	//STEP
	public void selectCust(String customerName)
	{
		slib.selectOptionByText(selCustTaskDrpDwn, customerName);
	}
	
	//STEP
	public void selectProj(String projectName)
	{
		slib.selectOptionByText(selProjectDrpDwn, projectName);
	}
	
	//STEP
	public void enterTaskData(String taskName)
	{
		slib.enterData(taskNameTextBx, taskName);
		deadlineCalendarImg.click();
		todayDate.click();
		slib.selectOptionByText(billingTypeDrpDwn, "Billable");
		slib.clickCheckBox(addToMyTimeTrackChkBx);
		slib.clickButon(createTasksBtn);
	}
	
	public void MultipleTasks(String newTaskName)
	{
		slib.enterData(multipleTasksTxtBx, newTaskName);
		calenderImg.click();
		multipleTasksTodayDate.click();
		slib.selectOptionByText(multipleTasksBillingDrpDwn, "Billable");
		slib.clickCheckBox(multipleTasksAddToMyTimeTrackChkBx);
	}
	public void clickOnCreateTasksBtn()
	{
		slib.clickButon(createTasksBtn);
	}
}
