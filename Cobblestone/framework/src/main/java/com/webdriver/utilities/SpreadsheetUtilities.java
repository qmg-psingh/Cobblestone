package com.webdriver.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashSet;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class SpreadsheetUtilities {

	Workbook workbook;
	Sheet sheet, newSheet;
	String workbookName ;
	
	public SpreadsheetUtilities(String spreadsheetName) {
	
			workbookName = spreadsheetName;
			
	}			
	


	public ArrayList<ArrayList<String>> fetchCompleteDataOfSheet(String sheetName) {
		return null;
		
		
	}
	
	public Sheet addNewSheetInSpreadsheet(String sheetName) {
		
		
		return null;
	}
	
	public void addDataInSheet(String sheetName, LinkedHashSet<String> rowData, int rowIndex){
	
	}
	
	public void addDataInSheet(String sheetName, String columnHeader, String data, int rowIndex) {
		
	}
	
	public String getDataFromSheet(String sheetName, String columnHeader, int rowIndex) {
		return columnHeader;
		
		
	}
}
