package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import base.BasePage;
import utilities.LoggerUtil;

public class CustRelationshipPage extends BasePage {

    // =================================================
    // Locators
    // =================================================
    private By isMemberCheckboxBy = By.name("isAssociatedMemberCustomer");

    private By familyCheckboxBy = By.xpath("//input[@name='kycInfoCategoryCodes' and @value='2']");
    private By nomineeCheckboxBy = By.xpath("//input[@name='kycInfoCategoryCodes' and @value='3']");
    private By dependentCheckboxBy = By.xpath("//input[@name='kycInfoCategoryCodes' and @value='9']");

    private By relationContainerBy = By
            .xpath("//input[@aria-label='relationId']/ancestor::div[contains(@class, 'container')]");
    private By relationInputBy = By.xpath("//input[@aria-label='relationId']");

    private By firstNameInputBy = By.name("firstName");
    private By firstNameLocalInputBy = By.name("firstNameLocal");
    private By middleNameInputBy = By.name("middleName");
    private By middleNameLocalInputBy = By.name("middleNameLocal");
    private By lastNameInputBy = By.name("lastName");
    private By lastNameLocalInputBy = By.name("lastNameLocal");
    private By birthDateButtonLocator = By.name("birthDateAD");
    private By monthDropdownLocator = By.xpath("//select[@name='months']");
    private By yearDropdownLocator = By.xpath("//select[@name='years']");

    private By birthCountryContainerBy = By
            .xpath("//input[@aria-label='Birth Country']/ancestor::div[contains(@class, 'container')]");
    private By birthCountryInputBy = By.xpath("//input[@aria-label='Birth Country']");

    private By genderInputBy = By.xpath("//input[@aria-label='genderId']");
    private By maritalStatusContainerBy = By
            .xpath("//input[@aria-label='maritalStatusId']/ancestor::div[contains(@class, 'container')]");
    private By maritalStatusInputBy = By.xpath("//input[@aria-label='maritalStatusId']");
    private By occupationContainerBy = By
            .xpath("//input[@aria-label='occupationId']/ancestor::div[contains(@class, 'container')]");
    private By occupationInputBy = By.xpath("//input[@aria-label='occupationId']");

    private By educationContainerBy = By
            .xpath("//input[@aria-label='educationId']/ancestor::div[contains(@class, 'container')]");
    private By educationInputBy = By.xpath("//input[@aria-label='educationId']");

    private By nextBtnBy = By.xpath("//button[@title='Next']");

    public CustRelationshipPage(WebDriver driver) {
        super(driver);
    }

    // =================================================
    // Actions
    // =================================================

    public void setMemberCustomer(boolean isMember) {
        LoggerUtil.info("Setting 'Is Member Customer?' to " + isMember);
        setCheckbox(isMemberCheckboxBy, isMember);
    }

    public void setKycCategory(String category) {
        LoggerUtil.info("Setting KYC Category: " + category);
        if (category.equalsIgnoreCase("Family"))
            setCheckbox(familyCheckboxBy, true);
        else if (category.equalsIgnoreCase("Nominee"))
            setCheckbox(nomineeCheckboxBy, true);
        else if (category.equalsIgnoreCase("Dependent"))
            setCheckbox(dependentCheckboxBy, true);
    }

    public void selectRelation(String relation) {
        LoggerUtil.info("Selecting Relation: " + relation);
        selectFromReactSelect(relationContainerBy, relationInputBy, relation);
    }

    public void enterFirstName(String name, String nameLocal) {
        LoggerUtil.info("Entering First Name: " + name + " (" + nameLocal + ")");
        typeText(firstNameInputBy, name);
        typeText(firstNameLocalInputBy, nameLocal);
    }

    public void enterMiddleName(String name, String nameLocal) {
        LoggerUtil.info("Entering Middle Name: " + name + " (" + nameLocal + ")");
        typeText(middleNameInputBy, name);
        typeText(middleNameLocalInputBy, nameLocal);
    }

    public void enterLastName(String name, String nameLocal) {
        LoggerUtil.info("Entering Last Name: " + name + " (" + nameLocal + ")");
        typeText(lastNameInputBy, name);
        typeText(lastNameLocalInputBy, nameLocal);
    }

    public void selectBirthDate(String yearValue, String monthValue, String dayValue) {
        LoggerUtil.info("Selecting Date of Birth - Year: " + yearValue +
                ", Month: " + monthValue + ", Day: " + dayValue);

        By dayLocator = By.xpath("//button[@name='day' and normalize-space()='" + dayValue + "' and not(@disabled)]");
        selectDate(birthDateButtonLocator, yearDropdownLocator, yearValue,
                monthDropdownLocator, monthValue, dayLocator);

        assertFalseCondition(getAttributeValue(birthDateButtonLocator, "value").isEmpty(),
                "Birth date was not selected");
    }

    public void selectBirthCountry(String country) {
        LoggerUtil.info("Selecting Birth Country: " + country);
        selectFromReactSelect(birthCountryContainerBy, birthCountryInputBy, country);
    }

    public void selectGender(String gender) {
        LoggerUtil.info("Selecting Gender: " + gender);
        selectFromGenderDropdown(genderInputBy, gender);
    }

    public void selectMaritalStatus(String maritalStatus) {
        LoggerUtil.info("Selecting Marital Status: " + maritalStatus);
        selectFromReactSelect(maritalStatusContainerBy, maritalStatusInputBy, maritalStatus);
    }

    public void selectOccupation(String occupation) {
        LoggerUtil.info("Selecting Occupation: " + occupation);
        selectFromReactSelect(occupationContainerBy, occupationInputBy, occupation);
    }

    public void selectEducation(String education) {
        LoggerUtil.info("Selecting Education: " + education);
        selectFromReactSelect(educationContainerBy, educationInputBy, education);
    }

    public void clickNext() {
        LoggerUtil.info("Clicking 'Next' button in Relationship module");
        click(nextBtnBy);
    }
}
