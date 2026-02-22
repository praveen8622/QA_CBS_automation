package base;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

import utilities.LoggerUtil;
import utilities.WaitUtils;

public class BasePage {

	protected WebDriver driver;
	protected WaitUtils wait;
	protected SoftAssert softAssert;

	public BasePage(WebDriver driver) {
		this.driver = driver;
		this.wait = new WaitUtils(driver);
	}

	public void setSoftAssert(SoftAssert softAssert) {
		this.softAssert = softAssert;
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
	}

	protected void clickUsingJS(WebElement element) {
		org.openqa.selenium.JavascriptExecutor js = (org.openqa.selenium.JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", element);
	}

	// ================================
	// Reusable Assertions
	// ================================
	protected void assertElementVisible(By locator, String message) {
		boolean isVisible = wait.waitForElementToBeVisible(locator).isDisplayed();
		if (softAssert != null) {
			softAssert.assertTrue(isVisible, message);
		} else {
			LoggerUtil.info("[Assertion skipped - SoftAssert null] " + message + " | Status: "
					+ (isVisible ? "Visible" : "Not Visible"));
		}
	}

	protected void assertElementNotVisible(By locator, String message) {
		boolean isVisible = wait.waitForElementToBeVisible(locator).isDisplayed();
		if (softAssert != null) {
			softAssert.assertFalse(isVisible, message);
		} else {
			LoggerUtil.info("[Assertion skipped - SoftAssert null] " + message + " | Status: "
					+ (isVisible ? "Visible" : "Not Visible"));
		}
	}

	protected void assertTextEquals(By locator, String expectedText, String message) {
		String actualText = wait.waitForElementToBeVisible(locator).getText();
		if (softAssert != null) {
			softAssert.assertEquals(actualText, expectedText, message);
		} else {
			LoggerUtil.info("[Assertion skipped - SoftAssert null] " + message + " | Expected: [" + expectedText
					+ "], Actual: [" + actualText + "]");
		}
	}

	protected void assertValueEquals(By locator, String expectedValue, String message) {
		String actualValue = getAttributeValue(locator, "value");
		if (softAssert != null) {
			softAssert.assertEquals(actualValue, expectedValue, message);
		} else {
			LoggerUtil
					.info("[Assertion skipped - SoftAssert not provided] " + message + " | Expected: [" + expectedValue
							+ "], Actual: [" + actualValue + "]");
		}
	}

	protected void assertTrueCondition(boolean condition, String message) {
		if (softAssert != null) {
			softAssert.assertTrue(condition, message);
		} else {
			LoggerUtil.info("[Assertion skipped - SoftAssert null] " + message + " | Condition: " + condition);
		}
	}

	protected void assertFalseCondition(boolean condition, String message) {
		if (softAssert != null) {
			softAssert.assertFalse(condition, message);
		} else {
			LoggerUtil.info("[Assertion skipped - SoftAssert null] " + message + " | Condition: " + condition);
		}
	}

	// ================================
	// File Upload
	// ================================
	protected void uploadFile(By locator, String filePath) {
		WebElement element = wait.waitForElementToBePresent(locator);
		element.sendKeys(filePath);
	}

	// ================================
	// Common Identity Logic
	// ================================
	/**
	 * Fills the corresponding conditional field based on the Identity Type.
	 * 
	 * @param type               The identity type selected.
	 * @param fieldValue         The value to enter in the office/local body/state
	 *                           field.
	 * @param issueOfficeLocator Locator for the Issue Office input.
	 * @param localBodyContainer Locator for the Local Body React-Select container.
	 * @param localBodyInput     Locator for the Local Body React-Select input.
	 * @param stateContainer     Locator for the State React-Select container.
	 * @param stateInput         Locator for the State React-Select input.
	 */
	public void fillConditionalIdentityField(String type, String fieldValue,
			By issueOfficeLocator,
			By localBodyInput,
			By stateInput) {

		switch (type) {
			case "Birth Certificate":
			case "Company Registration Certificate":
			case "Passport":
			case "Voter ID":
				if (issueOfficeLocator != null) {
					typeText(issueOfficeLocator, fieldValue);
				}
				break;
			case "Citizenship":
				if (localBodyInput != null) {
					selectFromDropdown(localBodyInput, fieldValue);
				}
				break;
			case "Driver’s License":
			case "National Identity":
			case "Tax Identification Number":
				if (stateInput != null) {
					selectFromDropdown(stateInput, fieldValue);
				}
				break;
			default:
				LoggerUtil.info("No conditional field mapping identified for Identity Type: " + type);
				break;
		}
	}
}
