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
    private By titleTextLocator = By.xpath("//p[normalize-space()='Customer Registration List']");

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
        assertElementVisible(titleTextLocator, "Customer Registration page not loaded successfully");

    }

}
