package com.webdriver.utilities;

import java.io.File;
import java.io.IOException;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.read.biff.BiffException;

public class TestDataReader {

	String fileName;
	String sheetName;
	String tableName;

	public TestDataReader(String className, String methodName,
			String userDirectory) {
		sheetName = className;
		tableName = methodName;
		fileName = userDirectory
				+ "/src/test/java/com/webapp/testData/TestData.xls";

		System.out.println(sheetName+"_"+tableName);
		

	}

	public Object[][] readSpreadsheet() {
		Object[][] tabArray = null;

		Workbook workbook;
		try {
			workbook = Workbook.getWorkbook(new File(fileName));

			Sheet sheet = workbook.getSheet(sheetName);
			int startRow, startCol, endRow, endCol, ci, cj;
			Cell tableStart = sheet.findCell(tableName);
			startRow = tableStart.getRow();
			startCol = tableStart.getColumn();

			Cell tableEnd = sheet.findCell(tableName, startCol + 1,
					startRow + 1, 100, 64000, false);

			endRow = tableEnd.getRow();
			endCol = tableEnd.getColumn();

			tabArray = new Object[endRow - startRow - 1][endCol - startCol - 1];
			ci = 0;

			for (int i = startRow + 1; i < endRow; i++, ci++) {
				cj = 0;
				for (int j = startCol + 1; j < endCol; j++, cj++) {
					tabArray[ci][cj] = sheet.getCell(j, i).getContents();
				}
			}
		} catch (BiffException e) {
			e.printStackTrace();
		}
		catch( IOException e)
		{
			e.printStackTrace();
		}
		return tabArray;
	}
}
