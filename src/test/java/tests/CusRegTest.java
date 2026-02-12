package tests;

import org.testng.annotations.Test;

import base.BaseTest;
import pages.CustAddressPage;
import pages.CustCommunicationPage;
import pages.CustDocument;
import pages.CustHighProfilePage;
import pages.CustIdentityPage;
import pages.CustRegisterPage;
import utilities.LoggerUtil;

//import pages.LoginPage;
import pages.HomePage;

public class CusRegTest extends BaseTest {

	@Test
	public void verifyLogin() throws InterruptedException {
		LoggerUtil.info("Registration test started");
		CustRegisterPage reg = new CustRegisterPage(driver);
		CustIdentityPage identityPage = new CustIdentityPage(driver);
		CustCommunicationPage communicationPage = new CustCommunicationPage(driver);
		CustDocument documentPage = new CustDocument(driver);
		CustAddressPage addressPage = new CustAddressPage(driver);
		CustHighProfilePage highProfilePage = new CustHighProfilePage(driver);

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

		// open and fill identity form
		reg.openIdentityformPage();
		identityPage.openAddIdentityForm();
		Thread.sleep(3000);
		identityPage.selectIdentityType("Passport");
		identityPage.enterIdentityNumber("H123456789");
		identityPage.enterOpenIssueOfficeName("DAO");
		Thread.sleep(3000);
		identityPage.selectIssueDate("2020", "March", "29");
		identityPage.handleExpiryDateIfApplicable("2030", "March", "30");
		Thread.sleep(3000);
		identityPage.clickSaveIdentity();
		Thread.sleep(3000);
		identityPage.clickNextbutton();
		Thread.sleep(3000);

		// open and fill customer communication page

		communicationPage.openAddCommunicationForm();
		Thread.sleep(3000);
		communicationPage.selectDevice("Mobile");
		Thread.sleep(3000);
		communicationPage.selectIsPersonalDevice("Yes");
		Thread.sleep(3000);
		communicationPage.enterPriorityOrder("1");
		Thread.sleep(3000);
		communicationPage.enterDeviceNumber("9841234567");
		Thread.sleep(3000);
		communicationPage.clickSaveButton();
		Thread.sleep(3000);
		communicationPage.clickNextbutton();
		Thread.sleep(3000);
		// open and fill customer document page
		documentPage.clickNext();
		Thread.sleep(3000);
		addressPage.openAddAddressForm();
		Thread.sleep(3000);
		addressPage.selectAddressType("Permanent");
		Thread.sleep(3000);
		addressPage.selectState("Bagmati");
		Thread.sleep(3000);
		addressPage.selectDistrict("Kathmandu");
		Thread.sleep(3000);
		addressPage.selectLocalBody("Kathmandu");
		Thread.sleep(3000);
		addressPage.enterPostalCode("12345");
		Thread.sleep(3000);
		addressPage.enterStreet("Kathmandu");
		Thread.sleep(3000);
		addressPage.enterWardNo("123");
		Thread.sleep(3000);
		addressPage.enterHouseNo("123");
		Thread.sleep(3000);
		addressPage.enterLatitude("123");
		Thread.sleep(3000);
		addressPage.enterLongitude("123");
		// Thread.sleep(3000);
		// addressPage.uploadAddressDocument("C:\\Users\\Praveen_Vortex\\Downloads\\1.jpg");
		Thread.sleep(3000);
		addressPage.clickSave();
		Thread.sleep(3000);
		addressPage.clickNext();
		Thread.sleep(3000);
		addressPage.openHighProfilevConnformPage();
		Thread.sleep(3000);

		// open and fill customer high profile page
		highProfilePage.openAddHighProfileForm();
		Thread.sleep(3000);
		highProfilePage.enterFullName("Ram");
		Thread.sleep(3000);
		highProfilePage.enterFullNameLocal("राम");
		Thread.sleep(3000);
		highProfilePage.selectGender("male");
		Thread.sleep(3000);
		highProfilePage.selectRelation("father");
		Thread.sleep(3000);
		highProfilePage.selectOccupation("engineer");
		Thread.sleep(3000);
		highProfilePage.selectCitizenshipCategory("Pure Domestic Citizen");
		Thread.sleep(3000);
		highProfilePage.selectPrimaryCitizenCountry("Nepal");
		Thread.sleep(3000);
		highProfilePage.selectSecondaryCitizenCountry("Nepal");
		Thread.sleep(3000);
		highProfilePage.selectResidentCountry("Nepal");
		Thread.sleep(3000);
		highProfilePage.selectPrCountry("Nepal");
		Thread.sleep(3000);
		highProfilePage.selectEducation("master");
		// Thread.sleep(3000);
		// highProfilePage.enterPosition("Manager");
		Thread.sleep(3000);
		highProfilePage.clickSave();
		Thread.sleep(3000);
		highProfilePage.clickNext();
		Thread.sleep(3000);

	}
}
