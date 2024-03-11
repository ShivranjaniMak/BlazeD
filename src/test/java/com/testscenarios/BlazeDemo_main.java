package com.testscenarios;

import org.testng.annotations.Test;

import com.utilities.CommonFunctions;

import org.testng.annotations.BeforeClass;

import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;

public class BlazeDemo_main extends CommonFunctions {

  @Test
  public void f() throws Exception {
	  
		
		getURL("BD_URL");
		Thread.sleep(5000);
		new Select(driver.findElement(loc.blazeDemo_Dept_City_Dropdown)).selectByValue("Boston");
		new Select(driver.findElement(loc.blazeDemo_Dest_City_Dropdown)).selectByValue("London");
		Thread.sleep(3000);
		driver.findElement(loc.blazeDemo_FindFlight_Button).click();
	
		//selectDropdownByValue("DEPT_CITY", "Boston");
        clickByAnyLocator(loc.blazeDemo_FindFlight_Button);
        Thread.sleep(3000);
        clickByAnyLocator(loc.blazeDemo_ChooseThisFlight_Button);
        Thread.sleep(3000);
        clickByAnyLocator(loc.blazeDemo_Purchase_Button);
  }  
 


@BeforeClass
  public void beforeClass() {
	  chromeBrowserLaunch();
  }

  @AfterClass
  public void afterClass() {
	  	driver.quit();
  }

}
