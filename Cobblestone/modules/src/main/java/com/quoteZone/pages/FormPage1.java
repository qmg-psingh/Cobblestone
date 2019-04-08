package com.quoteZone.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.webdriver.controls.DropDown;
import com.webdriver.controls.RadioButton;
import com.webdriver.controls.TextField;
import com.webdriver.driver.Driver;
import com.webdriver.utilities.SpreadsheetUtilities;

/**
 * This page contains all the object and event libraries to perform action on
 * Home Page.
 * 
 * @author QASource
 *
 */
public class FormPage1 {

	public WebDriver driver;
	SpreadsheetUtilities spreadsheetUtilities;
	
	

	private RadioButton houseRadio;
	private RadioButton flatApartmentRadio;
	private RadioButton bungalowRadio;
	private RadioButton townHouseRadio;
	private RadioButton otherRadio;
	private DropDown houseTypeList;
	private DropDown apartmentTypeList;

	private DropDown otherTypeList;
	private TextField bedroomsInput;
	private TextField bathroomsInput;
	private TextField livingRoomInput;
	private TextField kitchenInput;

	private TextField otherRoomInput;
	private TextField yearBuiltInput;
	private RadioButton tallerTreesRadio;
	private DropDown roofMaterialList;
	private DropDown flatRoofList;
	private RadioButton assumptionRadio;

	// ********************** Below elements appear on clicking assumptions No
	// Radio
	private DropDown extWallsMaterialList;
	private RadioButton subsidentPropRadio;

	private RadioButton underpiningRadio;

	private RadioButton floodingRadio;

	private RadioButton workInProgressRadio;

	private DropDown nearestRiverList;
	private DropDown listedBuildingList;
	private DropDown mainResidenceList;
	private RadioButton forSaleRadio;

	private RadioButton goodRepairStateRadio;

	/**
	 * This is the constructor of this class. est
	 * 
	 * @param driver:
	 *            The WebDriver instance
	 */
	public FormPage1(WebDriver driver) {

		this.driver = driver;
		spreadsheetUtilities = new SpreadsheetUtilities("TestData_"+Driver.aggregatorName+".xls");

		houseRadio = new RadioButton(driver, By.id("property_sort_House"));
		flatApartmentRadio = new RadioButton(driver, By.id("property_sort_Apartment"));
		bungalowRadio = new RadioButton(driver, By.id("property_sort_Bungalow"));
		townHouseRadio = new RadioButton(driver, By.id("property_sort_TownHouse"));
		otherRadio = new RadioButton(driver, By.id("property_sort_Other"));
		houseTypeList = new DropDown(driver, By.id("property_house_type"));// used
																			// for
																			// property
																			// sort
																			// house,
																			// bungalow,
																			// Town
																			// House

		apartmentTypeList = new DropDown(driver, By.id("property_apartment_type"));// used
																					// for
																					// Flat/
																					// Apartment
		otherTypeList = new DropDown(driver, By.id("property_other_type"));// used
																			// for
																			// Other

		bedroomsInput = new TextField(driver, By.name("property_bedrooms"));
		bathroomsInput = new TextField(driver, By.name("property_bathrooms"));
		livingRoomInput = new TextField(driver, By.name("property_livingrooms"));
		kitchenInput = new TextField(driver, By.name("property_kitchenrooms"));

		otherRoomInput = new TextField(driver, By.id("property_otherooms"));
		yearBuiltInput = new TextField(driver, By.name("property_year"));
		roofMaterialList = new DropDown(driver, By.name("property_roof_made"));
		flatRoofList = new DropDown(driver, By.name("property_flat_roof"));

		// ********************** Below elements appear on clicking assumptions
		// No Radio
		extWallsMaterialList = new DropDown(driver, By.name("property_house_type"));

		nearestRiverList = new DropDown(driver, By.id("property_house_type"));
		listedBuildingList = new DropDown(driver, By.id("property_house_type"));
		mainResidenceList = new DropDown(driver, By.id("property_house_type"));

	}

	/**
	 * This method is used to select type of cover as Buildings and contents on
	 * Index page
	 */
	public void selectSortOfProperty(String aggregatorQuestion, String propertySort) {
		
		
		switch (propertySort) {
		case "House":
			houseRadio.click();
			System.out.println("House radio clicked");
			break;
		case "Flat/Apartment":
			flatApartmentRadio.click();
			System.out.println("Flat/Apartment radio clicked");
			break;
		case "Bangalow":
			bungalowRadio.click();
			System.out.println("Bungalow radio clicked");
			break;
		case "Town house":
			townHouseRadio.click();
			System.out.println("Town House radio clicked");
			break;
		case "Other":
			otherRadio.click();
			System.out.println("Other radio clicked");
			break;
		default:
			System.out.println("Property sort is invalid: " + propertySort);
			break;
		}
		
		
		
	}

	public void selectTypeOfProperty(String aggregatorQuestion, String propertyType,String sortOfProperty) {
		switch (propertyType) {
		case "Detached":
		case "Semi-detached":
		case "Link detached":
		case "Terrace":
		case "End Terrace":
			houseTypeList.select(propertyType);
			System.out.println("Property type " + propertyType + " selected");
			break;

		case "Purpose built (Self-contained)":
		case "Converted (Self-contained)":
		case "Purpose built (Other)":
		case "Converted (Other)":
		case "Maisonette - Converted":
		case "Maisonette – Purpose built":
			apartmentTypeList.select(propertyType);
			System.out.println("Property type " + propertyType + " selected");
			break;
		case "Bedsit":
		case "Halls of Residence":
			otherTypeList.select(propertyType);
			System.out.println("Property type " + propertyType + " selected");
			break;

		default:
			System.out.println("Property type is invalid: " + propertyType);
			break;
		}

	
	}

	public void setNumberOfBedrooms(String aggregatorQuestion, String bedroomCount) {
		bedroomsInput.sendKeys(bedroomCount);

	
	}

	public void setYearBuilt(String aggregatorQuestion, String yearBuilt) {
		yearBuiltInput.sendKeys(yearBuilt);
		
     
	}
	

	
	public void setTallTreesRadio(String aggregatorQuestion, String value) {
		if (value.equalsIgnoreCase("Yes")) {
			tallerTreesRadio = new RadioButton(driver,
					By.xpath("//input[@name='property_nearest_tree' and @value='Y']"));
			tallerTreesRadio.click();
		} else if (value.equalsIgnoreCase("No")) {
			tallerTreesRadio = new RadioButton(driver,
					By.xpath("//input[@name='property_nearest_tree' and @value='N']"));
			tallerTreesRadio.click();
		} else {
			System.out.println("Value is invalid:" + value);
		}

		
		
     
	}

	

	public void setAssumptionsRadio(String aggregatorQuestion, String value) {
		if (value.equalsIgnoreCase("Yes")) {
			assumptionRadio = new RadioButton(driver, By.xpath("//input[@name='property_assumptions' and @value='Y']"));
			assumptionRadio.click();
		} else if (value.equalsIgnoreCase("No")) {
			assumptionRadio = new RadioButton(driver, By.xpath("//input[@name='property_assumptions' and @value='N']"));
			assumptionRadio.click();
		} else {
			System.out.println("Value is invalid:" + value);
		}

	}
	

		public void setRoofMaterial(String aggregatorQuestion, String roofMaterialValue) {
		roofMaterialList.select(roofMaterialValue);
	}

	public void setFlatRoof(String aggregatorQuestion, String flatRoofValue) {
		flatRoofList.select(flatRoofValue);
	}

}
