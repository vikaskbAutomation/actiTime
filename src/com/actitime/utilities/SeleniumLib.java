package com.actitime.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

public class SeleniumLib 
{
	WebDriver driver;
	
	/***************CONSTRUCTOR************/
	
	public SeleniumLib(WebDriver driver)
	{
		this.driver=driver;
		
	}
	
	/***********ENTER DATA****************/
	public void enterData(WebElement textBx,String input)
	{
		if(textBx.getAttribute("value")!=null)
		{
			textBx.clear();
			textBx.sendKeys(input);
			
		}
		else
		{
			textBx.sendKeys(input);
			
		}
		
	}
	/**************click button************/
	public void clickButon(WebElement button)
	{
		if(button.getAttribute("type").equalsIgnoreCase("button"))
		{
			button.click();
			
		}
		else if(button.getAttribute("type").equalsIgnoreCase("submit"))
		{
			button.submit();
			
		}
	}
	/***********************CLICK CHECKBOX****************/
	public void clickCheckBox(WebElement checkbox)
	{
		if(checkbox.isSelected()==false)
		{
			checkbox.click();
			
		}
		
	}
	/************************MOUSE OVER******************/
	public void mouseOver(WebElement element)
	{
		Actions act = new Actions(driver);
		act.moveToElement(element).perform();
		
		
		
	}
	
	/*************************SELECT OPTION BY TEXT***********/
	public void selectOptionByText(WebElement dropdown, String text)
	{
		Select sel= new Select(dropdown);
		sel.selectByVisibleText(text);
		
	}
	/***********************HARD CODE WAIT********************/
	public void isSleep(int seconds)
	{
		try 
		{
			Thread.sleep(seconds*1000);
		} 
		catch (InterruptedException e)
		{
			e.printStackTrace();
		}
		
	}
	
	/************************EXPLICIT WAIT**********/
	public void eWaitForVisible(int seconds, WebElement element)
	{
		WebDriverWait wait =new WebDriverWait(driver, seconds);
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}


/*******************ASSERT***********************/
	public void validate(String expected, String actual, String msg)
	{
	Assert.assertEquals(actual, expected);
	Reporter.log(msg, true);
	
	}
	/************************GET TITLE********/
	public String getPageTitle()
	{
		
		String title = driver.getTitle();
		return title;
	}
	
	/**********************ASSERT DISPLAYED******/
	
	public void validateElementDisplyed(WebElement element, String exptext,String msg)
	{
		Assert.assertTrue(element.isDisplayed());
		Assert.assertTrue(element.getText().contains(exptext));
		Reporter.log(msg, true);
	}
	
	/***********************HANDLING-POPUP******/
	
	public void popUpHandle()
	{
		driver.switchTo().alert().accept();
	}
	
	
}
