package com.test.tests;

import java.io.File;
import java.io.FileOutputStream;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

/**
 * @author sharikavadavat
 *
 */

public class TestCases extends ClassVariables {

	WebDriver driver;
	WebDriverWait wait;
	
	@BeforeTest
	public void launchBrowser() {

		try {

			driver = config.driverSetUp();
			wait = new WebDriverWait(driver, 10);
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method logs into the application
	 */
	public void load() throws InterruptedException {

		/* Logging into the application using pop-up url */
		driver.get(ClassVariables.wordPressURL);
		Reporter.log("URL was launched successfully");

	}

	/**
	 * This is the test case method that runs through the test case steps -
	 * Identified through keyword 'Test'
	 */
	@Test
	public void identifyQuotes() {

		try {

			load();
			addAllGideonQuote();

			Reporter.log("Verification of Quote and Author was completed successfully");

		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	/**
	 * This method
	 */
	public void addAllGideonQuote() {

		try {

			wait.until(
					ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(ClassVariables.gideonSearchSelector)));

			List<WebElement> quotePull = driver.findElements(By.xpath(ClassVariables.gideonSearchSelector));
			
		
			FileOutputStream fop = new FileOutputStream(new File("output.txt"));
			 
			
			System.out.println("Total quotes by Gideon: " + quotePull.size());
			for (int i = 0; i <= quotePull.size() - 1; i++) {
				int j = i+1;
				System.out.println(quotePull.get(i).getText());
				fop.write(("Quote "+j+" "+quotePull.get(i).getText().replaceAll("Gideon: ", "")).getBytes());
				fop.write(System.getProperty("line.separator").getBytes());
				

			}
			fop.close();
		}

		catch (Exception e) {

			e.printStackTrace();
		}

	}

	@AfterTest
	public void terminateBrowser() throws InterruptedException {

		config.driverTerminate();
	}
}
