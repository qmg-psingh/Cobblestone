package com.quoteZone.pages;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.controls.Button;
import com.webdriver.controls.Link;
import com.webdriver.controls.TextField;

/**
 * This page contains all the object and event libraries to perform action on Index page.
 * @author QASource
 *
 */
public class IndexPage {
	
	public WebDriver driver;
	
	private Link bcLink;
		
	/**
	 * This is the constructor of this class. est
	 * @param driver: The WebDriver instance
	 */
	public IndexPage(WebDriver driver) {
		
		this.driver = driver;
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.MILLISECONDS);
		bcLink = new Link(driver, By.xpath(".//div[contains(@class,'coverDiv')]/img[contains(@alt,'Buildings & Contents Insurance')]"));
		
		
	}
	
	/**
	 * This method is used to select type of cover as Buildings and contents on Index page
	 */
	public void selectBuildingsAndContents(){
		
		bcLink.click();
	}
	
	
}
