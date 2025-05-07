package com.qa.opencart.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.qa.opencart.base.BaseTest;
import com.qa.opencart.constants.AppConstants;
import com.qa.opencart.utils.ExcelUtil;

public class RegisterPageTest extends BaseTest {

	@BeforeClass
	public void registerSetup() {
		registerPage = loginPage.navigateToRegister();
	}

	// MSexcel: .xlsx : read using apache POI API

	@DataProvider
	public Object[][] getUserRegTestData() {
		return new Object[][] { { "priti", "bharat", "1238567890", "vishal@123", "yes" },
				{ "Betun", "bharat", "1274567890", "vishal@123", "no" },
				{ "Bibek", "bharat", "1238567890", "vishal@123", "yes" } };
	}

	@DataProvider
	public Object[][] getUserRegData() {
		Object regData[][] = ExcelUtil.getTestData(AppConstants.REGISTER_SHEET_NAME);
		return regData;
	}

	@Test(dataProvider = "getUserRegData")
	public void userRegisterTest(String firstName, String lastName, String telephone, String password,
			String subscribe) {
		Assert.assertTrue(registerPage.userRegistrationMethod(firstName, lastName, telephone, password, subscribe));
	}

}
