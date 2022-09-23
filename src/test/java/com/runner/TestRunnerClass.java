package com.runner;

import org.junit.AfterClass;
import org.junit.runner.RunWith;

import com.reports.Reporting;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
		

/**
 *  
 * @author Velumani Devendiran
 * 
 * @Description User to Run feature files and Generate JVM report
 * 
 * @Date 06/09/2022
 * 
 */


@RunWith(Cucumber.class)
@CucumberOptions( dryRun = false, stepNotifications = true, monochrome=true,snippets=SnippetType.CAMELCASE,
plugin= {"json:C:\\Users\\Velumani Devendiran\\eclipse-workspace\\OMRBranchAdactinAutomation\\target\\output.json"},features = "src\\test\\resources\\Features", glue = "com.stepdefinition")

public class TestRunnerClass {
		
	
	@AfterClass
	public static void afterClass() {

		Reporting.generateJvmReport(System.getProperty("user.dir")+"\\target\\output.json");
	}

}
