package com.quoteZone.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.webdriver.controls.Button;
import com.webdriver.controls.CheckBox;
import com.webdriver.controls.DropDown;
import com.webdriver.controls.RadioButton;
import com.webdriver.controls.TextField;

public class AboutYouPage {

	public static WebDriver driver;

	private Button findAddressButton;
	private TextField firstNameInput, surnameInput, daytimeTelephoneInput, mobileTelephoneInput, emailAddressInput,
			postCodeInput;
	private RadioButton partTimeOccupationeRadio, jointInsuredRadio;
	private DropDown titleList, dateOfBirthDayList, dateOfBirthMonthList, dateOfBirthYearList, ukResidentMonthList,
			ukResidentYearList, maritalStatusList, employmentStatusList, confirmAddressList, occupationList,
			businessList;
	private CheckBox birthCheckBox;

	private DropDown confirmAddressList2;

	/**
	 * This is the constructor of this class. est
	 * 
	 * @param driver:
	 *            The WebDriver instance
	 */
	public AboutYouPage(WebDriver driver) {

		this.driver = driver;
		titleList = new DropDown(driver, By.xpath("//select[contains(@name,'title')]"));
		firstNameInput = new TextField(driver, By.name("first_name"));
		surnameInput = new TextField(driver, By.name("surname"));
		dateOfBirthDayList = new DropDown(driver, By.name("date_of_birth_dd"));
		dateOfBirthMonthList = new DropDown(driver, By.name("date_of_birth_mm"));
		dateOfBirthYearList = new DropDown(driver, By.name("date_of_birth_yyyy"));
		birthCheckBox = new CheckBox(driver, By.name("born_in_uk"));
		ukResidentMonthList = new DropDown(driver, By.name("date_of_uk_resident_mm"));
		ukResidentYearList = new DropDown(driver, By.name("date_of_uk_resident_yyyy"));
		maritalStatusList = new DropDown(driver, By.name("marital_status"));
		employmentStatusList = new DropDown(driver, By.name("employment_status"));
		occupationList = new DropDown(driver, By.id("occupation_list_id"));
		businessList = new DropDown(driver, By.id("business_list_id"));
		daytimeTelephoneInput = new TextField(driver, By.name("daytime_telephone_single_input"));
		mobileTelephoneInput = new TextField(driver, By.name("mobile_telephone_single_input"));
		findAddressButton = new Button(driver, By.cssSelector("div.stdBtn.floatLeft a"));
		postCodeInput = new TextField(driver, By.id("postcodeID"));
		confirmAddressList = new DropDown(driver, By.cssSelector("div#postcode_id select option"));
		confirmAddressList2 = new DropDown(driver, By.name("found_address"));
		emailAddressInput = new TextField(driver, By.name("email_address"));
		partTimeOccupationeRadio = new RadioButton(driver, By.name("part_time_occupation"));
		jointInsuredRadio = new RadioButton(driver, By.name("joint_insured"));
	}

	public boolean verifyPageTitle() {
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath("//h1[contains(.,'Your Details')]")).isDisplayed();
	}

	public void selectTitle(String value) {
		titleList.select(value);
	}

	public void setFirstName(String firstName) {
		firstNameInput.sendKeys(firstName);
	}

	public void setSurname(String surname) {
		surnameInput.sendKeys(surname);
	}

	public void selectDateOfBirth(String day, String month, String year) {
		dateOfBirthDayList.select(day);
		dateOfBirthMonthList.select(month);
		dateOfBirthYearList.select(year);
	}

	public void checkUkResidentByBirth() {
		if (!birthCheckBox.isSelected())
			birthCheckBox.click();
	}

	public void selectUKResidentDateOfBirth(String month, String year) {
		ukResidentMonthList.select(month);
		ukResidentYearList.select(year);
	}

	public void selectMartialList(String value) {
		maritalStatusList.select(value);
	}

	public void selectEmployementStatus(String employementValue) {
		employmentStatusList.select(employementValue);
	}

	public void selectOccupationType(String occupationValue) {
		if (occupationList.isPresent())
			occupationList.select(occupationValue);
	}

	public void selectBusinessType(String businessValue) {
		if (businessList.isPresent())
			businessList.select(businessValue);
	}

	public void selectPartTimeOccupationRadio(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			partTimeOccupationeRadio = new RadioButton(driver,
					By.xpath("//input[@name='part_time_occupation' and @value='Y']"));
			partTimeOccupationeRadio.click();
		} else if (value.equalsIgnoreCase("No")) {
			partTimeOccupationeRadio = new RadioButton(driver,
					By.xpath("//input[@name='part_time_occupation' and @value='N']"));
			partTimeOccupationeRadio.click();
		} else {
			System.out.println("Value is invalid:" + value);
		}
	}

	public void setTelephoneNumber(String dayTimeContact) {
		daytimeTelephoneInput.sendKeys(dayTimeContact);
	}

	public void setMobileNumber(String mobileNumber) {
		mobileTelephoneInput.sendKeys(mobileNumber);
	}

	public void setPostCode(String postCode) {
		postCodeInput.sendKeys(postCode);

	}

	public void clickOnFindAddressButton() {
		findAddressButton.click();

	}

	public Boolean verifyConfirmAddressListDisplays() {
		return confirmAddressList.isPresent();
	}

	public void selectConfirmAddressList(String expectedValue) throws InterruptedException {
	List<WebElement> list = confirmAddressList.getMultipleElements(By.cssSelector("div#postcode_id select option"));
		System.out.println("Size: " + list.size());

		for (WebElement list1 : list) {
			if (list1.getText().equalsIgnoreCase(expectedValue)) {
				list1.click();
				Thread.sleep(7000);
				break;
			}
		}
	}

	public void setEmailAddress(String bedroomCount) {
		emailAddressInput.sendKeys(bedroomCount);
	}

	public void selectNomineeRadio(String value) {
		if (value.equalsIgnoreCase("Yes")) {
			jointInsuredRadio = new RadioButton(driver, By.xpath("//input[@name='joint_insured' and @value='Y']"));
			jointInsuredRadio.click();
		} else if (value.equalsIgnoreCase("No")) {
			jointInsuredRadio = new RadioButton(driver, By.xpath("//input[@name='joint_insured' and @value='N']"));
			jointInsuredRadio.click();
		} else {
			System.out.println("Value is invalid:" + value);
		}
	}
}
