package com.atlassian.po;

import org.openqa.selenium.By;

import com.atlassian.util.Browser;

/**
 * This is the page object for issue web page
 * 
 * @author nitin
 *
 */
public class IssuePageObject extends Browser {

	private String linkIssue = "//*[contains(@aria-label, 'Link issue')]";
	private String issueSummary = "//*[contains(@placeholder, 'Search for issues')]";
	private String linkButton = "//*[text()= 'Link']";
	private String verifyLinkedIssue = "//*[text()= 'ISSUE']";
	private String sucessMessageVisible = ".aui-flag[aria-hidden=true]";
	private String linkButtonClass = ".css-1yx6h60";

	public void enterIssueIDToBeLinked(String text) {
		enterTextWithEnterKey(By.xpath(issueSummary), text);
	}

	public void clickLinkIssue() {
		click(By.xpath(linkIssue));
	}

	public void linkIssue() {
		checkPresenceOfLinkedIssue();
		click(By.xpath(linkButton));
	}

	public String getLinkedIssue(String issueID) {
		String xpathForLinkVerification = verifyLinkedIssue.replace("ISSUE", issueID);
		return getElementText(By.xpath(xpathForLinkVerification));
	}

	public boolean isSuccessMessageVisible() {
		return checkPresenceOfELement(By.cssSelector(sucessMessageVisible));
	}

	public void checkPresenceOfLinkedIssue() {
		checkPresenceOfELement(By.cssSelector(linkButtonClass));
	}

}
