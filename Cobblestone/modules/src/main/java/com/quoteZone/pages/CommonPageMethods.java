package com.quoteZone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.controls.Button;

public class CommonPageMethods {
	public WebDriver driver ;
	private Button nextButton;
	public CommonPageMethods(WebDriver driver) {
		this.driver=driver;
		 nextButton=new Button(driver, By.id("nextButton"));
	}
	public void clickNextButton(){
		nextButton.click();
	}
}
