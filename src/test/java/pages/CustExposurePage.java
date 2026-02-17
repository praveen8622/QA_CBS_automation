package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustExposurePage extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By exposureTabLocator = By.xpath("//p[normalize-space()='Exposure to Other Financial Institutions']");
    private By addBtnLocator = By.xpath("//button[@title='Add']");

    private By instTypeContainerBy = By
            .xpath("//input[@aria-label='Institution Type']/ancestor::div[contains(@class, 'container')]");
    private By instTypeInputBy = By.xpath("//input[@aria-label='Institution Type']");

    private By instNameInputBy = By.xpath("//input[@aria-label='Institution Name']");

    private By productTypeContainerBy = By
            .xpath("//input[@aria-label='Product Type Name']/ancestor::div[contains(@class, 'container')]");
    private By productTypeInputBy = By.xpath("//input[@aria-label='Product Type Name']");

    private By portfolioAmountInputBy = By.xpath("//input[@aria-label='Portfolio Amount']");
    private By averageIntRateInputBy = By.xpath("//input[@aria-label='Average Interest Rate']");
    private By servicePeriodInputBy = By.xpath("//input[@aria-label='Service Period Month']");

    private By saveBtnBy = By.xpath("//button[normalize-space()='Save']");

    public CustExposurePage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void navigateToExposureTab() {
        LoggerUtil.info("Navigating to Exposure tab");
        click(exposureTabLocator);
    }

    public void clickAdd() {
        LoggerUtil.info("Clicking 'Add' button for Exposure details");
        click(addBtnLocator);
    }

    public void enterExposureDetails(String instType, String instName, String prodType, String portfolio, String rate,
            String period) {
        LoggerUtil.info("Entering Exposure Details: Institution=" + instName + ", Product=" + prodType);

        selectFromReactSelect(instTypeContainerBy, instTypeInputBy, instType);
        typeText(instNameInputBy, instName);
        selectFromReactSelect(productTypeContainerBy, productTypeInputBy, prodType);
        typeText(portfolioAmountInputBy, portfolio);
        typeText(averageIntRateInputBy, rate);
        typeText(servicePeriodInputBy, period);
    }

    public void clickSave() {
        LoggerUtil.info("Clicking 'Save' button in Exposure dialog");
        click(saveBtnBy);
    }
}
