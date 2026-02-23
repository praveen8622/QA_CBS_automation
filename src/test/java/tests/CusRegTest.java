package tests;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
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
import pages.CustRelationshipAddressPage;
import pages.CustRelationshipDocumentPage;
import pages.CustRelationshipPage;
import pages.CustScreeningPage;
import pages.CustRegHomepage;
import pages.CustRegisterPage;
import pages.CustRelationshipCommunication;
import pages.CustTransactionPage;
import pages.HomePage;
import utilities.DataGenerator;
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
	private CustRelationshipAddressPage relationshipAddressPage;
	private CustRegHomepage custRegHomePage;
	private HomePage homePage;
	private CustScreeningPage custScreeningPage;

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
		relationshipAddressPage = new CustRelationshipAddressPage(driver);
		custRegHomePage = new CustRegHomepage(driver);
		custScreeningPage = new CustScreeningPage(driver);
	}

	@BeforeMethod
	public void setupSoftAssert() {
		setSoftAssertToPages();
	}

	private void setSoftAssertToPages() {
		reg.setSoftAssert(softAssert);
		homePage.setSoftAssert(softAssert);
		identityPage.setSoftAssert(softAssert);
		communicationPage.setSoftAssert(softAssert);
		documentPage.setSoftAssert(softAssert);
		addressPage.setSoftAssert(softAssert);
		highProfilePage.setSoftAssert(softAssert);
		transactionPage.setSoftAssert(softAssert);
		cashFlowPage.setSoftAssert(softAssert);
		exposurePage.setSoftAssert(softAssert);
		employmentPage.setSoftAssert(softAssert);
		relationshipPage.setSoftAssert(softAssert);
		relationshipIdentityPage.setSoftAssert(softAssert);
		relationshipCommunicationPage.setSoftAssert(softAssert);
		relationshipDocumentPage.setSoftAssert(softAssert);
		relationshipAddressPage.setSoftAssert(softAssert);
		custRegHomePage.setSoftAssert(softAssert);
		custScreeningPage.setSoftAssert(softAssert);
	}

	@Test(priority = 1)
	public void verifyCustomerRegistration() throws InterruptedException {
		LoggerUtil.info("Registration test started");
		// Generate screening id
		homePage.navigateToCustomerScreening();
		custScreeningPage.enterFullName("Bahadur Karki");
		custScreeningPage.clickSearch();
		// Capture Screening Id
		String screeningId = custScreeningPage.getScreeningId();

		// Navigate and start Customer registration
		homePage.navigateToCustomerRegistration();
		custRegHomePage.clickAddCustomerRegistration();

		LoggerUtil.info("Verifying Customer Registration form visibility");
		if (!reg.isFormVisible()) {
			throw new RuntimeException("Customer Registration form is not visible after navigation");
		}

		reg.chooseLegalStatus("Individual");
		reg.enterScreeningId(screeningId);
		Thread.sleep(1000);
		reg.isEmployee("No");
		Thread.sleep(1000);
		// reg.enterCustomerName("Prakash", "Bahadur", "Karki");
		// reg.enterCustomerNameLocal("प्रकाश", "बाहादुर", "कारकि");
		reg.enterMaidenName("Karki");
		Thread.sleep(1000);
		reg.selectBirthDate("1995", "March", "29");
		Thread.sleep(1000);
		reg.enterBirthCountry("Nepal");
		reg.enterBirthAddressIfApplicable("Nepal");
		reg.selectIsForeign(false, "India");
		reg.selectIsPEP(false, "Domestic pep");
		reg.selectGender("male");
		reg.selectOnboardingChannel("Physical");
		reg.selectMaritalStatus("Single");
		reg.selectReligion("Hindu");
		reg.selectEducation("Master’s Degree");
		reg.selectMotherLanguage("Nepali");
		reg.selectPreferredCommunicationLanguage("Nepali");
		Thread.sleep(1000);
		reg.clickNextButton();
		Thread.sleep(1000);
	}

	@Test(priority = 2)
	public void verifyIdentityDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		LoggerUtil.info("Identity Details test started");

		custRegHomePage.navigateToIdentityTab();

		identityPage.openAddIdentityForm();
		Thread.sleep(1000);
		identityPage.selectIdentityTypeAndFillConditionalField("Citizenship", "Kathmandu");
		identityPage.enterIdentityNumber(DataGenerator.generateRandomLicense());
		Thread.sleep(1000);
		identityPage.selectIssueDate("2020", "March", "29");
		Thread.sleep(1000);
		identityPage.handleExpiryDateIfApplicable("2030", "March", "30");
		Thread.sleep(1000);
		identityPage.uploadIdentityDocument(
				"C:\\Users\\Praveen_Vortex\\eclipse-workspace\\KYC_Cus_Reg\\src\\test\\resources\\testimages\\testdoc.jpg");
		Thread.sleep(1000);
		identityPage.clickSaveIdentity();
		Thread.sleep(1000);
		identityPage.clickNextbutton();
		Thread.sleep(1000);
	}

	@Test(priority = 3)
	public void verifyCommunicationDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		LoggerUtil.info("Communication Details test started");

		custRegHomePage.navigateToCommunicationTab();
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
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		LoggerUtil.info("Document Details test started");
		custRegHomePage.navigateToDocumentTab();
		documentPage.clickAddDocument();
		documentPage.selectDocumentType("Passport");
		documentPage.enterDocumentTitle("Passport");
		documentPage.enterDocumentNumber(DataGenerator.generateRandomPassport());
		Thread.sleep(1000);
		documentPage.uploadDocument(
				"C:\\Users\\Praveen_Vortex\\eclipse-workspace\\KYC_Cus_Reg\\src\\test\\resources\\testimages\\testdoc.jpg");
		documentPage.clickSave();
		Thread.sleep(1000);
	}

	@Test(priority = 5)
	public void verifyAddressDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		LoggerUtil.info("Address Details test started");

		custRegHomePage.navigateToAddressTab();
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
		Thread.sleep(1000);
		addressPage.uploadAddressDocument(
				"C:\\Users\\Praveen_Vortex\\eclipse-workspace\\KYC_Cus_Reg\\src\\test\\resources\\testimages\\testdoc.jpg");
		Thread.sleep(1000);
		addressPage.clickSave();
		Thread.sleep(1000);
		addressPage.clickNext();
		Thread.sleep(1000);
	}

	@Test(priority = 6)
	public void verifyHighProfileDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		LoggerUtil.info("High Profile Details test started");

		custRegHomePage.navigateToHighProfileTab();
		Thread.sleep(1000);

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
		Thread.sleep(1000);
		highProfilePage.enterPosition("Manager");
		Thread.sleep(1000);
		highProfilePage.clickSave();
		Thread.sleep(1000);
		highProfilePage.clickNext();
		Thread.sleep(1000);
	}

	@Test(priority = 7)
	public void verifyTransactionDetails() throws InterruptedException {
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		LoggerUtil.info("Transaction Details test started");

		Thread.sleep(1000);
		custRegHomePage.navigateToTransactionVolumeTab();
		transactionPage.enterTransactionDetails("Daily", true, "10000", "5");
		transactionPage.enterTransactionDetails("Weekly", true, "50000", "10");

		Thread.sleep(1000);
		transactionPage.clickSave();
		Thread.sleep(1000);
	}

	@Test(priority = 8)
	public void verifyCashFlowDetails() throws InterruptedException {
		LoggerUtil.info("Cash Flow Details test started");
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

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
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		Thread.sleep(1000);
		custRegHomePage.navigateToExposureTab();
		Thread.sleep(1000);
		exposurePage.clickAdd();
		Thread.sleep(1000);
		exposurePage.enterExposureDetails("Banking", "Global IME Bank", "Loans", "500000", "12", "60");
		Thread.sleep(1000);
		exposurePage.clickSave();
		Thread.sleep(1000);
	}

	@Test(priority = 10)
	public void verifyEmploymentDetails() throws InterruptedException {
		LoggerUtil.info("Employment Details test started");
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

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
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		Thread.sleep(1000);
		custRegHomePage.navigateToRelationshipMasterTab();
		Thread.sleep(1000);
		custRegHomePage.clickAddRelationshipBtn();
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
		Thread.sleep(2000);
		relationshipPage.clickNext();
		Thread.sleep(2000);
	}

	@Test(priority = 12)
	public void verifyRelationshipIdentity() throws InterruptedException {
		LoggerUtil.info("Relationship Identity Details test started");
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		// custRegHomePage.navigateToRelationshipMasterTab();
		// Thread.sleep(1000);
		// custRegHomePage.clickAddRelationshipBtn();
		relationshipIdentityPage.clickIdentityTab();
		Thread.sleep(1000);
		relationshipIdentityPage.clickAddIdentity();
		Thread.sleep(1000);
		relationshipIdentityPage.selectIdentityTypeAndFillConditionalField("Driver’s License", "Bagmati Province");
		Thread.sleep(1000);
		relationshipIdentityPage.enterIdentityNumber(DataGenerator.generateRandomLicense());
		Thread.sleep(1000);
		relationshipIdentityPage.selectIssueDate("2021", "January", "1");
		Thread.sleep(1000);
		relationshipIdentityPage.handleExpiryDateIfApplicable("2031", "January",
				"1");
		Thread.sleep(1000);
		relationshipIdentityPage.uploadDocument(
				"C:\\Users\\Praveen_Vortex\\eclipse-workspace\\KYC_Cus_Reg\\src\\test\\resources\\testimages\\testdoc.jpg");
		Thread.sleep(1000);
		relationshipIdentityPage.clickSave();
		Thread.sleep(2000);
		relationshipIdentityPage.clickNext();
		Thread.sleep(2000);
	}

	@Test(priority = 13)
	public void verifyRelationshipCommunication() throws InterruptedException {
		LoggerUtil.info("Relationship Communication Details test started");
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		// custRegHomePage.navigateToRelationshipMasterTab();
		// Thread.sleep(1000);
		// custRegHomePage.clickAddRelationshipBtn();
		// Thread.sleep(3000);
		relationshipCommunicationPage.clickCommunicationTab();
		Thread.sleep(1000);
		relationshipCommunicationPage.clickAddCommunication();
		Thread.sleep(1000);
		relationshipCommunicationPage.selectCommunicationType("Mobile");
		Thread.sleep(1000);
		relationshipCommunicationPage.enterCommunicationNumber("9876543221");
		Thread.sleep(1000);
		relationshipCommunicationPage.clickSaveCommunication();
		Thread.sleep(2000);
		relationshipCommunicationPage.clickNext();
		Thread.sleep(2000);
	}

	@Test(priority = 14)
	public void verifyRelationshipDocument() throws InterruptedException {
		LoggerUtil.info("Relationship Document Details test started");
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		// custRegHomePage.navigateToRelationshipMasterTab();
		// Thread.sleep(1000);
		// custRegHomePage.clickAddRelationshipBtn();
		// Thread.sleep(3000);
		relationshipDocumentPage.clickDocumentTab();
		Thread.sleep(1000);
		relationshipDocumentPage.clickAddDocument();
		Thread.sleep(1000);
		relationshipDocumentPage.selectDocumentType("Citizenship");
		Thread.sleep(1000);
		relationshipDocumentPage.enterDocumentTitle("Citizenship Front");
		Thread.sleep(1000);
		relationshipDocumentPage.enterDocumentNumber(DataGenerator.generateRandomNumber(10));
		Thread.sleep(1000);
		relationshipDocumentPage.selectMimeType("image/png");
		Thread.sleep(1000);
		relationshipDocumentPage.uploadDocument(
				"C:\\Users\\Praveen_Vortex\\eclipse-workspace\\KYC_Cus_Reg\\src\\test\\resources\\testimages\\testdoc.jpg");
		Thread.sleep(1000);

		relationshipDocumentPage.clickSave();
		Thread.sleep(2000);
		relationshipDocumentPage.clickNext();
		Thread.sleep(2000);
	}

	@Test(priority = 15)
	public void verifyRelationshipAddress() throws InterruptedException {
		LoggerUtil.info("Relationship Address Details test started");
		// custRegHomePage.searchAndEditDraftCustomer("PRAKASH BAHADUR KARKI");

		// custRegHomePage.navigateToRelationshipMasterTab();
		// Thread.sleep(1000);
		// custRegHomePage.clickAddRelationshipBtn();
		// Thread.sleep(3000);
		relationshipAddressPage.clickAddressTab();
		Thread.sleep(1000);
		relationshipAddressPage.clickAddAddress();
		Thread.sleep(1000);
		relationshipAddressPage.selectAddressType("Permanent");
		Thread.sleep(1000);
		relationshipAddressPage.selectState("Bagmati");
		Thread.sleep(1000);
		relationshipAddressPage.selectDistrict("Kathmandu");
		Thread.sleep(1000);
		relationshipAddressPage.selectTownship("Kathmandu Metropolitan City");
		Thread.sleep(1000);
		// relationshipAddressPage.selectQuarter("Baluwatar");
		// Thread.sleep(1000);
		relationshipAddressPage.enterPostalCode("44600");
		Thread.sleep(1000);
		relationshipAddressPage.enterStreet("Main Street");
		Thread.sleep(1000);
		relationshipAddressPage.enterWardNo("4");
		Thread.sleep(1000);
		relationshipAddressPage.enterHouseNo("123");
		Thread.sleep(1000);
		relationshipAddressPage.enterLatitude("27.7172");
		Thread.sleep(1000);
		relationshipAddressPage.enterLongitude("85.3240");
		Thread.sleep(1000);
		// relationshipAddressPage.uploadDocument("C:\\path\\to\\doc.png");

		relationshipAddressPage.clickSave();
		Thread.sleep(2000);
		relationshipAddressPage.clickNext();
		Thread.sleep(2000);
	}
}
