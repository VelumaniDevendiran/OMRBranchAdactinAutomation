package com.reports;

import java.io.File;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import net.masterthought.cucumber.Configuration;
import net.masterthought.cucumber.ReportBuilder;

/**
 * 
 * @author Velumani Devendiran
 *@description Used to generate JVM report to maintain browser and OS details
 *
 *@Date 28/08/2022
 */

public class Reporting {
	
	public static void generateJvmReport(String jsonFile) {
		
		
		File file = new File(System.getProperty("user.dir")+"\\target");
		
		Configuration configuration = new Configuration(file, "Adactin Hotel Automation");
		
		configuration.addClassifications("Browser", "Chrome");
		configuration.addClassifications("BrowserVersion", "105");
		configuration.addClassifications("OS", "Windows 10");
		configuration.addClassifications("Sprint", "2");
		
		List<String>jsonFiles = new ArrayList<String>();
		
		jsonFiles.add(jsonFile);
		
		ReportBuilder builder = new ReportBuilder(jsonFiles, configuration);
		
		builder.generateReports();
	}

}
