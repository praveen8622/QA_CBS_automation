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
}
