package com.webdriver.driver;

import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

import com.webdriver.utilities.TestdataFileUtils;
// Driver class is responsible for performing pre and post test tasks 
public class Driver {

	protected WebDriver driver;
	protected String appURL;
	protected String mainWindowHandle;
	private long maxWaitTimeToPOLLElement;
	
	public static int TestRunID;
	public static Map<String, String> data = new HashMap<String, String>();
	
	public static String aggregatorName;
	public TestdataFileUtils fileUtils;
	
	public	static int rowCount;
	public	List<Object> headers;
	public static String expectedResultsSheetName;
	
	ArrayList<String> aggregatorHeaders;
	ArrayList<String> expectedHeadersList;
	// Setup aggregator to be tested
	@BeforeClass
	@Parameters({"aggregatorName"})
	public void setup(String aggregatorName){
		Driver.aggregatorName= aggregatorName;
		
		
	}
	
	public void addExpectedHeadersInSpreadsheet(){
		
		headers = Arrays.asList(fileUtils.getHeadersList());
		fileUtils.createExpectedResultsSpreadsheet();
		
		
		HashMap<String, String> expectedValues = new LinkedHashMap();
		LinkedHashSet<String> expectedHeaders = new LinkedHashSet<>();
		
		for (Object aggregatorHeader : headers) {
			
			
		}
		
		expectedHeadersList = new ArrayList<>(expectedHeaders);
		
		
		fileUtils.addExpectedHeadersInNewSpreadsheet(expectedHeaders);
	}
	// Start browser initialization, URL setup and page object initialization before test methods are executed
	@BeforeMethod
	@Parameters({"browser"})
	public void initialize(String browser) throws MalformedURLException {

		appURL = ConfigReader.getLocalValue("URL") != null ? ConfigReader
				.getLocalValue("URL") : ConfigReader.getGlobalValue("URL");

		maxWaitTimeToPOLLElement = Long
				.valueOf(ConfigReader.getLocalValue("maxWaitTimeToPOLLElement") != null ? ConfigReader
						.getLocalValue("maxWaitTimeToPOLLElement")
						: ConfigReader
								.getGlobalValue("maxWaitTimeToPOLLElement"));

		driver = DriverFactory.getDriver(browser);

		

		driver.manage().timeouts()
				.implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();

		mainWindowHandle = driver.getWindowHandle();

		driver.get(appURL);
		
		driver.manage().window().maximize();
		PageSetup();
		
	}
// Method  to add data to Policy experts expected sheet
private void addExpectedDataTospreadsheet(String aggregatorHeader, String expectedValue){
		
	
	}
// Closes Browser instance after test completes
	@AfterMethod
	protected void drop() throws Exception {
		driver.quit();
		
	}
	
// Page setup method declaration. Overrides in test script for definition 
	protected void PageSetup()
	{
		
	}
	

	
	// Method to get driver object if required
	public WebDriver getDriver() {
		return driver;
	}
}
