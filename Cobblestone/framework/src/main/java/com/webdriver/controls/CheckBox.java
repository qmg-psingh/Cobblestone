package com.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//This class is a wrapper on Selenium Checkbox class and contains all methods of a webelement checkbox

public class CheckBox
{

	private ObjectFactory object;

	public CheckBox(WebDriver driver, By by) {
		object = new ObjectFactory(driver, by);
	}

	public void click() {
		object.click();		
	}
	
	public void submit(){
		object.submit();
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
	
	public String getAttributeValue(String attributeName)
    {
	    String value=object.getAttributeValue(attributeName);
	    return value;
    }
}

