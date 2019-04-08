package com.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//This class is a wrapper on Selenium Select class and contains all methods of a webelement select


public class DropDown 
{
	private ObjectFactory object;

	public DropDown(WebDriver driver, By by) {
		object = new ObjectFactory(driver, by);
	}
	public String getSelectedValue(){
		return object.getSelectedValue();
	}
	
	public void click() {
		object.click();		
	}
	
	public boolean isPresent(){
		return object.isDisplayed();
	}
	
	public boolean isEnabled(){
		return object.isEnabled();
	}
	
	public boolean isSelected(){
		return object.isSelected();
	}
	
	public void select(String value)
    {
        object.Select(value);
    }
	public void selectByIndex( int index)
    {
        object.SelectByIndex(index);
    }
	
	
	public String getAttributeValue(String attributeName)
    {
	    String value=object.getAttributeValue(attributeName);
	    return value;
    }
}
