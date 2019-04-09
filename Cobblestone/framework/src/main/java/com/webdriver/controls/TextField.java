package com.webdriver.controls;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//This class is a wrapper on Selenium TextField class and contains all methods of a webelement TextField

public class TextField {
	private ObjectFactory object;

	public TextField(WebDriver driver, By by) {
		object = new ObjectFactory(driver, by);
	}

	public void sendKeys(String... str) {
		object.clear();
		object.sendKeys(str);
	}

	@Deprecated
	public void TypeKeys(String... str) {
		object.sendKeys(str);
	}
	
	public String getText() {
		return object.getText();
	}
	
	public String getAttributes(String str) {
		return object.getAttribute(str);
	}

	public void click() {
		object.click();
	}

	public boolean isPresent() {
		return object.isDisplayed();
	}

	public boolean isEnabled() {
		return object.isEnabled();
	}

	public boolean isSelected() {
		return object.isSelected();
	}
	
	public String getAttributeValue(String attributeName)
    {
	    String value=object.getAttributeValue(attributeName);
	    return value;
    }
	
}
