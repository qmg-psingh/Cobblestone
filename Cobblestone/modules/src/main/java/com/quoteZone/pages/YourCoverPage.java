package com.quoteZone.pages;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.webdriver.controls.DropDown;
import com.webdriver.controls.RadioButton;
import com.webdriver.controls.TextField;

public class YourCoverPage {

	public static WebDriver driver;
	private TextField  renewalPriceInput, rebuildInput, marketValueInput, contentsSumInput;
	private RadioButton insuranceCoverRadio, bankruptRadio, specialTermsRadio, policyDeclinedRadio,
			insuranceClaimsRadio, accidentalBuildingsRadio, laptopInsuranceRadio, specificItemsInsuranceRadio, accidentalContentsDamageRadio;
	private DropDown noClaimList, dateOfInsuranceList, insurancePaymentList, occupantsConvictionsList,
			buildNoClaimsList, buildVoluntaryExcessList, coverList,contentsVoluntaryExcessInput;

	/**
	 * This is the constructor of this class. est
	 * 
	 * @param driver:
	 *            The WebDriver instance
	 */
	public YourCoverPage(WebDriver driver) {

		this.driver = driver;

		dateOfInsuranceList = new DropDown(driver, By.name("date_of_insurance_start_fake"));
		insurancePaymentList = new DropDown(driver, By.name("property_payment_type"));
	
		occupantsConvictionsList = new DropDown(driver, By.name("occupants_convictions"));
	
		renewalPriceInput = new TextField(driver, By.id("user_renewal_price"));
		rebuildInput = new TextField(driver, By.name("build_sums_ins"));
		marketValueInput = new TextField(driver, By.name("build_sums_market"));
		buildNoClaimsList = new DropDown(driver, By.name("build_no_claims_bonus"));
		buildVoluntaryExcessList = new DropDown(driver, By.name("build_voluntary_excess"));

		contentsSumInput = new TextField(driver, By.xpath("//input[@name='contents_sums_ins']"));
		
		
		coverList = new DropDown(driver, By.name("all_risks_unspecified"));
		noClaimList = new DropDown(driver, By.name("contents_no_claims_bonus"));
		contentsVoluntaryExcessInput = new DropDown(driver, By.name("contents_voluntary_excess"));
	}
	public boolean verifyPageTitle(){
		driver.manage().timeouts().pageLoadTimeout(200, TimeUnit.MILLISECONDS);
		return driver.findElement(By.xpath("//h1[contains(.,'Your cover')]")).isDisplayed();
	}//
	public void selectInsuranceCoverRadio(String value) {
		if(value.equalsIgnoreCase("The building and its contents")){
			 insuranceCoverRadio=new RadioButton(driver, By.xpath("//input[@name='property_cover_type' and @value='BC']"));
			 insuranceCoverRadio.click();
		}
		else if (value.equalsIgnoreCase("The building only")) {
			insuranceCoverRadio=new RadioButton(driver, By.xpath("//input[@name='property_cover_type' and @value='B']"));
			insuranceCoverRadio.click();
		}
		else if (value.equalsIgnoreCase("The contents only")) {
			insuranceCoverRadio=new RadioButton(driver, By.xpath("//input[@name='property_cover_type' and @value='C']"));
			insuranceCoverRadio.click();
		}
		else {
		 System.out.println("Value is invalid:"+value);
		}
	}

	public void selectDateOfInsuranceList(int index) {
		dateOfInsuranceList.selectByIndex(index);
	}

	public void selectInsurancePaymentList(String value) {
		insurancePaymentList.select(value);
	}

	public void selectBankruptRadio(String value) {
		
		if(value.equalsIgnoreCase("Yes")){
			 bankruptRadio=new RadioButton(driver, By.xpath("//input[@name='property_bankrupt' and @value='Y']"));
bankruptRadio.click();
		}
		else if (value.equalsIgnoreCase("No")) {
			 bankruptRadio=new RadioButton(driver, By.xpath("//input[@name='property_bankrupt' and @value='N']"));
bankruptRadio.click();
		}
		else {
		 System.out.println("Value is invalid:"+value);
		}
	}

	public void selectSpecialTermsRadio(String value) {
		
		if(value.equalsIgnoreCase("Yes")){
			 specialTermsRadio=new RadioButton(driver, By.xpath("//input[@name='special_terms_policy' and @value='Y']"));
			 specialTermsRadio.click();
		}
		else if (value.equalsIgnoreCase("No")) {
			 specialTermsRadio=new RadioButton(driver, By.xpath("//input[@name='special_terms_policy' and @value='N']"));
			 specialTermsRadio.click();
		}
	
		else {
		 System.out.println("Value is invalid:"+value);
		}
	}

