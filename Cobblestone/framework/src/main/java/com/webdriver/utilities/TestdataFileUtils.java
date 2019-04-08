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
	
	}

	public Iterator<Object[]> getTestDataForScript(){
		
		
		return null;
	}
	
	public Object[] getHeadersList(){
		return null;
	}
	
	public void createExpectedResultsSpreadsheet(){
		
		
	}
	
	public void addExpectedHeadersInNewSpreadsheet(LinkedHashSet expectedHeadersList){
		
	}
	
	public void addExpectedResult(String  expectedHeader, String expectedAnswer, int rowIndex){
		
	}
	

}
