
package com.webdriver.driver;
/**
 * comment
 *
 * @Reference	   		: 
 * @Rule Number(s)	   	: 
 * @GUI Qualifier Used	: No
 * @author		     	: QASource
 * @Date	  	    	: Mar 3, 2014
 * 
 */
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.CapabilityType.ForSeleniumServer;
import org.openqa.selenium.remote.RemoteWebDriver;

public class DriverFactory {
// Opens up browser as specified in testNg.xml file by user
	public static WebDriver getDriver(String browser) throws MalformedURLException {

		WebDriver driver = null;
	
		

					DesiredCapabilities capabilities = new DesiredCapabilities();
					if (browser == null) {
						browser = "Firefox";
						capabilities.setBrowserName("Firefox");
						
						System.out.println("Initiating " + browser
								);
						driver = new FirefoxDriver();

					} else if ((browser != null)
							&& browser.equalsIgnoreCase("InternetExplorer")) {
						System.setProperty("webdriver.ie.driver",
								"../../../clientdrivers/IEDriverServer.exe");
						capabilities = DesiredCapabilities.internetExplorer();
						driver = new InternetExplorerDriver();
					} else if ((browser != null)
							&& browser.equalsIgnoreCase("GoogleChrome")) {
						System.setProperty("webdriver.chrome.driver",
								"E:\\Framework\\Cobblestone\\clientdrivers\\chromedriver.exe");

						capabilities = DesiredCapabilities.chrome();
						driver = new ChromeDriver(capabilities);
					} else if ((browser != null) && browser.equalsIgnoreCase("Firefox")) {
						System.setProperty("webdriver.gecko.driver",
								"E:\\Framework\\Cobblestone\\clientdrivers\\geckodriver.exe");

						capabilities = DesiredCapabilities.firefox();
						driver=new FirefoxDriver(capabilities);
					}

				
				return driver;
	}
}
