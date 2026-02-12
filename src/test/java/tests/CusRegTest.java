package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CustRegisterPage;
import utilities.LoggerUtil;

//import pages.LoginPage;
import pages.HomePage;

public class CusRegTest extends BaseTest {

	@Test
	public void verifyLogin() throws InterruptedException {
		LoggerUtil.info("Registration test started");
		CustRegisterPage reg = new CustRegisterPage(driver);

		HomePage homePage = new HomePage(driver);

		// customer reg individual master
		homePage.navigateToCustomerRegistration();
		homePage.clickAddCustomerRegistration();

		LoggerUtil.info("Verifying Customer Registration form visibility");
		if (!reg.isFormVisible()) {
			throw new RuntimeException("Customer Registration form is not visible after navigation");
		}

		reg.chooseLegalStatus("Individual");
		reg.isEmployee("No");

		reg.enterCustomerName("Ram", "Bahadur", "Karki");
		reg.enterCustomerNameLocal("राम", "बाहादुर", "कारकि");

		reg.enterMaidenName("Karki");

		reg.selectBirthDate("1995", "March", "29");
		reg.enterBirthCountry("india");
		reg.enterBirthAddressIfApplicable("india");

		reg.selectIsForeign(false, "India");
		reg.selectIsPEP(false, "Domestic pep");

		reg.selectGender("male");
		reg.selectMaritalStatus("single");
		reg.selectReligion("hindu");
		reg.selectEducation("Master’s Degree");
		reg.selectMotherLanguage("nepali");
		reg.selectPreferredCommunicationLanguage("nepali");
		Thread.sleep(3000);
		reg.clickNextButton();
		Thread.sleep(3000);
	}
}
