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
		try {
			workbook = WorkbookFactory.create(new File(Utilities.getTestDataFilePath(workbookName)));
		} catch (EncryptedDocumentException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		sheet = workbook.getSheet(sheetName);
		ArrayList<ArrayList<String>> sheetData = new ArrayList<ArrayList<String>>();
		DataFormatter dataFormatter = new DataFormatter();

		for (Row row : sheet) {
			ArrayList<String> rowData = new ArrayList<String>();
			for (Cell cell : row) {
				rowData.add(dataFormatter.formatCellValue(cell).trim());
			}
			sheetData.add(rowData);
		}
		
		try {
			workbook.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sheetData;
	}
	
	public Sheet addNewSheetInSpreadsheet(String sheetName) {
		if (workbook != null) {
			try {
				workbook.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		FileInputStream fileinp;
		FileOutputStream fileOut;
		Sheet createdSheet=null;
		
		try {
			fileinp = new FileInputStream(Utilities.getTestDataFilePath(workbookName));
			workbook = new HSSFWorkbook(fileinp);
			fileOut = new FileOutputStream(Utilities.getTestDataFilePath(workbookName));
			
			int index=workbook.getSheetIndex(sheetName);
			
			if(index!=-1){
			workbook.removeSheetAt(index);
			}
			
			createdSheet= workbook.createSheet(sheetName);
			
			
			   workbook.write(fileOut);
			    fileOut.close();
			    fileinp.close();
			    workbook.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		
		return createdSheet;
	}
	
	public void addDataInSheet(String sheetName, LinkedHashSet<String> rowData, int rowIndex){
		try
		   {
		       FileInputStream myxls = new FileInputStream(Utilities.getTestDataFilePath(workbookName));
		       HSSFWorkbook workbook = new HSSFWorkbook(myxls);
		       HSSFSheet worksheet = workbook.getSheet(sheetName);
		       Row row = worksheet.createRow(rowIndex);
		       int i=0;
		       for(String data : rowData){
		    	   row.createCell(i).setCellValue(data);
		    	   i++;
		       }
		       
		       myxls.close();
		       FileOutputStream output_file =new FileOutputStream(new File(Utilities.getTestDataFilePath(workbookName)));  
		       //write changes
		       workbook.write(output_file);
		       output_file.close();
		       workbook.close();
		    }
		    catch(Exception e)
		    {
		    }
	}
	
	public void addDataInSheet(String sheetName, String columnHeader, String data, int rowIndex) {
		try {
			FileInputStream myxls = new FileInputStream(Utilities.getTestDataFilePath(workbookName));
			HSSFWorkbook workbook = new HSSFWorkbook(myxls);
			HSSFSheet worksheet = workbook.getSheet(sheetName);
			Row row = null;
			
			if (worksheet.getRow(rowIndex) == null) {
				worksheet.createRow(rowIndex);
			}

			row = worksheet.getRow(rowIndex);

			int columnIndex = 0;
			Row headerRow = worksheet.getRow(0);
			Iterator<Cell> cellIterator = headerRow.cellIterator();
			while (cellIterator.hasNext()) {
				Cell columnName = cellIterator.next();
				if (columnHeader.equals(columnName.getRichStringCellValue().toString())) {
					columnIndex = columnName.getColumnIndex();
					break;
				}
			}

			row.createCell(columnIndex).setCellValue(data);

			myxls.close();
			FileOutputStream output_file = new FileOutputStream(new File(Utilities.getTestDataFilePath(workbookName)));
			// write changes
			workbook.write(output_file);
			output_file.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public String getDataFromSheet(String sheetName, String columnHeader, int rowIndex) {
		String cellValue=null;
		try {
			FileInputStream myxls = new FileInputStream(Utilities.getTestDataFilePath(workbookName));
			HSSFWorkbook workbook = new HSSFWorkbook(myxls);
			HSSFSheet worksheet = workbook.getSheet(sheetName);
			Row row = worksheet.getRow(rowIndex);

			int columnIndex = 0;
			Row headerRow = worksheet.getRow(0);
			Iterator<Cell> cellIterator = headerRow.cellIterator();
			while (cellIterator.hasNext()) {
				Cell columnName = cellIterator.next();
				if (columnHeader.equals(columnName.getRichStringCellValue().toString())) {
					columnIndex = columnName.getColumnIndex();
					break;
				}
			}

			cellValue = row.getCell(columnIndex).getRichStringCellValue().getString();

			myxls.close();
			workbook.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return cellValue;
	}
}
