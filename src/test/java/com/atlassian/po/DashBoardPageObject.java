package com.atlassian.po;

import org.openqa.selenium.By;

import com.atlassian.util.Browser;

/**
 * This is the dashboard page object
 * 
 * @author nitin
 *
 */
public class DashBoardPageObject extends Browser {

	private String createGlobalItemID = "createGlobalItem";
	private String quickSearchGlobalItem = "quickSearchGlobalItem";

	public void clickCreateNewItem1() {
		click(By.id(createGlobalItemID));
	}

	public void clickQuickSearchGlobalItem() {
		click(By.id(quickSearchGlobalItem));
	}

	public void clickCreateNewItem() {
		click(By.id(createGlobalItemID));
	}
}
