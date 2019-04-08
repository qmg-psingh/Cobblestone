package com.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//This class is a wrapper on Selenium Button class and contains all methods of a webelement button
public class Button {

	private ObjectFactory object;

	public Button(WebDriver driver, By by) {
		object = new ObjectFactory(driver, by);
	}
	public java.util.List<WebElement> getMultipleElements(By by){		
		return object.findElements(by);		
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
}
