package com.atlassian.runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

/**
 * This is the runner class to trigger test cases
 * change tags as per testcase run is required.
 * 
 * @author nitin
 *
 */

@RunWith(Cucumber.class)
@CucumberOptions(plugin = { "com.cucumber.listener.ExtentCucumberFormatter:output/report.html" }, features = {
		"src/test/resources/features" }, glue = { "com.atlassian.impl" }, tags = { "@smoke" })
public class RuncukesTest {	

}
