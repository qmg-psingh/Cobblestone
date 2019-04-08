package com.webdriver.controls;

import java.awt.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
//This class is a wrapper on Selenium Radiobutton class and contains all methods of a webelement radiobutton

public class RadioButton 
{
	private ObjectFactory object;

	public RadioButton(WebDriver driver, By by) {
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
	public java.util.List<WebElement> getMultipleElements(By by){		
		return object.findElements(by);		
	}
	
	public String getText(){		
		return object.getText();
	}

}
