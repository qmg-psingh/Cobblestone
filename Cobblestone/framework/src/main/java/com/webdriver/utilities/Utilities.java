package com.webdriver.utilities;

import java.io.File;
import java.io.FilenameFilter;

public class Utilities {
	
	public static String getMappingFilePath(String fileName){
		File folder = new File(System.getProperty("user.dir") + "/src/test/resources/mappingFiles/");

		FilenameFilter txtFileFilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.equalsIgnoreCase(fileName)) {
					return true;
				} else {
					return false;
				}
			}
		};

		File[] files = folder.listFiles(txtFileFilter);
		return files[0].getAbsolutePath();	
	}
	
	public static String getTestDataFilePath(String fileName){
		File folder = new File(System.getProperty("user.dir") + "/src/test/resources/spreadsheets/");

		FilenameFilter txtFileFilter = new FilenameFilter() {
			@Override
			public boolean accept(File dir, String name) {
				if (name.equalsIgnoreCase(fileName)) {
					return true;
				} else {
					return false;
				}
			}
		};

		File[] files = folder.listFiles(txtFileFilter);
		return files[0].getAbsolutePath();	
	}

}
