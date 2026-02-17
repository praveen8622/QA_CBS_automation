package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import base.BaseTestSequential;
import pages.CustAddressPage;
import pages.CustCashFlowPage;
import pages.CustCommunicationPage;
import pages.CustDocument;
import pages.CustHighProfilePage;
import pages.CustIdentityPage;
import pages.CustRegisterPage;
import pages.CustTransactionPage;
import pages.HomePage;
import utilities.LoggerUtil;

public class CusRegTest extends BaseTestSequential {

	private CustRegisterPage reg;
	private CustIdentityPage identityPage;
	private CustCommunicationPage communicationPage;
	private CustDocument documentPage;
	private CustAddressPage addressPage;
	private CustHighProfilePage highProfilePage;
	private CustTransactionPage transactionPage;
	private CustCashFlowPage cashFlowPage;
	private HomePage homePage;

	@BeforeClass
	public void pageSetup() {
		reg = new CustRegisterPage(driver);
		identityPage = new CustIdentityPage(driver);
		communicationPage = new CustCommunicationPage(driver);
		documentPage = new CustDocument(driver);
		addressPage = new CustAddressPage(driver);
		highProfilePage = new CustHighProfilePage(driver);
		transactionPage = new CustTransactionPage(driver);
		cashFlowPage = new CustCashFlowPage(driver);
		homePage = new HomePage(driver);
	}

	@Test(priority = 1)
	public void verifyCustomerRegistration() throws InterruptedException {
		LoggerUtil.info("Registration test started");

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

	@Test(priority = 2)
	public void verifyIdentityDetails() throws InterruptedException {
		// homePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		// open and fill identity form
		LoggerUtil.info("Identity Details test started");

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
	}

	@Test(priority = 3)
	public void verifyCommunicationDetails() throws InterruptedException {
		// homePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		// open and fill customer communication page
		LoggerUtil.info("Communication Details test started");

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
	}

	@Test(priority = 4)
	public void verifyDocumentDetails() throws InterruptedException {
		// homePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		// open and fill customer document page
		LoggerUtil.info("Document Details test started");

		// The original code passed document details quickly?
		// Original: documentPage.clickNext();
		documentPage.clickNext();
		Thread.sleep(3000);
	}

	@Test(priority = 5)
	public void verifyAddressDetails() throws InterruptedException {
		// homePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		LoggerUtil.info("Address Details test started");

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
	}

	@Test(priority = 6)
	public void verifyHighProfileDetails() throws InterruptedException {
		// homePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		LoggerUtil.info("High Profile Details test started");

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

	@Test(priority = 7)
	public void verifyTransactionDetails() throws InterruptedException {
		// homePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		LoggerUtil.info("Transaction Details test started");

		Thread.sleep(3000);

		transactionPage.enterTransactionDetails("Daily", true, "10000", "5");
		transactionPage.enterTransactionDetails("Weekly", true, "50000", "10");

		Thread.sleep(3000);
		transactionPage.clickSave();
		Thread.sleep(3000);
	}

	@Test(priority = 8)
	public void verifyCashFlowDetails() throws InterruptedException {
		LoggerUtil.info("Cash Flow Details test started");
		homePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		Thread.sleep(3000);
		cashFlowPage.navigateToCashFlowTab();
		Thread.sleep(3000);
		cashFlowPage.clickAdd();
		Thread.sleep(3000);
		cashFlowPage.enterCashFlowDetails("Income", "Monthly", "10000");
		Thread.sleep(2000);
		cashFlowPage.clickSave();
		Thread.sleep(3000);
	}
}
