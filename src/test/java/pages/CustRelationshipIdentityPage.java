package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRelationshipIdentityPage extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By identityTabLocator = By.xpath("//button[normalize-space()='Identity']");
    private By addIdentityBtnLocator = By.xpath(
            "//h4[normalize-space()='Relationship Identity']/ancestor::div[contains(@class,'flex')]//button[@title='Add']");
    private By identityTypeContainerLocator = By
            .xpath("//input[@aria-label='Identity Type']/ancestor::div[contains(@class, 'container')]");
    private By identityTypeInputLocator = By.xpath("//input[@aria-label='Identity Type']");
    private By identityNoInputLocator = By.xpath("//input[@aria-label='Identity Number']");

    private By issueDateButtonLocator = By.name("issueDate");

    private By isExpiryBasedInputLocator = By.xpath("//input[@name='isExpiryBased']");
    private By expiryDateButtonLocator = By.name("expiryDate");
    private By monthDropdownLocator = By.xpath("//select[@name='months']");
    private By yearDropdownLocator = By.xpath("//select[@name='years']");

    // Conditional Fields
    private By issueOfficeInputLocator = By.name("openIssueOfficeName");
    private By localBodyContainerLocator = By
            .xpath("//input[@aria-label='Local Body']/ancestor::div[contains(@class, 'container')]");
    private By localBodyInputLocator = By.xpath("//input[@aria-label='local Body']");
    private By stateContainerLocator = By
            .xpath("//input[@aria-label='State']/ancestor::div[contains(@class, 'container')]");
    private By stateInputLocator = By.xpath("//input[@aria-label='State']");

    private By fileUploadInputLocator = By.xpath("//input[@type='file']");
    private By saveBtnLocator = By.xpath("//button[normalize-space()='Save']");

    public CustRelationshipIdentityPage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================
    public void clickIdentityTab() {
        LoggerUtil.info("Clicking Identity tab");
        click(identityTabLocator);
    }

    public void clickAddIdentity() {
        LoggerUtil.info("Clicking Add Identity button");
        click(addIdentityBtnLocator);
    }

    public void selectIdentityType(String type) {
        LoggerUtil.info("Selecting Identity Type: " + type);
        selectFromReactSelect(identityTypeContainerLocator, identityTypeInputLocator, type);
    }

    public void enterIdentityNumber(String number) {
        LoggerUtil.info("Entering Identity Number: " + number);
        typeText(identityNoInputLocator, number);
        assertValueEquals(identityNoInputLocator, number, "Identity number not entered correctly");
    }

    public void selectIssueDate(String year, String month, String day) {
        LoggerUtil.info("Selecting Issue Date - Year: " + year + ", Month: " + month + ", Day: " + day);
        By dayLocator = By.xpath("//button[@name='day' and normalize-space()='" + day + "' and not(@disabled)]");
        selectDate(issueDateButtonLocator, yearDropdownLocator, year, monthDropdownLocator, month, dayLocator);
    }

    public void selectExpiryDate(String year, String month, String day) {
        LoggerUtil.info("Selecting Expiry Date - Year: " + year + ", Month: " + month + ", Day: " + day);
        By dayLocator = By.xpath("//button[@name='day' and normalize-space()='" + day + "' and not(@disabled)]");
        selectDate(expiryDateButtonLocator, yearDropdownLocator, year, monthDropdownLocator, month, dayLocator);
    }

    public boolean isIdentityExpiryBased() {
        LoggerUtil.info("Checking 'Is Expiry Based' field value");
        String value = getAttributeValue(isExpiryBasedInputLocator, "value");
        System.out.println(value);
        return value != null && value.equalsIgnoreCase("Yes");

    }

    public boolean isExpiryDateDisabled() {
        return getAttributeValue(expiryDateButtonLocator, "disabled") != null;
    }

    public boolean isExpiryDateEnabled() {
        return getAttributeValue(expiryDateButtonLocator, "disabled") == null;
    }

    public void handleExpiryDateIfApplicable(
            String year, String month, String day) {

        LoggerUtil.info("Handling Expiry Date selection if applicable");

        if (isIdentityExpiryBased()) {
            LoggerUtil.info("Identity is expiry-based. Selecting Expiry Date: Year " + year + ", Month " + month
                    + ", Day " + day);

            // ===== Expiry-based identity =====
            assertTrueCondition(isExpiryDateEnabled(),
                    "Expiry Date is disabled for expiry-based identity");

            By dayLocator = By.xpath(
                    "//button[@name='day' and normalize-space()='"
                            + day + "' and not(@disabled)]");

            selectDate(
                    expiryDateButtonLocator,
                    yearDropdownLocator, year,
                    monthDropdownLocator, month,
                    dayLocator);

            assertFalseCondition(
                    getAttributeValue(expiryDateButtonLocator, "value").isEmpty(),
                    "Expiry Date was not populated");

        } else {
            LoggerUtil.info("Identity is NOT expiry-based. Skipping Expiry Date selection.");

            // ===== Non-expiry identity =====
            assertTrueCondition(isExpiryDateDisabled(),
                    "Expiry Date is enabled for non-expiry identity");
        }
    }

    public void enterIssueOffice(String office) {
        LoggerUtil.info("Entering Issue Office: " + office);
        typeText(issueOfficeInputLocator, office);
    }

    public void selectLocalBody(String localBody) {
        LoggerUtil.info("Selecting Local Body: " + localBody);
        selectFromReactSelect(localBodyContainerLocator, localBodyInputLocator, localBody);
    }

    public void selectState(String state) {
        LoggerUtil.info("Selecting State: " + state);
        selectFromReactSelect(stateContainerLocator, stateInputLocator, state);
    }

    public void uploadDocument(String filePath) {
        LoggerUtil.info("Uploading document: " + filePath);
        uploadFile(fileUploadInputLocator, filePath);
    }

    public void clickSave() {
        LoggerUtil.info("Clicking Save button in Relationship Identity form");
        click(saveBtnLocator);
    }
}
