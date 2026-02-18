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
import pages.CustEmploymentPage;
import pages.CustExposurePage;
import pages.CustRelationshipIdentityPage;
import pages.CustRelationshipDocumentPage;
import pages.CustRelationshipPage;
import pages.CustRegHomepage;
import pages.CustRegisterPage;
import pages.CustRelationshipCommunication;
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
	private CustExposurePage exposurePage;
	private CustEmploymentPage employmentPage;
	private CustRelationshipPage relationshipPage;
	private CustRelationshipIdentityPage relationshipIdentityPage;
	private CustRelationshipCommunication relationshipCommunicationPage;
	private CustRelationshipDocumentPage relationshipDocumentPage;
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
		exposurePage = new CustExposurePage(driver);
		employmentPage = new CustEmploymentPage(driver);
		relationshipPage = new CustRelationshipPage(driver);
		relationshipIdentityPage = new CustRelationshipIdentityPage(driver);
		relationshipCommunicationPage = new CustRelationshipCommunication(driver);
		relationshipDocumentPage = new CustRelationshipDocumentPage(driver);
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
		reg.enterScreeningId("1");
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

		custRegHomePage.openIdentityformPage();

		identityPage.openAddIdentityForm();
		Thread.sleep(1000);
		identityPage.selectIdentityType("Passport");
		identityPage.enterIdentityNumber("H123456789");
		identityPage.enterOpenIssueOfficeName("DAO Kathmandu");
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

		LoggerUtil.info("Document Details test started");
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

		custRegHomePage.openHighProfilevConnformPage();
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
		custRegHomePage.navigateToCashFlowTab();
		Thread.sleep(1000);
		cashFlowPage.clickAdd();
		Thread.sleep(1000);
		cashFlowPage.enterCashFlowDetails("Income", "Monthly", "10000");
		Thread.sleep(1000);
		cashFlowPage.clickSave();
		Thread.sleep(1000);
	}

	@Test(priority = 9)
	public void verifyExposureDetails() throws InterruptedException {
		LoggerUtil.info("Exposure to Other Financial Institutions Details test started");
		custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		Thread.sleep(1000);
		custRegHomePage.navigateToExposureTab();
		Thread.sleep(1000);
		exposurePage.clickAdd();
		Thread.sleep(1000);
		exposurePage.enterExposureDetails("Banking", "Global IME Bank", "Loans / Credit Exposure", "500000", "12",
				"60");
		Thread.sleep(1000);
		exposurePage.clickSave();
		Thread.sleep(1000);
	}

	@Test(priority = 10)
	public void verifyEmploymentDetails() throws InterruptedException {
		LoggerUtil.info("Employment Details test started");
		custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		Thread.sleep(1000);
		custRegHomePage.navigateToEmploymentTab();
		Thread.sleep(1000);
		employmentPage.clickAdd();
		Thread.sleep(1000);
		employmentPage.enterEmploymentDetails("Salaried", "Engineer", "Manager", "Tech Corp", "Kathmandu", "1200000");
		Thread.sleep(1000);
		employmentPage.clickSave();
		Thread.sleep(1000);
	}

	@Test(priority = 11)
	public void verifyRelationshipDetails() throws InterruptedException {
		LoggerUtil.info("Relationship Details test started");
		custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");

		Thread.sleep(1000);
		custRegHomePage.clickRelationshipMasterTab();
		Thread.sleep(1000);
		custRegHomePage.clickAddRelationship();
		Thread.sleep(1000);
		relationshipPage.setKycCategory("Family");
		Thread.sleep(1000);
		relationshipPage.selectRelation("Father");
		Thread.sleep(1000);
		relationshipPage.enterFirstName("Hari", "हरि");
		Thread.sleep(1000);
		relationshipPage.enterLastName("Karki", "कारकि");
		Thread.sleep(1000);
		relationshipPage.selectBirthDate("2000", "January", "1");
		Thread.sleep(1000);
		relationshipPage.selectBirthCountry("Nepal");
		Thread.sleep(1000);
		relationshipPage.selectGender("Male");
		Thread.sleep(1000);
		relationshipPage.selectMaritalStatus("Single");
		Thread.sleep(1000);
		relationshipPage.selectOccupation("Engineer");
		Thread.sleep(1000);
		relationshipPage.selectEducation("Master’s Degree'");
		Thread.sleep(6000);
		relationshipPage.clickNext();
	}

	@Test(priority = 12)
	public void verifyRelationshipIdentity() throws InterruptedException {
		LoggerUtil.info("Relationship Identity Details test started");
		custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");
		custRegHomePage.clickRelationshipMasterTab();
		Thread.sleep(1000);
		custRegHomePage.clickAddRelationship();

		relationshipIdentityPage.clickIdentityTab();
		Thread.sleep(1000);
		relationshipIdentityPage.clickAddIdentity();
		Thread.sleep(1000);
		relationshipIdentityPage.selectIdentityType("Passport");
		Thread.sleep(1000);
		relationshipIdentityPage.enterIdentityNumber("P1234567");
		Thread.sleep(1000);
		relationshipIdentityPage.enterIssueOffice("DAO Kathmandu");
		Thread.sleep(1000);
		relationshipIdentityPage.selectIssueDate("2021", "January", "1");
		Thread.sleep(1000);
		relationshipIdentityPage.handleExpiryDateIfApplicable("2031", "January", "1");
		Thread.sleep(1000);
		// relationshipIdentityPage.uploadDocument("C:\\path\\to\\doc.jpg"); // Skip
		// upload for now as it needs a real file

		relationshipIdentityPage.clickSave();
		Thread.sleep(2000);
	}

	@Test(priority = 13)
	public void verifyRelationshipCommunication() throws InterruptedException {
		LoggerUtil.info("Relationship Communication Details test started");
		custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");
		custRegHomePage.clickRelationshipMasterTab();
		Thread.sleep(1000);
		custRegHomePage.clickAddRelationship();
		Thread.sleep(3000);
		relationshipCommunicationPage.clickCommunicationTab();
		Thread.sleep(1000);
		relationshipCommunicationPage.clickAddCommunication();
		Thread.sleep(1000);
		relationshipCommunicationPage.selectCommunicationType("Mobile");
		Thread.sleep(1000);
		relationshipCommunicationPage.enterCommunicationNumber("987654321");
		Thread.sleep(1000);
		relationshipCommunicationPage.clickSaveCommunication();
		Thread.sleep(2000);
	}

	@Test(priority = 14)
	public void verifyRelationshipDocument() throws InterruptedException {
		LoggerUtil.info("Relationship Document Details test started");
		custRegHomePage.searchAndEditDraftCustomer("RAM BAHADUR KARKI");
		custRegHomePage.clickRelationshipMasterTab();
		Thread.sleep(1000);
		custRegHomePage.clickAddRelationship();
		Thread.sleep(3000);

		relationshipDocumentPage.clickDocumentTab();
		Thread.sleep(1000);
		relationshipDocumentPage.clickAddDocument();
		Thread.sleep(1000);

		relationshipDocumentPage.selectDocumentType("Citizenship");
		Thread.sleep(1000);
		relationshipDocumentPage.enterDocumentTitle("Citizenship Front");
		Thread.sleep(1000);
		relationshipDocumentPage.enterDocumentNumber("123-456-789");
		Thread.sleep(1000);
		relationshipDocumentPage.selectMimeType("image/png");
		Thread.sleep(1000);
		// relationshipDocumentPage.uploadDocument("C:\\path\\to\\doc.png");

		relationshipDocumentPage.clickSave();
		Thread.sleep(2000);
	}
}
