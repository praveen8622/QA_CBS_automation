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
import pages.CustRegHomepage;
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
	private CustRegHomepage custRegHomePage;
	private HomePage homePage;

	@BeforeClass
	public void pageSetup() {
		reg = new CustRegisterPage(driver);
		homePage = new HomePage(driver);
		identityPage = new CustIdentityPage(driver);
		communicationPage = new CustCommunicationPage(driver);
		documentPage = new CustDocument(driver);
		addressPage = new CustAddressPage(driver);
		highProfilePage = new CustHighProfilePage(driver);
		transactionPage = new CustTransactionPage(driver);
		cashFlowPage = new CustCashFlowPage(driver);
		custRegHomePage = new CustRegHomepage(driver);
	}

	@Test(priority = 1)
	public void verifyCustomerRegistration() throws InterruptedException {
		LoggerUtil.info("Registration test started");

		// customer reg individual master

		homePage.navigateToCustomerRegistration();
		custRegHomePage.clickAddCustomerRegistration();

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
		Thread.sleep(1000);
		reg.clickNextButton();
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void verifyIdentityDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		// open and fill identity form
		LoggerUtil.info("Identity Details test started");

		reg.openIdentityformPage();

		identityPage.openAddIdentityForm();
		Thread.sleep(1000);
		identityPage.selectIdentityType("Passport");
		identityPage.enterIdentityNumber("H123456789");
		identityPage.enterOpenIssueOfficeName("DAO");
		Thread.sleep(1000);
		identityPage.selectIssueDate("2020", "March", "29");
		identityPage.handleExpiryDateIfApplicable("2030", "March", "30");
		Thread.sleep(1000);
		identityPage.clickSaveIdentity();
		Thread.sleep(1000);
		identityPage.clickNextbutton();
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void verifyCommunicationDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		// open and fill customer communication page
		LoggerUtil.info("Communication Details test started");

		communicationPage.openAddCommunicationForm();
		Thread.sleep(1000);
		communicationPage.selectDevice("Mobile");
		Thread.sleep(1000);
		communicationPage.selectIsPersonalDevice("Yes");
		Thread.sleep(1000);
		communicationPage.enterPriorityOrder("1");
		Thread.sleep(1000);
		communicationPage.enterDeviceNumber("9841234567");
		Thread.sleep(1000);
		communicationPage.clickSaveButton();
		Thread.sleep(1000);
		communicationPage.clickNextbutton();
		Thread.sleep(1000);
	}

	@Test(priority = 4)
	public void verifyDocumentDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		// open and fill customer document page
		LoggerUtil.info("Document Details test started");

		// The original code passed document details quickly?
		// Original: documentPage.clickNext();
		documentPage.clickNext();
		Thread.sleep(1000);
	}

	@Test(priority = 5)
	public void verifyAddressDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		LoggerUtil.info("Address Details test started");

		addressPage.openAddAddressForm();
		Thread.sleep(1000);
		addressPage.selectAddressType("Permanent");
		Thread.sleep(1000);
		addressPage.selectState("Bagmati");
		Thread.sleep(1000);
		addressPage.selectDistrict("Kathmandu");
		Thread.sleep(1000);
		addressPage.selectLocalBody("Kathmandu");
		Thread.sleep(1000);
		addressPage.enterPostalCode("12345");
		Thread.sleep(1000);
		addressPage.enterStreet("Kathmandu");
		Thread.sleep(1000);
		addressPage.enterWardNo("123");
		Thread.sleep(1000);
		addressPage.enterHouseNo("123");
		Thread.sleep(1000);
		addressPage.enterLatitude("123");
		Thread.sleep(1000);
		addressPage.enterLongitude("123");
		// Thread.sleep(1000);
		// addressPage.uploadAddressDocument("C:\\Users\\Praveen_Vortex\\Downloads\\1.jpg");
		Thread.sleep(1000);
		addressPage.clickSave();
		Thread.sleep(1000);
		addressPage.clickNext();
		Thread.sleep(1000);
	}

	@Test(priority = 6)
	public void verifyHighProfileDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		LoggerUtil.info("High Profile Details test started");

		addressPage.openHighProfilevConnformPage();
		Thread.sleep(1000);

		// open and fill customer high profile page
		highProfilePage.openAddHighProfileForm();
		Thread.sleep(1000);
		highProfilePage.enterFullName("Ram");
		Thread.sleep(1000);
		highProfilePage.enterFullNameLocal("राम");
		Thread.sleep(1000);
		highProfilePage.selectGender("male");
		Thread.sleep(1000);
		highProfilePage.selectRelation("father");
		Thread.sleep(1000);
		highProfilePage.selectOccupation("engineer");
		Thread.sleep(1000);
		highProfilePage.selectCitizenshipCategory("Pure Domestic Citizen");
		Thread.sleep(1000);
		highProfilePage.selectPrimaryCitizenCountry("Nepal");
		Thread.sleep(1000);
		highProfilePage.selectSecondaryCitizenCountry("Nepal");
		Thread.sleep(1000);
		highProfilePage.selectResidentCountry("Nepal");
		Thread.sleep(1000);
		highProfilePage.selectPrCountry("Nepal");
		Thread.sleep(1000);
		highProfilePage.selectEducation("master");
		// Thread.sleep(1000);
		// highProfilePage.enterPosition("Manager");
		Thread.sleep(1000);
		highProfilePage.clickSave();
		Thread.sleep(1000);
		highProfilePage.clickNext();
		Thread.sleep(1000);
	}

	@Test(priority = 7)
	public void verifyTransactionDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		LoggerUtil.info("Transaction Details test started");

		Thread.sleep(1000);

		transactionPage.enterTransactionDetails("Daily", true, "10000", "5");
		transactionPage.enterTransactionDetails("Weekly", true, "50000", "10");

		Thread.sleep(1000);
		transactionPage.clickSave();
		Thread.sleep(1000);
	}

	@Test(priority = 8)
	public void verifyCashFlowDetails() throws InterruptedException {
		LoggerUtil.info("Cash Flow Details test started");
		// custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		Thread.sleep(1000);
		cashFlowPage.navigateToCashFlowTab();
		Thread.sleep(1000);
		cashFlowPage.clickAdd();
		Thread.sleep(1000);
		cashFlowPage.enterCashFlowDetails("Income", "Monthly", "10000");
		Thread.sleep(1000);
		cashFlowPage.clickSave();
		Thread.sleep(1000);
	}
}
