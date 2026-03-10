package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import base.BaseTestSequential;
import utilities.DataGenerator;
import utilities.LoggerUtil;
import workflows.CorporateCustRegWorkflow;

public class CorporateCustRegTest extends BaseTestSequential {

    private CorporateCustRegWorkflow corpKyc;
    private String testImagePath = "testimages/testdoc.jpg";

    @BeforeClass
    public void pageSetup() {
        corpKyc = new CorporateCustRegWorkflow(driver, softAssert);
    }

    @BeforeMethod
    public void setupSoftAssert() {
        corpKyc.updateSoftAssert(softAssert);
    }

    @Test(priority = 1, description = "Verify Corporate Customer Registration")
    public void verifyCorporateCustomerRegistration() throws InterruptedException {
        LoggerUtil.info("Corporate Registration test started");

        String companyName = DataGenerator.generateRandomfirstName() + " Corp";
        String registeredNumber = DataGenerator.generateRandomNumber(6);

        // Assuming common dropdown values are available in the mock/actual data:
        // Adjust "Company Registrar" and "Main Entity" based on actual dropdown list if
        // needed.
        corpKyc.fillPrimaryRegistration(companyName, "Company", registeredNumber, "Nepal Electricity");

        softAssert.assertAll();
    }

    @Test(priority = 2, description = "Verify Identity Details")
    public void verifyIdentityDetails() throws InterruptedException {
        LoggerUtil.info("Identity Details test started");
        corpKyc.fillIdentityDetails(DataGenerator.generateRandomLicense(), testImagePath);
        softAssert.assertAll();
    }
}