	public void selectPolicyDeclinedRadio(String value) {
		
		if(value.equalsIgnoreCase("Yes")){
			 policyDeclinedRadio=new RadioButton(driver, By.xpath("//input[@name='policy_declined' and @value='Y']"));
policyDeclinedRadio.click();
		}
		else if (value.equalsIgnoreCase("No")) {
			policyDeclinedRadio=new RadioButton(driver, By.xpath("//input[@name='policy_declined' and @value='N']"));
			policyDeclinedRadio.click();
		}
		else {
		 System.out.println("Value is invalid:"+value);
		}
	}

	public void selectOccupantsConvictionsList(String value) {
		occupantsConvictionsList.select(value);
	}

	public void selectInsuranceClaimsRadio(String value) {
		
		if(value.equalsIgnoreCase("Yes")){
			 insuranceClaimsRadio=new RadioButton(driver, By.xpath("//input[@name='property_insurance_claims' and @value='Y']"));
insuranceClaimsRadio.click();
		}
		else if (value.equalsIgnoreCase("No")) {
			 insuranceClaimsRadio=new RadioButton(driver, By.xpath("//input[@name='property_insurance_claims' and @value='N']"));
insuranceClaimsRadio.click();
		}
		else {
		 System.out.println("Value is invalid:"+value);
		}
	}

	public void setRenewalPrice(String price) {
		renewalPriceInput.sendKeys(price);
	}

	public void setRebuildInput(String price) {
		rebuildInput.sendKeys(price);
	}

	public void setMarketValue(String value) {
		marketValueInput.sendKeys(value);
	}

	public void selectBuildNoClaimsList(String value) {
		buildNoClaimsList.select(value);
	}

	public void selectBuildVoluntaryExcessList( int index) {
		buildVoluntaryExcessList.selectByIndex(index);
	}
	public void selectBuildVoluntaryExcessListString( String value) {
		buildVoluntaryExcessList.select(value);
	}

	public void selectBuildingsAccidentalRadio(String value) {
		
		if(value.equalsIgnoreCase("Yes")){
			 accidentalBuildingsRadio=new RadioButton(driver, By.xpath("//input[@name='build_acc_dam' and @value='Y']"));
			 accidentalBuildingsRadio.click();

		}
		else if (value.equalsIgnoreCase("No")) {
			 accidentalBuildingsRadio=new RadioButton(driver, By.xpath("//input[@name='build_acc_dam' and @value='N']"));
			 accidentalBuildingsRadio.click();
		}
		else {
		 System.out.println("Value is invalid:"+value);
		}
		
	}

	public void setContentsSum(String value) {
		contentsSumInput.sendKeys(value);
	}

	public void selectLaptopInsuranceRadio(String value) {
		
		if(value.equalsIgnoreCase("Yes")){
			 laptopInsuranceRadio=new RadioButton(driver, By.xpath("//input[@name='property_laptop_insurance' and @value='Y']"));
laptopInsuranceRadio.click();
		}
		else if (value.equalsIgnoreCase("No")) {
			laptopInsuranceRadio=new RadioButton(driver, By.xpath("//input[@name='property_laptop_insurance' and @value='N']"));
laptopInsuranceRadio.click();
		}
		else {
		 System.out.println("Value is invalid:"+value);
		}
	}

	public void selectSpecificItemInsuranceRadio(String value) {
		
		if(value.equalsIgnoreCase("Yes")){
			 specificItemsInsuranceRadio=new RadioButton(driver, By.xpath("//input[@name='property_items_insurance' and @value='Y']"));
			 specificItemsInsuranceRadio.click();
		}
		else if (value.equalsIgnoreCase("No")) {
			 specificItemsInsuranceRadio=new RadioButton(driver, By.xpath("//input[@name='property_items_insurance' and @value='N']"));
			 specificItemsInsuranceRadio.click();
		}
		else {
		 System.out.println("Value is invalid:"+value);
		}
	}

	public void selectPersonalPossesionsCoverList(String value) {
		coverList.select(value);
	}

	public void selectNoClaimContentsList(String value) {
		noClaimList.select(value);
	}

	public void setContentVoluntaryExcessInput(String value) {
		contentsVoluntaryExcessInput.select(value);
	}

	public void selectContentsAccidentalDamageRadio(String value) {
		
		if(value.equalsIgnoreCase("Yes")){
			 accidentalContentsDamageRadio=new RadioButton(driver, By.xpath("//input[@name='contents_acc_dam' and @value='Y']"));
			 accidentalContentsDamageRadio.click();
		}
		else if (value.equalsIgnoreCase("No")) {
			accidentalContentsDamageRadio=new RadioButton(driver, By.xpath("//input[@name='contents_acc_dam' and @value='N']"));
			accidentalContentsDamageRadio.click();
		}
		else {
		 System.out.println("Value is invalid:"+value);
		}
	}
}