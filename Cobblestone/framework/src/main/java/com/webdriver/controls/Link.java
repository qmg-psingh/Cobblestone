package com.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//This class is a wrapper on Selenium Link class and contains all methods of a webelement link

public class Link 
{
	private ObjectFactory object;

	public Link(WebDriver driver, By by) {
		object = new ObjectFactory(driver, by);
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
	
	public String getText() {
		return object.getText();
	}
}
