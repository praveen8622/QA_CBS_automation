package workflows;

import org.openqa.selenium.WebDriver;
import org.testng.asserts.SoftAssert;
import pages.*;

public class CorporateCustRegWorkflow {
    private WebDriver driver;
    private SoftAssert softAssert;

    // Pages
    private CorporateCustRegPage corpRegPage;
    private CustRegHomepage custRegHomePage;
    private HomePage homePage;
    private CustIdentityPage identityPage;

    public CorporateCustRegWorkflow(WebDriver driver, SoftAssert softAssert) {
        this.driver = driver;
        this.softAssert = softAssert;
        initializePages();
    }

    private void initializePages() {
        corpRegPage = new CorporateCustRegPage(driver);
        homePage = new HomePage(driver);
        custRegHomePage = new CustRegHomepage(driver);
        identityPage = new CustIdentityPage(driver);

        syncSoftAssert();
    }

    private void syncSoftAssert() {
        corpRegPage.setSoftAssert(softAssert);
        homePage.setSoftAssert(softAssert);
        custRegHomePage.setSoftAssert(softAssert);
        identityPage.setSoftAssert(softAssert);
    }

    public void updateSoftAssert(SoftAssert newSoftAssert) {
        this.softAssert = newSoftAssert;
        syncSoftAssert();
    }

    // ================================
    // Business Flows
    // ================================

    public void fillPrimaryRegistration(String companyName, String authority, String registeredNumber, String obligor)
            throws InterruptedException {
        // Navigate to Customer Registration and open the form
        homePage.navigateToCustomerManagement();
        homePage.navigateToCustomerRegistration();
        custRegHomePage.clickAddCustomerRegistration();

        // Select Legal Entities (This will show the Corporate Customer form)
        corpRegPage.chooseLegalStatus("Legal Entities");
        Thread.sleep(1000);

        // Fill Corporate Customer Details
        corpRegPage.enterCompanyName(companyName);
        corpRegPage.selectIssuedAuthority(authority);
        corpRegPage.enterRegisteredNumber(registeredNumber);

        // Let's ensure Authority Remarks are tested, even if empty or simple text
        corpRegPage.enterAuthorityRemarks("Registered accurately");

        Thread.sleep(1000);
        corpRegPage.selectRegisteredDate("2020", "March", "15");

        Thread.sleep(1000);
        corpRegPage.selectOnboardingChannel("Physical");
        corpRegPage.selectObligor(obligor);
        Thread.sleep(2000);
        corpRegPage.selectCountry("Nepal");
        Thread.sleep(2000);
        corpRegPage.selectIsForeignResident(false);

        Thread.sleep(2000);
        corpRegPage.clickProceedButton();
        Thread.sleep(2000);
    }

    public void fillIdentityDetails(String licenseNumber, String relativePath) throws InterruptedException {
        custRegHomePage.navigateToIdentityTab();
        identityPage.openAddIdentityForm();
        Thread.sleep(1000);
        identityPage.selectIdentityTypeAndFillConditionalField("Citizenship", "Kathmandu");
        identityPage.enterIdentityNumber(licenseNumber);
        Thread.sleep(1000);
        identityPage.selectIssueDate("2020", "March", "29");
        Thread.sleep(1000);
        // identityPage.handleExpiryDateIfApplicable("2030", "March", "30");
        Thread.sleep(1000);
        identityPage.uploadIdentityDocument(relativePath);
        Thread.sleep(1000);
        identityPage.clickSaveIdentity();
        Thread.sleep(1000);
        identityPage.clickNextbutton();
        Thread.sleep(1000);
    }
}
