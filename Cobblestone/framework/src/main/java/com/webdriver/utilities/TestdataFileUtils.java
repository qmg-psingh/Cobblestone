package com.webdriver.utilities;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;

public class TestdataFileUtils {
	SpreadsheetUtilities spreadsheetUtilities;
	ArrayList<ArrayList<String>> spreadsheetData = new ArrayList<ArrayList<String>>();
	LinkedHashSet expectedHeadersList;
	Object[] header;
	String sheetName;
	String aggregatorName;
	String expectedDataSheetName;
	
	

	public TestdataFileUtils(String aggregatorName, String sheetName) {
		this.sheetName = sheetName;
		this.aggregatorName = aggregatorName;
		spreadsheetUtilities = new SpreadsheetUtilities("TestData_"+aggregatorName+".xls");
		spreadsheetData = spreadsheetUtilities.fetchCompleteDataOfSheet(sheetName);
	}

	
	public Iterator<Object[]> getTestDataForScript(){
		ArrayList<Object[]> testData = new ArrayList<>();
		
		for (ArrayList<String> row : spreadsheetData) {
			Object[] testDataRow = row.toArray();
			testData.add(testDataRow);
		}
		
		header = testData.get(0);
		testData.remove(0);
		
		return testData.iterator();
	}
	
	public Object[] getHeadersList(){
		return header;
	}
	
	public void createExpectedResultsSpreadsheet(){
		expectedDataSheetName=sheetName+"_E";
		spreadsheetUtilities.addNewSheetInSpreadsheet(expectedDataSheetName);
		
	}
	
	public void addExpectedHeadersInNewSpreadsheet(LinkedHashSet expectedHeadersList){
		this.expectedHeadersList = expectedHeadersList;
		spreadsheetUtilities.addDataInSheet(expectedDataSheetName, this.expectedHeadersList, 0);
	}
	
	public void addExpectedResult(String  expectedHeader, String expectedAnswer, int rowIndex){
		spreadsheetUtilities.addDataInSheet(expectedDataSheetName, expectedHeader, expectedAnswer, rowIndex);
	}
	

}
