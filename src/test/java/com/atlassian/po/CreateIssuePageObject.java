package com.atlassian.po;

import org.openqa.selenium.By;

import com.atlassian.util.Browser;

/**
 * This is the page object for issue creation web page
 * 
 * @author nitin
 *
 */
public class CreateIssuePageObject extends Browser {

	private String summaryID = "summary";
	private String issueTypeFieldID = "issuetype-field";
	private String createIssueSubmitID = "create-issue-submit";
	private String successMessage = "aui-flag";

	public void enterSummaryText(String summaryText) {
		enterText(By.id(summaryID), summaryText);
	}

	public void selectIssueType(String issueType) {
		clear(By.id(issueTypeFieldID));
		enterTextWithEnterKey(By.id(issueTypeFieldID), issueType);
	}

	public void clickCreateIssue() {
		click(By.id(createIssueSubmitID));
	}

	public String getMessage() {
		return getElementText(By.className(successMessage));
	}

}
