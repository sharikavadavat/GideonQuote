package com.test.tests;

import java.io.InputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ConfigurationSetUp {
	WebDriver driverLaunch;
	Properties properties = new Properties();
	InputStream inputStream;

	public WebDriver driverSetUp() {
		// WebDriverManager.getInstance(CHROME).setup();
		WebDriverManager.chromedriver().setup();
		driverLaunch = new ChromeDriver();
		driverLaunch.manage().window().maximize();

		return driverLaunch;
	}

	public void driverTerminate() {
		driverLaunch.quit();
	}

}
