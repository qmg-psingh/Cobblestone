package com.quoteZone.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.webdriver.controls.Button;
import com.webdriver.controls.DropDown;
import com.webdriver.controls.RadioButton;

public class FormPage3 {

	public static WebDriver driver;

	private DropDown mainDoorList, patioDoorList, externalDoorList, totalSmokeAlarmList, neighbourhoodWatchList;

	private RadioButton lockableEntranceRadio, alarmRadio, windowLockRadio;
	private Button nextButton;

	/**
	 * This is the constructor of this class. est
	 * 
	 * @param driver:
	 *            The WebDriver instance
	 */
	public FormPage3(WebDriver driver) {

		this.driver = driver;
		lockableEntranceRadio = new RadioButton(driver,
				By.cssSelector("div.floatRight input[name='own_lockable_entrance']"));
		alarmRadio = new RadioButton(driver, By.cssSelector("div.floatRight input[name='property_alarm_installed']"));
		windowLockRadio = new RadioButton(driver, By.cssSelector("div.floatRight input[name='property_window_lock']"));

		mainDoorList = new DropDown(driver, By.cssSelector("select[name='property_maindor_lock']"));
		patioDoorList = new DropDown(driver, By.cssSelector("select[name='property_patiodor_lock']"));
		externalDoorList = new DropDown(driver, By.cssSelector("select[name='property_externaldor_lock']"));
		totalSmokeAlarmList = new DropDown(driver, By.cssSelector("select[name='property_total_smoke_alarms']"));
		neighbourhoodWatchList = new DropDown(driver, By.cssSelector("select[name='property_local_watch']"));
		nextButton = new Button(driver, By.id("nextButton"));

	}

	public void selectLocakableRadio(String radioLabel) {
		List<WebElement> lockableEntranceRadioList = lockableEntranceRadio
				.getMultipleElements(By.cssSelector("div.floatRight input[name='own_lockable_entrance']"));
		for (WebElement radioButton : lockableEntranceRadioList) {
			if (radioButton.getText().equalsIgnoreCase(radioLabel)) {
				radioButton.click();
				break;
			}
		}
	}

	public void selectAlarmRadio(String radioLabel) {
		if (radioLabel.equalsIgnoreCase("Yes")) {
			alarmRadio= new RadioButton(driver, By.xpath("//input[@name='property_alarm_installed' and @value='Y']"));
alarmRadio.click();
		}
		else if (radioLabel.equalsIgnoreCase("No")) {
			alarmRadio= new RadioButton(driver, By.xpath("//input[@name='property_alarm_installed' and @value='N']"));
alarmRadio.click();
		}
		else{
			System.out.println("In valid value entered:"+radioLabel);
			
		}
	}

		
	

	public void selectWindowLockRadio(String radioLabel) {
		
		if (radioLabel.equalsIgnoreCase("Yes")) {
			windowLockRadio= new RadioButton(driver, By.xpath("//input[@name='property_window_lock' and @value='Y']"));
windowLockRadio.click();
		}
		else if (radioLabel.equalsIgnoreCase("No")) {
			windowLockRadio= new RadioButton(driver, By.xpath("//input[@name='property_window_lock' and @value='N']"));
windowLockRadio.click();
		}
		else{
			System.out.println("In valid value entered:"+radioLabel);
			
		}
	}

	public void selectMainDoor(String value) {
		mainDoorList.select(value);
	}

	public void selectPatioDoor(String value) {
		patioDoorList.select(value);
	}

	public void selectExternalDoor(String value) {
		externalDoorList.select(value);
	}

	public void selectTotalSmokeAlarm(String value) {
		totalSmokeAlarmList.select(value);
	}

	public void selectNeighbourhoodWatch(String value) {
		neighbourhoodWatchList.select(value);
	}

	public void clickOnNextButton() {
		nextButton.click();
	}
	public boolean verifyPageTitle(){
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath("//h1[contains(.,'Security')]")).isDisplayed();
	}

}
