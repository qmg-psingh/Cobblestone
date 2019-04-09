package com.webdriver.controls;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
//import org.openqa.selenium.browserlaunchers.Sleeper;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Reporter;

import com.webdriver.driver.ConfigReader;

public class ObjectFactory implements WebElement {

	private WebDriver driver;
	private By by;
	private WebElement element;
	protected Select selectElement;

	Long maxWaitTimeToFindElement = Long.valueOf(ConfigReader
			.getLocalValue("maxWaitTimeToFindElement") != null ? ConfigReader
			.getLocalValue("maxWaitTimeToFindElement") : ConfigReader
			.getGlobalValue("maxWaitTimeToFindElement"));

	Long maxWaitTimeToPOLLElement = Long.valueOf(ConfigReader
			.getLocalValue("maxWaitTimeToPOLLElement") != null ? ConfigReader
			.getLocalValue("maxWaitTimeToPOLLElement") : ConfigReader
			.getGlobalValue("maxWaitTimeToPOLLElement"));

	Boolean hFlag = Boolean.valueOf(ConfigReader
			.getGlobalValue("highlightElement"));

	public ObjectFactory(WebDriver driver, By by) {
		this.driver = driver;
		this.by = by;
	}

	public WebElement findElement(By by) {
		return waitAndFindElement();
	}
	public String getSelectedValue(){
		Select select = new Select(element);
		WebElement option = select.getFirstSelectedOption();
		String defaultItem = option.getText();
		System.out.println(defaultItem );
		return defaultItem;
	}

	public List<WebElement> findElements(By by) {
		return waitAndFindAllElements();
	}

	public void clear() {
		waitAndFindElement().clear();
	}

	public void click() {
		waitAndFindElement().click();
	}

	public void sendKeys(CharSequence... arg) {
		waitAndFindElement().sendKeys(arg);
	}

	public void submit() {
		waitAndFindElement().submit();
	}

	public String getAttribute(String arg) {
		return waitAndFindElement().getAttribute(arg);
	}

	public String getCssValue(String arg) {
		return waitAndFindElement().getCssValue(arg);
	}

	public Point getLocation() {
		return waitAndFindElement().getLocation();
	}

	public Dimension getSize() {
		return waitAndFindElement().getSize();
	}

	public String getTagName() {
		return waitAndFindElement().getTagName();
	}

	public String getText() {
		return waitAndFindElement().getText();
	}
	
	public String getAttributeValue(String attributeName) {
		String text = null;
		if (waitAndFindElement().isDisplayed()) {
			text = element.getAttribute(attributeName);
		}
		return text;
	}
	

	protected void Select(String value) {
		if (waitAndFindElement() != null)
		selectElement= new Select(element);
		selectElement.selectByVisibleText(value);
	}
	protected void SelectByIndex( int index) {
		if (waitAndFindElement() != null)
		selectElement= new Select(element);
		selectElement.selectByIndex(index);
	}
	
	public boolean isDisplayed() {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(maxWaitTimeToFindElement, TimeUnit.SECONDS)
					.pollingEvery(maxWaitTimeToPOLLElement, TimeUnit.SECONDS);
			element = wait.until(ExpectedConditions
					.visibilityOfElementLocated(by));
			highlightElement();
			return element.isDisplayed() ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isEnabled() {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(maxWaitTimeToFindElement, TimeUnit.SECONDS)
					.pollingEvery(maxWaitTimeToPOLLElement, TimeUnit.SECONDS);
			highlightElement();
			element = wait.until(ExpectedConditions.elementToBeClickable(by));
			return element.isEnabled() ? true : false;
		} catch (Exception e) {
			return false;
		}
	}

	public boolean isSelected() {
		try {
			Wait<WebDriver> wait = new FluentWait<WebDriver>(driver)
					.withTimeout(maxWaitTimeToFindElement, TimeUnit.SECONDS)
					.pollingEvery(maxWaitTimeToPOLLElement, TimeUnit.SECONDS);
			if (wait.until(ExpectedConditions.elementToBeSelected(by))) {
				highlightElement();
				return true;
			} else
				return false;
		} catch (Exception e) {
			return false;
		}
	}

	/**
	 * Finds the element with the given "By" condition and waits for the
	 * specified amount of time
	 * 
	 * @return the (same) WebElement once it is found in DOM else throws Timeout
	 *         exception
	 */

	private WebElement waitAndFindElement() {

		String message = "Searching element "
				+ by.toString().substring(by.toString().indexOf(":"))
				+ " for presence, will wait by maximum " + maxWaitTimeToFindElement
				+ " seconds";
		Reporter.log(message, true);
		try {
			element = new WebDriverWait(driver, maxWaitTimeToFindElement)
					.until(ExpectedConditions.presenceOfElementLocated(by));
			highlightElement();
			Reporter.log(
					"Element "
							+ by.toString().substring(
									by.toString().indexOf(":"))
							+ " is present and available", true);
			
		} catch (Error e) {
			Reporter.log(
					"Element "
							+ by.toString().substring(
									by.toString().indexOf(":"))
							+ " is not available", true);
			e.printStackTrace();
		}
		return element;
	}

	/**
	 * Finds the elements with the given "By" condition and waits for the
	 * specified amount of time
	 * 
	 * @return a List of elements once found in DOM else throws Timeout
	 *         exception
	 */

	private List<WebElement> waitAndFindAllElements() {

		return new WebDriverWait(driver, maxWaitTimeToFindElement)
				.until(new ExpectedCondition<List<WebElement>>() {
					@Override
					public List<WebElement> apply(WebDriver driver) {
						List<WebElement> elements = driver.findElements(by);
						return elements.size() > 0 ? elements : null;
					}

					@Override
					public String toString() {
						return " - searched for element located by " + by;
					}
				});
	}

	private void highlightElement() {
		if (hFlag) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "color: black; border: 3px solid BLUE;");
					try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
					
			//Sleeper.sleepTight(50L);
			js.executeScript(
					"arguments[0].setAttribute('style', arguments[1]);",
					element, "");
		}
	}

	@Override
	public <X> X getScreenshotAs(OutputType<X> arg0) throws WebDriverException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Rectangle getRect() {
		// TODO Auto-generated method stub
		return null;
	}
}
