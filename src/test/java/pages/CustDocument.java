package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import base.BasePage;
import utilities.LoggerUtil;

public class CustDocument extends BasePage {

	public CustDocument(WebDriver driver) {
		super(driver);

	}

	// private By documentTypeDropdownLocator =
	// By.xpath("//input[@aria-label='Document Type']");
	// private By documentTitleLocator = By.xpath("//input[@name='documentTitle']");
	// private By documentNumLocator = By.xpath("//input[@name='documentNo']");
	// private By addBtnLocator = By.xpath("//input[@name='documentNo']");
	// private By exitBtnLocator = By.xpath("//input[@name='documentNo']");
	// private By resetBtnLocator = By.xpath("//input[@name='documentNo']");
	private By nextButtonLocator = By.xpath("//button[@title='Next Step']");

	public void clickNext() {
		LoggerUtil.info("Clicking 'Next' button on Document page");
		click(nextButtonLocator);
	}

}
