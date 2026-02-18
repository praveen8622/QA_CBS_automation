package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRegHomepage extends BasePage {

    // =================================================
    // Navigation Locators
    // =================================================
    private By addCustregBtnLocator = By.xpath("//div[contains(text(),'Add Customer Registration')]");
    private By loadBtnLocator = By.xpath("//button[@title='Load Data']");
    private By nextBtnLocator = By.xpath("//form//button[@type='submit' and .//div[normalize-space()='Next Step']]");
    // =================================================
    // Locators of menues
    // =================================================
    private By custIdentityLocator = By.xpath("//p[normalize-space()='Customer Identity']");
    private By highProfilevConnLocator = By.xpath("//p[normalize-space()='High Profile Connections']");
    private By cashFlowTabLocator = By.xpath("//p[normalize-space()='Cash Flow']");
    private By exposureTabLocator = By.xpath("//p[normalize-space()='Exposure to Other Financial Institutions']");
    private By employmentTabLocator = By.xpath("//p[normalize-space()='Employment Details']");
    private By relationshipTabLocator = By.xpath("//div[normalize-space()='Relationships']");
    private By addRelationshipBtn = By.xpath("//button[@title='Add']");

    public CustRegHomepage(WebDriver driver) {
        super(driver);
    }

    HomePage homePage = new HomePage(driver);

    public void clickAddCustomerRegistration() {
        LoggerUtil.info("Clicking 'Add Customer Registration' button");
        click(addCustregBtnLocator);
    }

    // =================================================
    // Table Action Methods
    // =================================================
    public void selectStatus(String status) {
        LoggerUtil.info("Selecting status: " + status);
        // Locate the dropdown that contains a "singleValue" (currently selected option)
        By statusDropdownLocator = By
                .xpath("//div[contains(@class, '-control')][.//div[contains(@class, 'singleValue')]]");
        click(statusDropdownLocator);

        // Select the option from the dropdown menu
        By statusOptionLocator = By.xpath("//div[contains(text(), '" + status + "')]");
        click(statusOptionLocator);
    }

    public void clickEditAction(String customerName) {
        LoggerUtil.info("Clicking 'Edit' button for customer: " + customerName);
        By editBtnLocator = By.xpath("//tr[td[normalize-space()='" + customerName + "']]//button[@title='Edit']");
        click(editBtnLocator);
    }

    public void searchAndEditDraftCustomer(String customerName) {
        LoggerUtil.info("Searching and editing customer (Draft): " + customerName);

        homePage.navigateToCustomerRegistration();
        selectStatus("Draft");
        click(loadBtnLocator);
        clickEditAction(customerName);
        click(nextBtnLocator);
    }

    public void clickViewAction(String customerName) {
        LoggerUtil.info("Clicking 'View' button for customer: " + customerName);
        By viewBtnLocator = By.xpath("//tr[td[normalize-space()='" + customerName + "']]//button[@title='View']");
        click(viewBtnLocator);
    }

    public void clickDeleteAction(String customerName) {
        LoggerUtil.info("Clicking 'Delete' button for customer: " + customerName);
        By deleteBtnLocator = By.xpath("//tr[td[normalize-space()='" + customerName + "']]//button[@title='Delete']");
        click(deleteBtnLocator);
    }

    public void openIdentityformPage() {
        LoggerUtil.info("Clicking 'Customer Identity' step");
        click(custIdentityLocator);
    }

    public void openHighProfilevConnformPage() {
        LoggerUtil.info("Clicking 'High Profilev Conn' step");
        click(highProfilevConnLocator);
    }

    public void navigateToCashFlowTab() {
        LoggerUtil.info("Navigating to Cash Flow tab");
        click(cashFlowTabLocator);
    }

    public void navigateToExposureTab() {
        LoggerUtil.info("Navigating to Exposure tab");
        click(exposureTabLocator);
    }

    public void navigateToEmploymentTab() {
        LoggerUtil.info("Navigating to Employment Details tab");
        click(employmentTabLocator);
    }

    public void clickRelationshipMasterTab() {
        LoggerUtil.info("Clicking 'Relationship tab");
        click(relationshipTabLocator);
    }

    public void clickAddRelationship() {
        LoggerUtil.info("Clicking 'Add Relationship' button");
        click(addRelationshipBtn);
    }
}
