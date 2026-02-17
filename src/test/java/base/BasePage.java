package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import utilities.LoggerUtil;
import utilities.WaitUtils;

public class BasePage {

	protected WebDriver driver;
	protected WaitUtils wait;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	// ================================
	// Basic Actions
	// ================================
	protected void click(By locator) {
		wait.waitForElementToBeClickable(locator).click();
	}

	protected void typeText(By locator, String text) {
		WebElement element = wait.waitForElementToBeClickable(locator);
		element.click();
		element.clear();
		element.sendKeys(text);
	}

	protected void selectFromDropdown(By locator, String value) {
		if (value == null || value.trim().isEmpty())
			return;
		WebElement element = wait.waitForElementToBeClickable(locator);
		element.click();
		element.sendKeys(value);
		element.sendKeys(Keys.ENTER);
	}

	// ================================
	// React-Select handler (STABLE)
	// ================================
	protected void selectFromReactSelect(By containerLocator,
			By inputLocator,
			String value) {

		WebElement container = wait.waitForElementToBeClickable(containerLocator);
		container.click();

		WebElement input = wait.waitForElementToBeVisible(inputLocator);
		input.sendKeys(value);
		input.sendKeys(Keys.ENTER);
	}

	protected void selectFromGenderDropdown(By locator, String value) {
		WebElement element = wait.waitForElementToBeClickable(locator);
		element.click();
		element.sendKeys(value);
		if (value.equalsIgnoreCase("Male")) {
			element.sendKeys(Keys.ARROW_DOWN);
		}
		element.sendKeys(Keys.ENTER);
	}

	protected void selectDate(By dateInput, By yearDropdown, String year, By monthDropdown, String month,
			By dayLocator) {
		click(dateInput);

		Select years = new Select(driver.findElement(yearDropdown));
		years.selectByVisibleText(year);

		Select mnth = new Select(driver.findElement(monthDropdown));
		mnth.selectByVisibleText(month);

		click(dayLocator);
	}

	// ================================
	// Get element info
	// ================================
	protected String getAttributeValue(By locator, String attribute) {
		WebElement element = wait.waitForElementToBePresent(locator);
		return element.getAttribute(attribute);
	}

	protected boolean isSelected(By locator) {
		WebElement element = wait.waitForElementToBePresent(locator);
		return element.isSelected();
	}

	// ================================
	// Checkbox handling
	// ================================
	protected void setCheckbox(By locator, boolean shouldBeChecked) {
		WebElement element = wait.waitForElementToBePresent(locator);

		if (element.isSelected() != shouldBeChecked) {
			try {
				element.click();
			} catch (Exception e) {
				LoggerUtil.info("Regular click failed, trying JS click for checkbox");
				clickUsingJS(element);
			}
		}

		Assert.assertEquals(isSelected(locator), shouldBeChecked, "Checkbox state mismatch");
	}

	protected void clickUsingJS(WebElement element) {
		org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// ================================
	// Reusable Assertions
	// ================================
	protected void assertElementVisible(By locator, String message) {
		Assert.assertTrue(wait.waitForElementToBeVisible(locator).isDisplayed(), message);
	}

	protected void assertElementNotVisible(By locator, String message) {
		Assert.assertFalse(wait.waitForElementToBeVisible(locator).isDisplayed(), message);
	}

	protected void assertTextEquals(By locator, String expectedText, String message) {
		String actualText = wait.waitForElementToBeVisible(locator).getText();
		Assert.assertEquals(actualText, expectedText, message);
	}

	protected void assertValueEquals(By locator, String expectedValue, String message) {
		String actualValue = getAttributeValue(locator, "value");
		Assert.assertEquals(actualValue, expectedValue, message);
	}

	protected void assertTrueCondition(boolean condition, String message) {
		Assert.assertTrue(condition, message);
	}

	protected void assertFalseCondition(boolean condition, String message) {
		Assert.assertFalse(condition, message);
	}
}
