package com.atlassian.po;

import org.openqa.selenium.By;

import com.atlassian.util.Browser;

/**
 * This is the page object class for login page of jira cloud site
 * @author nitin
 *
 */
public class LoginPageObject extends Browser{

	private String userNameID = "username";
	private String loginSubmitID = "login-submit";
	private String passwordID = "password";


	public void setUserName(String username) {
		enterText(By.id(userNameID),username);
	}
	
	public void setPassword(String password) {
		enterText(By.id(passwordID),password);
	}
	
	public void clickSubmit() {
		click(By.id(loginSubmitID));
	}

}
