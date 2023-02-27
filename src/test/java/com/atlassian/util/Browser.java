package com.atlassian.util;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * This is the super class for all page objects and it contains all actions
 * required on page components
 * 
 * @author nitin
 *
 */
public class Browser {
	public LoadDataUtil dataConfig = new LoadDataUtil();
	static WebDriver driver = null;
	int waitTime = 120;
	WebDriverWait wait = new WebDriverWait(driver, waitTime);

	static {
		driver = ChromeBrowser.buildChromeBrowser();
	}

	public void init(String url) {
		driver.get(url);
	}

	public void exit() {
		driver.quit();
	}

	public void enterText(By by, String textToEnter) {
		WebElement element = getParentElement(by);
		element.sendKeys(textToEnter);
	}

	public void enterTextWithEnterKey(By by, String textToEnter) {
		WebElement element = getParentElement(by);
		element.sendKeys(textToEnter);
		element.sendKeys(Keys.ENTER);

	}

	public void clear(By by) {
		WebElement element = getParentElement(by);
		element.click();
	}

	public boolean checkPresenceOfELement(By by) throws NoSuchElementException {
		try {
			wait.until(ExpectedConditions.presenceOfElementLocated(by));
			return true;
		} catch (Exception e) {
			throw new NoSuchElementException("exception");
		}
	}

	public boolean checkIfVisible(By by) throws NoSuchElementException {
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			return true;
		} catch (Exception e) {
			throw new NoSuchElementException("exception");
		}
	}

	public boolean checkIfClickable(By by) throws NoSuchElementException {
		try {
			wait.until(ExpectedConditions.elementToBeClickable(by));
			return true;
		} catch (Exception e) {
			throw new NoSuchElementException("exception");
		}
	}

	public WebElement getParentElement(By by) {
		WebElement element = null;
		if (checkIfVisible(by) && checkIfClickable(by))
			element = driver.findElement(by);
		return element;
	}

	public void click(By by) {
		try {
			if (checkIfVisible(by) && checkIfClickable(by) && driver.findElement(by).isEnabled()) {
				driver.findElement(by).click();
			}
		} catch (Exception ne) {
			throw new NoSuchElementException();
		}
	}

	public String getElementText(By by) {
		String elementText = null;
		if (checkIfVisible(by))
			elementText = driver.findElement(by).getText();
		return elementText;
	}
}
