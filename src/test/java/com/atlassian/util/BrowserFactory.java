package com.atlassian.util;

import org.openqa.selenium.WebDriver;

/**
 * This class is the browser factory and can provide different tyoe of browser instances
 *  based on value set in property
 * @author nitin
 *
 */

public class BrowserFactory {

	public static WebDriver getBrowser() {
		WebDriver desiredBrowser = null;
		// put more if else conditions if tests needs to run against another browser
		if ("chrome".equals(LoadDataUtil.prop.getProperty("browser")))
			desiredBrowser = ChromeBrowser.buildChromeBrowser();
		return desiredBrowser;

	}
}
