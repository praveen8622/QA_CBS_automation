package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.CustRegisterPage;

//import pages.LoginPage;
public class CusRegTest extends BaseTest {

	@Test
	public void verifyLogin() throws InterruptedException {
		CustRegisterPage reg = new CustRegisterPage(driver);

		reg.clicknavReg();
		reg.clickcustReg();
		reg.clickAddCust();
		reg.chooseLegalstatus("individual");
		reg.isEmployee("Yes");
		reg.enterFirstname("Ram");
		reg.enterMiddlename("Bahadur");
		reg.enterLastname("Karki");
		reg.enterFirstnameLocal("राम");
		reg.enterMiddlenameLocal("बाहादुर");
		reg.enterLastnamelocal("कारकि");
		reg.enterMaidenName("Karki");
		reg.selectBirthDate("1995", "29", "March");
		reg.enterBirthCountry("india");
		reg.enterGender("Female");
		Thread.sleep(5000);
		Assert.assertTrue(reg.visibleForm(), "Load failed: Form not displayed");
		

	}
}
