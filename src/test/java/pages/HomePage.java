package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class HomePage extends BasePage {

    // =================================================
    // Navigation Locators
    // =================================================
    private By navCustregLocator = By.xpath("//p[normalize-space()='Customer Management']");
    private By custRegLocator = By.xpath("//p[normalize-space()='Customer Registration']");
    private By addCustregBtnLocator = By.xpath("//div[contains(text(),'Add Customer Registration')]");

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Navigation Methods
    // =================================================
    public void navigateToCustomerRegistration() {
        LoggerUtil.info("Clicking 'Customer Management' menu");
        click(navCustregLocator);

        LoggerUtil.info("Clicking 'Customer Registration' submenu");
        click(custRegLocator);
    }

    public void clickAddCustomerRegistration() {
        LoggerUtil.info("Clicking 'Add Customer Registration' button");
        click(addCustregBtnLocator);
    }

    // =================================================
    // Table Action Methods
    // =================================================
    public void clickEditAction(String customerName) {
        LoggerUtil.info("Clicking 'Edit' button for customer: " + customerName);
        By editBtnLocator = By.xpath("//tr[td[normalize-space()='" + customerName + "']]//button[@title='Edit']");
        click(editBtnLocator);
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
