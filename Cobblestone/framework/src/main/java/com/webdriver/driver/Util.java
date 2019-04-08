package com.webdriver.driver;

import java.util.Random;

// Common utils methods used in framework throughout

public class Util
{
    public static Long maxWaitTimeToFindElement;
	public String currentMethod;
// Method to set name of currently executing method	
	public void setCurrentMethodName(String methodName) {
		currentMethod = methodName;
	}
	// Method to get name of currently executing method	

	public String getCurrentMethodName() {
		return currentMethod;
	}
// Method to wait for element before timeout
	public static void waitForElement(int timeInSeconds)
	{
	try {
				Thread.sleep(timeInSeconds*1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	// Method to generate random numbers 
	public static int generateRandomNumber(){
		Random random = new Random();
		int randomNumber = random.nextInt(1000);
		return randomNumber;
	}
	
}

