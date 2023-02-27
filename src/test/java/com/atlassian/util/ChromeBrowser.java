package com.atlassian.util;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

/**
 * This class is a chrome driver similar class needs to be designed for IE or FIREFOX driver
 * @author nitin
 *
 */
public class ChromeBrowser extends ChromeDriver {

	static DesiredCapabilities capabilities = DesiredCapabilities.chrome();
	
	private ChromeBrowser() {
		super(capabilities);
	}

	public static WebDriver buildChromeBrowser() {
		return new ChromeBrowser();
	}

}
