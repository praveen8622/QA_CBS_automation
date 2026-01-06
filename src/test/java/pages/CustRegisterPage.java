package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import base.BasePage;
import utilities.WaitUtils;

public class CustRegisterPage extends BasePage {
	private WaitUtils wait;
	
	private By navCustreg = By.xpath("//p[normalize-space()='Customer Management']");
	private By custReg = By.xpath("//p[normalize-space()='Customer Registration']");
	private By addCustregBtn = By.xpath("//div[contains(text(),'Add Customer Registration')]");
	private By legalStatus = By.cssSelector("input[role='combobox']");
	private By formVisible = By.xpath("//label[@class='text-sm mb-1 block text-gray-600']");
	private By fName = By.cssSelector("input[aria-label='First Name']");
	private By mName = By.cssSelector("input[aria-label='Middle Name']");
	private By lName = By.cssSelector("input[aria-label='Last Name']");
	private By fNameLocaL = By.xpath("//input[@name='firstNameLocal']");
	private By mNameLocal = By.xpath("//input[@name='middleNameLocal']");
	private By lNameLocal = By.xpath("//input[@name='lastNameLocal']");
	private By maidenName = By.cssSelector("input[aria-label='Maiden Name']");
	private By birthCntry = By.xpath("//input[@aria-label='Birth Country']");
	private By selectGender = By.xpath("//input[@aria-label='Gender']");
	private By birthDateInput = By.cssSelector("input[data-testid='eng-date-picker']");
	private By monthDropdown = By.xpath("//select[@name='months']");
	private By yearDropdown = By.xpath("//select[@name='years']");
	
	

	public CustRegisterPage(WebDriver driver) {
		super(driver);
		this.wait = new WaitUtils(driver);
		
	}
	
	public void clicknavReg(){
		 
		click(wait.waitForElementToBeClickable(navCustreg));
		
		
	}
	public void clickcustReg(){
		click(wait.waitForElementToBeClickable(custReg));
		
		
	}
	public void clickAddCust() {
		click(wait.waitForElementToBeClickable(addCustregBtn));
	}
	
	public void chooseLegalstatus(String legalStats) {
		
		WebElement legalstat = wait.waitForElementToBeClickable(legalStatus);
		legalstat.click();
		legalstat.sendKeys(legalStats);
		legalstat.sendKeys(Keys.ENTER);
	}
	
	public void isEmployee(String option) {
	    String value = option.equalsIgnoreCase("yes") ? "true" : "false";

	    By radio = By.xpath("//input[@name='isHomeEmployee' and @value='" + value + "']");
	    driver.findElement(radio).click();
	}

	public void enterFirstname (String fistName) {
		typeText(wait.waitForElementToBeClickable(fName), fistName);
	}
	
	public void enterMiddlename (String MiddleName) {
		typeText(wait.waitForElementToBeClickable(mName), MiddleName);
	}
	
	public void enterLastname (String lastName) {
		typeText(wait.waitForElementToBeClickable(lName), lastName);
	}
	
	public void enterFirstnameLocal (String fistNameLocal) {
		typeText(wait.waitForElementToBeClickable(fNameLocaL), fistNameLocal);
	}
	
	public void enterMiddlenameLocal (String MiddleNameLocal) {
		typeText(wait.waitForElementToBeClickable(mNameLocal), MiddleNameLocal);
	}
	
	public void enterLastnamelocal (String lastNameLocal) {
		typeText(wait.waitForElementToBeClickable(lNameLocal), lastNameLocal);
	}
	
	public void enterMaidenName (String maidenname) {
		typeText(wait.waitForElementToBeClickable(maidenName), maidenname);
	}
	
		
	public void selectBirthDate(String year, String day , String month ) {
	    wait.waitForElementToBeClickable(birthDateInput).click();

	    Select years = new Select(driver.findElement(yearDropdown));
	    years.selectByVisibleText(year);
	    
	    Select mnth = new Select(driver.findElement(monthDropdown));
	    mnth.selectByVisibleText(month);

	    By dayLocator = By.xpath(
	            "//button[@name='day' and normalize-space()='" + day + "' and not(@disabled)]"
	    );
	    wait.waitForElementToBeClickable(dayLocator).click();
	}
	
	public void enterBirthCountry(String birthCountry) {
		WebElement bc = wait.waitForElementToBeClickable(birthCntry);
		bc.click();
		bc.sendKeys(birthCountry);
		bc.sendKeys(Keys.ENTER);	
	}
	
	public void enterGender(String gender) {
		WebElement gen = wait.waitForElementToBeClickable(selectGender);
		gen.click();
		if (gender.equalsIgnoreCase("Male")) {
			gen.sendKeys(gender);
			gen.sendKeys(Keys.ARROW_DOWN);
			gen.sendKeys(Keys.ENTER);
		}else {
			gen.sendKeys(gender);
			gen.sendKeys(Keys.ENTER);
		}
			
		
	}
	
	public boolean visibleForm() {
        return wait.waitForElementToBeVisible(formVisible).isDisplayed();
    }

}
