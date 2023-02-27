package com.atlassian.impl;

import org.junit.Assert;

import com.atlassian.util.LoadDataUtil;

import cucumber.api.java.After;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class is the implementation class of scenarios
 * 
 * @author nitin
 */

public class IssueLinkImpl extends StepsDefinition {

	private static String storyID;
	private static String bugID;

	@Given("^I am a valid user and can login in application$")
	public void i_am_a_valid_user_and_can_login_in_application() throws Throwable {
		login();
	}

	@And("^I can create an issue type \"([^\"]*)\" with issue summary \"([^\"]*)\"$")
	public void i_can_create_an_issue_type(String issueType, String issueSummary) throws Throwable {
		if (issueType.equals("Bug")) {
			bugID = createAnIssueAndReturnID(issueType, issueSummary);
		} else {
			if (issuePageObject.isSuccessMessageVisible())
				storyID = createAnIssueAndReturnID(issueType, issueSummary);
		}
	}

	@When("^I link issue type bug with story$")
	public void i_link_issue_type_bug_with_story() throws Throwable {
		linkIssue(bugID, storyID);
	}

	@When("^I open newly created story$")
	public void i_open_newly_created_story() throws Throwable {
		browser.init(System.getProperty("app.url") + "browse/AUT-" + storyID);
	}

	@Then("^I successfully see bug is linked to story$")
	public void i_successfully_see_bug_is_linked_to_story() throws Throwable {
		Assert.assertTrue(("AUT-" + bugID).equals(issuePageObject.getLinkedIssue("AUT-" + bugID)));
	}

	@After
	public void after() {
		browser.exit();
	}

}
