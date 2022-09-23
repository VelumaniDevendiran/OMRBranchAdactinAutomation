package com.stepdefinition;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.base.BaseClass;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

/**
 * 
 * @author Velumani Devendiran
 * @Description Used to maintain Browser Types and Login Url
 *
 */
public class HooksClass extends BaseClass {

	@Before
	public void beforeScenario() throws FileNotFoundException, IOException {
		getDriver(getPropertyFileValue("browserType"));
		enterUrl(getPropertyFileValue("url"));
		maximizeWindow();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}

	@After
	public void afterScenario(Scenario scenario) {
		
		TakesScreenshot screenshot = (TakesScreenshot) driver;
		byte[] bs = screenshot.getScreenshotAs(OutputType.BYTES);		
		scenario.attach(bs, "image/png", "EveryScenario");
		
		
//		quitWindow();

	}

}
