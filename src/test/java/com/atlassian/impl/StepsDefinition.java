package com.atlassian.impl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Assert;

import com.atlassian.po.CreateIssuePageObject;
import com.atlassian.po.DashBoardPageObject;
import com.atlassian.po.IssuePageObject;
import com.atlassian.po.LoginPageObject;
import com.atlassian.util.Browser;
import com.atlassian.util.LoadDataUtil;

/**
 * This is super class of all feature implementation classes
 * @author nitin
 *
 */

public class StepsDefinition {
	protected Browser browser = new Browser();
	protected LoadDataUtil dataConfig = new LoadDataUtil();
	protected LoginPageObject loginPO = new LoginPageObject();
	protected DashBoardPageObject dashBoardPageObject = new DashBoardPageObject();
	protected CreateIssuePageObject createIssuePageObject = new CreateIssuePageObject();
	protected IssuePageObject issuePageObject = new IssuePageObject();
	private static String USERNAME = "username";
	private static String PASSWORD = "password";

	protected String getIssueID(String text) {
		Pattern p = Pattern.compile("(\\d+)");
		Matcher m = p.matcher(text);
		while (m.find()) {
			return m.group(1);
		}
		return null;
	}

	protected String createAnIssueAndReturnID(String issueType, String summaryText) throws InterruptedException {

		dashBoardPageObject.clickCreateNewItem();
		createIssuePageObject.selectIssueType(issueType);
		createIssuePageObject.enterSummaryText(summaryText);
		createIssuePageObject.clickCreateIssue();
		return getIssueID(createIssuePageObject.getMessage());
	}

	protected void login() {
		browser.init(System.getProperty("app.url"));
		loginPO.setUserName(LoadDataUtil.prop.getProperty(USERNAME));
		loginPO.clickSubmit();
		loginPO.setPassword(LoadDataUtil.prop.getProperty(PASSWORD));
		loginPO.clickSubmit();
	}

	protected void linkIssue(String issueID, String linkIssueID) {
		browser.init(System.getProperty("app.url") + "browse/AUT-" + issueID);
		issuePageObject.clickLinkIssue();
		issuePageObject.enterIssueIDToBeLinked("AUT-" + linkIssueID);		
	
		issuePageObject.linkIssue();		
		Assert.assertTrue(("AUT-" + linkIssueID).equals(issuePageObject.getLinkedIssue("AUT-" + linkIssueID)));
	}
}
