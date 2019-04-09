package com.quoteZone.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.webdriver.controls.Button;
import com.webdriver.controls.CheckBox;
import com.webdriver.controls.DropDown;
import com.webdriver.controls.ObjectFactory;
import com.webdriver.controls.RadioButton;
import com.webdriver.controls.TextField;

public class FormPage2 {

	public static WebDriver driver;
	
	private DropDown ownershipList,occupiedList,adultsList,childrenList,unoccupiedList,unoccupiedDaysList,businessTypeList,monthList,yearList;
	private CheckBox purchasedCheckbox;
	private TextField propertyLivedInput;
	private RadioButton smokerRadio;
	private Button nextButton;
	
	/**
	 * This is the constructor of this class. est
	 * 
	 * @param driver:
	 *            The WebDriver instance
	 */
	public FormPage2(WebDriver driver) {

		this.driver = driver;

		ownershipList = new DropDown(driver, By.cssSelector("select[name='property_owned']"));
		occupiedList = new DropDown(driver, By.cssSelector("select[name='property_occupied']"));
		adultsList=new DropDown(driver, By.cssSelector("select[name='property_adults']"));		
		childrenList=new DropDown(driver, By.cssSelector("select[name='property_children']"));
		unoccupiedList=new DropDown(driver, By.cssSelector("select[name='property_unoccupied']"));
		unoccupiedDaysList=new DropDown(driver, By.cssSelector("select[name='property_unoccupied_days']"));
		businessTypeList=new DropDown(driver, By.cssSelector("select[name='property_business_type']"));
		monthList=new DropDown(driver, By.id("monthID"));
		yearList=new DropDown(driver, By.id("yearID"));
		propertyLivedInput=new TextField(driver,By.cssSelector("[name='property_years_lived']"));
		purchasedCheckbox=new CheckBox(driver, By.cssSelector("[name='property_purchased']"));
		smokerRadio=new RadioButton(driver, By.cssSelector("div.rdlbl.floatLeft label"));
		nextButton=new Button(driver, By.id("nextButton"));
		
	}
	
	public boolean verifyPageTitle(){
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath("//h1[contains(.,'Occupancy')]")).isDisplayed();
	}

	public void selectOwnerShip(String ownership) {		
			ownershipList.select(ownership);		
	}
	
	public void selectPropertyOccupied(String occupiedValue) {		
			occupiedList.select(occupiedValue);		
		}
	
	public void selectAdults(String value) {		
		adultsList.select(value);		
	}
	
	public void selectChildren(String value) {		
		childrenList.select(value);		
	}
	
	public void selectUnoccupied(String value) {		
		unoccupiedList.select(value);		
	}
	
	public void selectUnoccupiedDays(String value) {		
		unoccupiedDaysList.select(value);		
	}
	
	public void selectbusinessType(String value) {		
		businessTypeList.select(value);		
	}
	
	public void checkPurchaseBox(){
		purchasedCheckbox.click();
	}
	
	public void selectMonth(String value){
		monthList.select(value);		
	}

	public void selectYear(String value){
		yearList.select(value);		
	}
	
	public void setYearToLived(String value) {
		propertyLivedInput.sendKeys(value);
	}

	public void selectSmokerRadio(String radioLabel){
		
		List<WebElement>smokerRadioList=smokerRadio.getMultipleElements(By.cssSelector("div.rdlbl.floatLeft label"));
		smokerRadioList.stream().filter(radio-> radio.getText().equalsIgnoreCase(radioLabel)).findAny().get().click();		
	}

	public void clickOnNextButton(){
		nextButton.click();
	}
	
}
