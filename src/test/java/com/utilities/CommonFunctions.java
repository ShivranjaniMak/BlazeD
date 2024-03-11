package com.utilities;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import com.objectrepository.Locators;

public class CommonFunctions {
	public static WebDriver driver;
	
	public String propertyFile = "QA_TD.properties";
	public Locators loc=new Locators();
	Properties p=new Properties();
	
	public void chromeBrowserLaunch() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}
	public void getURL(String URL) throws IOException {
		FileInputStream fi = new FileInputStream(".\\src\\test\\resources\\testdata\\" + propertyFile);
		p.load(fi);
		driver.get(p.getProperty(URL));
	}
	
	 public void selectDropdownByValue(By locator, String value) {
	        WebElement dropdownElement = (WebElement) driver.findElement(locator);
	        Select dropdown = new Select(dropdownElement);
	        dropdown.selectByValue(value);
	    }
	
	public void clickByAnyLocator(By locator) throws Exception {
		Thread.sleep(2000);
		// implicitWait(10);
		WebElement element = driver.findElement(locator);
		// Check your locator is displayed?
		if (driver.findElements(locator).size() > 0) {
			// Check your element is in enable state?
			if (element.isEnabled()) {
				// Click on Button/radiobutton/checkbox/Link...
				// highlightElement(element);
				element.click();
			} else {
				System.out.println("Given locator is not enable state on DOM(Current page***");
			}
		} else {
			System.out.println("Given locator is not displayed on DOM(Current page***");
		}
	}
}
