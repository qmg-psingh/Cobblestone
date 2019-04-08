package com.webdriver.driver;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

//This class is for reading values from configuration files 

public class ConfigReader {
//This method is for handling configurations at Global level and of environment property file
	public static String getGlobalValue(String variable) {

		Properties prop = new Properties();
		String workingDir = System.getProperty("user.dir");
		String propFileName = workingDir+"/../config/GlobalEnvConfig.properties";

		try {
			prop.load(new FileReader(propFileName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(variable);
	}
	//This method is for handling configurations at test level

	public static String getLocalValue(String variable) {

		Properties prop = new Properties();
		String propFileName = "config/envconfig.properties";

		try {
			prop.load(new FileReader(propFileName));

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return prop.getProperty(variable);
	}

}
